package at.privat.rausch.common;

import at.privat.rausch.ui.GameButton;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    @Getter
    GameButton[][] gameField;

    public GameBoard() {
        gameField = new GameButton[8][8];
        initializeButtons();
    }

    public void initializeButtons() {
        Color buttonColor;

        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[0].length; x++) {

                if ((x + y) % 2 == 0) {
                    buttonColor = Color.WHITE;
                }
                else {
                    buttonColor = Color.GRAY;
                }

                gameField[y][x] = new GameButton(new Point(x, y), buttonColor);
            }
        }
    }

    public void loadButtonColors() {
        Color buttonColor;

        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[0].length; x++) {

                if ((x + y) % 2 == 0) {
                    buttonColor = Color.WHITE;
                }
                else {
                    buttonColor = Color.GRAY;
                }

                gameField[y][x].setBackground(buttonColor);
            }
        }
    }

    public void highlightButtons(List<Point> posList) {
        for (Point pos : posList) {
            gameField[pos.y][pos.x].setBackground(Color.ORANGE);
        }
    }

    public void highlightButtons(ArrayList<ArrayList<Point>> posList) {
        for (ArrayList<Point> dirPosList : posList) {
            for (Point pos : dirPosList) {
                gameField[pos.y][pos.x].setBackground(Color.ORANGE);
            }
        }
    }

    public void highlightButton(Point pos) {
        gameField[pos.y][pos.x].setBackground(Color.RED);
    }

    public static boolean validatePosition(Point pos) {
        return (pos.x < 8 && pos.x >= 0) && (pos.y < 8 && pos.y >= 0);
    }
}