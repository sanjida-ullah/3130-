/***Sanjida Ullah
CISC 3130
Homework #1 ***/

import java.io.*;
import java.util.*;

class Contact implements Comparable<Contact> {
  
  private String first, last, number, address, city, state;
  
  public Contact(String first, String last, String number, String address, String city, String state) {
    
    this.first = first;
    this.last = last;
    this.number = number; 
    this.address = address;
    this.city = city;
    this.state = state; 
  }
  
  public Contact(String first, String last, String number) {
    this(first, last, number,"", "","");
  }
  
  public String getFirst() {return first;}
  public String getLast() {return last;}
  public String getNumber() {return number;}
  public String getAddress() {return address;}
  public String getCity() {return city;}
  public String getState() {return state;}
  
  
  public void update(String first, String last, String number, String address, String city, String state) {
    
    this.first = first;
    this.last = last;
    this.number = number; 
    this.address = address;
    this.city = city;
    this.state = state;
    
  } 
  
  public boolean equals(Contact other) { 
    return first.equals(other.first) && last.equals(other.last) && number.equals(other.number) ;
  }
  
  
  public String toString() {
    return (first + " " + last + "\t" + "Phone number: " + number +
            "\n" + address + "\n" + city + ", " + state);
  }
  
  public int compareTo(Contact another) {
    int var1 = last.compareTo(another.last);
    int var2 = first.compareTo(another.first);
    if (var1 == 0 && var2 == 0)
      return 0;
    else if (var1 == 0 && var2 != 0) 
      return var2;
    else return var1; 
  }
  
  
  public static void main (String [] args) throws Exception {
    String first = "Sanjida"; 
    String last = "Ullah"; 
    String number = "(718)123-4567";
    String address = "2900 Beford Avenue";
    String city = "Brooklyn";
    String state = "NY";
    
    String first2= "San";
    String last2= "Ull";
    String number2 = "(718) 987-6543";
    Contact contact = new Contact(first, last, number, address, city, state);
    Contact contact2 = new Contact(first2, last2, number2);
    
    System.out.println(contact.getFirst());
    System.out.println(contact.getLast());
    System.out.println(contact.getNumber());
    System.out.println(contact.getAddress());
    System.out.println(contact.getCity());
    System.out.println(contact.getState());
    System.out.println(contact.compareTo(contact2));
    System.out.println(contact.toString());
    System.out.println(contact.equals(contact2));
    
    contact.update("San", "Ull", "(346) 782-9561", "970 bedford ave", "queens", "NJ");
    System.out.println(contact);
    
  }  
}




