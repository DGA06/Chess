package at.privat.rausch.ui;

import at.privat.rausch.pref.Pref;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    @Getter
    Point pos;

    public GameButton(Point pos, Color color) {
        this.setPreferredSize(new Dimension(
                50 * Integer.parseInt(Pref.getPref("ui_scale").orElse("1")),
                50 * Integer.parseInt(Pref.getPref("ui_scale").orElse("1"))
        ));
        this.pos = pos;
        this.setBackground(color);
    }
}
