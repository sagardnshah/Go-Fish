/**
 * @author Sagar Shah
 * Playing cards from: https://github.com/hayeah/playing-cards-assets
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> pile = new ArrayList<>();
    int cardsLeftInPile = 52;
    //diamonds, hearts, spades, clubs
    private Card d1 = new Card("Diamonds", 1, "/png/ace_of_diamonds.png");
    private Card d2 = new Card("Diamonds", 2, "/png/2_of_diamonds.png");
    private Card d3 = new Card("Diamonds", 3, "/png/3_of_diamonds.png");
    private Card d4 = new Card("Diamonds", 4, "/png/4_of_diamonds.png");
    private Card d5 = new Card("Diamonds", 5, "/png/5_of_diamonds.png");
    private Card d6 = new Card("Diamonds", 6, "/png/6_of_diamonds.png");
    private Card d7 = new Card("Diamonds", 7, "/png/7_of_diamonds.png");
    private Card d8 = new Card("Diamonds", 8, "/png/8_of_diamonds.png");
    private Card d9 = new Card("Diamonds", 9, "/png/9_of_diamonds.png");
    private Card d10 = new Card("Diamonds", 10, "/png/10_of_diamonds.png");
    private Card d11 = new Card("Diamonds", 11, "/png/jack_of_diamonds.png");
    private Card d12 = new Card("Diamonds", 12, "/png/queen_of_diamonds.png");
    private Card d13 = new Card("Diamonds", 13, "/png/king_of_diamonds.png");
    private Card h1 = new Card("Hearts", 1, "/png/ace_of_hearts.png");
    private Card h2 = new Card("Hearts", 2, "/png/2_of_hearts.png");
    private Card h3 = new Card("Hearts", 3, "/png/3_of_hearts.png");
    private Card h4 = new Card("Hearts", 4, "/png/4_of_hearts.png");
    private Card h5 = new Card("Hearts", 5, "/png/5_of_hearts.png");
    private Card h6 = new Card("Hearts", 6, "/png/6_of_hearts.png");
    private Card h7 = new Card("Hearts", 7, "/png/7_of_hearts.png");
    private Card h8 = new Card("Hearts", 8, "/png/8_of_hearts.png");
    private Card h9 = new Card("Hearts", 9, "/png/9_of_hearts.png");
    private Card h10 = new Card("Hearts", 10, "/png/10_of_hearts.png");
    private Card h11 = new Card("Hearts", 11, "/png/jack_of_hearts.png");
    private Card h12 = new Card("Hearts", 12, "/png/queen_of_hearts.png");
    private Card h13 = new Card("Hearts", 13, "/png/king_of_hearts.png");
    private Card s1 = new Card("Spades", 1, "/png/ace_of_spades.png");
    private Card s2 = new Card("Spades", 2, "/png/2_of_spades.png");
    private Card s3 = new Card("Spades", 3, "/png/3_of_spades.png");
    private Card s4 = new Card("Spades", 4, "/png/4_of_spades.png");
    private Card s5 = new Card("Spades", 5, "/png/5_of_spades.png");
    private Card s6 = new Card("Spades", 6, "/png/6_of_spades.png");
    private Card s7 = new Card("Spades", 7, "/png/7_of_spades.png");
    private Card s8 = new Card("Spades", 8, "/png/8_of_spades.png");
    private Card s9 = new Card("Spades", 9, "/png/9_of_spades.png");
    private Card s10 = new Card("Spades", 10, "/png/10_of_spades.png");
    private Card s11 = new Card("Spades", 11, "/png/jack_of_spades.png");
    private Card s12 = new Card("Spades", 12, "/png/queen_of_spades.png");
    private Card s13 = new Card("Spades", 13, "/png/king_of_spades.png");
    private Card c1 = new Card("Clubs", 1, "/png/ace_of_clubs.png");
    private Card c2 = new Card("Clubs", 2, "/png/2_of_clubs.png");
    private Card c3 = new Card("Clubs", 3, "/png/3_of_clubs.png");
    private Card c4 = new Card("Clubs", 4, "/png/4_of_clubs.png");
    private Card c5 = new Card("Clubs", 5, "/png/5_of_clubs.png");
    private Card c6 = new Card("Clubs", 6, "/png/6_of_clubs.png");
    private Card c7 = new Card("Clubs", 7, "/png/7_of_clubs.png");
    private Card c8 = new Card("Clubs", 8, "/png/8_of_clubs.png");
    private Card c9 = new Card("Clubs", 9, "/png/9_of_clubs.png");
    private Card c10 = new Card("Clubs", 10, "/png/10_of_clubs.png");
    private Card c11 = new Card("Clubs", 11, "/png/jack_of_clubs.png");
    private Card c12 = new Card("Clubs", 12, "/png/queen_of_clubs.png");
    private Card c13 = new Card("Clubs", 13, "/png/king_of_clubs.png");

    public Deck(){
        deck.addAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13));
        deck.addAll(Arrays.asList(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13));
        deck.addAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13));
        deck.addAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13));
    }

    public void createPile(){
        for(int i=0; i<deck.size(); i++){
            pile.add(deck.get(i));
        }
    }

    public int getPileSize(){
        return pile.size();
    }

    public ArrayList<Card> getPile(){
        return pile;
    }

    public Card getCard(String card){
        if(card.equals("d1"))
            return deck.get(0);
        if(card.equals("d2"))
            return deck.get(1);
        if(card.equals("d3"))
            return deck.get(2);
        if(card.equals("d4"))
            return deck.get(3);
        if(card.equals("d5"))
            return deck.get(4);
        if(card.equals("d6"))
            return deck.get(5);
        if(card.equals("d7"))
            return deck.get(6);
        if(card.equals("d8"))
            return deck.get(7);
        if(card.equals("d9"))
            return deck.get(8);
        if(card.equals("d10"))
            return deck.get(9);
        if(card.equals("d11"))
            return deck.get(10);
        if(card.equals("d12"))
            return deck.get(11);
        if(card.equals("d13"))
            return deck.get(12);

        if(card.equals("h1"))
            return deck.get(13);
        if(card.equals("h2"))
            return deck.get(14);
        if(card.equals("h3"))
            return deck.get(15);
        if(card.equals("h4"))
            return deck.get(16);
        if(card.equals("h5"))
            return deck.get(17);
        if(card.equals("h6"))
            return deck.get(18);
        if(card.equals("h7"))
            return deck.get(19);
        if(card.equals("h8"))
            return deck.get(20);
        if(card.equals("h9"))
            return deck.get(21);
        if(card.equals("h10"))
            return deck.get(22);
        if(card.equals("h11"))
            return deck.get(23);
        if(card.equals("h12"))
            return deck.get(24);
        if(card.equals("h13"))
            return deck.get(25);

        if(card.equals("s1"))
            return deck.get(26);
        if(card.equals("s2"))
            return deck.get(27);
        if(card.equals("s3"))
            return deck.get(28);
        if(card.equals("s4"))
            return deck.get(29);
        if(card.equals("s5"))
            return deck.get(30);
        if(card.equals("s6"))
            return deck.get(31);
        if(card.equals("s7"))
            return deck.get(32);
        if(card.equals("s8"))
            return deck.get(33);
        if(card.equals("s9"))
            return deck.get(34);
        if(card.equals("s10"))
            return deck.get(35);
        if(card.equals("s11"))
            return deck.get(36);
        if(card.equals("s12"))
            return deck.get(37);
        if(card.equals("s13"))
            return deck.get(38);

        if(card.equals("c1"))
            return deck.get(39);
        if(card.equals("c2"))
            return deck.get(40);
        if(card.equals("c3"))
            return deck.get(41);
        if(card.equals("c4"))
            return deck.get(42);
        if(card.equals("c5"))
            return deck.get(44);
        if(card.equals("c6"))
            return deck.get(45);
        if(card.equals("c7"))
            return deck.get(46);
        if(card.equals("c8"))
            return deck.get(47);
        if(card.equals("c9"))
            return deck.get(48);
        if(card.equals("c10"))
            return deck.get(49);
        if(card.equals("c11"))
            return deck.get(50);
        if(card.equals("c12"))
            return deck.get(51);
        if(card.equals("c13"))
            return deck.get(52);
        else return null;
    }
    public ArrayList<Card> draw5cards(){
        ArrayList<Card> draw = new ArrayList<Card>();
        ArrayList<Integer> rands = new ArrayList<Integer>();
        int handSize=0;
        int rand = -1;
        //ensuring one card isn't added twice to a hand
        while(handSize<5){
            rand = ThreadLocalRandom.current().nextInt(0, cardsLeftInPile);
            if(!rands.contains(rand)){
                rands.add(rand);
                draw.add(pile.get(rand));
                handSize++;
            }
        }
        for(int y=0; y<5; y++){
            for(int z=0; z<pile.size(); z++) {
                Card currentCard = pile.get(z);
                if (draw.get(y).getImage() == currentCard.getImage()) {
                    pile.remove(z);
                }
            }
        }
        cardsLeftInPile -=5;
        return draw;
    }
}
