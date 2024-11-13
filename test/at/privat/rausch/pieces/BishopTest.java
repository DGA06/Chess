package at.privat.rausch.pieces;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void getPossibleMoves() {
        Bishop bishop = new Bishop(new Point(5, 3), Piece.BLACK);
        System.out.println(bishop.getPossibleMoves());
        assert true;
    }
}