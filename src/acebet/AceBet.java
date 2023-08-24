/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package acebet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;

/**
 *
 * @author guero: Marouane Guerouji.
 */
public class AceBet {

    int playerScore = 100;
    int botScore = 0;
    int betAmount = 0;
    Card deck = null;
    boolean touches = false;
    boolean roundResult = false;

    ArrayList<Card> cardsList = null;

    /**
     * Constructor.
     */
    public AceBet() {

        intializeDeck();
        intializeCards(3);

    }

    private void intializeDeck() {
        deck = new Card("deck");
    }

    public int getBetAmount() {
        return this.betAmount;
    }

    public boolean checkBettingPower() {
        // if (getCurrTotal() > 0)
        if (getBetAmount() > this.getCurrTotal()) {
            if (getCurrTotal() > 0) {
                this.updateBetAmount(getCurrTotal());
                this.updateTotal(0);
            }
            return false;

        }
        return true;

    }

    public void setBetAmount(int val) {
        this.betAmount += val;

    }

    public boolean updateBetAmount(int bet) {
        int temp = betAmount + bet;
        int tot = this.getCurrTotal() - bet;
        if (bet < 0) {
            int totBet = this.getBetAmount() + bet;
            if (totBet < 0) {
                return false;
            }
        }

        if (tot < 0) {
            return false;
        }

        this.setBetAmount(bet);
        this.updateTotal(-bet);
        return true;

    }

    public void updateTotal(int update) {
        this.playerScore += update;
    }

    public int getCurrTotal() {
        return this.playerScore;

    }

    public void newRound() {
        shuffleCards();

    }

    public Card getDeckCard() {
        return deck;

    }

    public boolean roundInProgress() {
        return touches;
    }

    public void setroundInProgress() {
        touches = true;
    }

    public void setroundfinished() {
        touches = false;
    }

    private void intializeCards(int numCards) {
        cardsList = new ArrayList();

        for (int i = 0; i < numCards; i++) {
            Card card = new Card(i + "");
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

    public ArrayList<Card> listgetter() {
        return this.cardsList;

    }

    public void shuffleCards() {
        for (int i = 0; i < 100; i++) {
            Collections.shuffle(cardsList);
        }

    }

    public boolean compareChoice(String choice) {

        return choice.equals("Ace");

    }

    public int startRound() {

        if (this.getBetAmount() < 1) {
            return 0;
        }
        if (getCurrTotal() < 1 && this.getBetAmount() == 0) {

            return 0;
        }

        if (getCurrTotal() > 0 || getBetAmount() > 0) {
            shuffleCards();

            this.setroundInProgress();
            setRoundResult(false);

            return getCurrTotal();
        }

        return 0;

    }

    public int roundResults(String choice) {
        int tot = this.getBetAmount();
        tot += this.getBetAmount();;
        if (compareChoice(choice)) {
            this.updateTotal(tot);
            setRoundResult(true);
        }

        this.setroundfinished();
        this.betAmount = 0;
        return getCurrTotal();

    }

    public boolean getRoundResult() {
        return roundResult;
    }

    public void setRoundResult(boolean var) {
        roundResult = var;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, InterruptedException {
        //TODO code application logic here
//          UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
//        for (UIManager.LookAndFeelInfo look : looks) {
//            System.out.println(look.getClassName());
//        }

        /// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        
        /// javax.swing.plaf.nimbus.NimbusLookAndFeel

        AceBet myBet = new AceBet();
        myBet.intializeCards(3);

        MainFrame frame = new MainFrame();
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BettingPanel pan = new BettingPanel(myBet);

        frame.setContentPane(pan);

        frame.setSize(847, 600);
        ///frame.add(pan); 
        frame.setVisible(true);

    }

}
