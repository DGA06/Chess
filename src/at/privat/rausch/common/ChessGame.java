package at.privat.rausch.common;

import at.privat.rausch.pieces.*;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;

public class ChessGame {
    @Getter
    private final Piece[][] pieces;
    private ArrayList<Piece> beatenPieces;
    @Getter
    private final GameBoard board;
    @Getter
    private Piece selectedPiece;
    private ArrayList<ArrayList<Point>> possibleMoves;

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
        if (selectedPiece != null) {
            possibleMoves = selectedPiece.getPossibleMoves();
        }
    }

    public ChessGame() {
        board = new GameBoard();
        pieces = new Piece[8][8];
        initializePieces();
    }

    private void initializePieces() {
        for (int i = 0; i < 8; i++) {
            pieces[1][i] = new Pawn(new Point(i, 1), PieceColor.BLACK);
            pieces[6][i] = new Pawn(new Point(i, 6), PieceColor.WHITE);
        }

        for (PieceColor color : PieceColor.values()) {
            int posY = color.getValue() * 7;
            pieces[posY][0] = new Rook(new Point(0,posY), color);
            pieces[posY][7] = new Rook(new Point(7,posY), color);
            pieces[posY][2] = new Bishop(new Point(2,posY), color);
            pieces[posY][5] = new Bishop(new Point(5,posY), color);
        }
    }

    public void moveSelectedPiece(Point dest) {
        movePiece(selectedPiece.getPos(), dest);
    }

    public void movePiece(Point pos, Point dest) {
        if (notPossible(dest)) {
            selectedPiece = null;
            return;
        }

        if (pieces[dest.y][dest.x] == null) {
            pieces[dest.y][dest.x] = pieces[pos.y][pos.x];
        }

        pieces[pos.y][pos.x] = null;
        pieces[dest.y][dest.x].move(dest);

        selectedPiece = null;
    }

    public boolean isFree(Point pos) {
        return pieces[pos.y][pos.x] == null;
    }

    public boolean notPossible(Point dest) {
        for (ArrayList<Point> directionMoves : possibleMoves) {
            if (directionMoves.contains(dest) && isFree(dest)) {
                return false;
            }
        }
        return true;
    }

    public Piece getPiece(Point pos) {
        return pieces[pos.y][pos.x];
    }

    public void highlightButtons(Point pos) {
        board.highlightButton(pos);
        board.highlightButtons(getPiece(pos).getPossibleMoves());
    }

    public void highlightButtons(Piece piece) {
        board.highlightButton(piece.getPos());
        board.highlightButtons(piece.getPossibleMoves());
    }

    public void resetButtonColors() {
        board.loadButtonColors();
    }
}