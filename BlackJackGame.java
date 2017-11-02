/**
 * Created by Sidd on 2017-02-19.
 */
import java.util.Scanner;

public class BlackJackGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deck theDeck = new Deck(1, true);

        Player me = new Player("Sidd");
        Player dealer = new Player("Dealer");

        me.addCard(theDeck.dealCard());
        dealer.addCard(theDeck.dealCard());
        me.addCard(theDeck.dealCard());
        dealer.addCard(theDeck.dealCard());

        System.out.println("Here are the cards\n");
        me.printHand(true);
        System.out.println();
        dealer.printHand(false);
        System.out.println("\n");

        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while(!meDone || !dealerDone){
            if(!meDone){
                System.out.println("Hit or Stay? (Enter H or S):");
                ans = sc.next();
                System.out.println();

                if(ans.compareToIgnoreCase("H") == 0){
                    meDone = !me.addCard(theDeck.dealCard());
                    me.printHand(true);
                }else {
                    meDone = true;
                }
            }
            if(!dealerDone){
                if(dealer.getHandSum() < 17){
                    System.out.println("The dealer hits\n");
                    dealerDone = !dealer.addCard(theDeck.dealCard());
                    dealer.printHand(false);
                }
                else{
                    System.out.println("The dealer stays\n");
                    dealer.printHand(false);
                    dealerDone = true;
                }
            }
            System.out.println();
        }
        sc.close();

        //print final hands
        me.printHand(true);
        System.out.println();
        dealer.printHand(true);
        System.out.println();

        int playerSum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        if(playerSum > dealerSum && playerSum <= 21 || dealerSum > 21){
            System.out.println("You win!!!!");
        }else{
            System.out.println("Dealer wins");
        }


    }
}
