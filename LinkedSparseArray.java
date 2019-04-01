import java.io.File;
import java.util.Scanner;

public class LinkedSparseArray {

    private static class SListNode{                                     //SListNode class initialization

        private int index;                                              //private variables
        private int value;
        private SListNode next;


        public SListNode(int ind, int val , SListNode next){            //SListNode constructor
            this.index = ind;
            this.value = val;
            this.next = next;
        }
        public int getIndex(){return index;}                            //returns index

        public int getValue(){return value;}

        public SListNode getNext() {
            return this.next;
        }
        public void setNext(SListNode next){
            this.next = next;
        }

        public void setValue(int value){
            this.value = value;
        }

        public String toString(){return "[ "+this.index+", "+this.value+" ]";}
    }

    private SListNode head;
    private int numElem ;

          public LinkedSparseArray(){                       //Constructor for the main class
         this.head = null;
         numElem = 0;
}
    public int size(){ return numElem; }                    //keeps track of the size of the array

    public boolean isEMpty(){ return numElem==0;}           //returns boolean whether if the array is empty or not


    public int set (int index,int value){
            int ret = 0;
        if (head==null) {
            head = new SListNode(index, value, null);
            numElem++;
            return 0;
        }
        SListNode temp = head;



        while(temp!=null){
            if(temp.getIndex()==index){
                ret = temp.getValue();
                temp.setValue(value);
                return ret;}
            temp=temp.getNext();

        }
        SListNode newhead = new SListNode(index, value, head);

        this.head = newhead;
        numElem++;
        return 0;
        }               // either creates a new object of SListNode or replaces the value of the corresponding index



        public int get (int index){                         //does a linear search to find the element of an index
              SListNode temp =head;

              if(temp==null)
                  return 0 ;

              while(temp!=null){
                  if(temp.getIndex()==index)
                      return temp.getValue();
                  temp = temp.getNext();
              }

              return -1;
        }

        public String toString (){                                  //uses stringbuilder and calls the toString of SListNode class
        StringBuilder s = new StringBuilder();
            SListNode temp = head;


        while (temp!= null){
            s.append(temp);
            temp = temp.getNext();
            s.append("\n");
        }


        return s.toString();
        }

    public static void main(String[] args) throws Exception {               // main method

        LinkedSparseArray linkedSparseArray = new LinkedSparseArray();

        File file = new File ("ArraySparseArray.txt");           //file object
        Scanner filein = new Scanner (file);                                        //passing file object to scanner class
        Scanner keyin = new Scanner (System.in);                                    //keyboard input object initialization
        int  in;                                                                    //keyboard input variable

        while(filein.hasNext()){                                                     // reading from a file for testing
            linkedSparseArray.set(filein.nextInt(),filein.nextInt());
        }

        System.out.println(linkedSparseArray.toString());
        System.out.println(linkedSparseArray.isEMpty());
        System.out.println(linkedSparseArray.size());
        System.out.println(linkedSparseArray.get(6));


    }

    }



