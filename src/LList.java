/**********************************************************************
 * Creates a Linked List which is comprised of Nodes linked together.
 * 
 * @author chaplind
 * @param <E>
 **********************************************************************/
public class LList<E> implements ListInterface<E>
{
	/*
	 * Creates a Node for the Linked List.
	 */
	private class DNode
	{
		private E data;
		private DNode next;
		private DNode prev;
		
		
		/*********************************************************
		 * Default constructor which creates an empty Node that
		 * is unattached to the Linked List.
		 *********************************************************/
		private DNode()
		{
			this(null,null,null);
		}
		
		
		/*****************************************************************************
		 * Creates a Node that does not have a previous or next Node and so it isn't
		 * added into the Linked List yet.
		 * 
		 * @param dataPortion	E: The data of the new Node in the Linked List.
		 * @param nextNode		Node: The next Node to be referenced by the new Node.
		 *****************************************************************************/
		private DNode(E dataPortion)
		{
			data = dataPortion;
			next = null;
			prev = null;
		}
		
		
		/**********************************************************************************
		 * Creates a Node that is added to a specific position of the Linked List.
		 * References the next Node in the Linked List and sets the next Node's
		 * previous Node to this Node.
		 * 
		 * @param dataPortion	E: The data of the new Node in the Linked List.
		 * @param nextNode		Node: The next Node to be referenced by the new Node.
		 * @param prevNode		Node: The previous Node to be referenced by the new Node.
		 **********************************************************************************/
		private DNode(E dataPortion, DNode nextNode, DNode prevNode)
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
	 * Default constructor which creates an empty Linked List and calls
	 * a constructor for a Linked List with a default initial capacity.
	 *******************************************************************/
	public LList()
	{
		this(DEFAULT_CAPACITY);
	}
	
	
	/*******************************************************************
	 * Constructor which creates a Linked List with a specified initial
	 * capacity and a head and tail set to null and a length of zero.
	 * 
	 * @param capacity	int: The initial capacity of the Linked List.
	 *******************************************************************/
	public LList(int initialCapacity)
	{
		capacity = initialCapacity;
		head = null;
		tail = null;
		length = 0;
	}
	
	
	/********************************************************************************
	 * Adds a new entry to the end of the List and increases the List size by 1.
	 * 
	 * @param newEntry		E: The new entry to add to the List.
	 * @return boolean:	True if the Node was sucessfully added, false if the List is
	 * 					full and can't be added to.
	 ********************************************************************************/
	public boolean add(E newEntry)
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
	 * Adds a new entry to a specific position in a List, making all entries after that
	 * position having their position values increased by 1 and lastly increasing the size
	 * of the List by 1.
	 * 
	 * @param newPosition	int: The position for the new entry to be added into the List.
	 * @param newEntry		E: The new entry to add to the List.
	 * @return boolean:	True if the Node was successfully added, false if the List is full
	 * 					and can't be added to.
	 **************************************************************************************/
	public boolean add(int newPosition, E newEntry)
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
	 * Removes a specified entry from the List, changing all entries after the removed
	 * entry's position values decrease by 1 and lastly decreasing the size of the List
	 * by 1.
	 * 
	 * @param givenPosition	int: The position of the entry to be removed from the List.
	 * @return E:	
	 ************************************************************************************/
	public E remove(int givenPosition)
	{
		E result = null;
		
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
	 * Empties out the List by removing every entry in it and setting the List size to 0.
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
	 * @param givenPosition	int: The position of the entry in the List to be replaced.
	 * @param newEntry		E: The new entry that will replace the specified entry int the List.
	 * @return boolean:	True if successful or false if the List is full, the new position is 
	 * 						less than 1, or if the new position is bigger than the List size+1.
	 **********************************************************************************************/
	public boolean replace(int givenPosition, E newEntry)
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
	public E getEntry(int givenPosition)
	{
		E result = null;
		
		if(!isEmpty()){
			if(givenPosition>=1 && givenPosition<=length){
				result = getNodeAt(givenPosition).data;
			}
		}
		
		return result;
	}
	
	
	/******************************************************************************
	 * Searches for a specific entry inside of a List.
	 * 
	 * @param anEntry	E: The entry that the method will search for in the List.
	 * @return boolean:	True if the entry is found, false otherwise.
	 ******************************************************************************/
	public boolean contains(E anEntry)
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
	
	
	/*************************************************************
	 * Returns the number of entries currently in the List.
	 * 
	 * @return int:	The number of entries currently in the List.
	 *************************************************************/
	public int getLength()
	{
		return length;
	}
	
	
	/*************************************************************
	 * Returns the number of entries currently in the List.
	 * 
	 * @return int:	The number of entries currently in the List.
	 *************************************************************/
	public int getCapacity()
	{
		return capacity;
	}
	
	
	/**************************************************************************************
	 * Returns whether or not the List is full.
	 * 
	 * @return boolean:	True if the List has reached its maximum length, false otherwise.
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
	 * Returns whether or not the List is empty.
	 * 
	 * @return boolean:	True if the List is empty, false otherwise.
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
	 * Displays each entry in the List in order.
	 *********************************************/
	public void display()
	{
		if(!isEmpty()){
			for(int i=1;i<length+1;i++){
				System.out.println("Entry "+i+": "+getEntry(i));
			}
		}else{
			System.out.println("List is emtpy.");
		}
		
		System.out.println();
	}
}



