//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import java.io.Serializable;

public final class ConstantSize$Unit implements Serializable {
    private final transient String name;
    private final transient String abbreviation;
    private final transient String parseAbbreviation;
    final transient boolean requiresIntegers;
    private static int nextOrdinal = 0;
    private final int ordinal;

    private ConstantSize$Unit(String name, String abbreviation, String parseAbbreviation, boolean requiresIntegers) {
        this.ordinal = nextOrdinal++;
        this.name = name;
        this.abbreviation = abbreviation;
        this.parseAbbreviation = parseAbbreviation;
        this.requiresIntegers = requiresIntegers;
    }

    static ConstantSize$Unit valueOf(String name, boolean horizontal) {
        if (name.length() == 0) {
            ConstantSize$Unit defaultUnit = Sizes.getDefaultUnit();
            if (defaultUnit != null) {
                return defaultUnit;
            } else {
                return horizontal ? ConstantSize.DIALOG_UNITS_X : ConstantSize.DIALOG_UNITS_Y;
            }
        } else if (name.equals("px")) {
            return ConstantSize.PIXEL;
        } else if (name.equals("dlu")) {
            return horizontal ? ConstantSize.DIALOG_UNITS_X : ConstantSize.DIALOG_UNITS_Y;
        } else if (name.equals("pt")) {
            return ConstantSize.POINT;
        } else if (name.equals("in")) {
            return ConstantSize.INCH;
        } else if (name.equals("mm")) {
            return ConstantSize.MILLIMETER;
        } else if (name.equals("cm")) {
            return ConstantSize.CENTIMETER;
        } else {
            throw new IllegalArgumentException("Invalid unit name '" + name + "'. Must be one of: " + "px, dlu, pt, mm, cm, in");
        }
    }

    public String toString() {
        return this.name;
    }

    public String encode() {
        return this.parseAbbreviation != null ? this.parseAbbreviation : this.abbreviation;
    }

    public String abbreviation() {
        return this.abbreviation;
    }

    private Object readResolve() {
        return ConstantSize.access$100()[this.ordinal];
    }
}
