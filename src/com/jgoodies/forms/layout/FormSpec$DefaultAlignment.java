//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import java.io.Serializable;

public final class FormSpec$DefaultAlignment implements Serializable {
    private final transient String name;
    private static int nextOrdinal = 0;
    private final int ordinal;

    private FormSpec$DefaultAlignment(String name) {
        this.ordinal = nextOrdinal++;
        this.name = name;
    }

    private static FormSpec$DefaultAlignment valueOf(String str, boolean isHorizontal) {
        if (!str.equals("f") && !str.equals("fill")) {
            if (!str.equals("c") && !str.equals("center")) {
                if (isHorizontal) {
                    if (!str.equals("r") && !str.equals("right")) {
                        return !str.equals("l") && !str.equals("left") ? null : FormSpec.LEFT_ALIGN;
                    } else {
                        return FormSpec.RIGHT_ALIGN;
                    }
                } else if (!str.equals("t") && !str.equals("top")) {
                    return !str.equals("b") && !str.equals("bottom") ? null : FormSpec.BOTTOM_ALIGN;
                } else {
                    return FormSpec.TOP_ALIGN;
                }
            } else {
                return FormSpec.CENTER_ALIGN;
            }
        } else {
            return FormSpec.FILL_ALIGN;
        }
    }

    public String toString() {
        return this.name;
    }

    public char abbreviation() {
        return this.name.charAt(0);
    }

    private Object readResolve() {
        return FormSpec.access$200()[this.ordinal];
    }
}
