package at.privat.rausch.pieces;

import at.privat.rausch.common.GameBoard;

import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{
    public King(Point pos, PieceColor color) {
        super(pos, new String[] {"data/pawn_black.png", "data/pawn_white.png"}, color);
    }

    public ArrayList<ArrayList<Point>> getPossibleMoves () {
        ArrayList<ArrayList<Point>> posList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            posList.add(new ArrayList<>());
        }

        Point tempPos;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                tempPos = new Point(pos.x + x, pos.y + y);
                if (GameBoard.validatePosition(tempPos) && !tempPos.equals(pos)) {
                    posList.add(new ArrayList<>());
                    posList.get(posList.size() - 1).add(tempPos);
                }
            }
        }
        posList.removeIf(ArrayList::isEmpty);

        return posList;
    }
}
