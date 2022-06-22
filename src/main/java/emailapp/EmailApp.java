package emailapp;
import java.util.*;
import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        // User name
        System.out.println("Enter first name:");
        String f_name = s.next();
        System.out.println("Enter last name:");
        String l_name = s.next();

        // creating object for Email class
        Email em1 = new Email(f_name,l_name);
        int choice =-1;
        do{
            System.out.println("\n*********\nEnter your choice\n1.Show info\n2.Change password\n3.Change mailbox capacity\n4.Set Alternate mail\n5.Exit ");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    System.out.println("Thank you for using our application!");
                    break;
                default:
                    System.out.println("Invalid Choice!! \nEnter a valid choice again...");

            }
        }while (choice!=5);

    }
}
