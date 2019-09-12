//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.factories;

import com.jgoodies.forms.factories.DefaultComponentFactory.1;
import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;
import javax.swing.JLabel.AccessibleJLabel;

class DefaultComponentFactory$FormsLabel extends JLabel {
    private DefaultComponentFactory$FormsLabel() {
    }

    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new DefaultComponentFactory$FormsLabel.AccessibleFormsLabel((1)null);
        }

        return this.accessibleContext;
    }

    private final class AccessibleFormsLabel extends AccessibleJLabel {
        private AccessibleFormsLabel() {
            super(DefaultComponentFactory$FormsLabel.this);
        }

        public String getAccessibleName() {
            if (this.accessibleName != null) {
                return this.accessibleName;
            } else {
                String text = DefaultComponentFactory$FormsLabel.this.getText();
                if (text == null) {
                    return super.getAccessibleName();
                } else {
                    return text.endsWith(":") ? text.substring(0, text.length() - 1) : text;
                }
            }
        }
    }
}
