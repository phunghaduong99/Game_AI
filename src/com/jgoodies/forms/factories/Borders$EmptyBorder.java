//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.factories;

import com.jgoodies.forms.layout.ConstantSize;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public final class Borders$EmptyBorder extends AbstractBorder {
    private final ConstantSize top;
    private final ConstantSize left;
    private final ConstantSize bottom;
    private final ConstantSize right;

    private Borders$EmptyBorder(ConstantSize top, ConstantSize left, ConstantSize bottom, ConstantSize right) {
        if (top != null && left != null && bottom != null && right != null) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        } else {
            throw new NullPointerException("The top, left, bottom, and right must not be null.");
        }
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        insets.top = this.top.getPixelSize(c);
        insets.left = this.left.getPixelSize(c);
        insets.bottom = this.bottom.getPixelSize(c);
        insets.right = this.right.getPixelSize(c);
        return insets;
    }

    public Insets getBorderInsets(Component c) {
        return this.getBorderInsets(c, new Insets(0, 0, 0, 0));
    }

    public ConstantSize top() {
        return this.top;
    }

    public ConstantSize left() {
        return this.left;
    }

    public ConstantSize bottom() {
        return this.bottom;
    }

    public ConstantSize right() {
        return this.right;
    }
}
