package MiniBankingApp;

public class Client extends User implements CreatePassword {
        public int ID;
        private static int COUNTER = 0;

        public Client(String firstName, String lastName){
            super(firstName, lastName);
            COUNTER++;
            this.ID = COUNTER;
        }

    @Override
    public String generatePassword() {
        return String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0)) + ID + "_" + hashCode();
    }
}
