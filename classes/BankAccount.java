package MiniBankingApp;

import java.util.ArrayList;
import java.util.Date;

public class BankAccount implements AccountOperations {
   public double balance = 0;
   public ArrayList transactions = new ArrayList();

    public BankAccount(Client client) {
        this.balance = balance;
        this.transactions = new ArrayList();
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList getTransactions() {
        return transactions;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void transfer(BankAccount accountToTransfer, double amount) throws AccountOperationException {
        if (amount <= 0 || amount > this.balance){
            throw new AccountOperationException("Incorrect value, check your balance and the amount you choose");
        }
        this.balance -= amount;
        accountToTransfer.balance += amount;
    }

    @Override
    public double deposit(double amount) {
        Date date = new Date();
        transactions.add("Deposit: " + amount + " " + date);
        return balance += amount;
    }
}
