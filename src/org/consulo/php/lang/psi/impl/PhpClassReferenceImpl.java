package org.consulo.php.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import lombok.val;
import org.consulo.php.completion.ClassUsageContext;
import org.consulo.php.lang.lexer.PhpTokenTypes;
import org.consulo.php.lang.parser.PhpElementTypes;
import org.consulo.php.lang.psi.PhpClass;
import org.consulo.php.lang.psi.PhpClassReference;
import org.consulo.php.lang.psi.PhpFunction;
import org.consulo.php.lang.psi.PhpPsiElementFactory;
import org.consulo.php.lang.psi.visitors.PhpElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author jay
 * @date May 11, 2008 9:56:57 PM
 */
public class PhpClassReferenceImpl extends PhpElementImpl implements PhpClassReference
{

	public PhpClassReferenceImpl(ASTNode node)
	{
		super(node);
	}

	public PsiElement getNameIdentifier()
	{
		return findChildByType(PhpTokenTypes.IDENTIFIER);
	}

	@Override
	public String getReferenceName()
	{
		return getText();
	}

	@Override
	public void accept(@NotNull PhpElementVisitor visitor) {
		visitor.visitClassReference(this);
	}

	@Override
	public PsiReference getReference()
	{
		return this;
	}

	@Override
	@SuppressWarnings({"ConstantConditions"})
	@NotNull
	public ResolveResult[] multiResolve(boolean incompleteCode)
	{
		/*boolean instantiation = getParent() instanceof NewExpression;

		if(getReferenceName().equals("self"))
		{
			final PhpClass phpClass = PsiTreeUtil.getParentOfType(this, PhpClass.class);
			if(phpClass != null)
			{
				return new ResolveResult[]{new PhpResolveResult(phpClass)};
			}
		}
		if(getReferenceName().equals("parent"))
		{
			final PhpClass phpClass = PsiTreeUtil.getParentOfType(this, PhpClass.class);
			if(phpClass != null)
			{
				final PhpClass superClass = phpClass.getSuperClass();
				if(superClass != null)
				{
					return new ResolveResult[]{new PhpResolveResult(superClass)};
				}
			}
		}

		DeclarationsIndex index = DeclarationsIndex.getInstance(this);
		if(index == null)
		{
			return ResolveResult.EMPTY_ARRAY;
		}
		List<LightPhpClass> classes = index.getClassesByName(getReferenceName());
		List<LightPhpInterface> interfaces = index.getInterfacesByName(getReferenceName());
		ResolveResult[] result = new ResolveResult[classes.size() + interfaces.size()];
		for(int i = 0; i < classes.size(); i++)
		{
			final PsiElement element;
			final PhpClass klass = (PhpClass) classes.get(i).getPsi(getProject());
			if(klass != null && instantiation)
			{
				PhpMethod constructor = klass.getConstructor();
				if(constructor == null)
				{
					element = klass;
				}
				else
				{
					element = constructor;
				}
			}
			else
			{
				element = klass;
			}
			result[i] = new PhpResolveResult(element);
		}
		for(int i = 0; i < interfaces.size(); i++)
		{
			final PhpClass anInterface = (PhpClass) interfaces.get(i).getPsi(getProject());
			result[i + classes.size()] = new PhpResolveResult(anInterface);
		}
		return result; */
		return new ResolveResult[0];
	}

	@Override
	public PsiElement getElement()
	{
		return this;
	}

	@Override
	public TextRange getRangeInElement()
	{
		return new TextRange(0, getTextLength());
	}

	@Override
	@Nullable
	public PsiElement resolve()
	{
		ResolveResult[] results = multiResolve(false);
		if(results.length == 1)
		{
			return results[0].getElement();
		}
		return null;
	}

	@Override
	public String getCanonicalText()
	{
		return null;
	}

	@Override
	public PsiElement handleElementRename(String name) throws IncorrectOperationException
	{
		PsiElement nameIdentifier = getNameIdentifier();
		//noinspection ConstantConditions
		if(nameIdentifier != null && !getReferenceName().equals(name))
		{
			val constantReference = PhpPsiElementFactory.createConstantReference(getProject(), name);
			nameIdentifier.replace(constantReference.getNameIdentifier());
		}
		return this;
	}

	@Override
	public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException
	{
		return null;
	}

	@Override
	public boolean isReferenceTo(PsiElement element)
	{
		if(element instanceof PhpClass || element instanceof PhpFunction)
		{
			val resolveResult = resolve();
			val isReference = element == resolveResult;
			if(isReference)
			{
				return isReference;
			}
			if(element instanceof PhpClass && resolveResult instanceof PhpFunction)
			{
				return PsiTreeUtil.getParentOfType(resolveResult, PhpClass.class) == element;
			}
		}
		return false;
	}

	private ClassUsageContext getUsageContext()
	{
		ClassUsageContext context = new ClassUsageContext();
		//noinspection ConstantConditions
		val parent = getParent().getNode().getElementType();
		if(parent == PhpElementTypes.INSTANCEOF_EXPRESSION)
		{
			context.setInInstanceof(true);
		}
		if(parent == PhpElementTypes.EXTENDS_LIST)
		{
			context.setInExtends(true);
		}
		if(parent == PhpElementTypes.IMPLEMENTS_LIST)
		{
			context.setInImplements(true);
		}
		if(parent == PhpElementTypes.NEW_EXPRESSION)
		{
			context.setInNew(true);
		}
		return context;
	}

	@Override
	public Object[] getVariants()
	{
		/*Collection<PhpClass> classes = PhpIndexUtil.getClasses(this);
		final List<LookupElement> list = PhpVariantsUtil.getLookupItemsForClasses(classes, getUsageContext());
		return list.toArray(new LookupElement[list.size()]);   */
		return new Object[0];
	}

	@Override
	public boolean isSoft()
	{
		return false;
	}
}