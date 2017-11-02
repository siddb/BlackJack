/**
 * Created by Sidd on 2017-02-19.
 */
public class Player {
    private String name;
    private Card[] hand = new Card[10];
    private int numCards;

    public Player(String name_a){
        this.name = name_a;

        this.emptyHand();
    }
    public void emptyHand(){
        for(int c =0; c < 10; c++){
            this.hand[c] = null;
        }
        this.numCards = 0;
    }
    public boolean addCard(Card card_a){
        if(this.numCards == 10){
            System.err.print(this.name +" already has 10 cards");
            System.exit(1);
        }
        this.hand[this.numCards] = card_a;
        numCards++;

        return(this.getHandSum() <= 21);
    }
    public int getHandSum(){
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        for(int c = 0; c < this.numCards;c++){
            cardNum = this.hand[c].getValue();
            if(cardNum == 1){
                numAces++;
                handSum+=11;
            }else if (cardNum > 10){
                handSum+=10;
            }else {
                handSum+= cardNum;

            }
            while(handSum > 21 && numAces > 0){
                handSum -= 10;
                numAces--;
            }

        }
        return handSum;

    }
    public void printHand(boolean showFirstCard){
        System.out.println(this.name +"'s cards: ");
        for(int c=0; c < this.numCards; c++){
            if(c == 0 && !showFirstCard){
                System.out.println(" [hidden] " );

                }
                else{
                System.out.println(this.hand[c].toString());
                }

            }
        }
    }



