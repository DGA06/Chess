package at.privat.rausch.ui;

import at.privat.rausch.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    GameGui gui;

    public ButtonListener(GameGui gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String posString = command.split("\\[")[1];
        posString = posString.replaceAll("]", "");
        int posX = Integer.parseInt(posString.split(",")[0].split("=")[1]);
        int posY = Integer.parseInt(posString.split(",")[1].split("=")[1]);
        //System.out.println(posX + "    " + posY);

        Point buttonPos = new Point(posX, posY);

        if (gui.getGame().getSelectedPiece() != null) {
            gui.getGame().moveSelectedPiece(buttonPos);
            gui.reloadButtons();
            return;
        }

        if (!gui.getGame().isFree(buttonPos)) {
            gui.getGame().setSelectedPiece(gui.getGame().getPiece(buttonPos));
            gui.getGame().resetButtonColors();
            gui.getGame().highlightButtons(buttonPos);
        }

        Main.getMainFrame().requestFocus();
    }
}