package w17jan19;

/**
 *
 * @author Charlie
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    public Card(String faceName, String suit, int value)
    {
        this.faceName = faceName;
        setSuit(suit);
        setFaceValue(value);
    }
         
    /**
     * This method will validate the argument is in the range 2-14 and
     * set the face value accordingly.
     */
    private void setFaceValue(int value)
    {
        if (value >=2 && value <=14)
            faceValue = value;
        else
            throw new IllegalArgumentException("card must have values in the range of 2-14");
    }
    
    /**
     * This method will validate that the argument is hearts, diamonds, 
     * clubs, or spades. If it is, then it will set the instance variable
     * for the class. If it is not a valid input, it will throw an exception.
     */
    private void setSuit(String suit)
    {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") ||
            suit.equalsIgnoreCase("clubs") || suit.equalsIgnoreCase("spades"))
            this.suit = suit;
        else
            throw new IllegalArgumentException("suit must be hearts, diamonds, spades, or clubs");
    }
    
    /**
     * This method will return a String to represent the card
     */
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }
    
    
}
