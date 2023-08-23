/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package acebet;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;

/**
 *
 * @author guero: Marouane Guerouji. 
 */
public class AceBet {
    int playerScore =100; 
    int botScore = 0; 
    int betAmount = 0; 
    Card deck =null;
    boolean touches = false; 
         
      
    ArrayList<Card> cardsList = null; 
    
    public  AceBet(){

         
         ///deck.name = "deck"; 
        /// deck.imageGetter();
        intializeDeck();
        intializeCards(3);
       /// shuffleCards();
       /// System.err.println(compareChoice("ACE"));
       //compareChoice("ACE");
    
    }
    private void intializeDeck(){
        deck =  new Card("deck");
        //System.out.println(deck.imageGetter());
        ///deck.imageGetter();
    
    }
    public int getBetAmount(){
        return this.betAmount;
    
    }
     public boolean checkBettingPower(){
        // if (getCurrTotal() > 0)
         if (getBetAmount() > this.getCurrTotal()){
             if (getCurrTotal() > 0){
             this.updateBetAmount(getCurrTotal());
             this.updateTotal(0);
             }
             return false;
             
         }
         return true; 
         
    
    }
     public void setBetAmount(int val){
         this.betAmount += val; 
     
     }
    public boolean updateBetAmount(int bet){
        int temp = betAmount +bet;
        int tot = this.getCurrTotal() - bet; 
        if (bet < 0){
           int totBet = this.getBetAmount()+bet; 
           //// System.out.println("totBet : +++++++++++++++"+ totBet);
           if (totBet < 0){
           return false; }
        }
     
        
       /// if (this.playerScore - bet> 0)
       /// System.err.println("bet Amount : "+ bet);
//        if (getCurrTotal() < bet ){
//            System.err.println("oaopcakn ca");
//        return false; 
//        }
///System.err.println("bet Amount : "+ bet + " total: "+temp+ " curr tot: "+ tot+ " beTotal: "+ this.getBetAmount());
        if (tot < 0 ){
        return false;}

        
        //if(temp > 0  )
        {
       /// this.betAmount += bet;
          this.setBetAmount(bet);
       /// this.updateBetAmount(bet);
        this.updateTotal(-bet);
        return true;
        }
       //return false; 
    
    }
    
    
    public void updateTotal(int update){
        this.playerScore += update; 
    }
    
    public int getCurrTotal (){
        return this.playerScore;
    
    }
//    public void updateTotalIncrease(){
//        playerScore += betAmount; 
//    
//    }
//    public void updateTotalDecrease(){
//        playerScore -= betAmount; 
//    
//    }
    public void newRound(){
        shuffleCards();
    
    
    }
    public Card getDeckCard(){
        return deck; 
    
    }
    public boolean roundInProgress(){
        return touches ;
    }
    public void setroundInProgress(){
        touches = true; 
    }
    public void setroundfinished(){
        touches = false; 
    }
    
    private void intializeCards(int numCards){
        cardsList = new ArrayList();
        
        for (int i = 0; i < numCards; i++) {
            Card card = new Card(i+"");
            ///card.imageGetter();
            this.cardsList.add(card);  
            
        
        }
       cardsList.get(0).name = "Ace"; 
        cardsList.get(0).imageGetter();
      
       cardsList.get(1).name = "Q"; 
        cardsList.get(1).imageGetter();        
        cardsList.get(2).name = "K"; 
         cardsList.get(2).imageGetter();
         
        
    
    }
    
    public ArrayList<Card> listgetter(){
         return this.cardsList;
    
    }
  
    
    public void shuffleCards(){
        for (int i = 0; i < 100; i++)
    Collections.shuffle(cardsList);
    
    }
    public boolean compareChoice(String choice){
       
      
        return choice.equals("Ace"); 
    
    }
    public int startRound(){
       /// this.intializeCards(3);
       
       if (this.getBetAmount()  < 1){
           System.out.println("bet amount*******: "+ betAmount);
       return 0; 
       }
       if(getCurrTotal() < 1 && this.getBetAmount() == 0){
           
       return 0; }
       
       if ( getCurrTotal()> 0 || getBetAmount()> 0 ){
        shuffleCards();
        
//         if (checkBettingPower()  ){
//         this.updateTotal(-this.betAmount);
//        }
       
        this.setroundInProgress();
        
//        if (checkBettingPower()){
//         this.updateTotal(-this.betAmount);
//        }
       
        return getCurrTotal();
       }
       System.out.println("acebet.AceBet.startRound()8888888888888");
       return 0; 
    
    }
    
    public int roundResults(String choice){
        ///System.out.println("compare strings : " + compareChoice(choice)+ " bet : "+ this.betAmount);
        int tot= this.getBetAmount();
        tot += this.getBetAmount();;
        if (compareChoice(choice)){
            ///updateTotalIncrease(); 
            
            this.updateTotal(tot);
        }
//        else {
//            ///this.updateTotal(-getBetAmount());
//              /// this.updateTotalDecrease();
//
//        
//        }
        this.setroundfinished();
        ///System.err.println("total: "+tot + " total : "+getCurrTotal() );
        this.betAmount = 0; 
        return getCurrTotal();
   
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AceBet myBet = new  AceBet();
        myBet.intializeCards(3);
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BettingPanel pan =  new BettingPanel(myBet); 
        frame.setContentPane(pan);
        frame.setSize(910,620);
        ///frame.add(pan); 
        frame.setVisible(true);
        
        

        
    }
    
}
