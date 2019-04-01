/***Sanjida Ullah
CISC 3130
Homework #4 ***/	
import java.util.*;
	import java.io.*;
	
	class Book {
	  private String title;
	  private String publisher;
	  private int yearOfPublication;
	  private String[ ] authors;
	  private int numAuthors;
	
	  public Book(String title, String publisher, int yearOfPublication, String[ ] authors, int numAuthors) {
	  this.title = title;
	  this.publisher = publisher; 
	  this.yearOfPublication = yearOfPublication;
	  this.authors = authors;
	  this.numAuthors = numAuthors; 
	  }
	  public String getTitle() {return title;}
	  public String getPublisher() {return publisher;}
	  public int getYearOfPublication() {return yearOfPublication;}
	  
	  public String[] getAuthors() {return authors;}
	  public int getNumAuthors() {return numAuthors;}
	  
	  public boolean equals (Object obj) {
	  return title.equals(((Book) obj).getTitle());
	  }
	  public int compareTo(Book another) {
	    int var1 = title.compareTo(another.title);
	   return var1; 
	  }
	  public String toString() {
	    return ("Title: " + title + "\n" + "Authors: " + Arrays.toString(authors) + "\nPublisher: " + publisher +
	            "\n" + "Year: " + yearOfPublication+"\n\n");
	  }
	 
	  
	}
	
