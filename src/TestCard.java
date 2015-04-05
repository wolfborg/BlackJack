
public class TestCard
{
	public static void main(String[] args)
	{
		Card[] card = new Card[10];
		card[0] = new Card("TWO","DIAMONDS");
		card[1] = new Card(7,"SPADES");
		card[2] = new Card("ACE",4);
		card[3] = new Card(11,1);
		
		//jokers
		card[4] = new Card("ehfiuwf","wfrwi");
		card[5] = new Card(78, "HEARTS");
		card[6] = new Card("ACE",7);
		card[7] = new Card(19,5);
		
		//constructor tests
		testToString(card[0], "TWO of DIAMONDS");
		testToString(card[1], "SEVEN of SPADES");
		testToString(card[2], "ACE of DIAMONDS");
		testToString(card[3], "JACK of SPADES");
		testToString(card[4], "JOKER");
		testToString(card[5], "JOKER");
		testToString(card[6], "JOKER");
		testToString(card[7], "JOKER");

		//accessor tests
		testGetRank(card[0], "TWO");
		testGetRankValue(card[0], 2);
		testGetSuit(card[0], "DIAMONDS");
		testGetFace(card[0], false);
		
		testGetRank(card[4], "JOKER");
		testGetRankValue(card[4], 0);
		testGetSuit(card[4], "JOKER");
		testGetFace(card[4], false);
		
		testGetFace(card[3], true);
		
		//mutator tests
		testSetRankString(card[0], "TEN", true);
		testSetRankString(card[0], "hduqehf", false);
		testGetRank(card[0], "TEN");
		testGetRankValue(card[0], 10);
		
		testSetRankInt(card[1], 4, true);
		testSetRankInt(card[1], 53, false);
		testGetRank(card[1], "FOUR");
		testGetRankValue(card[1], 4);
		
		testGetFace(card[2], false);
		testSetRankString(card[2], "QUEEN", true);
		testGetFace(card[2], true);
		testSetRankInt(card[1], 13, true);
		testGetFace(card[1], true);
		
		
	}
	
	public static void testToString(Card card, String correct)
	{
		System.out.println("Testing toString method:");
		
		System.out.print("toString returns "+card+": ");
		if(card.toString().equals(correct)){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetRank(Card card, String correct)
	{
		System.out.println("Testing getRank method on the "+card+":");
		
		System.out.print("getRank returns "+card.getRank()+": ");
		if(card.getRank().equals(correct)){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetRankValue(Card card, int correct)
	{
		System.out.println("Testing getRankValue method on the "+card+":");
		
		System.out.print("getRankValue returns "+card.getRankValue()+": ");
		if(card.getRankValue() == correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetSuit(Card card, String correct)
	{
		System.out.println("Testing getRank method on the "+card+":");
		
		System.out.print("getSuit returns "+card.getSuit()+": ");
		if(card.getSuit().equals(correct)){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetFace(Card card, boolean correct)
	{
		System.out.println("Testing getFace method on the "+card+":");
		
		System.out.print("getFace method returns "+card.getFace()+": ");
		if(card.getFace()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testSetRankString(Card card, String newRank, boolean correct)
	{
		System.out.println("Testing method setRank on the "+card+" with a string parameter for newRank:");
		
		System.out.print("Setting rank to "+newRank+" ... ");
		boolean result = card.setRank(newRank);
		if(result){
			System.out.print("Success: ");
		}else{
			System.out.print("Faulure: ");
		}
		
		if(result == correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testSetRankInt(Card card, int newRank, boolean correct)
	{
		System.out.println("Testing method setRank on the "+card+" with an int parameter for newRank:");
		
		System.out.print("Setting rank to "+newRank+" ... ");
		boolean result = card.setRank(newRank);
		if(result){
			System.out.print("Success: ");
		}else{
			System.out.print("Faulure: ");
		}
		
		if(result == correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testSetSuitString(Card card, String newSuit, boolean correct)
	{
		System.out.println("Testing method setSuit on the "+card+" with a string parameter for newSuit:");
		
		System.out.print("Setting rank to "+newSuit+" ... ");
		boolean result = card.setRank(newSuit);
		if(result){
			System.out.print("Success: ");
		}else{
			System.out.print("Faulure: ");
		}
		
		if(result == correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testSetSuitInt(Card card, int newSuit, boolean correct)
	{
		System.out.println("Testing method setSuit on the "+card+" with a string parameter for newSuit:");
		
		System.out.print("Setting rank to "+newSuit+" ... ");
		boolean result = card.setRank(newSuit);
		if(result){
			System.out.print("Success: ");
		}else{
			System.out.print("Faulure: ");
		}
		
		if(result == correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testSetPrevious(Card card, Card newPrevious, Card correct)
	{
		System.out.println("Testing method setPrevious on the "+card+":");
		
		System.out.print("Setting previous to "+newPrevious+" ... ");
		card.setPrevious(newPrevious);
		if(card.getPrevious() == correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testSetNext(Card card, Card newNext, Card correct)
	{
		System.out.println("Testing method setNext on the "+card+":");
		
		System.out.print("Setting next to "+newNext+" ... ");
		card.setNext(newNext);
		if(card.getPrevious() == correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
}
