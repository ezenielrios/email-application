package emailapp;
import java.util.*;
import java.io.*; //input and output library
public class Email {
    public Scanner s = new Scanner(System.in); //Scanner class global
    //Setting Variables as private
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;
    //Constructor to receive first name, last name
    public Email(String fname,String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee:"+this.fname+""+this.lname);


    }
    //Generate the mail method and to achieve abstraction make private
    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }
    //Asking for dept
    private String setDept(){
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        //could use if else but switch case is more efficient to reduce time complexity
        boolean flag = false;
        do{
            System.out.println("Enter Department code");
            int choice =s.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose again");
            }
        }while (!flag);
        return null;
    }
    //Generate Random Password
    private String generate_password(int length){
        Random r =new Random();
        String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars="abcdefghijklmnopqrstuvwxyz";
        String numbers ="0123456789";
        String symbols="!@#$%&?";
        String values=Capital_chars+Small_chars+numbers+symbols;
        String password="";
        for(int i=0;i<length;i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
    //change password method make public for user
    public void set_password(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password!(Y/N)");
            char choice = s.next().charAt(0);
            if(choice=='Y'||choice=='y') {
                flag = true;
                System.out.println("Enter current password:");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password:");
                    this.password = s.next();
                    System.out.println("Password changed succesfully");
                } else {
                    System.out.println("Incorrect password");
                }
            }else if(choice =='N'||choice =='n'){
                flag = true;
                System.out.println("Password changed option cancelled!");
            }
            else{
                System.out.println("Enter Valid choice");
            }
        }while (!flag);
    }
    //set mailbox capacity
    public void set_mailCap(){
        System.out.println("Current Capacity= "+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }
    //set alternate mail
    public void alternate_email(){
        System.out.println("Enter new alternate mail:");
        this.alter_email = s.next("Alternate email is set");
    }

}
