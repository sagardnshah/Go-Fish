/**
 * @author Sagar Shah
 * Playing cards from: https://github.com/hayeah/playing-cards-assets
 */
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<ArrayList> books = new ArrayList<>();

    public Player(){

    }

    public Player(ArrayList<Card> hand){
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addToHand(ArrayList<Card> newCards){
        for(int i=0; i<newCards.size(); i++){
            hand.add(newCards.get(i));
        }
    }

    public void addToHand(Card a){
        hand.add(a);
    }

    public void createBooks(){
        ArrayList<Card> currentBook = new ArrayList<>();
        int currentRank = -1;
        int currentTally = 0; //taly for current rank
        for(int i=0; i<hand.size(); i++) {
            currentRank = hand.get(i).getRank();
            for (int y = 0; y < hand.size(); y++) {
                if (hand.get(y).getRank() == currentRank) {
                    currentBook.add(hand.get(y));
                    currentTally++;
                }
            }
            if(currentBook.size()==4){
                books.add(currentBook);
            }
        }
    }

    public ArrayList<ArrayList> getBooks(){
        return books;
    }


}
