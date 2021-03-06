package consulo.php.codeInsight;

import consulo.php.lang.inspections.PhpDynamicAsStaticMethodCall;
import consulo.php.lang.inspections.PhpUndefinedMethodCall;
import consulo.php.lang.inspections.PhpUndefinedVariable;
import consulo.php.lang.inspections.classes.PhpUnimplementedMethodsInClass;
import com.intellij.codeInspection.InspectionToolProvider;

/**
 * @author VISTALL
 * @since 18.09.13.
 */
public class PhpInspectionToolProvider implements InspectionToolProvider
{
	@Override
	public Class[] getInspectionClasses()
	{
		return new Class[]{
				PhpUndefinedVariable.class,
				PhpUndefinedMethodCall.class,
				PhpDynamicAsStaticMethodCall.class,
				PhpUnimplementedMethodsInClass.class,
		};
	}
}
