import java.util.*;

class ATM {
    Scanner sc = new Scanner(System.in);

    int accno = 123456;
    int pin = 1234;
    double balance = 10000;

    void start() {

        System.out.println("Atm started");

        if (login()) {
            menu();
        } else {
            System.out.println("Wrong credentials");
        }
    }

    boolean login() {
        try {
            System.out.print("Enter account number: ");

            long enteredAccno = sc.nextLong();

            System.out.print("Enter PIN: ");

            int enteredPin = sc.nextInt();

            return enteredAccno == accno && enteredPin == pin;

        } catch (InputMismatchException e) {

            System.out.println("invalid pin or account number use only digits.");

            sc.nextLine();
            return false;
        }

    }

    void checkBalance() {

        System.out.println("your balance is: ");

        System.out.println(balance);
    }

    void deposit() {

        try {
            System.out.println("enter the amount: ");

            int amt = sc.nextInt();
            if (amt < 0) {
                System.out.println("Invalid deposit amountamount should be greater than 0");
                return;
            }

            balance = balance + amt;

            System.out.println("new balance: ");

            System.out.println(balance);
        } catch (InputMismatchException e) {
            System.out.println("Invalid deposit amount enter ony digits");
            sc.nextLine();
        }

    }

    void withdraw() {

        try {
            System.out.println("your current balance:");

            System.out.println(balance);

            System.out.println("enter the amount to withdraw:");

            int withamt = sc.nextInt();
            if (withamt <= 1) {

                System.out.println("invalid amount");
                return;
            }

            if ((balance - withamt) < 0) {

                System.out.println("insufficient baance..");

            } else {

                balance = balance - withamt;

                System.out.println("new balance: ");

                System.out.println(balance);

            }

        } catch (InputMismatchException e) {

            System.out.println("use only positive digits");

            sc.nextLine();
        }

    }

    void changePin() {
        try {

            System.out.println("enter your old pin: ");
            int enpin = sc.nextInt();
            if (enpin != pin) {
                System.out.println("invalid pin");
            } else {
                System.out.println("enter your new pin:");
                int cpin = sc.nextInt();
                String s = String.valueOf(cpin);
                if (s.length() != 4) {
                    System.out.println("pin can only have 4 digits");

                } else {
                    pin = cpin;
                    System.out.println("pin changed");

                }

            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid pin type use only digits.");
            sc.nextLine();

        }
    }

    void exit() {
        System.out.println("Thank you for using the ATM!");
    }

    void menu() {

        System.out.println("\nWelcome!");

        while (true) {

            System.out.println("\nMENU");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            
            try{
                int choice = sc.nextInt();
            
            

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    changePin();
                    break;

                case 5:
                    exit();
                    return;

                default:
                    System.out.println("Invalid choice");
            }}catch(InputMismatchException e){
                System.out.println("invalid choice");
                sc.nextLine();
            }

        }

    }

}

public class Caller {
    public static void main(String[] args) {
        ATM a = new ATM();
        a.start();
    }
}