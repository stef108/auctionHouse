package model;

public class VIPUser extends User{
    public VIPUser(String username, double balance) {
        super(username, balance);
    }

    @Override
    public boolean deductListingFee() {
        System.out.println("VIP account: no fee deducted");
        return true;
    }
}
