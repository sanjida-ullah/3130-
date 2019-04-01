/***Sanjida Ullah
  CISC 3130
  Homework #2 ***/
import java.util.ArrayList;
import java.util.Iterator;

public class ContactList implements Iterable<Contact> {
  
  private ArrayList<Contact> ContactList;
  
  public Iterator<Contact> iterator () {
    return ContactList.iterator();
  }
  
  public ContactList() { // creates empty contactList
    
    ContactList = new ArrayList<Contact>();
  }
  
  public ContactList(Contact[] cont) { //intializing Contact list with array of contacts
    
    for (int i= 0; i < cont.length; i++) {
      ContactList.add(cont[i]);
    }
  }
  
  public Contact searchByLastName(String last) {
    
    for (int i = 0; i < ContactList.size(); i++) {
      
      if (last.equals(ContactList.get(i).getLast()))
        
        return ContactList.get(i);
    }
    return null;   
  }
  
  public Contact searchByPhoneNumber(String number) {
    
    for (int i = 0; i < ContactList.size(); i++) {
      
      if (number.equals(ContactList.get(i).getNumber())) 
      
        return ContactList.get(i); 
    }
    return null;
  }
  
  public ArrayList listBySpecificLastChr (String chr) { //returns contacts begining with same letter
    
    ArrayList<Contact> conts = new ArrayList<Contact>();
    
    for (int i = 0; i < ContactList.size(); i++)
      
      if(chr.equals(ContactList.get(i).getLast().indexOf(0)))
      
      conts.add(ContactList.get(i));
    
    if(conts.isEmpty())
    
      return null;
   
    return conts;  
  }   
  
  public ArrayList contactListByCity (String city) {
    
    ArrayList<Contact> conts = new ArrayList<Contact>();
    
    for (int i = 0; i < ContactList.size(); i++) {
      
      if(city.equals(ContactList.get(i).getCity())) 
        
        conts.add(ContactList.get(i));
    }
    if(conts.isEmpty()) 
     
      return null;
    
    return conts; 
  }
  
  public void addContact (Contact cont) {
    
    if(!ContactList.contains(cont))
      ContactList.add(cont);
  }
  
  public int contatListSize() {
    
    return ContactList.size(); 
  }
  
  public void removeContact(Contact c) {
    
    if(ContactList.contains(c))
      ContactList.remove(c);
    else System.out.println(" ***Contact Does NOT Exist*** ");
  }
  
  public Contact contactByIndex(int i) throws IndexOutOfBoundsException {
    
    if (i < 0 || i >= ContactList.size())
      
      throw new IndexOutOfBoundsException("Index is out of bound!!");
    
    return ContactList.get(i);
  }
  public boolean equals(ArrayList<ContactList> cont) {
    
    return (cont.retainAll(ContactList));
  }
  
  public String toString() {
    
    StringBuilder sb = new StringBuilder("");
    
    for (int i = 0; i < ContactList.size(); i++) {
      
      sb.append(ContactList.get(i).toString() + "\n");
      
    }
    return sb.toString();
    
  }
  
  
  public static void main(String[] args) {
    
    ContactList myCtList = new ContactList();
    
    Contact cont1 = new Contact("San", "Ul", "1234", "892 Avenue P", "Brooklyn", "New York");
    
    Contact cont2 = new Contact("Miky", "Doe", "5678", "723 Broadway", "New York", "New York");
    
    Contact cont3 = new Contact("Drake", "Harold", "9101", "1120 happy Lane", "Denver", "Colorado");
    
    Contact cont4 = new Contact("Jane", "Doe", "1121", "23 President St",  "LakeVill", "Virginia");
    
    Contact cont5 = new Contact("Jane", "Doe", "1121", "23 President St", "LakeVill",  "Virginia");
    
    myCtList.addContact(cont1);
    myCtList.addContact(cont2);
    myCtList.addContact(cont3);
    myCtList.addContact(cont4);
    myCtList.addContact(cont5);
    
    ContactList myCtList2 = new ContactList();
    myCtList2.addContact(cont1);
    myCtList2.addContact(cont2);
    myCtList2.addContact(cont3);
    myCtList2.addContact(cont4);
    myCtList2.addContact(cont5);
    
    ArrayList<ContactList> myList = new ArrayList<ContactList>();
    myList.add(myCtList);
    
    System.out.println(myCtList.toString());
    myCtList.addContact(new Contact("Monkey", "George", "2301","funny Street", "Montgomery", "Alabama"));
 
    System.out.println(myCtList.toString());
    System.out.println(myCtList.searchByPhoneNumber("1234").toString());
    System.out.println(myCtList.contactByIndex(2));
    System.out.println(myCtList.equals(myList));
    System.out.println(myCtList.contactByIndex(2));
    
    
  }
}






