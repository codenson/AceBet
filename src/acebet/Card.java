package acebet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author guero: Marouane Guerouji.
 */
public class Card {

    String name;

    public Card(String name) {
        this.name = name;

    }

    /**
     * Method to return an IconImage.
     */

    public ImageIcon imageGetter() {
        return new ImageIcon(getClass().getResource("/Images/" + name + ".png"));

    }

    public static void main(String[] arg) {
        System.out.println("Card.main()");
        Card m = new Card("");

        m.imageGetter();

    }

}
