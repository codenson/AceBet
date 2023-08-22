/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package acebet;

import java.util.ArrayList;

/**
 *
 * @author guero
 */
public class AceBet {
    int playerScore =0; 
    int botScore = 0; 
    ArrayList<Card> cardsList = null; 
    
    private void intializeCards(int numCards){
        for (int i = 0; i < numCards; i++) {
            Card card = new Card(i+"");
            card.imageGetter();
            this.cardsList.add(card);  
            
        
        }
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
