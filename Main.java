import model.AuctionListing;
import patterns.structural.AuctionSystemFacade;

public class Main {
    public static void main(String[] args) {
        AuctionSystemFacade market = new AuctionSystemFacade();

        // 1. Setup: Alice (VIP, $50000) and Bob (Standard, $100) list items
        market.loginOrRegister("Bob", "STANDARD");
        market.createAuction("Old Book", 5.00, "Rare classic.");
        AuctionListing book = market.findFirstListing();

        market.loginOrRegister("Alice", "VIP");

        // 2. Bob attempts to bid (FAIL: Low Balance)
        market.loginOrRegister("Bob", "STANDARD");
        market.placeBid(book, 1000.00);

        // 3. Alice attempts to bid (SUCCESS)
        market.loginOrRegister("Alice", "VIP");
        market.placeBid(book, 10.00);
    }
}