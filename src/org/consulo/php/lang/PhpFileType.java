package org.consulo.php.lang;

import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.consulo.php.PhpBundle;
import org.consulo.php.PhpIcons2;
import org.consulo.php.lang.highlighter.PhpSyntaxHighlighter;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jay
 * Date: 22.02.2007
 *
 * @author jay
 */
public class PhpFileType extends LanguageFileType
{
	public static final PhpFileType INSTANCE = new PhpFileType();

	public static final String DEFAULT_EXTENSION = "php";
	public static final String DESCRIPTION = PhpBundle.message("filetype.description");
	public static final String NAME = "PHP";
	public static final
	@NonNls
	String[] EXTENTIONS = new String[]{
			DEFAULT_EXTENSION,
			"inc",
			"phtml",
			"php3"
	};

	protected PhpFileType()
	{
		super(PhpLanguage.INSTANCE);
		FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, new EditorHighlighterProvider()
		{
			@Override
			public EditorHighlighter getEditorHighlighter(@Nullable Project project, @NotNull FileType fileType, @Nullable VirtualFile virtualFile, @NotNull EditorColorsScheme editorColorsScheme)
			{
				return new PhpSyntaxHighlighter(project, virtualFile, editorColorsScheme);
			}
		});
	}

	@NotNull
	@NonNls
	public String getName()
	{
		return NAME;
	}

	@NotNull
	public String getDescription()
	{
		return DESCRIPTION;
	}

	@NotNull
	@NonNls
	public String getDefaultExtension()
	{
		return DEFAULT_EXTENSION;
	}

	@Nullable
	public Icon getIcon()
	{
		return PhpIcons2.Php;
	}

}
