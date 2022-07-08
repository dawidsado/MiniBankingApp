package Test;

import MiniBankingApp.*;

import java.util.Random;

public class Test {

    // To generate number of credit card
    private static long getNumberOfCreditCard(){
        Random random = new Random();
        long container = 1 + random.nextInt(9);
        for (int i=0;i<15;i++){
            container *= 10L;
            container += random.nextInt(10);
        }
        return container;
    }

    public static void main(String[] args) throws AccountOperationException {
        /* Test of classes, methods, interfaces
        I will create admin, two employees, four clients and accounts for them
         */

        // Admin

        Admin a1 = new Admin("Jan", "Kowalski");
        // System.out.println(a1.generatePassword()); password
        /* Admin can create employees and clients
        a1.createClient("Adam", "Kowalski");
        Also is able to remove employees
        a1.removeEmployee(e1); */

        // Employee

        Employee e1 = a1.createEmployee("Michał", "Bursztyn");
        Employee e2 = new Employee("Agnieszka", "Burczymucha");

        // Is able to create new client and account for him
        Client c1 = e1.createClient("Zbigniew", "Jóźwiak");
        e1.createBankAccount(c1);
        // System.out.println(c1.generatePassword() + c1.ID); password and ID of first client in system

        // Client
        Client c2 = new Client("Andrzej", "Wolny");
        Client c3 = new Client("Jolanta", "Szybka");
        Client c4 = new Client("Adrian", "Sprytny");

        // Accounts for them
        BankAccount b1 = e1.createBankAccount(c2); BankAccount b2 = e1.createBankAccount(c3); BankAccount b3 = e1.createBankAccount(c4);

        /* ID and password for them
        System.out.println(c2.generatePassword() + c2.ID);
        System.out.println(c3.generatePassword() + c3.ID);
        System.out.println(c4.generatePassword() + c4.ID);
         */

        // CreditCardForm
        // Now I will create credit card for one of the clients, number will be generated based on the method from Test class
        long number = getNumberOfCreditCard();
        CreditCardForm creditCardFormC1 = new CreditCardForm(c1.firstName, c1.lastName, number, 123);

        /* Expiration year
        System.out.println(creditCardFormC1.setExpirationYear()); */

        // BankAccount
        // I will deposit money into accounts and make between them transactions
        b1.deposit(450); b2.deposit(300); b3.deposit(10_000);
        System.out.println(b1.transactions + " " + b2.transactions + " " + b3.transactions);
        //System.out.println(b1.checkBalance() + " " + b2.checkBalance() + " " + b3.checkBalance());

        /*
        b1.transfer(b2, 100);
        System.out.println(b1.checkBalance());
        System.out.println(b2.checkBalance()); */

        /* To check error
        b2.transfer(b3, 2000);
        System.out.println(b3.checkBalance());
        System.out.println(b2.checkBalance()); */

        /* b3.transfer(b1,10_000);
        System.out.println(b1.checkBalance());
        System.out.println(b3.checkBalance());
         */


        /* OR you can use createTransaction method from Transaction class, more extended and official way to execute the transfers

          c2 = b1   c3 = b2   c4 = b3 */

        Transaction t1 = new Transaction(100, c3, c2);
        t1.createTransaction(b1, 100, b2);

        Transaction t2 = new Transaction(10_000, c2, c4);
        t2.createTransaction(b3, 10_000, b1);
        System.out.println(b3.checkBalance() + " " + b1.checkBalance());
    }
}