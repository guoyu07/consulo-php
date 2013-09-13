package org.consulo.php;

import org.consulo.php.completion.PhpCompletionData;
import org.consulo.php.lang.PHPFileType;
import org.consulo.php.lang.inspections.PhpDynamicAsStaticMethodCall;
import org.consulo.php.lang.inspections.PhpUndefinedMethodCall;
import org.consulo.php.lang.inspections.PhpUndefinedVariable;
import org.consulo.php.lang.inspections.classes.PhpUnimplementedMethodsInClass;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.codeInsight.completion.CompletionUtil;
import com.intellij.codeInspection.InspectionToolProvider;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlFileNSInfoProvider;
import com.intellij.xml.util.XmlUtil;

/**
 * Created by IntelliJ IDEA.
 * User: jay
 * Date: 22.02.2007
 *
 * @author jay
 */
public class PHPSupportApplicationComponent implements ApplicationComponent, InspectionToolProvider
{

	public PHPSupportApplicationComponent()
	{
	}

	public void initComponent()
	{
		ApplicationManager.getApplication().runWriteAction(new Runnable()
		{
			public void run()
			{
				CompletionUtil.registerCompletionData(PHPFileType.INSTANCE, new PhpCompletionData());
			}
		});
	}

	public void disposeComponent()
	{
	}

	@NotNull
	public String getComponentName()
	{
		return "PHPSupportApplicationComponent";
	}

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