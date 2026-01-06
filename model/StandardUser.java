package model;

public class StandardUser extends User {
    public StandardUser(String username, double balance) {
        super(username, balance);
    }

    @Override
    public boolean deductListingFee() {
        double fee = 5.00;
        if (this.balance >= fee) {
            this.adjustBalance(-fee);
            System.out.println("Standard Account: $" + fee + " listing fee deducted.");
            return true;
        } else {
            System.out.println("Error: Insufficient funds for listing fee.");
            return false;
        }
    }
}
