//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout$1;
import com.jgoodies.forms.layout.FormLayout.CachingMeasure;
import com.jgoodies.forms.layout.FormLayout.ComponentSizeCache;
import java.awt.Component;

final class FormLayout$MinimumHeightMeasure extends CachingMeasure {
    private FormLayout$MinimumHeightMeasure(ComponentSizeCache cache) {
        super(cache, (1)null);
    }

    public int sizeOf(Component c) {
        return this.cache.getMinimumSize(c).height;
    }
}
