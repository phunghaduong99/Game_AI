//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout.Measure;
import java.awt.Container;
import java.util.List;

public interface Size {
    int maximumSize(Container var1, List var2, Measure var3, Measure var4, Measure var5);

    boolean compressible();

    String encode();
}
