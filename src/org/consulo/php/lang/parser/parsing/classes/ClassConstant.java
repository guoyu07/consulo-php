package org.consulo.php.lang.parser.parsing.classes;

import org.consulo.php.lang.lexer.PhpTokenTypes;
import org.consulo.php.lang.parser.PhpElementTypes;
import org.consulo.php.lang.parser.parsing.expressions.StaticScalar;
import org.consulo.php.lang.parser.util.ListParsingHelper;
import org.consulo.php.lang.parser.util.PhpPsiBuilder;
import org.consulo.php.lang.parser.util.ParserPart;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;

/**
 * Created by IntelliJ IDEA.
 * User: markov
 * Date: 27.10.2007
 */
public class ClassConstant implements PhpTokenTypes
{

	//	class_constant_declaration:
	//		class_constant_declaration ',' IDENTIFIER '=' static_scalar
	//		| kwCONST IDENTIFIER '=' static_scalar
	//	;
	public static IElementType parse(PhpPsiBuilder builder)
	{
		if(!builder.compareAndEat(kwCONST))
		{
			return PhpElementTypes.EMPTY_INPUT;
		}

		ParserPart constantParser = new ParserPart()
		{
			public IElementType parse(PhpPsiBuilder builder)
			{
				if(!builder.compare(IDENTIFIER))
				{
					return PhpElementTypes.EMPTY_INPUT;
				}
				PsiBuilder.Marker classConstant = builder.mark();
				builder.match(IDENTIFIER);
				builder.match(opASGN);
				StaticScalar.parse(builder);
				classConstant.done(PhpElementTypes.CLASS_CONSTANT);
				return PhpElementTypes.CLASS_CONSTANT;
			}
		};
		ListParsingHelper.parseCommaDelimitedExpressionWithLeadExpr(builder, constantParser.parse(builder), constantParser, false);
		return PhpElementTypes.CLASS_CONSTANT;
	}

}
