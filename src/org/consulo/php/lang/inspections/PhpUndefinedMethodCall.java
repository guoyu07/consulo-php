package org.consulo.php.lang.inspections;

import org.consulo.php.PhpBundle;
import org.consulo.php.lang.psi.elements.PhpMethodReference;
import org.consulo.php.lang.psi.visitors.PhpElementVisitor;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.ResolveResult;

/**
 * @author jay
 * @date Jun 17, 2008 12:48:26 AM
 */
public class PhpUndefinedMethodCall extends PhpInspection
{
	@Nls
	@NotNull
	public String getDisplayName()
	{
		return PhpBundle.message("php.inspections.undefined_method_call");
	}

	@NotNull
	public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly)
	{
		return new PhpElementVisitor()
		{
			public void visitPhpMethodReference(PhpMethodReference reference)
			{
				if(reference.canReadName())
				{
					//noinspection ConstantConditions
					final ResolveResult[] results = ((PsiPolyVariantReference) reference.getReference()).multiResolve(false);
					if(results.length == 0)
					{
						holder.registerProblem(reference, PhpBundle.message("php.inspections.undefined_method_call"));
					}
				}
			}
		};
	}
}
