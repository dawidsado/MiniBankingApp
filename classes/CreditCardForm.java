package MiniBankingApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class CreditCardForm extends Client {
    private long number;
    private int CVC;
    private int expirationDate;
    private static final ArrayList<Integer> AVAILABLE_YEARS = new ArrayList<>();

    public CreditCardForm(String firstName, String lastName, long number, int CVC) {
        super(firstName, lastName);
        this.number = number;
        this.CVC = CVC;
    }

    static {
        int currentYear = getCurrentYear();
        for (int i=currentYear;i<=currentYear + 20;i++){
           AVAILABLE_YEARS.add(i);
        }
    }


    private static int getCurrentYear(){
        return LocalDate.now().getYear();
    }

    public int setExpirationYear() {
        Random random = new Random();
        return AVAILABLE_YEARS.get(random.nextInt(AVAILABLE_YEARS.size()));
    }
}
