package at.privat.rausch.ui;

import at.privat.rausch.Main;
import lombok.Getter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardAdapter extends KeyAdapter {
    @Getter
    private static final KeyboardAdapter INSTANCE;

    static {
        INSTANCE = new KeyboardAdapter();
    }

    private KeyboardAdapter() {}

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Main.getGame().resetButtonColors();
            Main.getGame().setSelectedPiece(null);
        }

        if (e.getKeyCode() == KeyEvent.VK_R && e.isControlDown() && e.isAltDown()) {
            Main.hardReset();
        }
    }
}
