/*packages used in this code.*/
import  java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Ritik_Contact_List_App {                                          //Implementation class
    ArrayList<Person> arrayList = new ArrayList<>();                    //List to store the details of the person(name,contacts and email).
    Scanner sc = new Scanner(System.in);                                //Scanner obj to take inputs from the user.
    public void addContact()                                            //method to to add the contacts of the person.
    {
        Person person = new Person();
        System.out.println("You have chosen to add a new contact: ");
        System.out.println("Please enter the name of the Person.");
        System.out.print("First Name: ");
        person.setFirst_Name(sc.next());                                 //taking person's first name input from user.
        System.out.print("Last Name: ");
        person.setLast_Name(sc.next());                                  //taking person's last name input from user.
        System.out.print("Contact Number: ");
        person.setArr(sc.nextLong());                                     //taking person's contact number input from user.


        int t=4;
        /*below while loop is to take extra inputs of contact numbers
        if user wants to add.(MAXIMUM 4 EXTRA CONTACTS NUMBERS CAN BE ADDED.)*/
        while(t>0)
        {
            System.out.println("Would you like to add another contact number? (y/n): ");
            String s = sc.next();
            if (s.equals("y")) {
                System.out.println("Contact Number: ");
                person.setArr(sc.nextLong());
            } else if (s.equals("n")) {
                break;
            } else {
                System.out.println("Enter only y(for yes) or n(for no).");
            }
            t--;
        }


        /*below while loop to take person's emails inputs from the user.
        (MAXIMUM 1 EMAIL ONLY CAN BE ADDED.)*/
        while(true) {
            System.out.println("Would you like to add email address? (y/n):");
            String s2 = sc.next();
            if (s2.equals("y")) {
                System.out.print("Email Address: ");
                person.setEmail_ID(sc.next());
                break;
            } else if(s2.equals("n")) {
                break;
            }
            else
            {
                System.out.println("Enter only y(for yes) or n(for no).");
            }
        }

        arrayList.add(person);                      /*adding the details of the person contact taken as input from user
                                                      into the list*/
        bubblesort(arrayList);

    }

    public void bubblesort(ArrayList<Person> arrayList)
    {
        if(arrayList.size()>1) {
            Person temp;
            for (int i = 0; i < arrayList.size()-1; i++) {
                for (int j = 0; j < arrayList.size() - 1-i; j++) {
                    if ((arrayList.get(i).getFirst_Name()).compareTo(arrayList.get(i + 1).getFirst_Name()) > 0) {
                        temp = arrayList.get(i);
                        arrayList.set(i, arrayList.get(i + 1));
                        arrayList.set(i + 1, temp);
                    }
                }
            }
        }
    }
    public void viewContacts()                      //method to display the contact of all person stored in the list by the user.
    {
        System.out.println("---Here are all your contacts---");
        for(int i=0;i<arrayList.size();i++)
        {
            System.out.println("-------- * -------- * -------- * --------");
            System.out.print(i+1+". ");
            System.out.print("Name: ");
            System.out.println(arrayList.get(i).getFirst_Name()+" "+arrayList.get(i).getLast_Name());   //printing the first and last name of contact.
            int l=0;
            if(arrayList.get(i).getArr()[l] != 0 && arrayList.get(i).getArr()[l+1] == 0)
            {
                System.out.print("   Contact: ");
                checkNullContact(i);                  //method call to check null entries.
            }
            else if(arrayList.get(i).getArr()[l] != 0 && arrayList.get(i).getArr()[l+1] != 0)
            {
                System.out.print("   Contact(s): ");
                checkNullContact(i);                 //method call to check null entries.
            }
            System.out.print("   Emails: ");
            System.out.println(arrayList.get(i).getEmail_ID());
            System.out.println("-------- * -------- * -------- * --------");
        }
    }

    private void checkNullContact(int i) {           //method to check the null contacts.
        for(int k=0;k<arrayList.get(i).getArr().length; k++)
        {
            if (arrayList.get(i).getArr()[k] != 0)
            {
                System.out.print(arrayList.get(i).getArr()[k]+" "); //printing the contact numbers of the person
            }                }
        System.out.println();
    }

    public void searchContact()                                     //method to search for all contact by their first name.
    {
        System.out.println("You could search for a contact from their first names:  ");
        String str = sc.next();                                     //taking first name as input.
        str = str.toLowerCase();
        int c=0;
        for(int j=0; j<arrayList.size(); j++) {
            String str2 = arrayList.get(j).getFirst_Name();
            str2 = str2.toLowerCase();
            if (str.equals(str2))
            {
                System.out.println("1 match found!");
                System.out.println("-------- * -------- * -------- * --------");
                System.out.print("Name:");
                System.out.println(" "+arrayList.get(j).getFirst_Name()+" "+arrayList.get(j).getLast_Name());
                int l=0;
                if(arrayList.get(j).getArr()[l] != 0 && arrayList.get(j).getArr()[l+1] == 0)
                {
                    System.out.print("Contact: ");
                    checkNullContact(j);                  //method call to check null entries.
                }
                else if(arrayList.get(j).getArr()[l] != 0 && arrayList.get(j).getArr()[l+1] != 0)
                {
                    System.out.print("Contact(s): ");
                    checkNullContact(j);                 //method call to check null entries.
                }
                System.out.print("Emails: ");
                System.out.println(arrayList.get(j).getEmail_ID());
                c=1;
            }
        }
        if(c==0)
        {
            System.out.println("NO RESULTS FOUND!");
        }
    }
    public void delContact()                                       //method to delete a contact from the list.
    {
        viewContacts();
        System.out.println("Press the number against the contact to delete it: ");
        int i = sc.nextInt();
        String name = arrayList.get(i-1).getFirst_Name() + " " + arrayList.get(i-1).getLast_Name();
        arrayList.remove(i-1);
        System.out.println(name + "'s contact deleted from list!");
    }

}

class Ritik_Contact_List_App_Main                            //main method class.
{
    public static void main(String[] args) {                //main method.

        int i = 0;
        Ritik_Contact_List_App obj = new Ritik_Contact_List_App();     //creating object of implementation class.
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to add a new contact.");
            System.out.println("Press 2 to view all contacts.");
            System.out.println("Press 3 to search for a contact.");
            System.out.println("Press 4 to delete a contact.");
            System.out.println("Press 5 to exit program.");
            int choice = sc.nextInt();                                     //reading the choice of user as input.
            switch (choice) {
                case 1:
                    obj.addContact();
                    break;
                case 2:
                    obj.viewContacts();
                    break;
                case 3:
                    obj.searchContact();
                    break;
                case 4:
                    obj.delContact();
                    break;
                case 5:
                    System.exit(0);                             //to exit the code successfully.
                    break;
                default:
                    System.out.println("Enter correct option.");
            }
        }
    }
}
