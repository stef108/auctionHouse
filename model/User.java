package model;

public abstract class User {
    protected String username;
    protected double balance;

    public User(String username, double startingBalance) {
        this.username = username;
        this.balance = startingBalance;
    }

    public String getUsername() { return username; }
    public double getBalance() { return balance; }


    public abstract void deductListingFee();
    
    public void receiveNotification(String message) {
        System.out.println("Notifaction for" + username + ":" + message);
    }


}