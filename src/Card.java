
public class Card implements Comparable<Object>
{
	private int suit;
	private int rank;
	private boolean face;
	private Card previous;
	private Card next;
	
	public Card()
	{
		this(0,0);
	}
	
	public Card(int cardRank, int cardSuit)
	{
		if(rank>=1 && suit<=13){
			rank = cardRank;
		}
		
		if(suit>=1 && suit<=4){
			suit = cardSuit;
		}
		
		if(rank>=11 && rank<=13){
			face = true;
		}
		
		previous = null;
		next = null;
	}
	
	
	public String toString()
	{
		String name = null;
		switch (rank){
			case 1: name = "ACE"; break;
			case 2: name = "TWO"; break;
			case 3: name = "THREE"; break;
			case 4: name = "FOUR"; break;
			case 5: name = "FIVE"; break;
			case 6: name = "SIX"; break;
			case 7: name = "SEVEN"; break;
			case 8: name = "EIGHT"; break;
			case 9: name = "NINE"; break;
			case 10: name = "TEN"; break;
			case 11: name = "JACK"; break;
			case 12: name = "QUEEN"; break;
			case 13: name = "KING"; break;
		}
		
		String type = null;
		switch (suit){
			case 1: type = "SPADES"; break;
			case 2: type = "CLUBS"; break;
			case 3: type = "HEARTS"; break;
			case 4: type = "DIAMONDS"; break;
		}
		
		return name+type;
	}
	
	
	public int compareTo(Object o)
	{
		int result;
		
		if(this.rank>((Card)o).rank){
			result = 1;
		}else if(this.rank<((Card)o).rank){
			result = -1;
		}else{
			result = 0;
		}
		
		return result;
	}
	
	
	
	public void setRank(int newRank)
	{
		rank = newRank;
	}
	
	public void setSuit(int newSuit)
	{
		suit = newSuit;
	}
	
	public void setFace(boolean newFace)
	{
		face = newFace;
	}
	
	public void setPrevious(Card newPrevious)
	{
		previous = newPrevious;
	}
	
	public void setNext(Card newNext)
	{
		next = newNext;
	}
	
	public int getRank()
	{
		return rank;
	}
	
	public int getSuit()
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
}
