package at.privat.rausch.pieces;

import lombok.Getter;

@Getter
public enum PieceColor {
    BLACK(0),
    WHITE(1);

    private int value;

    PieceColor(int i) {
        value = i;
    }
}
