package org.consulo.php.lang.psi.elements.impl;

import org.consulo.php.lang.psi.elements.PhpElement;
import org.consulo.php.lang.psi.elements.Try;
import org.consulo.php.lang.psi.visitors.PhpElementVisitor;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

/**
 * @author jay
 * @date Jul 2, 2008 3:01:36 AM
 */
public class TryImpl extends PhpElementImpl implements Try
{

	public TryImpl(ASTNode node)
	{
		super(node);
	}

	public PhpElement getStatement()
	{
		return getFirstPsiChild();
	}

	public void accept(@NotNull PsiElementVisitor visitor)
	{
		if(visitor instanceof PhpElementVisitor)
		{
			((PhpElementVisitor) visitor).visitPhpTry(this);
		}
	}

	@Override
	public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState resolveState, PsiElement lastParent, @NotNull PsiElement source)
	{
		if(lastParent == null)
		{
			if(!getStatement().processDeclarations(processor, resolveState, null, source))
			{
				return false;
			}
		}
		return super.processDeclarations(processor, resolveState, lastParent, source);
	}

}
