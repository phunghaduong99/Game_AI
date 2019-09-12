//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.factories;

import com.jgoodies.forms.factories.DefaultComponentFactory.FormsLabel;
import javax.swing.JLabel.AccessibleJLabel;

final class DefaultComponentFactory$FormsLabel$AccessibleFormsLabel extends AccessibleJLabel {
    private DefaultComponentFactory$FormsLabel$AccessibleFormsLabel(FormsLabel var1) {
        super(var1);
        this.this$0 = var1;
    }

    public String getAccessibleName() {
        if (this.accessibleName != null) {
            return this.accessibleName;
        } else {
            String text = this.this$0.getText();
            if (text == null) {
                return super.getAccessibleName();
            } else {
                return text.endsWith(":") ? text.substring(0, text.length() - 1) : text;
            }
        }
    }
}
