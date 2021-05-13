package kz.kenzhe.emailapp;

import java.sql.Array;
import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "mycompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        System.out.println("Department:" + this.department);

        password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: " + password);

        email = firstName.toLowerCase() + "."
                + lastName.toLowerCase() + "@"
                + department + "."
                + companySuffix;
        System.out.println(email);
    }

    private String setDepartment() {
        System.out.println("Enter the department" +
                "\n1 for Sales" +
                "\n2 for Development" +
                "\n3 for Accounting" +
                "\n0 for none");

        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        else return "";
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*-=+";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand;
            if (i == 0) rand = (int) (Math.random() * 52);
            else rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }
}
