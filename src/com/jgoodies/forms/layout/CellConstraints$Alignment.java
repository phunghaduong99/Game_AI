//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import java.io.Serializable;
import java.util.Locale;

public final class CellConstraints$Alignment implements Serializable {
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int BOTH = 2;
    private final transient String name;
    private final transient int orientation;
    private static int nextOrdinal = 0;
    private final int ordinal;

    private CellConstraints$Alignment(String name, int orientation) {
        this.ordinal = nextOrdinal++;
        this.name = name;
        this.orientation = orientation;
    }

    static CellConstraints$Alignment valueOf(String nameOrAbbreviation) {
        String str = nameOrAbbreviation.toLowerCase(Locale.ENGLISH);
        if (!str.equals("d") && !str.equals("default")) {
            if (!str.equals("f") && !str.equals("fill")) {
                if (!str.equals("c") && !str.equals("center")) {
                    if (!str.equals("l") && !str.equals("left")) {
                        if (!str.equals("r") && !str.equals("right")) {
                            if (!str.equals("t") && !str.equals("top")) {
                                if (!str.equals("b") && !str.equals("bottom")) {
                                    throw new IllegalArgumentException("Invalid alignment " + nameOrAbbreviation + ". Must be one of: left, center, right, top, bottom, " + "fill, default, l, c, r, t, b, f, d.");
                                } else {
                                    return CellConstraints.BOTTOM;
                                }
                            } else {
                                return CellConstraints.TOP;
                            }
                        } else {
                            return CellConstraints.RIGHT;
                        }
                    } else {
                        return CellConstraints.LEFT;
                    }
                } else {
                    return CellConstraints.CENTER;
                }
            } else {
                return CellConstraints.FILL;
            }
        } else {
            return CellConstraints.DEFAULT;
        }
    }

    public String toString() {
        return this.name;
    }

    public char abbreviation() {
        return this.name.charAt(0);
    }

    private boolean isHorizontal() {
        return this.orientation != 1;
    }

    private boolean isVertical() {
        return this.orientation != 0;
    }

    private Object readResolve() {
        return CellConstraints.access$300()[this.ordinal];
    }
}
