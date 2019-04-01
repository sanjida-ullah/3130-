/***Sanjida Ullah
CISC 3130
Homework #4 ***/	
import java.util.*;
	import java.io.*; 
	class BookDatabase {
		  private String key;
		  private Book book;
		  

		  
		  Map<String, Book> bookData = new HashMap<String, Book>();
		  
		  public Book searchByTitle(String title) {
		  return bookData.get(title);
		  }
		  public Set<Book> searchByAuthor(String author) {
			 Set<String> t1 = bookData.keySet();
			 Set<Book>t2 = null; 
			 for(String x: t1) {
				 if(bookData.get(x).getAuthors().equals(author))
					 t2.add(bookData.get(x));
			 }
			 return t2; 
			  
		  }
		  public Set<Book> publishedBefore(int year) {
			  Set<String> t1 = bookData.keySet();
				 Set<Book>t2 = null; 
				 for(String x: t1) {
					 if(bookData.get(x).getYearOfPublication()<(year))
						 t2.add(bookData.get(x));
				 }
				 
				 return t2;
		  }
		  public Set<Book> searchByPublisher(String publisher) {
			  Set<String> t1 = bookData.keySet();
				 Set<Book>t2 = null; 
				 for(String x: t1) {
					 if(bookData.get(x).getPublisher().equals(publisher))
						 t2.add(bookData.get(x));
				 }
				 return t2; 
		  }
		  public void addBook(Book book) {
			  if(!bookData.containsKey(book.getTitle()))
		   bookData.put(book.getTitle(), book);
		
		}
		  
		  public String toString () {
			  Set<String> temp = bookData.keySet();
			  StringBuilder s = new StringBuilder();
			  for(String x:temp) {
				  s.append(bookData.get(x).toString());
			  }
			  return s.toString();
		  }
	}

		  
		  
		 
		  




