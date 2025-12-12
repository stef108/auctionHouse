package patterns.structural;

import model.User;
import model.AuctionListing;
import services.BankService;
import services.IBiddingService;
import services.BiddingEngine;

public class SecurityBiddingProxy implements IBiddingService {

    private final BiddingEngine realEngine;
    private final BankService bankService;

    public SecurityBiddingProxy(BankService bankService) {
        // The Proxy controls the creation of the Real Engine
        this.realEngine = new BiddingEngine();
        this.bankService = new BankService();
    }

    @Override
    public boolean placeBid(User bidder, AuctionListing listing, double amount) {
        System.out.println("PROXY: Intercepting bid request...");

        boolean isSolvent = bankService.checkSolvency(bidder, amount);

        if (!isSolvent) {
            System.out.println("PROXY: Security Alert! " + bidder.getUsername() +
                    " attempted to bid $" + amount + " but failed bank check.");
            return false;
        }

        System.out.println("PROXY: Bank check passed. Delegating to Bidding Engine.");
        return realEngine.placeBid(bidder, listing, amount);
    }

    private boolean checkUserBalance(User bidder, double amount) {
        return bidder.getBalance() >= amount;
    }
}