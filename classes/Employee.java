package MiniBankingApp;

public class Employee extends User implements CreatePassword {
    private int ID;
    private static int COUNTER = 0;

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
        COUNTER++;
        this.ID = COUNTER;
    }

    public Client createClient(String firstName, String lastName){
        Client newClient = new Client(firstName, lastName);
        return newClient;
    }

    public BankAccount createBankAccount(Client client){
        BankAccount newBankAccount = new BankAccount(client);
        return newBankAccount;
    }

    @Override
     public String generatePassword() {
        return String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + ID + "_" + hashCode();
     }
}
