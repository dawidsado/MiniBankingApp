package MiniBankingApp;

public abstract class User {
    public String firstName;
    public String lastName;

    User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
