package at.privat.rausch.pieces;

import at.privat.rausch.common.GameBoard;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(Point pos, PieceColor color) {
        super(pos,  new String[] {"data/queen_black.png", "data/queen_white.png"}, color);
    }

    @Override
    public ArrayList<ArrayList<Point>> getPossibleMoves() {
        ArrayList<ArrayList<Point>> posList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            posList.add(new ArrayList<>());
        }

        Point tempPos;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                switch (i) {
                    case 0 -> tempPos = new Point(pos.x + j, pos.y + j);
                    case 1 -> tempPos = new Point(pos.x - j, pos.y - j);
                    case 2 -> tempPos = new Point(pos.x - j, pos.y + j);
                    case 3 -> tempPos = new Point(pos.x + j, pos.y - j);
                    default -> tempPos = new Point(pos.x, pos.y);
                }

                if (GameBoard.validatePosition(tempPos) && !pos.equals(tempPos)) {
                    posList.get(i).add(tempPos);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                switch (i) {
                    case 0 -> tempPos = new Point(pos.x - j, pos.y);
                    case 1 -> tempPos = new Point(pos.x + j, pos.y);
                    case 2 -> tempPos = new Point(pos.x, pos.y - j);
                    case 3 -> tempPos = new Point(pos.x, pos.y + j);
                    default -> tempPos = new Point(pos);
                }

                if (GameBoard.validatePosition(tempPos) && !pos.equals(tempPos)) {
                    posList.get(i + 4).add(tempPos);
                }
            }
        }

        posList.removeIf(ArrayList::isEmpty);

        return posList;
    }
}
