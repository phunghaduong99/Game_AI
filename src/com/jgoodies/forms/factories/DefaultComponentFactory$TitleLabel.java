//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.factories;

import com.jgoodies.forms.factories.DefaultComponentFactory.1;
import com.jgoodies.forms.factories.DefaultComponentFactory.FormsLabel;
import com.jgoodies.forms.util.FormUtils;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

final class DefaultComponentFactory$TitleLabel extends FormsLabel {
    private DefaultComponentFactory$TitleLabel() {
        super((1)null);
    }

    public void updateUI() {
        super.updateUI();
        Color foreground = this.getTitleColor();
        if (foreground != null) {
            this.setForeground(foreground);
        }

        this.setFont(this.getTitleFont());
    }

    private Color getTitleColor() {
        return UIManager.getColor("TitledBorder.titleColor");
    }

    private Font getTitleFont() {
        return FormUtils.isLafAqua() ? UIManager.getFont("Label.font").deriveFont(1) : UIManager.getFont("TitledBorder.font");
    }
}
