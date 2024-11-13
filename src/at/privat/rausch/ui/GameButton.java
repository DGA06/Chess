package at.privat.rausch.ui;

import at.privat.rausch.pref.Pref;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class GameButton extends JButton {
    Point pos;

    public GameButton(Point pos, Color color) {
        this.setPreferredSize(new Dimension(
                (int) (50 * Double.parseDouble(Pref.getPref("ui_scale").orElse("1"))),
                (int) (50 * Double.parseDouble(Pref.getPref("ui_scale").orElse("1")))
        ));
        this.pos = pos;
        this.setBackground(color);
    }
}
