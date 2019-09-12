//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout.Measure;
import com.jgoodies.forms.util.DefaultUnitConverter;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.Serializable;
import java.util.List;

public final class PrototypeSize implements Size, Serializable {
    private final String prototype;

    public PrototypeSize(String prototype) {
        this.prototype = prototype;
    }

    public String getPrototype() {
        return this.prototype;
    }

    public int maximumSize(Container container, List components, Measure minMeasure, Measure prefMeasure, Measure defaultMeasure) {
        Font font = DefaultUnitConverter.getInstance().getDefaultDialogFont();
        FontMetrics fm = container.getFontMetrics(font);
        return fm.stringWidth(this.getPrototype());
    }

    public boolean compressible() {
        return false;
    }

    public String encode() {
        return "'" + this.prototype + "'";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof PrototypeSize)) {
            return false;
        } else {
            PrototypeSize size = (PrototypeSize)o;
            return this.prototype.equals(size.prototype);
        }
    }

    public int hashCode() {
        return this.prototype.hashCode();
    }

    public String toString() {
        return this.encode();
    }
}
