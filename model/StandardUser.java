package model;

public class StandardUser extends User {
    public StandardUser(String username, double balance) {
        super(username, balance);
    }

    @Override
    public void deductListingFee() {
        if (balance >= 5000.0) {
            balance -= 5000.0 ;
            System.out.println("Standard account: $5000 listing fee deducted");
        } else {
            System.out.println("Error: insufficient balance for listing fee");
        }
    }
}
