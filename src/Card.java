
public class Card implements Comparable<Object>
{
	private String suit;
	private String rank;
	private int rankValue;
	private boolean face;
	private Card previous;
	private Card next;
	private boolean hidden;
	
	public Card()
	{
		this(0,0);
	}
	
	public Card(int cardRank, int cardSuit)
	{
		rankValue = cardRank;
		face = false;
		
		switch (cardRank){
			case 1: 	rank = "ACE"; break;
			case 2: 	rank = "TWO"; break;
			case 3: 	rank = "THREE"; break;
			case 4: 	rank = "FOUR"; break;
			case 5: 	rank = "FIVE"; break;
			case 6: 	rank = "SIX"; break;
			case 7: 	rank = "SEVEN"; break;
			case 8: 	rank = "EIGHT"; break;
			case 9: 	rank = "NINE"; break;
			case 10: 	rank = "TEN"; break;
			case 11: 	rank = "JACK"; face = true; break;
			case 12: 	rank = "QUEEN"; face = true; break;
			case 13: 	rank = "KING"; face = true; break;
			default:	rank = "JOKER"; rankValue = 0;
		}
		
		switch (cardSuit){
			case 1: 	suit = "SPADES"; break;
			case 2: 	suit = "CLUBS"; break;
			case 3: 	suit = "HEARTS"; break;
			case 4: 	suit = "DIAMONDS"; break;
			default:	suit = "JOKER";
		}
		
		previous = null;
		next = null;
		hidden = true;
	}
	
	public Card(String cardRank, String cardSuit)
	{
		rank = cardRank;
		suit = cardSuit;
		face = false;
		
		switch(cardRank){
			case "ACE": 	rankValue = 1; break;
			case "TWO": 	rankValue = 2; break;
			case "THREE": 	rankValue = 3; break;
			case "FOUR": 	rankValue = 4; break;
			case "FIVE":	rankValue = 5; break;
			case "SIX":		rankValue = 6; break;
			case "SEVEN":	rankValue = 7; break;
			case "EIGHT":	rankValue = 8; break;
			case "NINE":	rankValue = 9; break;
			case "TEN":		rankValue = 10; break;
			case "JACK":	rankValue = 11; face = true; break;
			case "QUEEN":	rankValue = 12; face = true; break;
			case "KING":	rankValue = 13; face = true; break;
			default:		rank = "JOKER"; rankValue = 0;
		}
		
		switch(cardSuit){
			case "SPADES":		break;
			case "CLUBS":		break;
			case "HEARTS":		break;
			case "DIAMONDS":	break;
			default:			suit = "JOKER";
		}
		
		previous = null;
		next = null;
		hidden = true;
	}
	
	
	public Card(int cardRank, String cardSuit)
	{
		suit = cardSuit;
		face = false;
		
		switch (cardRank){
			case 1: 	rank = "ACE"; break;
			case 2: 	rank = "TWO"; break;
			case 3: 	rank = "THREE"; break;
			case 4: 	rank = "FOUR"; break;
			case 5: 	rank = "FIVE"; break;
			case 6: 	rank = "SIX"; break;
			case 7: 	rank = "SEVEN"; break;
			case 8: 	rank = "EIGHT"; break;
			case 9: 	rank = "NINE"; break;
			case 10: 	rank = "TEN"; break;
			case 11: 	rank = "JACK"; face = true; break;
			case 12: 	rank = "QUEEN"; face = true; break;
			case 13: 	rank = "KING"; face = true; break;
			default:	rank = "JOKER"; rankValue = 0;
		}
		
		switch(cardSuit){
			case "SPADES":		break;
			case "CLUBS":		break;
			case "HEARTS":		break;
			case "DIAMONDS":	break;
			default:			suit = "JOKER";
		}
		
		previous = null;
		next = null;
		hidden = true;
	}
	
	
	public Card(String cardRank, int cardSuit)
	{
		rank = cardRank;
		face = false;
		
		switch(cardRank){
			case "ACE": 	rankValue = 1; break;
			case "TWO": 	rankValue = 2; break;
			case "THREE": 	rankValue = 3; break;
			case "FOUR": 	rankValue = 4; break;
			case "FIVE":	rankValue = 5; break;
			case "SIX":		rankValue = 6; break;
			case "SEVEN":	rankValue = 7; break;
			case "EIGHT":	rankValue = 8; break;
			case "NINE":	rankValue = 9; break;
			case "TEN":		rankValue = 10; break;
			case "JACK":	rankValue = 11; face = true; break;
			case "QUEEN":	rankValue = 12; face = true; break;
			case "KING":	rankValue = 13; face = true; break;
			default:		rank = "JOKER"; rankValue = 0;
		}
		
		switch (cardSuit){
			case 1: 	suit = "SPADES"; break;
			case 2: 	suit = "CLUBS"; break;
			case 3: 	suit = "HEARTS"; break;
			case 4: 	suit = "DIAMONDS"; break;
			default:	suit = "JOKER";
		}
	
		previous = null;
		next = null;
		hidden = true;
	}
	
	public String toString()
	{
		if(!isHidden()){
			if(rank.equals("JOKER") || suit.equals("JOKER")){
				return "JOKER";
			}else{
				return rank+" of "+suit;	
			}
		}else{
			return "HIDDEN";
		}
	}
	
	
	public int compareTo(Object o)
	{
		int result;
		
		if(rankValue>((Card)o).rankValue){
			result = 1;
		}else if(rankValue<((Card)o).rankValue){
			result = -1;
		}else{
			result = 0;
		}
		
		return result;
	}
	
	
	public boolean equals(Card card)
	{
		if(rank == card.rank && suit.equals(card.suit)){
			return true;
		}
		
		return false;
	}
	
	
	public boolean setRank(int newRank)
	{
		if(rankValue == newRank){
			return false;
		}
		
		switch (newRank){
			case 1: 	rank = "ACE"; break;
			case 2: 	rank = "TWO"; break;
			case 3: 	rank = "THREE"; break;
			case 4: 	rank = "FOUR"; break;
			case 5: 	rank = "FIVE"; break;
			case 6: 	rank = "SIX"; break;
			case 7: 	rank = "SEVEN"; break;
			case 8: 	rank = "EIGHT"; break;
			case 9: 	rank = "NINE"; break;
			case 10: 	rank = "TEN"; break;
			case 11: 	rank = "JACK"; face = true; break;
			case 12: 	rank = "QUEEN"; face = true; break;
			case 13: 	rank = "KING"; face = true; break;
			default: 	return false;
		}
		
		rankValue = newRank;
		
		return true;
	}
	
	/**
	 * @return boolean:	True if successful, false otherwise.
	 */
	public boolean setRank(String newRank)
	{
		if(rank.equals(newRank)){
			return false;
		}
		
		switch (newRank){
			case "ACE": 	rankValue = 1; break;
			case "TWO": 	rankValue = 2; break;
			case "THREE": 	rankValue = 3; break;
			case "FOUR": 	rankValue = 4; break;
			case "FIVE":	rankValue = 5; break;
			case "SIX":		rankValue = 6; break;
			case "SEVEN":	rankValue = 7; break;
			case "EIGHT":	rankValue = 8; break;
			case "NINE":	rankValue = 9; break;
			case "TEN":		rankValue = 10; break;
			case "JACK":	rankValue = 11; face = true; break;
			case "QUEEN":	rankValue = 12; face = true; break;
			case "KING":	rankValue = 13; face = true; break;
			default: 		return false;
		}
		
		rank = newRank;
		
		return true;
	}
	
	public boolean setSuit(int newSuit)
	{
		switch(newSuit){
		case 1:		suit = "SPADES"; break;
		case 2:		suit = "CLUBS"; break;
		case 3:		suit = "HEARTS"; break;
		case 4:		suit = "DIAMONDS"; break;
		default:	return false;
		}
		
		if(suit.equals(newSuit)){
			return false;
		}
		
		return true;
	}
	
	public boolean setSuit(String newSuit)
	{
		if(suit.equals(newSuit)){
			return false;
		}
		
		switch(newSuit){
			case "SPADES":		break;
			case "CLUBS":		break;
			case "HEARTS":		break;
			case "DIAMONDS":	break;
			default:			return false;
		}
		
		suit = newSuit;
		
		return true;
	}
	
	public void setPrevious(Card newPrevious)
	{
		previous = newPrevious;
	}
	
	public void setNext(Card newNext)
	{
		next = newNext;
	}
	
	public void setHidden(boolean newHidden)
	{
		hidden = newHidden;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	public int getRankValue()
	{
		return rankValue;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public boolean getFace()
	{
		return face;
	}
	
	public Card getPrevious()
	{
		return previous;
	}
	
	public Card getNext()
	{
		return next;
	}
	
	public boolean isHidden()
	{
		return hidden;
	}
}
