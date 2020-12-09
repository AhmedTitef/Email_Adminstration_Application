import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println( "Email Created: " + this.firstName + " " + this.lastName );

        this.department = setDepartment();
//        System.out.println( "Department: " + this.department );


        this.password = randomPassword( defaultPasswordLength );
        System.out.println("Your password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
//        System.out.println("Your email is: " + email);





    }

    private String setDepartment() {
        System.out.println( "DEPARTMENT CODE\n Enter the department\n1 for Sales \n2 for Development\n3 for Accounting\n0 for none\n " );
        Scanner scanner = new Scanner( System.in );
        System.out.print("Department code: ");
        int deptChoice = scanner.nextInt();
        if (deptChoice == 1) {
            return "sales";

        } else if (deptChoice == 2) {
            return "dev";

        } else if (deptChoice == 3) {
            return "acct";

        } else {
            return "";
        }
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char [] password = new char[length];
        for (int i = 0 ; i < length ; i++){
           int rand =  (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt( rand );
        }
        return new String (password);
    }


    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String showInfo(){
        return "Display name: " + firstName + " " + lastName + "\n" +
                "Company email: " + email+ "\n" +
                "Mailbox capacity: " + mailboxCapacity + "mb\n";
    }
}
