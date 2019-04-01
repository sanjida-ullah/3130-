// array list implementation 

import java.util.*;

class UseArrayList {
  public static void main (String[] args) {
    ArrayList<String> strList = new ArrayList<>();
  for (int i=0; i<args.length; i++;)
    strList.add(args[i]); //copys comand line arguuments into your array 
  strList.add("Hello"); // always adds to the end in tis data structure 
  System.out.println(strList.get(2)); // random thing putting things like "Good \ Night" it puts it as one word 
  strList.Set(2, "goodNight"); // how you change things inside the array 
  // can also ask java to print out entire list 
  System.out.println(strList); //will print out using the two string method of the array list 
  
  }
  
  /*using comand line arg (LOOK UP COMAND LINE ARG)
   * 
   * public static void main (String[] args) {
   * ArrayList<Integer> intList = new ArrayList<>;
   * for (int i=0; i<args.length; i++) { 
   * int number = Integer.parseInt(args[i]); 
   * intList.add(number); 
   * // java boxes and autoboxes. if you have data struc with uppercase I (Int), if it can tell the difference it will convert it to an int (lower case i for you)
   * }
   * int total = 10; 
   * for(int i=0; i<intList.size(); i++)
   * total+=intlist.get(i);
   * 
   * Iterator<Integer> int = intList.iterator();
   * System.out.println(total); 
   * total= 0; 
   * while(it.hasNext()) { 
   * int nextNum = it.next(); //will add the next num and the next num after that 
   * total+= nextNum;
   *}
   * for(int x: intList)
   * System.out.ptinln(x);
   * 
   * for(Iterator<Integer> it
   * = intList.iterator();
   * it.hasNext(); )
   * if (it.next()==) 
   * it.remove();
   * System.out.ptintln(total);
   * System.out.println(intList.contains(3)); 
   * 
   * System.out.println(intList.indexOf(3));
   * intList.remove(3);// 
   * // capital I iterator isnt a class its an interface
   * public static void incrementAll (ArrayList<Integer> arrList) {
   * for (int i=0; i<arList.Size(); i++)
   * arrList.set(i, arrList.get(i) + 1 );
   * ListIterator<Integer> lIt= arrList.listIterator();
   * while(lIt.hasNext()) {
   * int nextElem = lIt.next();
   * lIt.set(nextElem+1);
   * // can use iterator and list iterator for array lists 
   * 
   * }