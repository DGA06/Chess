package at.privat.rausch.ui;

import at.privat.rausch.common.ChessGame;
import at.privat.rausch.pieces.Piece;
import at.privat.rausch.pref.Pref;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class GameGui {
    @Getter
    private JPanel gamePanel;
    private final ChessGame game;
    private final ButtonListener buttonListener;

    public GameGui(ChessGame game) {
        this.game = game;
        buttonListener = new ButtonListener(this);
        loadPanel();
        loadPieces();
    }

    private void loadPanel() {
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(0, 8));

        GameButton[][] buttons = game.getBoard().getGameField();

        for (GameButton[] row : buttons) {
            for (GameButton button : row) {
                button.setActionCommand(button.getPos().toString());
                button.addActionListener(buttonListener);
                gamePanel.add(button);
            }
        }
        gamePanel.add(new Label());
    }

    private void loadPieces() {
        GameButton[][] buttons = game.getBoard().getGameField();
        Piece[][] pieces = game.getPieces();

        for (GameButton[] row : buttons) {
            for (GameButton button : row) {
                button.setIcon(null);
            }
        }

        for (Piece[] row : pieces) {
            for (Piece piece : row) {
                if (piece != null) {
                    if (!piece.isBeaten()) {
                        buttons[piece.getPos().y][piece.getPos().x].setIcon(new ImageIcon(piece.getSkins()[piece.getColor().getValue()]));
                    }
                }
            }
        }
    }

    public void reloadButtons() {
        loadPieces();
        game.resetButtonColors();
    }
}
