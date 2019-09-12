//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.factories;

import com.jgoodies.forms.layout.Sizes;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JLabel;

final class DefaultComponentFactory$TitledSeparatorLayout implements LayoutManager {
    private final boolean centerSeparators;

    private DefaultComponentFactory$TitledSeparatorLayout(boolean centerSeparators) {
        this.centerSeparators = centerSeparators;
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension minimumLayoutSize(Container parent) {
        return this.preferredLayoutSize(parent);
    }

    public Dimension preferredLayoutSize(Container parent) {
        Component label = this.getLabel(parent);
        Dimension labelSize = label.getPreferredSize();
        Insets insets = parent.getInsets();
        int width = labelSize.width + insets.left + insets.right;
        int height = labelSize.height + insets.top + insets.bottom;
        return new Dimension(width, height);
    }

    public void layoutContainer(Container parent) {
        synchronized(parent.getTreeLock()) {
            Dimension size = parent.getSize();
            Insets insets = parent.getInsets();
            int width = size.width - insets.left - insets.right;
            JLabel label = this.getLabel(parent);
            Dimension labelSize = label.getPreferredSize();
            int labelWidth = labelSize.width;
            int labelHeight = labelSize.height;
            Component separator1 = parent.getComponent(1);
            int separatorHeight = separator1.getPreferredSize().height;
            FontMetrics metrics = label.getFontMetrics(label.getFont());
            int ascent = metrics.getMaxAscent();
            int hGapDlu = this.centerSeparators ? 3 : 1;
            int hGap = Sizes.dialogUnitXAsPixel(hGapDlu, label);
            int vOffset = this.centerSeparators ? 1 + (labelHeight - separatorHeight) / 2 : ascent - separatorHeight / 2;
            int alignment = label.getHorizontalAlignment();
            int y = insets.top;
            int x;
            int separatorWidth;
            if (alignment == 2) {
                x = insets.left;
                label.setBounds(x, y, labelWidth, labelHeight);
                x += labelWidth;
                x += hGap;
                separatorWidth = size.width - insets.right - x;
                separator1.setBounds(x, y + vOffset, separatorWidth, separatorHeight);
            } else if (alignment == 4) {
                x = insets.left + width - labelWidth;
                label.setBounds(x, y, labelWidth, labelHeight);
                x -= hGap;
                --x;
                separatorWidth = x - insets.left;
                separator1.setBounds(insets.left, y + vOffset, separatorWidth, separatorHeight);
            } else {
                x = (width - labelWidth - 2 * hGap) / 2;
                separatorWidth = insets.left;
                separator1.setBounds(separatorWidth, y + vOffset, x - 1, separatorHeight);
                separatorWidth += x;
                separatorWidth += hGap;
                label.setBounds(separatorWidth, y, labelWidth, labelHeight);
                separatorWidth += labelWidth;
                separatorWidth += hGap;
                Component separator2 = parent.getComponent(2);
                int separatorWidth = size.width - insets.right - separatorWidth;
                separator2.setBounds(separatorWidth, y + vOffset, separatorWidth, separatorHeight);
            }

        }
    }

    private JLabel getLabel(Container parent) {
        return (JLabel)parent.getComponent(0);
    }
}
