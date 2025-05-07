package view.console;

import exceptions.InvalidDNIException;
import exceptions.InvalidNameException;
import java.util.Scanner;
import model.validations.UserDataValidations;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String option;
        do {
            System.out.println("MENU: ");
            System.out.println("1.- Tester CheckId");
            System.out.println("2.- Tester CheckFormatDate");
            System.out.println("3.- Tester CalculateAge");
            System.out.println("4.- Tester CheckPostalCode");
            System.out.println("5.- Tester IsNumeric");
            System.out.println("6.- Tester IsAlphabetic");
            System.out.println("7.- Tester CheckEmail");
            System.out.println("8.- Tester CheckName");
            System.out.println("9.- Exit");
            System.out.println("Option: ");
            option = sc.next();

            switch (option) {
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testCheckFormatDate();
                    break;
                case "3":
                    testCalculateAge();
                    break;
                case "4":
                    testCheckPostalCode();
                    break;
                case "5":
                    testIsNumeric();
                    break;
                case "6":
                    testIsAlphabetic();
                    break;
                case "7":
                    testCheckEmail();
                    break;
                case "8":
                    testCheckName();
                    break;
                case "9":
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option");
            }

        } while (!option.equals("9"));
    }

    static void testCheckId() {
        System.out.println("NIF validator");
        System.out.print("Enter your ID: ");
        String dni = sc.next();

        try {
            UserDataValidations.checkId(1, dni);
            System.out.println("ID is valid: true");
        } catch (InvalidDNIException e) {
            System.out.println("ID is valid: false");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    static void testCheckFormatDate() {
        System.out.println("Date validator");
        System.out.println("Enter a date (dd/MM/yyyy): ");
        String date = sc.next();
        boolean validDate = UserDataValidations.checkFormatDate(date);
        System.out.println("Date is valid: " + validDate);
    }

    static void testCalculateAge() {
        System.out.println("Age calculator");
        System.out.println("Enter your birth date (dd/MM/yyyy): ");
        String birthDate = sc.next();
        int age = UserDataValidations.calculateAge(birthDate);
        System.out.println("Your age is: " + (age == -1 ? "Invalid date" : age));
    }

    static void testCheckPostalCode() {
        System.out.println("Postal Code validator");
        System.out.println("Enter your postal code: ");
        String zip = sc.next();
        boolean validZip = UserDataValidations.checkPostalCode(zip);
        System.out.println("Postal code is valid: " + validZip);
    }

    static void testIsNumeric() {
        System.out.println("Numeric validator");
        System.out.println("Enter a string: ");
        String input = sc.next();
        boolean isNumeric = UserDataValidations.isNumeric(input);
        System.out.println("Is numeric: " + isNumeric);
    }

    static void testIsAlphabetic() {
        System.out.println("Alphabetic validator");
        System.out.println("Enter a string: ");
        String input = sc.next();
        boolean isAlphabetic = UserDataValidations.isAlphabetic(input);
        System.out.println("Is alphabetic: " + isAlphabetic);
    }

    static void testCheckEmail() {
        System.out.println("Email validator");
        System.out.println("Enter an email: ");
        String email = sc.next();
        boolean validEmail = UserDataValidations.checkEmail(email);
        System.out.println("Email is valid: " + validEmail);
    }

    static void testCheckName() {
        System.out.println("Name validator");
        System.out.print("Enter a name: ");
        String name = sc.next();

        try {
            UserDataValidations.checkName(name);
            System.out.println("Name is valid: true");
        } catch (InvalidNameException e) {
            System.out.println("Name is valid: false");
            System.out.println("Reason: " + e.getMessage());
        }
    }
}
