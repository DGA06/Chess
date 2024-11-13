package at.privat.rausch.pieces;

import at.privat.rausch.common.GameBoard;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Point pos, PieceColor color) {
        super(pos, new String[] {"data/bishop_black.png", "data/bishop_white.png"}, color);
    }

    @Override
    public ArrayList<ArrayList<Point>> getPossibleMoves() {
        ArrayList<ArrayList<Point>> posList = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
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
        posList.removeIf(ArrayList::isEmpty);

        return posList;
    }
}
