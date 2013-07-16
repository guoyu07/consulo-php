package org.consulo.php.module.extension;

import com.intellij.openapi.module.Module;
import net.jay.plugins.php.PHPIcons2;
import org.consulo.module.extension.ModuleExtensionProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author VISTALL
 * @since 04.07.13.
 */
public class PhpModuleExtensionProvider implements ModuleExtensionProvider<PhpModuleExtension, PhpMutableModuleExtension> {
	@Nullable
	@Override
	public Icon getIcon() {
		return PHPIcons2.Php;
	}

	@NotNull
	@Override
	public String getName() {
		return "PHP";
	}

	@NotNull
	@Override
	public Class<PhpModuleExtension> getImmutableClass() {
		return PhpModuleExtension.class;
	}

	@NotNull
	@Override
	public PhpModuleExtension createImmutable(@NotNull String s, @NotNull Module module) {
		return new PhpModuleExtension(s, module);
	}

	@NotNull
	@Override
	public PhpMutableModuleExtension createMutable(@NotNull String s, @NotNull Module module, @NotNull PhpModuleExtension phpModuleExtension) {
		return new PhpMutableModuleExtension(s, module, phpModuleExtension);
	}
}