package MiniBankingApp;

public class Admin extends User implements CreatePassword {
    private int ID;
    private static int COUNTER = 0;

    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
        COUNTER++;
        this.ID = COUNTER;
    }

    public Client createClient (String firstName, String lastName){
        Client client = new Client(firstName, lastName);
        BankAccount newClient = new BankAccount(client);
        return client;
    }

    public Employee createEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        return employee;
    }

    public void removeEmployee (Employee employee){
        employee = null;
    }


    @Override
    public String generatePassword() {
        return String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + ID + "_" + hashCode();
    }
}
