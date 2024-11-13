package at.privat.rausch.pieces;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    void getPossibleMoves() {
        King king  = new King(new Point(4, 4), 0);
        System.out.println(king.getPossibleMoves());
        assert true;
    }
}