import model.AuctionListing;
import patterns.structural.AuctionSystemFacade;

public class Main {
    public static void main(String[] args) {
        AuctionSystemFacade market = new AuctionSystemFacade();

        //  Setup
        market.loginOrRegister("Bob", "STANDARD");
        market.createAuction("Retro Laptop", 100.00, "Good condition");
        AuctionListing laptop = market.findFirstListing();

        //  Alice Bids but Bob is the owner, so he might not be watching
        market.loginOrRegister("Alice", "VIP");
        market.placeBid(laptop, 200.00);
        // Alice is now automatically added to the observer list.

        System.out.println("\n--- Charlie enters the chat ---");

        // Charlie Bids
        market.loginOrRegister("Charlie", "STANDARD");
        market.placeBid(laptop, 250.00);

        // Alice should receive a notification automatically!
        System.out.println("\n--- Alice fights back ---");
        market.loginOrRegister("Alice", "VIP");
        market.placeBid(laptop, 300.00);

    }
}