package at.privat.rausch.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardAdapter extends KeyAdapter {
    GameGui gui;

    public KeyboardAdapter(GameGui gui) {
        this.gui = gui;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gui.getGame().resetButtonColors();
            gui.getGame().setSelectedPiece(null);
        }
    }
}