//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.factories;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.CellConstraints.Alignment;
import java.io.Serializable;

public final class CC implements Cloneable, Serializable {
    public static final Alignment DEFAULT;
    public static final Alignment FILL;
    public static final Alignment LEFT;
    public static final Alignment RIGHT;
    public static final Alignment CENTER;
    public static final Alignment TOP;
    public static final Alignment BOTTOM;

    public CC() {
    }

    public static CellConstraints xy(int col, int row) {
        return xywh(col, row, 1, 1);
    }

    public static CellConstraints xy(int col, int row, String encodedAlignments) {
        return xywh(col, row, 1, 1, encodedAlignments);
    }

    public static CellConstraints xy(int col, int row, Alignment colAlign, Alignment rowAlign) {
        return xywh(col, row, 1, 1, colAlign, rowAlign);
    }

    public static CellConstraints xyw(int col, int row, int colSpan) {
        return xywh(col, row, colSpan, 1, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
    }

    public static CellConstraints xyw(int col, int row, int colSpan, String encodedAlignments) {
        return xywh(col, row, colSpan, 1, encodedAlignments);
    }

    public static CellConstraints xyw(int col, int row, int colSpan, Alignment colAlign, Alignment rowAlign) {
        return xywh(col, row, colSpan, 1, colAlign, rowAlign);
    }

    public static CellConstraints xywh(int col, int row, int colSpan, int rowSpan) {
        return xywh(col, row, colSpan, rowSpan, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
    }

    public static CellConstraints xywh(int col, int row, int colSpan, int rowSpan, String encodedAlignments) {
        return (new CellConstraints()).xywh(col, row, colSpan, rowSpan, encodedAlignments);
    }

    public static CellConstraints xywh(int col, int row, int colSpan, int rowSpan, Alignment colAlign, Alignment rowAlign) {
        return new CellConstraints(col, row, colSpan, rowSpan, colAlign, rowAlign);
    }

    public static CellConstraints rc(int row, int col) {
        return rchw(row, col, 1, 1);
    }

    public static CellConstraints rc(int row, int col, String encodedAlignments) {
        return rchw(row, col, 1, 1, encodedAlignments);
    }

    public static CellConstraints rc(int row, int col, Alignment rowAlign, Alignment colAlign) {
        return rchw(row, col, 1, 1, rowAlign, colAlign);
    }

    public static CellConstraints rcw(int row, int col, int colSpan) {
        return rchw(row, col, 1, colSpan, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
    }

    public static CellConstraints rcw(int row, int col, int colSpan, String encodedAlignments) {
        return rchw(row, col, 1, colSpan, encodedAlignments);
    }

    public static CellConstraints rcw(int row, int col, int colSpan, Alignment rowAlign, Alignment colAlign) {
        return rchw(row, col, 1, colSpan, rowAlign, colAlign);
    }

    public static CellConstraints rchw(int row, int col, int rowSpan, int colSpan) {
        return rchw(row, col, rowSpan, colSpan, CellConstraints.DEFAULT, CellConstraints.DEFAULT);
    }

    public static CellConstraints rchw(int row, int col, int rowSpan, int colSpan, String encodedAlignments) {
        return (new CellConstraints()).rchw(row, col, rowSpan, colSpan, encodedAlignments);
    }

    public static CellConstraints rchw(int row, int col, int rowSpan, int colSpan, Alignment rowAlign, Alignment colAlign) {
        return xywh(col, row, colSpan, rowSpan, colAlign, rowAlign);
    }

    static {
        DEFAULT = CellConstraints.DEFAULT;
        FILL = CellConstraints.FILL;
        LEFT = CellConstraints.LEFT;
        RIGHT = CellConstraints.RIGHT;
        CENTER = CellConstraints.CENTER;
        TOP = CellConstraints.TOP;
        BOTTOM = CellConstraints.BOTTOM;
    }
}
