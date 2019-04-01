import java.util.ArrayList;

import java.util.Arrays;

import java.util.Iterator;

class Contact2 {

   private String firstName, lastName, phone, city;

   public Contact2(String firstName, String lastName, String phone, String city) {

       super();

       this.firstName = firstName;

       this.lastName = lastName;

       this.phone = phone;

       this.city = city;

   }

   /**

   * @return the firstName

   */

   public String getFirstName() {

       return firstName;

   }

   /**

   * @param firstName the firstName to set

   */

   public void setFirstName(String firstName) {

       this.firstName = firstName;

   }

   /**

   * @return the lastName

   */

   public String getLastName() {

       return lastName;

   }

   /**

   * @param lastName the lastName to set

   */

   public void setLastName(String lastName) {

       this.lastName = lastName;

   }

   /**

   * @return the phone

   */

   public String getPhone() {

       return phone;

   }

   /**

   * @param phone the phone to set

   */

   public void setPhone(String phone) {

       this.phone = phone;

   }

   /**

   * @return the city

   */

   public String getCity() {

       return city;

   }

   /**

   * @param city the city to set

   */

   public void setCity(String city) {

       this.city = city;

   }

   /* (non-Javadoc)

   * @see java.lang.Object#hashCode()

   */

   @Override

   public int hashCode() {

       final int prime = 31;

       int result = 1;

       result = prime * result + ((city == null) ? 0 : city.hashCode());

       result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());

       result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());

       result = prime * result + ((phone == null) ? 0 : phone.hashCode());

       return result;

   }

   /* (non-Javadoc)

   * @see java.lang.Object#equals(java.lang.Object)

   */

   @Override

   public boolean equals(Object obj) {

       if (this == obj)

           return true;

       if (obj == null)

           return false;

       if (getClass() != obj.getClass())

           return false;

       Contact other = (Contact) obj;

       if (city == null) {

           if (other.city != null)

               return false;

       } else if (!city.equals(other.city))

           return false;

       if (firstName == null) {

           if (other.firstName != null)

               return false;

       } else if (!firstName.equals(other.firstName))

           return false;

       if (lastName == null) {

           if (other.lastName != null)

               return false;

       } else if (!lastName.equals(other.lastName))

           return false;

       if (phone == null) {

           if (other.phone != null)

               return false;

       } else if (!phone.equals(other.phone))

           return false;

       return true;

   }

   /* (non-Javadoc)

   * @see java.lang.Object#toString()

   */

   @Override

   public String toString() {

       return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", city=" + city

               + "]";

   }

}

public class ContactList implements Iterable<Contact> {

  

   private ArrayList<Contact> contacts;

  

   public ContactList() {

       contacts = new ArrayList<>();

   }

  

   public ContactList(Contact[] cont) {

       contacts = new ArrayList<>(Arrays.asList(cont));

   }

  

   public ContactList(ArrayList<Contact> cont) {

       contacts = new ArrayList<>(cont);

   }

  

   public ArrayList<Contact> getContactList() {

       return contacts;

   }

  

   public Contact searchByLastName(String lastName) {

       for(Contact c : contacts) {

           if (lastName.equalsIgnoreCase(c.getLastName()))

               return c;

       }

       return null;

   }

  

   public Contact searchByPhoneNumber(String phoneNumber) {

       for(Contact c : contacts) {

           if (phoneNumber.equalsIgnoreCase(c.getPhone()))

               return c;

       }

       return null;

   }

  

   public ContactList getContactList(char ch) {

       ArrayList<Contact> conts = new ArrayList<>();

      

       for(Contact c : contacts) {

           if(c.getLastName().toLowerCase().charAt(0) == Character.toLowerCase(ch)) {

               conts.add(c);

           }

       }

       return new ContactList(conts);

   }

  

   public ContactList getContactListByCity(String city) {

       ArrayList<Contact> conts = new ArrayList<>();

      

       for(Contact c : contacts) {

           if(city.equalsIgnoreCase(c.getCity())) {

               conts.add(c);

           }

       }

       return new ContactList(conts);

   }

  

   public void addContact(Contact c) {

       if(contacts.contains(c))

           return;

       contacts.add(c);

   }

  

   public int getSize() {

       return contacts.size();

   }

  

   public void removeContact(Contact c) {

       contacts.remove(c);

   }

  

   public Contact getContactByIndex(int i) {

       if (i < 0 || i >= contacts.size())

           throw new IndexOutOfBoundsException("Index is out of bound!!");

       return contacts.get(i);

   }

  

   public boolean equals(ContactList cont) {

       for (Contact c1 : cont.getContactList()) {

           boolean found = false;

           for (Contact c2 : contacts) {

               if(c1.equals(c2)) {

                   found = true;

                   break;

               }

           }

           if (!found)

               return false;

       }

       return true;

   }

  

   public String toString() {

       StringBuffer sb = new StringBuffer();

       for(Contact c : contacts) {

           sb.append(c.toString() + "\n");

       }

      

       return sb.toString();

   }

  

   @Override

   public Iterator<Contact> iterator() {

       Iterator<Contact> it = new Iterator<Contact>() {

          

           private int currentIndex = 0;

          

           @Override

           public Contact next() {

               return contacts.get(currentIndex ++);

           }

          

           @Override

           public boolean hasNext() {

               return currentIndex < contacts.size() && contacts.get(currentIndex) != null;

           }

       };

       return it;

   }

  

   public static void main(String args[]) {

       ContactList c1 = new ContactList();

       c1.addContact(new Contact("John", "Doe", "1234", "New York"));

       c1.addContact(new Contact("Mitchelle", "Kane", "6741", "New York"));

       c1.addContact(new Contact("Drake", "Harold", "1001", "LA"));

       c1.addContact(new Contact("Jane", "Doe", "7812", "Omaha"));

       c1.addContact(new Contact("Javier", "Hernandez", "5566", "New York"));

      

       System.out.println("\nContact with last name Harold : " + c1.searchByLastName("Harold"));

       System.out.println("\nContact with phone number 1234 : " + c1.searchByPhoneNumber("1234"));

       System.out.println("\nList of contacts with last name starting from letter H : \n" + c1.getContactList('H'));

       System.out.println("\nContact at index 4 : " + c1.getContactByIndex(4));

       System.out.println("\nList of contacts living in city New York : \n" + c1.getContactListByCity("New York"));

      

       Contact c = new Contact("Javier", "Hernandez", "5566", "New York");

       System.out.println("\nRemoving contact " + c + " .......");

       c1.removeContact(c);

       System.out.println("\nList of contacts now : \n" + c1);

      

       ContactList c2 = new ContactList();

       c2.addContact(new Contact("Drake", "Harold", "1001", "LA"));

       c2.addContact(new Contact("Mitchelle", "Kane", "6741", "New York"));

       c2.addContact(new Contact("Jane", "Doe", "7812", "Omaha"));

       c2.addContact(new Contact("John", "Doe", "1234", "New York"));

      

       System.out.println("\nSecond list of contacts: \n");

       System.out.println(c2);

      

       System.out.println("Are both the contact lists equal ? : " + c1.equals(c2));

   }

}