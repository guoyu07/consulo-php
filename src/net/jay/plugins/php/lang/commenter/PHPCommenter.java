package net.jay.plugins.php.lang.commenter;

import net.jay.plugins.php.lang.lexer.PHPTokenTypes;

import org.jetbrains.annotations.Nullable;
import com.intellij.lang.CodeDocumentationAwareCommenter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;

/**
 * @author jay
 * @time 21.12.2007 18:41:02
 */
public class PHPCommenter implements CodeDocumentationAwareCommenter
{
	@Nullable
	public String getLineCommentPrefix()
	{
		return "//";
	}

	@Nullable
	public String getBlockCommentPrefix()
	{
		return "/*";
	}

	@Nullable
	public String getBlockCommentSuffix()
	{
		return "*/";
	}

	@Nullable
	@Override
	public String getCommentedBlockCommentPrefix()
	{
		return null;
	}

	@Nullable
	@Override
	public String getCommentedBlockCommentSuffix()
	{
		return null;
	}

	@Nullable
	public IElementType getLineCommentTokenType()
	{
		return PHPTokenTypes.LINE_COMMENT;
	}

	@Nullable
	public IElementType getBlockCommentTokenType()
	{
		return PHPTokenTypes.C_STYLE_COMMENT;
	}

	@Nullable
	public IElementType getDocumentationCommentTokenType()
	{
		return PHPTokenTypes.DOC_COMMENT;
	}

	@Nullable
	public String getDocumentationCommentPrefix()
	{
		return "/**";
	}

	@Nullable
	public String getDocumentationCommentLinePrefix()
	{
		return "*";
	}

	@Nullable
	public String getDocumentationCommentSuffix()
	{
		return " */";
	}

	public boolean isDocumentationComment(PsiComment element)
	{
		return element.getText().startsWith(getDocumentationCommentPrefix());
	}
}
