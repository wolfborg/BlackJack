
public class TestLList
{
	public static void main(String[] args)
	{
		LList<String> test1 = new LList<String>();
		
		//empty list tests
		testIsEmpty(test1, true);
		testIsFull(test1, false);
		testGetLength(test1, 0);
		
		//unempty list tests
		testAdd(test1, "test1", true);
		testIsEmpty(test1, false);
		testGetLength(test1, 1);
		
		//test adds
		testAdd(test1, "test2", true);
		testGetLength(test1, 2);
		testAdd(test1, "test4", true);
		testGetLength(test1, 3);
		testAdd(test1, "test5", true);
		testGetLength(test1, 4);
		testAdd(test1, 3, "test3", true);
		testGetLength(test1, 5);
		
		//test getEntry
		testGetEntry(test1, 1, "test1");
		testGetEntry(test1, 2, "test2");
		testGetEntry(test1, 3, "test3");
		testGetEntry(test1, 4, "test4");
		testGetEntry(test1, 5, "test5");
		testGetEntry(test1, 0, null);
		testGetEntry(test1, 6, null);
		
		//test remove
		testRemove(test1, 1, "test1");
		testGetLength(test1, 4);
		testGetEntry(test1, 1, "test2");
		testRemove(test1, 3, "test4");
		testGetEntry(test1, 2, "test3");
		testGetLength(test1, 3);
		
		//test clear
		testClear(test1);
		testIsEmpty(test1, true);
		testGetLength(test1, 0);
		
		//test full
		testGetCapacity(test1, 25);
		for(int i=1;i<=test1.getCapacity();i++){
			test1.add("test"+i);
		}
		testIsFull(test1, true);
		testAdd(test1, "test25", false);
		
		test1.display();
		
		//test contains and replace
		testContains(test1, "test4", true);
		testContains(test1, "test26", false);
		testReplace(test1, 3, "test26", true);
		testReplace(test1, 0, "test0", false);
	}
	
	public static void testAdd(ListInterface<String> list, String test, boolean correct)
	{
		System.out.println("Testing add method: ");
		
		System.out.println("Adding '"+test+"' to the list ... ");
		boolean result = list.add(test);
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
	
	public static void testAdd(ListInterface<String> list, int position, String test, boolean correct)
	{
		System.out.println("Testing add method: ");
		
		System.out.print("Adding '"+test+"' to the list ... ");
		if(list.add(position,test)==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	
	public static void testRemove(ListInterface<String> list, int position, String correct)
	{
		System.out.println("Testing remove method: ");
		
		System.out.println("Removing entry at position "+position+" ... ");
		String result = list.remove(position);
		System.out.print("Remove method returned "+result+": ");
		if(result!=null){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	
	public static void testClear(ListInterface<String> list)
	{
		System.out.println("Testing clear method: ");
		
		list.clear();
		
		System.out.print("Checking if list is cleared: ");
		if(list.isEmpty()){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	
	public static void testIsEmpty(ListInterface<String> list, boolean correct)
	{	
		System.out.print("Testing isEmpty method with ");
		if(correct){
			System.out.println("an empty list:");
		}else{
			System.out.println("a list that isn't empty:");
		}
		
		System.out.print("isEmpty method returns "+list.isEmpty()+": ");
		if(list.isEmpty()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testIsFull(ListInterface<String> list, boolean correct)
	{
		System.out.print("Testing isFull method with ");
		if(correct){
			System.out.println("a full list:");
		}else{
			System.out.println("a list that isn't full:");
		}
		
		System.out.print("isFull method returns "+list.isFull()+": ");
		if(list.isFull()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetLength(ListInterface<String> list, int correct)
	{
		System.out.println("Testing getLength method of a list with a length of "+correct+":");
		
		System.out.print("getLength method returns "+list.getLength()+": ");
		if(list.getLength()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetCapacity(ListInterface<String> list, int correct)
	{
		System.out.println("Testing getCapacity method for a list with a capacity of "+correct+":");
		
		System.out.print("getCpacity method returns "+list.getCapacity()+": ");
		if(list.getCapacity()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetEntry(ListInterface<String> list, int position, String correct)
	{
		System.out.println("Testing getEntry method for entry at position "+position+":");
		
		String result = list.getEntry(position);
		System.out.print("getEntry method returns "+result+": ");
		
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
	
	public static void testReplace(ListInterface<String> list, int position, String test, boolean correct)
	{
		System.out.println("Testing replace method: ");
		
		System.out.println("Replacing entry at position "+position+" with '"+test+"' ... ");
		boolean result = list.replace(position, test);
		
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
	
	public static void testContains(ListInterface<String> list, String test, boolean correct)
	{
		System.out.println("Testing contains method for the entry '"+test+"': ");
		
		System.out.println("Searching for entry '"+test+"' ... ");
		boolean result = list.contains(test);
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



