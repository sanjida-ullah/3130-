import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;


public class HomeworkNum5 {
	
	private ArrayList<LinkedList<Pair>> theTable;

	public static class Pair {
		private String key;
		private Integer value;
		
	Pair(String key, Integer value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public Integer getValue() {
		return value;
	}
	public Integer setValue (Integer x) { 
		Integer temp = this.value;
		this.value = x;
		return temp;
	}
	public String toString() {
		return key + " " + value;
	}
	private int hashItOut(String key) {
		  return Math.abs(key.hashCode() % theTable.size());
	}
	public MyMap (int number) {
		theTable = new ArrayList<>();
		for (int i =0; i<number; i++);
		theTable.add(new LinkedList<Pair>());
	}
	}
	public void put (String key, Integer value) {
		int  location = hashItOut(key);
		boolean locationKnown = false;
		for (int i = 0; i < theTable.get(location).size()); i++)
Pair pair = theTable.get(location).get(i);
if(key.equals(pair.getKey())) {
	pair.setValue(value);
	locationKnown = true;
}
	if(!locationKnown) {
		theTable.get(location).add(new Pair (key, value));
	}
	public boolan containsKey(String key) {
		int location = hashItOut(key);
		  for (int i = 0; i < theTable.get(location).size(); i++) { // iterating over linked list
		   Pair pair = theTable.get(location).get(i); // pair at i in linked list
		   if (pair.getKey().equals(key)) { // if key found return true, else false
		    return true;
		   }
		  }
		  return false;
		 }
		 public boolean containsValue(Integer value) {
		  for (int i = 0; i < theTable.size(); i++) { // iterating over arraylist
		   for (int k = 0; k < theTable.get(i).size(); k++) { // iterating over linked list
		    Pair pair = theTable.get(i).get(k); 
		    if (pair.getValue() == value) {
		     return true;
		    }
		   }
		  }
		  return false;
		 }
		 
}
}

		
	
		
		
	
			
		
		
	}
		
	}
		
	
	
	
	
	/*private String key;
	private Integer value;
	  
	  Map<String, Book> myMap = new HashMap<String, Book>();
	  
	public void put (String key, Integer value) {
		 
	insert this key-value pair into the map under the following rules:
	If key already exists in the map, change its value to value, overwriting what was
	there.
	If key is not already there, insert this key-value pair into the map.
	}
	boolean containsKey(String key);
	returns true iff key already exists in the map.
	boolean containsValue(Integer value);
	returns true iff value appears in the map. (N.B. Since the values need not be unique, this
	doesn’t necessarily tell you anything interesting.)
	boolean remove (Object key);
	If key is in the map, remove it. (This is a little bit tricky).
	Integer get(String key);
	If key is in the map, return the associated value.
	If key is NOT in the map, return null.
	Set<Pair> entrySet();
	Returns a Set of all pairs in the map.
	List<Integer> values();
	Returns a list of all of the associated values in the map.
	Set<String> keySet();
	Returns a set of all keys in the map.
	int size();
	returns the number of elements in the map
	boolean isEmpty();
	returns true iff the number of elements in the map is 0.
	
	
	You will use a hash table as the underlying structure.
	The declaration for the private data member should be:
	private ArrayList<LinkedList<Pair>> theTable;
	Pair should be an inner static class with the following methods.
	Pair(String str, Integer value);
	Constructs a pair
	String getKey();
	Returns the key
	Integer getValue();
	Returns the value
	Integer setValue(Integer value);
	Changes the value to a new value and returns the old value.
*/
}
