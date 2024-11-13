package at.privat.rausch.pieces;

import at.privat.rausch.common.GameBoard;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Point pos, PieceColor color) {
        super(pos, new String[] {"data/pawn_black.png", "data/pawn_white.png"}, color);
    }

    @Override
    public ArrayList<ArrayList<Point>> getPossibleMoves() {
        ArrayList<ArrayList<Point>> posList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            posList.add(new ArrayList<>());
        }

        posList.get(0).add(new Point(pos.x + 2, pos.y - 1));
        posList.get(1).add(new Point(pos.x + 2, pos.y + 1));

        posList.get(2).add(new Point(pos.x - 2, pos.y - 1));
        posList.get(3).add(new Point(pos.x - 2, pos.y + 1));

        posList.get(4).add(new Point(pos.x - 1, pos.y + 2));
        posList.get(5).add(new Point(pos.x + 1, pos.y + 2));

        posList.get(6).add(new Point(pos.x - 1, pos.y - 2));
        posList.get(7).add(new Point(pos.x + 1, pos.y - 2));

        for (ArrayList<Point> dirPos : posList) {
            dirPos.removeIf(tempPos -> !GameBoard.validatePosition(tempPos));
        }
        posList.removeIf(ArrayList::isEmpty);

        return posList;
    }
}
