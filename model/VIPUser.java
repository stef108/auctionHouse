package model;

public class VIPUser extends User{
    public VIPUser(String username, double balance) {
        super(username, balance);
    }

    @Override
    public void deductListingFee() {
        System.out.println("VIP account: no fee deducted");
    }
}
