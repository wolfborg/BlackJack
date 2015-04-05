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
	private class DNode
	{
		private Card data;
		private DNode next;
		private DNode prev;
		
		
		/*********************************************************
		 * Default constructor which creates an empty Node that
		 * is unattached to the Linked Pile.
		 *********************************************************/
		private DNode()
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
		private DNode(Card dataPortion)
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
		private DNode(Card dataPortion, DNode nextNode, DNode prevNode)
		{
			data = dataPortion;
			next = nextNode;
			prev = prevNode;
		}
	}
	
	private DNode getNodeAt(int position)
	{
		DNode result = null;
		
		if(!isEmpty() && position>=1 && position<=length){
			if(position==1){
				result = head;
			}else if(position==length){
				result = tail;
			}else{
				result = head;
				for(int i=1;i<position;i++){
					result = result.next;
				}
			}
		}
		
		return result;
	}
	
	private DNode head, tail;
	private int length, capacity;
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
	 * capacity and a head and tail set to null and a length of zero.
	 * 
	 * @param capacity	int: The initial capacity of the Linked Pile.
	 *******************************************************************/
	public Pile(int initialCapacity)
	{
		capacity = initialCapacity;
		head = null;
		tail = null;
		length = 0;
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
			DNode newNode = new DNode(newEntry);

			if(!isEmpty()){
				newNode.prev = tail;
				tail.next = newNode;
				tail = newNode;
			}else{
				head = newNode;
				tail = newNode;
			}
			
			length++;
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
		
		if(newPosition>=1 && newPosition<=length+1){
			if(!isFull()){
				if(newPosition==1){
					DNode newNode = new DNode(newEntry,head,null);
					head.prev = newNode;
					head = newNode;
					if(length==0){
						tail = newNode;
					}
				}else if(newPosition==length+1){
					DNode newNode = new DNode(newEntry,null,tail);
					tail.next = newNode;
					tail = newNode;
					if(length==0){
						head = newNode;
					}
				}else{
					DNode nodeAfter = getNodeAt(newPosition);
					DNode nodeBefore = nodeAfter.prev;
		
					DNode newNode = new DNode(newEntry,nodeAfter,nodeBefore);
					
					nodeAfter.prev = newNode;
					nodeBefore.next = newNode;
				}
				
				length++;
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
		
		if(givenPosition>=1 && givenPosition<=length){
			if(!isEmpty()){
				if(givenPosition == 1){
					result = head.data;
					
					if(length==1){
						head = null;
						tail = null;
					}else{
						head = head.next;
					}
					
				}else if(givenPosition == length){
					result = tail.data;
					if(length==1){
						head = null;
						tail = null;
					}else{
						tail = tail.prev;
					}
				}else{
					DNode nodeToRemove = getNodeAt(givenPosition);
					DNode nodeBefore = nodeToRemove.prev;
					DNode nodeAfter = nodeToRemove.next;
					
					nodeBefore.next = nodeAfter;
					nodeAfter.prev = nodeBefore;
					
					result = nodeToRemove.data;
				}
				
				length--;
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
			if(givenPosition>=1 && givenPosition<=length){
				DNode node = getNodeAt(givenPosition);
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
	public Card getEntry(int givenPosition)
	{
		Card result = null;
		
		if(!isEmpty()){
			if(givenPosition>=1 && givenPosition<=length){
				result = getNodeAt(givenPosition).data;
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
			for(int i=1;i<=length;i++){
				if(getEntry(i).equals(anEntry)){
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
	public int getLength()
	{
		return length;
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
	 * @return boolean:	True if the Pile has reached its maximum length, false otherwise.
	 **************************************************************************************/
	public boolean isFull()
	{
		boolean result = false;
		
		if(length==capacity){
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
		
		if(length==0){
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
			for(int i=1;i<length+1;i++){
				System.out.println("Entry "+i+": "+getEntry(i));
			}
		}else{
			System.out.println("Pile is emtpy.");
		}
		
		System.out.println();
	}
	
	public void shuffle(){
		Pile newPile = new Pile(length);
		
		for(int i=1;i<=length;i++){
			int rand = randInt(i,length);
			Card card = getEntry(rand);
			newPile.add(card);
		}
		
		newPile.display();
		
		for(int i=1;i<=length;i++){
			replace(i,newPile.getEntry(i));
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



