package at.privat.rausch.pieces;

import at.privat.rausch.common.GameBoard;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean moved = false;

    public Pawn(Point pos, PieceColor color) {
        super(pos, new String[] {"data/pawn_black.png", "data/pawn_white.png"}, color);
    }

    @Override
    public ArrayList<ArrayList<Point>> getPossibleMoves() {
        ArrayList<ArrayList<Point>> posList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            posList.add(new ArrayList<>());
        }

        Point tempPos;

        for (int i = -1; i <= 1; i++) {
            switch (color) {
                case BLACK -> tempPos = new Point(pos.x + i, pos.y + 1);
                case WHITE -> tempPos = new Point(pos.x + i, pos.y - 1);
                default -> tempPos = new Point(pos.x, pos.y);
            }
            if (GameBoard.validatePosition(tempPos)) {
               posList.get(i + 1).add(tempPos);
            }
        }

        if (!moved) {
            switch (color) {
                case BLACK -> tempPos = new Point(pos.x, pos.y + 2);
                case WHITE -> tempPos = new Point(pos.x, pos.y - 2);
                default -> tempPos = new Point(pos.x, pos.y);
            }
            posList.get(1).add(tempPos);
        }
        posList.removeIf(ArrayList::isEmpty);

        return posList;
    }

    @Override
    public void move(Point newPos) {
        super.move(newPos);
        if (!moved) {
            moved = true;
        }
    }
}
