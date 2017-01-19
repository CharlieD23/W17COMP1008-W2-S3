package w17jan19;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Charlie
 */
public class DeckOfCards {
    private ArrayList<Card> deck;
    
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        
        String[] suits = {"spades","hearts","clubs","diamonds"};
        String[] faceNames = {"two","three","four","five","six","seven","eight",
                                "nine","ten","Jack","Queen","King","Ace"};
        
        for (String suit: suits)
        {
            for (int i=0; i < faceNames.length; i++)
            {
                Card newCard = new Card(faceNames[i], suit, i+2);
                deck.add(newCard);
            }
        }
    }
    
    @Override
    public String toString()
    {
        String deckString="";
        for (Card card: deck)
        {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
    
    /**
     * This method will "shuffle" deck of cards, changing the current order
     * of the cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    /**
     * This method will "deal" the top card off the deck
     * @return a Card object
     */
    public Card dealTopCard()
    {
        return deck.remove(0);
    }
    
}   //end of class
