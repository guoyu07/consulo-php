package org.consulo.php.lang.psi.impl;

import com.intellij.lang.ASTNode;
import org.consulo.php.lang.psi.PhpClassReference;
import org.consulo.php.lang.psi.PhpNamespaceStatement;
import org.consulo.php.lang.psi.visitors.PhpElementVisitor;
import org.jetbrains.annotations.NotNull;

/**
 * @author VISTALL
 * @since 19.09.13.
 */
public class PhpNamespaceStatementImpl extends PhpElementImpl implements PhpNamespaceStatement {
	public PhpNamespaceStatementImpl(ASTNode node) {
		super(node);
	}

	@Override
	public void accept(@NotNull PhpElementVisitor visitor) {
		visitor.visitNamespaceStatement(this);
	}

	@Override
	public PhpClassReference getPackageReference() {
		return findNotNullChildByClass(PhpClassReference.class);
	}
}