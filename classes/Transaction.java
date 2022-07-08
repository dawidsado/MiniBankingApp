package MiniBankingApp;

public class Transaction {
    private double amount;
    private Client transferReceiver;
    private Client transferSender;

    public Transaction(double amount, Client transferReceiver, Client transferSender) {
        this.amount = amount;
        this.transferReceiver = transferReceiver;
        this.transferSender = transferSender;
    }

    public void createTransaction(BankAccount senderAccount, double amount, BankAccount receiverAccount){
        if (amount > senderAccount.balance || amount <= 0){
            throw new IllegalArgumentException("Incorrect value, check your balance and the amount you choose");
        }
        senderAccount.balance -= amount;
        receiverAccount.balance += amount;
    }
}
