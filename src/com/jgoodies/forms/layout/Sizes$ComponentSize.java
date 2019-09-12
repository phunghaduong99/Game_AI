//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout.Measure;
import java.awt.Component;
import java.awt.Container;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

final class Sizes$ComponentSize implements Size, Serializable {
    private final transient String name;
    private static int nextOrdinal = 0;
    private final int ordinal;

    private Sizes$ComponentSize(String name) {
        this.ordinal = nextOrdinal++;
        this.name = name;
    }

    static Sizes$ComponentSize valueOf(String str) {
        if (!str.equals("m") && !str.equals("min")) {
            if (!str.equals("p") && !str.equals("pref")) {
                return !str.equals("d") && !str.equals("default") ? null : Sizes.DEFAULT;
            } else {
                return Sizes.PREFERRED;
            }
        } else {
            return Sizes.MINIMUM;
        }
    }

    public int maximumSize(Container container, List components, Measure minMeasure, Measure prefMeasure, Measure defaultMeasure) {
        Measure measure = this == Sizes.MINIMUM ? minMeasure : (this == Sizes.PREFERRED ? prefMeasure : defaultMeasure);
        int maximum = 0;

        Component c;
        for(Iterator i = components.iterator(); i.hasNext(); maximum = Math.max(maximum, measure.sizeOf(c))) {
            c = (Component)i.next();
        }

        return maximum;
    }

    public boolean compressible() {
        return this == Sizes.DEFAULT;
    }

    public String toString() {
        return this.encode();
    }

    public String encode() {
        return this.name.substring(0, 1);
    }

    private Object readResolve() {
        return Sizes.access$100()[this.ordinal];
    }
}
