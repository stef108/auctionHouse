package services;
import model.User;

public class BankService {
    public boolean transferFunds(User from, double amount) {
        if (from.getBalance() >= amount) {
            System.out.println("Bank: Transferred $" + amount + " from " + from.getUsername());
            return true;
        }
        System.out.println("Bank: Transaction failed due to insufficient funds.");
        return false;
    }

    public boolean checkSolvency(User user, double amount) {
        return user.getBalance() >= amount;
    }

    public void lockFunds(User user, double amount) {
        if (checkSolvency(user, amount)) {
            // For this simulation, we just print a log.
            System.out.println("BANK: Funds locked: $" + amount + " for user " + user.getUsername());
        }
    }
}
