package MiniBankingApp;

public interface AccountOperations {
    double checkBalance();
    void transfer(BankAccount accountToTransfer, double amount) throws AccountOperationException;
    double deposit(double amount);
}
