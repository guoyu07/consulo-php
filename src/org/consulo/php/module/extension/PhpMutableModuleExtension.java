package org.consulo.php.module.extension;

import javax.swing.JComponent;

import org.consulo.module.extension.MutableModuleExtensionWithSdk;
import org.consulo.module.extension.MutableModuleInheritableNamedPointer;
import org.consulo.php.PhpLanguageLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModifiableRootModel;

/**
 * @author VISTALL
 * @since 04.07.13.
 */
public class PhpMutableModuleExtension extends PhpModuleExtension implements MutableModuleExtensionWithSdk<PhpModuleExtension>
{
	public PhpMutableModuleExtension(@NotNull String id, @NotNull Module module)
	{
		super(id, module);
	}

	@NotNull
	@Override
	public MutableModuleInheritableNamedPointer<Sdk> getInheritableSdk()
	{
		return (MutableModuleInheritableNamedPointer<Sdk>) super.getInheritableSdk();
	}

	@Override
	@NotNull
	public MutableModuleInheritableNamedPointer<PhpLanguageLevel> getInheritableLanguageLevel()
	{
		return myLanguageLevel;
	}

	@Nullable
	@Override
	public JComponent createConfigurablePanel(@NotNull ModifiableRootModel modifiableRootModel, @Nullable Runnable runnable)
	{
		return new PhpModuleExtensionPanel(this, runnable);
	}

	@Override
	public void setEnabled(boolean b)
	{
		myIsEnabled = b;
	}

	@Override
	public boolean isModified(@NotNull PhpModuleExtension extension)
	{
		return isModifiedImpl(extension) || !extension.getInheritableLanguageLevel().equals(getInheritableLanguageLevel());
	}
}
