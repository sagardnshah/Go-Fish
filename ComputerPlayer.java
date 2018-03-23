/**
 * @author Sagar Shah
 * Playing cards from: https://github.com/hayeah/playing-cards-assets
 */
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer extends Player {
    public ComputerPlayer(ArrayList<Card> hand){
        super(hand);
    }

    public String choice(){
        ArrayList<Card> hand = super.getHand();
        int rand = ThreadLocalRandom.current().nextInt(0, hand.size());
        return hand.get(rand).getRankString();
    }

    public String goFish(ArrayList<Card> a){
        ArrayList<Card> pile = a;
        int rand = ThreadLocalRandom.current().nextInt(0, pile.size());
        return pile.get(rand).getRankString();
    }
}
