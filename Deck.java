/**
 * Created by Sidd on 2017-02-19.
 */
import java.util.Random;

public class Deck {

private Card[] cards;
private int numCards;

public Deck(int numDecks, boolean shuffle){
    this.numCards = numDecks*52;
    this.cards = new Card[this.numCards];

    int i = 0;
    for(int j = 0; j < numDecks; j++){
        for(int s = 0; s < 4; s++){
            for(int v = 1; v <= 13; v++){
                cards[i] = new Card(Suit.values()[s],v);
                i++;
            }

        }
    }
    if(shuffle == true){
        this.shuffle();
    }


    }

public void shuffle(){
    Random rand = new Random();

    for(int i = 0; i < this.cards.length; i++){
        Card temp = this.cards[i];
        int random = rand.nextInt(this.numCards);
        this.cards[i] = this.cards[random];
        this.cards[random] = temp;
    }



}

public Card dealCard(){
    Card top = this.cards[0];

    for(int c = 1; c < numCards; c++){
        this.cards[c - 1] = this.cards[c];
    }
    this.cards[this.numCards - 1] = null;
    this.numCards--;
    return top;
}

public void printDeck(int numToPrint){
    for(int c = 0; c < numToPrint; c++){
        System.out.printf("% 3d/%d %s\n",c+1,this.numCards,this.cards[c].toString());
    }
}
}
