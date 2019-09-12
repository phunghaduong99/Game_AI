//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout.ComponentSizeCache;
import com.jgoodies.forms.layout.FormLayout.Measure;
import java.io.Serializable;

abstract class FormLayout$CachingMeasure implements Measure, Serializable {
    protected final ComponentSizeCache cache;

    private FormLayout$CachingMeasure(ComponentSizeCache cache) {
        this.cache = cache;
    }
}
