package ca.sheridancollege.project;

public class Card {

    private int number;
    private int suit;

    public Card(int suit, int number) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        StringBuilder showcards = new StringBuilder();

        switch (number) {

            case 11:
                showcards.append("Jack");
                break;
            case 12:
                showcards.append("Queen");
                break;
            case 13:
                showcards.append("King");
                break;
            case 14:
                showcards.append("Ace");
                break;
            default:
                showcards.append(number);
                break;
        }

        showcards.append(" of ");
        switch (suit) {
            case 0:
                showcards.append("Spades");
                break;
            case 1:
                showcards.append("Hearts");
                break;
            case 2:
                showcards.append("Clubs");
                break;
            case 3:
                showcards.append("Diamonds");
                break;
            default:
                break;
        }
        return showcards.toString();
    }
}
