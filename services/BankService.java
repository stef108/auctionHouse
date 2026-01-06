package services;
import model.User;

public class BankService {

    public boolean checkSolvency(User user, double amount) {
        return user.getBalance() >= amount;
    }

    public boolean transferFunds(User buyer, User seller, double amount) {
        if (!checkSolvency(buyer, amount)) {
            System.out.println("BANK: Transaction failed. " + buyer.getUsername() + " has insufficient funds.");
            return false;
        }
        buyer.adjustBalance(-amount);
        seller.adjustBalance(amount);

        System.out.println("BANK: SUCCESS! Transferred $" + amount +
                " from " + buyer.getUsername() + " to " + seller.getUsername());
        return true;
    }

    public void lockFunds(User user, double amount) {
        if (checkSolvency(user, amount)) {
            System.out.println("BANK: Funds locked: $" + amount + " for user " + user.getUsername());
        }
    }
}
