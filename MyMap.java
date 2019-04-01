/***Sanjida Ullah
CISC 3130
Homework #5 ***/
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;


public class MyMap {
		
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
}
	private int hashItOut(String key) {
		  return Math.abs(key.hashCode() % theTable.size());
	}
public MyMap (int number) {
		theTable = new ArrayList<>();
		for (int i =0; i<number; i++); {
		theTable.add(new LinkedList<Pair>());
	}
}
public void put (String key, Integer value) {
	int  location = hashItOut(key);
	boolean locationKnown = false;
		
	for (int i = 0; i < theTable.get(location).size(); i++) {
		Pair pair = theTable.get(location).get(i);
		if(key.equals(pair.getKey())) {
		pair.setValue(value);
		locationKnown = true;
}
	}
		if(!locationKnown) {
		theTable.get(location).add(new Pair (key, value));
	}
	}

public boolean containsKey(String key) {
	int location = hashItOut(key);
	  for (int i = 0; i < theTable.get(location).size(); i++) { 
	   Pair pair = theTable.get(location).get(i); 
	   if (pair.getKey().equals(key)) { 
	    return true;
  }
}
	  return false;
}
public boolean containsValue(Integer value) {
		for (int i = 0; i < theTable.size(); i++) { 
	   for (int k = 0; k < theTable.get(i).size(); k++) { 
	    Pair pair = theTable.get(i).get(k); 
	    if (pair.getValue() == value) {
	     return true;
	}
   }
 }
	 return false;
}
public boolean remove(String key) {
	if(size() != 0) {
		int location = hashItOut(key);
	for (int i = 0; i < theTable.get(location).size(); i++) {
		LinkedList<Pair> myList = theTable.get(location); 
	if (key.equals(theTable.get(location).get(i).getKey())) { 
	    myList.remove(i); 
	return true;
 }
}
}
	return false;
}

Integer get(String key) {
  int location = hashItOut(key);
	  
  for (int i = 0; i < theTable.get(location).size(); i++) { 
	  Pair retrive = theTable.get(location).get(i); 
	   if (key.equals(retrive.getKey())) {  
return retrive.getValue();
	   }
	  }
return null;
	 }
 Set<String> makeKey() {
 Set<String> retriveKey = new HashSet<String>();
	  
	for (int i = 0; i < theTable.size(); i++) { 
	   for (int j = 0; j < theTable.get(i).size(); j++) {
	    retriveKey.add(theTable.get(i).get(j).getKey()); 
	   }
	  }
	  return retriveKey;
	 }
Set<Pair> entrySet() {
Set<Pair> entrySet = new HashSet<Pair>();
	  
	for (int i = 0; i < theTable.size(); i++) { 
	   for (int k = 0; k < theTable.get(i).size(); k++) { 
	    entrySet.add(theTable.get(i).get(k)); 
	   }
	  }
	return entrySet;
	  
	 }
List<Integer> values() {
List<Integer> setOfValues = new ArrayList<Integer>();
	  
	  for (int i = 0; i < theTable.size(); i++) { 
	   for (int k = 0; k < theTable.get(i).size(); k++) { 
	    setOfValues.add(theTable.get(i).get(k).getValue()); 
	   }
	  }
	  return setOfValues;
	 }
	 
	 int size() {
	  return theTable.size();
	 }
	 
	 boolean isEmpty() {
	  return theTable.size() == 0;
	 }

	 
 public static void main(String[] args) {
	  
	  MyMap okThisMap = new MyMap(20);
	  
	  okThisMap.put("A", 1);
	  okThisMap.put("B", 2);
	  okThisMap.put("C", 3);
	  okThisMap.put("D", 4);
	  
	  System.out.println(okThisMap.entrySet());
	  okThisMap.remove("C");
	  okThisMap.remove("D");
	  System.out.println(okThisMap.entrySet());
	  
	 }
}	
