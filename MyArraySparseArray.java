/***Sanjida Ullah
CISC 3130
Homework #3 ***/
import java.util.*;
import java.io.*;
public class MyArraySparseArray implements SparseArray {


    private int initSize;
    private int elements = 0;   
    private ArrayList <Pair> myList ;      

    public MyArraySparseArray(int initSize) { //Constructor
       myList = new ArrayList<Pair>();
        this.initSize = initSize ;

    }

    public int getinitSize() { //creates the array behind the scenes to hold initSize elements 
      return initSize;
    }

    public int size() {  // returns how many (meaningful) elements are being held by the array 
        return elements;
    }


    public boolean isEmpty() {      
        return elements == 0;
    }

    public int get(int index) {    

        for (int i = 0; i<myList.size(); i++){
            
          if (myList.get(i).getIndex()==index)
                
              return myList.get(i).getValue();
        }


        return 0;
    }
    
     public int set(int index, int value) {  
        int old = 0 ;
        Pair theValue ;

        myList.add(elements, new Pair(index, value));
        elements++;
        for (int i = 0; i<myList.size(); i++) {

            for(int k =i+1 ; k<myList.size();k++)
                if(myList.get(i).getIndex()>myList.get(k).getIndex()) {
                    theValue = myList.get(i);
                    myList.set(i,myList.get(k));
                    myList.set(k,theValue);
                }
        }
        for(int i = 0 ; i <myList.size(); i++){
            if(myList.get(i).getIndex()==index){
                old =  myList.get(i).getValue();
                myList.get(i).set(value);
                return old;
            }
        }
        return 0;
    }

    public int BinarySearch (int index){
       int x =-1;
        int firstElem = 0;
        int midElem = elements/2;
        int lastElem = elements-1;
        while(x!=index)
        if(myList.get(midElem).getIndex()>index){
            midElem = lastElem;
            x = myList.get(lastElem).getIndex();
        }
        else if (myList.get(midElem).getIndex()<index){
            firstElem = midElem;
            x = myList.get(firstElem).getIndex();
        }
        return myList.get(x).getValue();
    }


private static class Pair {  //Starting pair class within the 

    private int index;
    private int value;

    private Pair(int index, int value){

        this.index = index ;
        this.value = value;
    }

   private void set ( int value) {
        value = value;
   }

   private int getIndex () {  //return associated value if it is there. 
     return index;
   }
   private int getValue() {
     return value;
   }
}

  public String toString () {
        StringBuilder strblder = new StringBuilder();

        for (int k = 0 ; k < myList.size(); k ++){
            strblder.append("index = "+myList.get(k).getIndex()+"\t");
            strblder.append(" value = "+ myList.get(k).getValue()+"\n");
        }
        return strblder.toString();
            }

    public static void main(String[] args) throws Exception { //using scanner class to allow user input
        File file = new File ("ArraySparseArray.txt");           
        Scanner inFile = new Scanner (file);                                    
        Scanner kybd= new Scanner (System.in);                            
        int input;                                                                    
        ArraySparseArray sparseArray = new ArraySparseArray(100);          

        while(inFile.hasNext()) {          // while looop to allow user to set, search and print                                           
            sparseArray.set(inFile.nextInt(), inFile.nextInt());
        }

        System.out.println(" Size of Sparse Array: "+ sparseArray.size() + "\n");
        System.out.println("Choose From The Following Menu: \n ");                         
        System.out.println("To SET Enter: 1\nTo SEARCH Enter: 2\n" 
                             + "To Display Enter: 3\nEnter 4 to Exit\n");

        input = kybd.nextInt();

        while(input != 4){ 
         

            if ( input == 1 ) {
                System.out.println("Enter Index, Followed by the Value");
                System.out.print(sparseArray.set(+kybd.nextInt(), kybd.nextInt()));
                System.out.print(" was the value last value entered \t");
                input = kybd.nextInt();
            }

                else if (input == 2 ) {
                System.out.print("Index: ");
                System.out.println("value:"+(sparseArray.get(kybd.nextInt())));
                System.out.println("value: "+sparseArray.BinarySearch(kybd.nextInt()));
                input = kybd.nextInt();
            }

                    else if(input == 3) {
                System.out.println(sparseArray.toString());
                input = kybd.nextInt();
            }
                    else {
                System.out.println("**The Entry Is Not Valid**");
                input = kybd.nextInt();
            }
                     
            }
        }

    }
