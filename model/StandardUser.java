package model;

public class StandardUser extends User {
    public StandardUser(String username, double balance) {
        super(username, balance);
    }

    @Override
    public boolean deductListingFee() {
        if (balance >= 100.0) {
            balance -= 100.0 ;
            System.out.println("Standard account: $100 listing fee deducted");
            return true;
        } else {
            System.out.println("Error: insufficient balance for listing fee");
            return false;
        }
    }
}
