package at.privat.rausch;

import at.privat.rausch.pref.Pref;
import at.privat.rausch.ui.GameGui;
import at.privat.rausch.ui.KeyboardAdapter;
import lombok.Getter;

import javax.swing.*;

public class Main {
    @Getter
    private static JFrame mainFrame;

    public static void main() {
        double uiScale = Double.parseDouble(Pref.getPref("ui_scale").orElse("1"));

        GameGui gui = new GameGui();
        mainFrame = new JFrame("Simple Chess");
        mainFrame.setContentPane(gui.getGamePanel());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setBounds(500, 0,  ((int) (50 * uiScale) * 8) + 10, ((int) (50 * uiScale) * 8 ) + 30);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.addKeyListener(new KeyboardAdapter(gui));
    }
}
