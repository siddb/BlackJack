/**
 * Created by Sidd on 2017-02-18.
 */
public class Card {
private Suit suit; //suit
private int value; //value 1 - 13


// Constructor
public Card(Suit suit_a, int value_a){
    this.suit = suit_a;
    if(value_a > 0 && value_a <=13){
        this.value = value_a;
   }
    else {
        System.err.println(value_a + " is not a real card");
        System.exit(1);
    }

}
//return value of card
public int getValue(){
    return value;
}

//overwrite default method
public String toString(){
    String num2str = "None";

    switch(this.value){
        case 1:
            num2str = "Ace";
            break;
        case 2:
            num2str = "Two";
            break;
        case 3:
            num2str = "Three";
            break;
        case 4:
            num2str = "Four";
            break;
        case 5:
            num2str = "Five";
            break;
        case 6:
            num2str = "Six";
            break;
        case 7:
            num2str = "Seven";
            break;
        case 8:
            num2str = "Eight";
            break;
        case 9:
            num2str = "Nine";
            break;
        case 10:
            num2str = "Ten";
            break;
        case 11:
            num2str = "Jack";
            break;
        case 12:
            num2str = "Queen";
            break;
        case 13:
            num2str = "King";
            break;

    }
    return num2str + " of " +suit.toString();
}

}
