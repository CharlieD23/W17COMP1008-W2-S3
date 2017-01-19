
package w17jan19;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class GameOfWar {
    private ArrayList<Card> p1Hand;
    private ArrayList<Card> p2Hand;
    
    //This is the constructor
    public GameOfWar()
    {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        
        DeckOfCards theDeck = new DeckOfCards();
        theDeck.shuffle();
        
        dealCards(theDeck);
    }   //end of the constructor
    
    /**
     * This method will deal all the cards in the deck
     * equally divided to each player
     */
    private void dealCards(DeckOfCards theDeck)
    {
        for(int cardNum = 0; cardNum < 52; cardNum++)
        {
            if(cardNum % 2 == 0)
                p1Hand.add(theDeck.dealTopCard());
            else
                p2Hand.add(theDeck.dealTopCard());
        }
    }   //end of the method dealCards   
    
    /**
     * This method will simulate playing the game
     */
    public void playTheGame()
    {
        while(!p1Hand.isEmpty() && !p2Hand.isEmpty())
        {
            playHand();
        }
        
        if(p1Hand.isEmpty())
            System.out.println("Player 2 wins!");
        else if(p2Hand.isEmpty())
            System.out.println("Player 1 wins!");
    }   //end of the method playTheGame

    /**
     * This will simulate playing a "hand" in the game of war
     */
    private void playHand()
    {
        if(p1Hand.isEmpty() || p2Hand.isEmpty())
            return;
        
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        //if player 1 wins
        if(p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
        }
        //if player 2 wins
        else if(p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        }
        //if war happens
        else
        {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }     
    }   //end of the method playHand
    
    /**
     * This method simulates playing a "war" hand
     */
    private void playWarHand(ArrayList<Card> warPile)
    {
        //check if player 1 has enough cards to play war
        if(p1Hand.size() < 3)
        {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
            return;
        }
        //check if player 2 has enough cards to play war
        if(p2Hand.size() < 3)
        {
            p1Hand.addAll(p2Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
            return;
        }
        
        //take 3 cards out of player 1's hand
        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        Card p1Card = p1Hand.remove(0);
        
        //take 3 cards out of player 2's hand
        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        Card p2Card = p2Hand.remove(0);
        
        //check for player 1 to win
        if(p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1Hand.addAll(warPile);
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
            return;
        }
        //check for player 1 to win
        else if(p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            p2Hand.addAll(warPile);
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
            return;
        }
        //otherwise another war happes
        else
        {
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }   //end of method playWarHand 
    
}   //end of the class
