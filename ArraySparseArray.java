import java.util.*;
import java.io.*;
public class ArraySparseArray implements SparseArray {


    private int initSize;
    private int NumElm =0 ;   //initializing the number of element variable
    private ArrayList <Pair> arr ;      //initializing the array of type Pair

    public ArraySparseArray(int initSize) {  //Constructor
       arr = new ArrayList<Pair>();
        this.initSize = initSize ;

    }

    public int getInitSize() {return this.initSize;}

    public int size() {  // implemented method of SparseArray interface
        return NumElm;
    }


    public boolean isEmpty() {      // implemented method of SparseArray interface
        return NumElm ==0;
    }

    public int get(int index) {     // implemented method of SparseArray interface

        for (int i = 0; i<arr.size(); i++){
            if (arr.get(i).getInd()==index)
                return arr.get(i).getVal();
        }


        return 0;
    }

    public int BinarySearch (int index){
       int ret =-1;
        int f = 0;
        int m = NumElm/2;
        int l = NumElm-1;
        while(ret!=index)
        if(arr.get(m).getInd()>index){
            m = l;
            ret = arr.get(l).getInd();
        }
        else if (arr.get(m).getInd()<index){
            f = m;
            ret = arr.get(f).getInd();
        }
        return arr.get(ret).getVal();
    }


    public int set(int index, int value) {  // implemented method of SparseArray interface
        int ret = 0 ;
        Pair temp ;

        arr.add(NumElm , new Pair(index, value));
        NumElm++;
        for (int i = 0; i<arr.size(); i++) {

            for(int j =i+1 ; j<arr.size();j++)
                if(arr.get(i).getInd()>arr.get(j).getInd()) {
                    temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,temp);
                }
        }
        for(int i = 0 ; i <arr.size(); i++){
            if(arr.get(i).getInd()==index){
                ret =  arr.get(i).getVal();
                arr.get(i).set(value);
                return ret;
            } }




        return 0;

    }

    private static class Pair {  //private class within the Sparse Array class

        private int index;
        private int value;

        private Pair(int ind, int val){

            this.index = ind ;
            this.value = val;

            }

            private void set ( int val) {
            this.value = val;
            }

           private int getInd (){ return this.index; }
           private int getVal(){ return this.value; }

            }

            public String toString (){
        StringBuilder s = new StringBuilder();

        for (int k = 0 ; k < arr.size(); k ++){
            s.append("index = "+arr.get(k).getInd()+"\t");
            s.append(" value = "+ arr.get(k).getVal()+"\n");
        }

        return s.toString();

            }

    public static void main(String[] args) throws Exception {
        File file = new File ("ArraySparseArray.txt");           //file object
        Scanner filein = new Scanner (file);                                        //passing file object to scanner class
        Scanner keyin = new Scanner (System.in);                                    //keyboard input object initialization
        int  in;                                                                    //keyboard input variable
        ArraySparseArray arraySparseArray = new ArraySparseArray(5);          //initializing object arraysparsearray

        while(filein.hasNext()) {                                                    //loop that reads a file full of integers into the pair array object
            arraySparseArray.set(filein.nextInt(),filein.nextInt());
        }

        System.out.println(" Size: "+arraySparseArray.size());
        System.out.println("Enter the following options \n ");                         //Prompts user the options to carry actions
        System.out.println("SET = 0\n");
        System.out.println("SEARCH = 1\n");
        System.out.println("PRINT = 2\n");
        System.out.println("===========EXIT = 3============\n");

        in = keyin.nextInt();



        while(in!= 3){                                                                  //loop that keeps the corresponding options running until sentinal value is entered to terminate

            if ( in == 0 ) {
                System.out.println("Index :?\nValue:?");
                System.out.print(arraySparseArray.set(+keyin.nextInt(), keyin.nextInt()));
                System.out.print(" was the previous value \t");
                in = keyin.nextInt();
            }

                else if (in == 1 ) {
                System.out.print("Index: ");
                System.out.println("value:"+(arraySparseArray.get(keyin.nextInt())));
                //System.out.println("value: "+arraySparseArray.BinarySearch(keyin.nextInt()));
                in = keyin.nextInt();
            }

                    else if(in == 2) {
                System.out.println(arraySparseArray.toString());
                in = keyin.nextInt();
            }
                    else {
                System.out.println("Invalid input!!!!");
                in = keyin.nextInt();
            }
            }
        }

    }

