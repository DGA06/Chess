package at.privat.rausch.pieces;

import at.privat.rausch.common.GameBoard;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(Point pos, PieceColor color) {
        super(pos,  new String[] {"data/rook_black.png", "data/rook_white.png"}, color);
    }

    @Override
    public ArrayList<ArrayList<Point>> getPossibleMoves() {
        ArrayList<ArrayList<Point>> posList = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            posList.add(new ArrayList<>());
        }

        Point tempPos;

        int[] bounds = new int[]{0, 0};
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0 -> bounds = new int[]{0, pos.x};
                case 1 -> bounds = new int[]{pos.x, 8};
                case 2 -> bounds = new int[]{0, pos.y};
                case 3 -> bounds = new int[]{pos.y, 8};
            }

            for (int j = bounds[0]; j < bounds[1]; j++) {
                switch (i) {
                    case 0, 1 -> tempPos = new Point(j, pos.y);
                    case 2, 3 -> tempPos = new Point(pos.x, j);
                    default -> tempPos = new Point(pos);
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