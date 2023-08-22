/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package acebet;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author guero
 */
public class AceBet {
    int playerScore =0; 
    int botScore = 0; 
    ArrayList<Card> cardsList = null; 
    
    public  AceBet(){
        intializeCards(3);
        shuffleCards();
       /// System.err.println(compareChoice("ACE"));
       compareChoice("ACE");
    
    }
    
    private void intializeCards(int numCards){
        cardsList = new ArrayList();
        for (int i = 0; i < numCards; i++) {
            Card card = new Card(i+"");
            ///card.imageGetter();
            this.cardsList.add(card);  
            
        
        }
        cardsList.get(0).name = "ACE"; 
         cardsList.get(0).imageGetter();
      
        cardsList.get(1).name = "Q"; 
         cardsList.get(1).imageGetter();
         
        cardsList.get(2).name = "K"; 
         cardsList.get(2).imageGetter();
        
        ///Collections.shuffle(cardsList);
        
        
    
    }
    public void shuffleCards(){
    Collections.shuffle(cardsList);
    
    }
    public boolean compareChoice(String choice){
        choice = "ACE"; 
        for (int i = 0; i < this.cardsList.size(); i++){
            System.out.println("Check : "+  this.cardsList.get(i).name.equals(choice) );
        
        }
              ///choice.equals("ACE"); 
        return choice.equals("ACE"); 
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AceBet myBet = new  AceBet();
        
        

        
    }
    
}
