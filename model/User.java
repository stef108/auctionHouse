package model;

import patterns.behavioral.Observer;

public abstract class User implements Observer {
    protected String username;
    protected double balance;

    public User(String username, double startingBalance) {
        this.username = username;
        this.balance = startingBalance;
    }

    public String getUsername() { return username; }
    public double getBalance() { return balance; }


    public abstract boolean deductListingFee();

    public void adjustBalance(double amount) {
        this.balance += amount;
    }
    @Override
    public void update(String message) {
        System.out.println(">>> NOTIFICATION for " + username + ": " + message);
    }


}