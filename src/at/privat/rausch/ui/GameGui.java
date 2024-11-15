package at.privat.rausch.ui;

import at.privat.rausch.common.ChessGame;
import at.privat.rausch.pieces.Piece;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class GameGui {
    @Getter
    private JPanel gamePanel;
    @Setter
    private ChessGame game;
    private final ButtonListener buttonListener;

    public GameGui(ChessGame game) {
        this.game = game;
        buttonListener = new ButtonListener(this);

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(0, 8));

        loadPanel();
        loadPieces();
    }

    private void loadPanel() {
        GameButton[][] buttons = game.getBoard().getGameField();

        for (GameButton[] row : buttons) {
            for (GameButton button : row) {
                button.setActionCommand(button.getPos().toString());
                button.addActionListener(buttonListener);
                gamePanel.add(button);
            }
        }
        gamePanel.add(new Label("Label Stuff"));
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

    public void reloadPanel() {
        gamePanel.removeAll();

        loadPanel();
    }

    public void reloadButtons() {
        loadPieces();
        game.resetButtonColors();
    }
}
