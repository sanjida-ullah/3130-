/***Sanjida Ullah
CISC 3130
Homework #4 ***/
public class Main {
	
	public static void main(String []args) {
		
		Book book1 = new Book("Great Gatsby","HarperCollins Publishing",1975,new String[]{"F. Scott Fitz Gerald"},1);
		Book book2 = new Book("Girl with the dragon tattoo","sanjida's pub",1964,new String[] {"me","myself","I"},3);
		
		BookDatabase bdb1 = new BookDatabase ();
		
		bdb1.addBook(book1);
		bdb1.addBook(book2);
		
		
		System.out.println(bdb1.toString());
		System.out.println(book1.equals(book2));
		//System.out.println(bdb1.searchByPublisher(sanjida pub));
	}

}
