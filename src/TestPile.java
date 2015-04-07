/**
 * @author chaplind
 */

public class TestPile
{
	public static void main(String[] args)
	{
		Pile test1 = new Pile();
		
		Card card1 = new Card("ACE","CLUBS");
		Card card2 = new Card("THREE","DIAMONDS");
		Card card3 = new Card("FOUR","HEARTS");
		Card card4 = new Card("QUEEN","HEARTS");
		Card card5 = new Card("THREE","SPADES");
		
		//empty pile tests
		testIsEmpty(test1, true);
		testIsFull(test1, false);
		testGetNumberOfCards(test1, 0);
		
		//unempty pile tests
		testAdd(test1, card1, true);
		testIsEmpty(test1, false);
		testGetNumberOfCards(test1, 1);
		
		//test adds
		testAdd(test1, card2, true);
		testGetNumberOfCards(test1, 2);
		testAdd(test1, card4, true);
		testGetNumberOfCards(test1, 3);
		testAdd(test1, card5, true);
		testGetNumberOfCards(test1, 4);
		testAdd(test1, 3, card3, true);
		testGetNumberOfCards(test1, 5);
		
		//test getCard
		testgetCard(test1, 1, card1);
		testgetCard(test1, 2, card2);
		testgetCard(test1, 3, card3);
		testgetCard(test1, 4, card4);
		testgetCard(test1, 5, card5);
		testgetCard(test1, 0, null);
		testgetCard(test1, 6, null);
		
		//test remove
		testRemove(test1, 1, card1);
		testGetNumberOfCards(test1, 4);
		testgetCard(test1, 1, card2);
		testRemove(test1, 3, card4);
		testgetCard(test1, 2, card3);
		testGetNumberOfCards(test1, 3);
		
		//test clear
		testClear(test1);
		testIsEmpty(test1, true);
		testGetNumberOfCards(test1, 0);
		
		//test full
		test1.setCapacity(13);
		testGetCapacity(test1, 13);
		
		for(int i=1;i<=test1.getCapacity();i++){
			test1.add(new Card(i,"SPADES"));
		}
		testIsFull(test1, true);
		testAdd(test1, new Card("ACE","CLUBS"), false);
		
		test1.display();
		
		//test contains and replace
		testContains(test1, new Card("FOUR","SPADES"), true);
		testContains(test1, new Card("JACK","DIAMONDS"), false);
		testReplace(test1, 3, new Card("NINE","HEARTS"), true);
		testReplace(test1, 0, new Card("ACE","DIAMONDS"), false);
		
		//test shuffle
		System.out.println("Pile before shuffle:");
		test1.display();
		
		test1.shuffle();
		System.out.println("Pile after shuffle:");
		test1.display();
		
		System.out.println(test1.getTopCard());
	}
	
	public static void testAdd(Pile pile, Card test, boolean correct)
	{
		System.out.println("Testing add method: ");
		
		System.out.println("Adding '"+test+"' to the pile ... ");
		boolean result = pile.add(test);
		if(result){
			System.out.print("Add Success: ");
		}else{
			System.out.print("Add Failure: ");
		}
		
		if(result==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testAdd(Pile pile, int position, Card test, boolean correct)
	{
		System.out.println("Testing add method: ");
		
		System.out.print("Adding '"+test+"' to the pile ... ");
		if(pile.add(position,test)==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	
	public static void testRemove(Pile pile, int position, Card correct)
	{
		System.out.println("Testing remove method: ");
		
		System.out.println("Removing entry at position "+position+" ... ");
		Card result = pile.remove(position);
		System.out.print("Remove method returned "+result+": ");
		if(result.equals(correct)){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	
	public static void testClear(Pile pile)
	{
		System.out.println("Testing clear method: ");
		
		pile.clear();
		
		System.out.print("Checking if pile is cleared: ");
		if(pile.isEmpty()){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	
	public static void testIsEmpty(Pile pile, boolean correct)
	{	
		System.out.print("Testing isEmpty method with ");
		if(correct){
			System.out.println("an empty pile:");
		}else{
			System.out.println("a pile that isn't empty:");
		}
		
		System.out.print("isEmpty method returns "+pile.isEmpty()+": ");
		if(pile.isEmpty()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testIsFull(Pile pile, boolean correct)
	{
		System.out.print("Testing isFull method with ");
		if(correct){
			System.out.println("a full pile:");
		}else{
			System.out.println("a pile that isn't full:");
		}
		
		System.out.print("isFull method returns "+pile.isFull()+": ");
		if(pile.isFull()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetNumberOfCards(Pile pile, int correct)
	{
		System.out.println("Testing getNumberOfCards method of a pile with a NumberOfCards of "+correct+":");
		
		System.out.print("getNumberOfCards method returns "+pile.getNumberOfCards()+": ");
		if(pile.getNumberOfCards()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetCapacity(Pile pile, int correct)
	{
		System.out.println("Testing getCapacity method for a pile with a capacity of "+correct+":");
		
		System.out.print("getCpacity method returns "+pile.getCapacity()+": ");
		if(pile.getCapacity()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testgetCard(Pile pile, int position, Card correct)
	{
		System.out.println("Testing getCard method for entry at position "+position+":");
		
		Card result = pile.getCard(position);
		System.out.print("getCard method returns "+result+": ");
		
		if(result==null && correct==null){
			System.out.println("OK");
		}else if(result!=null && correct==null){
			System.out.println("ERROR");
		}else{
			if(result.equals(correct)){
				System.out.println("OK");
			}else{
				System.out.println("ERROR");
			}
		}
		
		System.out.println();
	}
	
	public static void testReplace(Pile pile, int position, Card test, boolean correct)
	{
		System.out.println("Testing replace method: ");
		
		System.out.println("Replacing entry at position "+position+" with '"+test+"' ... ");
		boolean result = pile.replace(position, test);
		
		if(result){
			System.out.print("Replace Success: ");
		}else{
			System.out.print("Replace Failure: ");
		}
		
		if(result==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testContains(Pile pile, Card test, boolean correct)
	{
		System.out.println("Testing contains method for the entry '"+test+"': ");
		
		System.out.println("Searching for entry '"+test+"' ... ");
		boolean result = pile.contains(test);
		if(result){
			System.out.print("Search Success: ");
		}else{
			System.out.print("Search Failure: ");
		}
		
		if(result==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
}



