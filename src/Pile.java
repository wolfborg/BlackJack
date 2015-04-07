
import java.util.Random;

/**********************************************************************
 * Creates a Linked Pile which is comprised of Nodes linked together.
 * 
 * @author chaplind
 * @param <E>
 **********************************************************************/
public class Pile
{
	/*
	 * Creates a Node for the Linked Pile.
	 */
	private class CardNode
	{
		private Card data;
		private CardNode next;
		private CardNode prev;
		
		
		/*********************************************************
		 * Default constructor which creates an empty Node that
		 * is unattached to the Linked Pile.
		 *********************************************************/
		private CardNode()
		{
			this(null);
		}
		
		
		/*****************************************************************************
		 * Creates a Node that does not have a previous or next Node and so it isn't
		 * added into the Linked Pile yet.
		 * 
		 * @param dataPortion	E: The data of the new Node in the Linked Pile.
		 * @param nextNode		Node: The next Node to be referenced by the new Node.
		 *****************************************************************************/
		private CardNode(Card dataPortion)
		{
			data = dataPortion;
			next = null;
			prev = null;
		}
		
		
		/**********************************************************************************
		 * Creates a Node that is added to a specific position of the Linked Pile.
		 * References the next Node in the Linked Pile and sets the next Node's
		 * previous Node to this Node.
		 * 
		 * @param dataPortion	E: The data of the new Node in the Linked Pile.
		 * @param nextNode		Node: The next Node to be referenced by the new Node.
		 * @param prevNode		Node: The previous Node to be referenced by the new Node.
		 **********************************************************************************/
		private CardNode(Card dataPortion, CardNode nextNode, CardNode prevNode)
		{
			data = dataPortion;
			next = nextNode;
			prev = prevNode;
		}
	}
	
	private CardNode getCardAt(int position)
	{
		CardNode result = null;
		
		if(!isEmpty() && position>=1 && position<=nCards){
			if(position==1){
				result = topCard;
			}else if(position==nCards){
				result = bottomCard;
			}else{
				result = topCard;
				for(int i=1;i<position;i++){
					result = result.next;
				}
			}
		}
		
		return result;
	}
	
	private CardNode topCard, bottomCard;
	private int nCards, capacity;
	private static int DEFAULT_CAPACITY = 25;
	
	/*******************************************************************
	 * Default constructor which creates an empty Linked Pile and calls
	 * a constructor for a Linked Pile with a default initial capacity.
	 *******************************************************************/
	public Pile()
	{
		this(DEFAULT_CAPACITY);
	}
	
	
	/*******************************************************************
	 * Constructor which creates a Linked Pile with a specified initial
	 * capacity and a topCard and bottomCard set to null and a nCards of zero.
	 * 
	 * @param capacity	int: The initial capacity of the Linked Pile.
	 *******************************************************************/
	public Pile(int initialCapacity)
	{
		capacity = initialCapacity;
		topCard = null;
		bottomCard = null;
		nCards = 0;
	}
	
	
	/********************************************************************************
	 * Adds a new entry to the end of the Pile and increases the Pile size by 1.
	 * 
	 * @param newEntry		E: The new entry to add to the Pile.
	 * @return boolean:	True if the Node was sucessfully added, false if the Pile is
	 * 					full and can't be added to.
	 ********************************************************************************/
	public boolean add(Card newEntry)
	{
		boolean result = false;
		
		if(!isFull()){
			CardNode newNode = new CardNode(newEntry);

			if(!isEmpty()){
				newNode.prev = bottomCard;
				bottomCard.next = newNode;
				bottomCard = newNode;
			}else{
				topCard = newNode;
				bottomCard = newNode;
			}
			
			nCards++;
			result = true;
		}
		
		return result;
	}
	
	
	/***************************************************************************************
	 * Adds a new entry to a specific position in a Pile, making all entries after that
	 * position having their position values increased by 1 and lastly increasing the size
	 * of the Pile by 1.
	 * 
	 * @param newPosition	int: The position for the new entry to be added into the Pile.
	 * @param newEntry		E: The new entry to add to the Pile.
	 * @return boolean:	True if the Node was successfully added, false if the Pile is full
	 * 					and can't be added to.
	 **************************************************************************************/
	public boolean add(int newPosition, Card newEntry)
	{
		boolean result = false;
		
		if(newPosition>=1 && newPosition<=nCards+1){
			if(!isFull()){
				if(newPosition==1){
					CardNode newNode = new CardNode(newEntry,topCard,null);
					topCard.prev = newNode;
					topCard = newNode;
					if(nCards==0){
						bottomCard = newNode;
					}
				}else if(newPosition==nCards+1){
					CardNode newNode = new CardNode(newEntry,null,bottomCard);
					bottomCard.next = newNode;
					bottomCard = newNode;
					if(nCards==0){
						topCard = newNode;
					}
				}else{
					CardNode nodeAfter = getCardAt(newPosition);
					CardNode nodeBefore = nodeAfter.prev;
		
					CardNode newNode = new CardNode(newEntry,nodeAfter,nodeBefore);
					
					nodeAfter.prev = newNode;
					nodeBefore.next = newNode;
				}
				
				nCards++;
				result = true;
			}
		}
		
		return result;
	}
	
	
	/************************************************************************************
	 * Removes a specified entry from the Pile, changing all entries after the removed
	 * entry's position values decrease by 1 and lastly decreasing the size of the Pile
	 * by 1.
	 * 
	 * @param givenPosition	int: The position of the entry to be removed from the Pile.
	 * @return E:	
	 ************************************************************************************/
	public Card remove(int givenPosition)
	{
		Card result = null;
		
		if(givenPosition>=1 && givenPosition<=nCards){
			if(!isEmpty()){
				if(givenPosition == 1){
					result = topCard.data;
					
					if(nCards==1){
						topCard = null;
						bottomCard = null;
					}else{
						topCard = topCard.next;
					}
					
				}else if(givenPosition == nCards){
					result = bottomCard.data;
					if(nCards==1){
						topCard = null;
						bottomCard = null;
					}else{
						bottomCard = bottomCard.prev;
					}
				}else{
					CardNode nodeToRemove = getCardAt(givenPosition);
					CardNode nodeBefore = nodeToRemove.prev;
					CardNode nodeAfter = nodeToRemove.next;
					
					nodeBefore.next = nodeAfter;
					nodeAfter.prev = nodeBefore;
					
					result = nodeToRemove.data;
				}
				
				nCards--;
			}
		}
		
		return result;
	}
	
	
	/***************************************************************************************
	 * Empties out the Pile by removing every entry in it and setting the Pile size to 0.
	 ***************************************************************************************/
	public void clear()
	{
		while(!isEmpty()){
			remove(1);
		}
	}
	
	
	/**********************************************************************************************
	 * Replaces the entry at the specified position with the new entry.
	 * 
	 * @param givenPosition	int: The position of the entry in the Pile to be replaced.
	 * @param newEntry		E: The new entry that will replace the specified entry int the Pile.
	 * @return boolean:	True if successful or false if the Pile is full, the new position is 
	 * 						less than 1, or if the new position is bigger than the Pile size+1.
	 **********************************************************************************************/
	public boolean replace(int givenPosition, Card newEntry)
	{
		boolean result = false;
		
		if(!isEmpty()){
			if(givenPosition>=1 && givenPosition<=nCards){
				CardNode node = getCardAt(givenPosition);
				node.data = newEntry;
				result = true;
			}
		}
		
		return result;
	}
	
	
	/******************************************************************************
	 * Returns an entry specified by a given position number.
	 * 
	 * @param givenPosition	int: The specified position of the entry to return.
	 * @return E:	The specified entry.
	 ******************************************************************************/
	public Card getCard(int givenPosition)
	{
		Card result = null;
		
		if(!isEmpty()){
			if(givenPosition>=1 && givenPosition<=nCards){
				result = getCardAt(givenPosition).data;
			}
		}
		
		return result;
	}
	
	
	/******************************************************************************
	 * Searches for a specific entry inside of a Pile.
	 * 
	 * @param anEntry	E: The entry that the method will search for in the Pile.
	 * @return boolean:	True if the entry is found, false otherwise.
	 ******************************************************************************/
	public boolean contains(Card anEntry)
	{
		boolean result = false;
		
		if(!isEmpty()){
			for(int i=1;i<=nCards;i++){
				if(getCard(i).equals(anEntry)){
					result = true;
					break;
				}
			}
		}
		
		return result;
	}
	
	
	
	public void setCapacity(int newCapacity)
	{
		capacity = newCapacity;
	}
	
	
	/*************************************************************
	 * Returns the number of entries currently in the Pile.
	 * 
	 * @return int:	The number of entries currently in the Pile.
	 *************************************************************/
	public int getNumberOfCards()
	{
		return nCards;
	}
	
	
	public Card getTopCard()
	{
		return getCard(1);
	}
	
	
	/*************************************************************
	 * Returns the number of entries currently in the Pile.
	 * 
	 * @return int:	The number of entries currently in the Pile.
	 *************************************************************/
	public int getCapacity()
	{
		return capacity;
	}
	
	
	/**************************************************************************************
	 * Returns whether or not the Pile is full.
	 * 
	 * @return boolean:	True if the Pile has reached its maximum nCards, false otherwise.
	 **************************************************************************************/
	public boolean isFull()
	{
		boolean result = false;
		
		if(nCards==capacity){
			result = true;
		}
		
		return result;
	}
	
	
	/************************************************************************
	 * Returns whether or not the Pile is empty.
	 * 
	 * @return boolean:	True if the Pile is empty, false otherwise.
	 ************************************************************************/
	public boolean isEmpty()
	{
		boolean result = false;
		
		if(nCards==0){
			result = true;
		}
		
		return result;
	}
	
	
	/*********************************************
	 * Displays each entry in the Pile in order.
	 *********************************************/
	public void display()
	{
		if(!isEmpty()){
			for(int i=1;i<nCards+1;i++){
				System.out.println("Card "+i+": "+getCard(i));
			}
		}else{
			System.out.println("Pile is empty.");
		}
	}
	
	public void shuffle(){
		Pile newPile = new Pile(nCards);
		int initialNumberOfCards = nCards;
		
		for(int i=1;i<=initialNumberOfCards;i++){
			int rand = randInt(1,nCards);
			newPile.add(getCard(rand));
			remove(rand);
		}
		
		for(int i=1;i<=newPile.getNumberOfCards();i++){
			add(newPile.getCard(i));
		}
	}
	
	/*****************************************************************************
	 * Generates and returns a random number within a specified range.
	 * @param min	- int that specifies the minumum of the random range.
	 * @param max	- int that specifies the maximum of the random range.
	 * @return		The random int within the minimum and maximum range.
	 *****************************************************************************/
	private int randInt(int min, int max)
	{
		return new Random().nextInt((max-min)+1)+min;
	}
}



