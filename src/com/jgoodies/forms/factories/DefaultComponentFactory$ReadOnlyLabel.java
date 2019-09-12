//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.factories;

import com.jgoodies.forms.factories.DefaultComponentFactory.1;
import com.jgoodies.forms.factories.DefaultComponentFactory.FormsLabel;
import java.awt.Color;
import javax.swing.UIManager;

final class DefaultComponentFactory$ReadOnlyLabel extends FormsLabel {
    private static final String[] UIMANAGER_KEYS = new String[]{"Label.disabledForeground", "Label.disabledText", "Label[Disabled].textForeground", "textInactiveText"};

    private DefaultComponentFactory$ReadOnlyLabel() {
        super((1)null);
    }

    public void updateUI() {
        super.updateUI();
        this.setForeground(this.getDisabledForeground());
    }

    private Color getDisabledForeground() {
        for(int i = 0; i < UIMANAGER_KEYS.length; ++i) {
            String key = UIMANAGER_KEYS[i];
            Color foreground = UIManager.getColor(key);
            if (foreground != null) {
                return foreground;
            }
        }

        return null;
    }
}
