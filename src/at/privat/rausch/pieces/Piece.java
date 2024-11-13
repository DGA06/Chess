package at.privat.rausch.pieces;

import at.privat.rausch.pref.Pref;
import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Getter
public abstract class Piece {

    protected Image[] skins;
    protected Point pos;
    protected boolean beaten = false;
    protected PieceColor color;

    Piece(Point pos, String[] imgPaths, PieceColor color) {
        this.pos = pos;
        this.color = color;
        importImages(imgPaths);
    }

    public abstract ArrayList<ArrayList<Point>> getPossibleMoves();

    public void move(Point newPos) {
        pos = newPos;
    }

    private void importImages(String[] paths) {
        skins = new Image[paths.length];

        for (int i = 0; i < paths.length; i++) {
            try {
                skins[i] = ImageIO.read(new File(paths[i])).getScaledInstance(
                        (int) (50 * Double.parseDouble(Pref.getPref("ui_scale").orElse("1"))) - 10,
                        (int) (50 * Double.parseDouble(Pref.getPref("ui_scale").orElse("1"))) - 10,
                        Image.SCALE_DEFAULT
                );
            }
            catch (IOException e) {
                System.out.println("Error while importing the images");
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
