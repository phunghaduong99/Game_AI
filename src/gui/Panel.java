//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import map.Map;

public class Panel extends JPanel implements MouseListener {
    Button[][] buttons = new Button[11][11];
    JButton butok = new JButton("OK");
    Frame jf;
    Font font = new Font("MV Boli", 1, 18);

    public Panel(Frame jf) {
        this.jf = jf;
        this.butok.setBackground(Color.decode("#f1f1f1"));
        this.butok.setFont(this.font);
        this.butok.setIcon(new ImageIcon(this.getClass().getResource("/lib/ok.png")));
        this.butok.setText((String)null);
        this.butok.setCursor(new Cursor(12));
        this.butok.setBorder((Border)null);
        this.addMouseListener(this);
        this.setFocusable(true);

        int i;
        int j;
        for(i = 0; i < 11; ++i) {
            for(j = 0; j < 11; ++j) {
                this.buttons[i][j] = new Button();
            }
        }

        this.setLayout(new GridLayout(11, 11));

        for(i = 0; i < 11; ++i) {
            for(j = 0; j < 11; ++j) {
                if (i == 5 && j == 5) {
                    this.add(this.butok);
                    this.butok.addMouseListener(this);
                } else {
                    this.add(this.buttons[i][j]);
                    this.buttons[i][j].addMouseListener(this);
                }
            }
        }

    }

    public void mouseClicked(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == this.butok) {
            Map map = new Map(this.getMap());
            this.jf.play(map);
        }

    }

    public void mouseReleased(MouseEvent arg0) {
        for(int i = 0; i < 11; ++i) {
            for(int j = 0; j < 11; ++j) {
                if (arg0.getSource() == this.buttons[i][j]) {
                    this.buttons[i][j].click();
                    this.buttons[10 - i][10 - j].setClick();
                }
            }
        }

    }

    public Map getMap() {
        int[][] map = new int[11][11];

        for(int i = 0; i < 11; ++i) {
            for(int j = 0; j < 11; ++j) {
                if (this.buttons[i][j].isSelected()) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        return new Map(map);
    }

    public void check() {
        for(int i = 0; i < 11; ++i) {
            for(int j = 0; j < 11; ++j) {
                if (this.buttons[i][j].isSelected() && !this.buttons[10 - i][10 - j].isSelected()) {
                    this.buttons[i][j].reset();
                    this.buttons[10 - i][10 - j].reset();
                }
            }
        }

    }
}
