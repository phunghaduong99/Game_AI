//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gui;

import java.awt.Component;
import java.io.FileNotFoundException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        Frame jf = new Frame("AI");
        jf.add(new PN(jf));
        jf.setVisible(true);
        jf.setSize(700, 720);
        jf.setResizable(false);
        jf.setLocationRelativeTo((Component)null);
        jf.setAlwaysOnTop(false);
        jf.setDefaultCloseOperation(3);
    }
    
 
    
}
