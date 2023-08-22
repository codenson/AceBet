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
 * @author guero
 */
public class Card {
    String name; 
    public Card(String name){
        this.name = name; 
    
    }
    /**
     * Method to return an IconImage. 
     */
  
    
    public ImageIcon imageGetter() {
        BufferedImage img = null;
      //  String s = "C:\\Users\\guero\\OneDrive\\Documents\\NetBeansProjects\\Lingo\\src\\lingo\\Images\\";
       // s += this.name + ".png";
        String s= ""; 
         String relativePath = "src/Images/";
         String userDir = System.getProperty("user.dir");
         String absolutePath = userDir + File.separator + relativePath;
         s+= absolutePath; 
         
        s += name + ".png";
     
        try {
            img = ImageIO.read(new File(s));
        } catch (IOException e) {
            return null;
            ///System.err.println("not");;
        }

        return new ImageIcon(img);
    }
    public static void main(String  [] arg){
        System.out.println("Card.main()");
        Card m = new Card("ace"); 

        m.imageGetter();
        
        
    }
    
}
