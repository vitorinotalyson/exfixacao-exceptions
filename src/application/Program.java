package src.application;

import src.application.model.entities.Account;
import src.application.model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        boolean openclose = true;
        while (openclose){

            try{
                System.out.println("Enter account data: ");
                System.out.print("Number: ");
                int number = sc.nextInt();
                sc.nextLine();
                System.out.print("Holder: ");
                String holder = sc.nextLine();
                System.out.print("Initial balance: ");
                double balance = sc.nextDouble();
                System.out.print("Withdraw limit: ");
                double withdrawLimit = sc.nextDouble();
                Account account = new Account(number,holder,balance,
                        withdrawLimit);
                System.out.println();
                System.out.print("Enter amount for withdraw: ");
                double withdraw = sc.nextDouble();
                account.withdraw(withdraw);
                System.out.printf("New balance: %.2f",account.getBalance());
            }
            catch (DomainException e){
                System.out.println("Withdraw error: "+ e.getMessage());
            }
            System.out.println();
            System.out.print("Continue? (y/n) ");
            char cnt = sc.next().toLowerCase().charAt(0);
            if (cnt == 'y'){
                openclose = true;
            }
            else if (cnt == 'n'){
                openclose = false;
                System.out.println("Program Closed.");
            }


        }
        sc.close();
    }
}
