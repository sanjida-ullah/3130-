import java.io.File;
import java.util.Scanner;

public class MyLinkedSparseArray {

    private static class SListNode{                                     

        private int index;                                              
        private int value;
        private SListNode next;


        public SListNode(int index, int value , SListNode next){           
            this.index = index;
            this.value = value;
            this.next = next;
        }
         public void setNext(SListNode next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }
        public String toString() {
          return "( "+ this.index +", "+this.value+" )"; 
        }
        public int getIndex() {
          return index;
        }                           

        public int getValue() {
          return value;
        }

        public SListNode getNext() {
            return next;
        }
    }

    private SListNode headNode;
    private int elements ;

          public MyLinkedSparseArray(){                       
         this.headNode = null;
         elements = 0;
}
    public int size() { 
      return elements;
    }                    

    public boolean isEmpty(){
      return elements==0;
    }           

    public int get (int index) {                        
              SListNode temp = headNode;

              if(temp==null)
                  return 0;

              while(temp!=null) {
                  if (temp.getIndex()==index)
                      return temp.getValue();
                  temp = temp.getNext();
              }

              return -1;
        }

    public int set (int index,int value){
            int x = 0;
        if (headNode==null) {
            headNode = new SListNode(index, value, null);
            elements++;
            return 0;
        }
        SListNode temp = headNode;

        while(temp!= null){
            if(temp.getIndex() == index){
                x = temp.getValue();
                temp.setValue(value);
                return x;}
            temp = temp.getNext();

        }
        SListNode newHeadNode = new SListNode(index, value, headNode);

        this.headNode = newHeadNode;
        elements++;
        return 0;
        }               
    
        
        public String toString (){                                 
        StringBuilder stringBuilder = new StringBuilder();
            SListNode temp = headNode;


        while (temp!= null){
            stringBuilder.append(temp);
            temp = temp.getNext();
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
        }

    public static void main(String[] args) throws Exception {        //test pgm       

        LinkedSparseArray myLinkedSparseArray = new LinkedSparseArray();

        File file = new File ("myLinkedSparseArray.txt");           
        Scanner inFile = new Scanner (file);                                        
        Scanner kybd = new Scanner (System.in);                                    
        int  in;                                                                    

        while(inFile.hasNext()){                                                     
            myLinkedSparseArray.set(inFile.nextInt(),inFile.nextInt());
        }
       
        System.out.println(myLinkedSparseArray.toString());
        System.out.println(myLinkedSparseArray.size());
        System.out.println(myLinkedSparseArray.get(2));
        System.out.println(myLinkedSparseArray.isEMpty());
       


    }

    }



