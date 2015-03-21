/***************************************
 * An interface for the List ADT.
 * Entry positions begin with 1.
 * 
 * @author chaplind
 * @param <E>
 ***************************************/
public interface ListInterface<E>
{
	/********************************************************************************
	 * Adds a new entry to the end of the List and increases the List size by 1.
	 * 
	 * @param newEntry		E: The new entry to add to the List.
	 * @return 
	 ********************************************************************************/
	public boolean add(E newEntry);
	
	
	/***************************************************************************************
	 * Adds a new entry to a specific position in a List, making all entries after that
	 * position having their position values increased by 1 and lastly increasing the size
	 * of the List by 1.
	 * 
	 * @param newPosition	int: The position for the new entry to be added into the List.
	 * @param newEntry		E: The new entry to add to the List.
	 **************************************************************************************/
	public boolean add(int newPosition, E newEntry);
	
	
	/************************************************************************************
	 * Removes a specified entry from the List, changing all entries after the removed
	 * entry's position values decrease by 1 and lastly decreasing the size of the List
	 * by 1.
	 * 
	 * @param givenPosition	int: The position of the entry to be removed from the List.
	 * @return E:	
	 ************************************************************************************/
	public E remove(int givenPosition);
	
	
	/***************************************************************************************
	 * Empties out the List by removing every entry in it and setting the List size to 0.
	 ***************************************************************************************/
	public void clear();
	
	
	/**********************************************************************************************
	 * Replaces the entry at the specified position with the new entry.
	 * 
	 * @param givenPosition	int: The position of the entry in the List to be replaced.
	 * @param newEntry		E: The new entry that will replace the specified entry int the List.
	 * @return boolean:	True if successful or false if the List is full, the new position is 
	 * 						less than 1, or if the new position is bigger than the List size+1.
	 **********************************************************************************************/
	public boolean replace(int givenPosition, E newEntry);
	
	
	/******************************************************************************
	 * Searches for a specific entry inside of a List.
	 * 
	 * @param anEntry	E: The entry that the method will search for in the List.
	 * @return boolean:	True if the entry is found, false otherwise.
	 ******************************************************************************/
	public boolean contains(E anEntry);
	
	
	/******************************************************************************
	 * Returns an entry specified by a given position number.
	 * 
	 * @param givenPosition	int: The specified position of the entry to return.
	 * @return E:	The specified entry.
	 ******************************************************************************/
	public E getEntry(int givenPosition);
	
	
	/*************************************************************
	 * Returns the number of entries currently in the List.
	 * 
	 * @return int:	The number of entries currently in the List.
	 *************************************************************/
	public int getLength();
	
	
	/*************************************************************
	 * Returns the number of entries allowed in the List.
	 * 
	 * @return int:	The number of entries allowed in the List.
	 *************************************************************/
	public int getCapacity();
	
	
	/**************************************************************************************
	 * Returns whether or not the List is full.
	 * 
	 * @return boolean:	True if the List has reached its maximum length, false otherwise.
	 **************************************************************************************/
	public boolean isFull();
	

	/************************************************************************
	 * Returns whether or not the List is empty.
	 * 
	 * @return boolean:	True if the List is empty, false otherwise.
	 ************************************************************************/
	public boolean isEmpty();
	
	
	/*********************************************
	 * Displays each entry in the List in order.
	 *********************************************/
	public void display();
} //end ListInterface

