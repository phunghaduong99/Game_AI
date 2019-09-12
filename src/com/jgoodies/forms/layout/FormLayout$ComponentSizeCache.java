//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import java.awt.Component;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

final class FormLayout$ComponentSizeCache implements Serializable {
    private final Map minimumSizes;
    private final Map preferredSizes;

    private FormLayout$ComponentSizeCache(int initialCapacity) {
        this.minimumSizes = new HashMap(initialCapacity);
        this.preferredSizes = new HashMap(initialCapacity);
    }

    void invalidate() {
        this.minimumSizes.clear();
        this.preferredSizes.clear();
    }

    Dimension getMinimumSize(Component component) {
        Dimension size = (Dimension)this.minimumSizes.get(component);
        if (size == null) {
            size = component.getMinimumSize();
            this.minimumSizes.put(component, size);
        }

        return size;
    }

    Dimension getPreferredSize(Component component) {
        Dimension size = (Dimension)this.preferredSizes.get(component);
        if (size == null) {
            size = component.getPreferredSize();
            this.preferredSizes.put(component, size);
        }

        return size;
    }

    void removeEntry(Component component) {
        this.minimumSizes.remove(component);
        this.preferredSizes.remove(component);
    }
}
