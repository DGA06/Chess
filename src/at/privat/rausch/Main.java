package at.privat.rausch;

import at.privat.rausch.common.ChessGame;
import at.privat.rausch.pref.Pref;
import at.privat.rausch.ui.GameGui;
import at.privat.rausch.ui.KeyboardAdapter;
import lombok.Getter;

import javax.swing.*;

public class Main {
    @Getter
    private static JFrame mainFrame;
    @Getter
    private static ChessGame game;
    private static final GameGui gui;

    static {
        game = new ChessGame();
        gui = new GameGui(game);
    }

    public static void main() {
        double uiScale = Double.parseDouble(Pref.getPref("ui_scale").orElse("1"));

        mainFrame = new JFrame("Simple Chess");
        mainFrame.setContentPane(gui.getGamePanel());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setBounds(500, 0,  ((int) (50 * uiScale) * 8) + 10, ((int) (50 * uiScale) * 8 ) + 30);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.addKeyListener(KeyboardAdapter.getINSTANCE());
        mainFrame.requestFocus();
    }

    public static void hardReset() {
        game = new ChessGame();
        gui.setGame(game);
        gui.reloadPanel();
        gui.reloadButtons();
        mainFrame.requestFocus();
    }
}
