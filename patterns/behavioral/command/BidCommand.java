package patterns.behavioral.command;

import model.AuctionListing;
import patterns.structural.AuctionSystemFacade;

public class BidCommand implements Command {
    private final AuctionSystemFacade facade;

    public BidCommand(AuctionSystemFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(String[] args) {
        // Expected syntax: bid <ItemName> <amount>
        if (args.length < 3) {
            System.out.println("Usage: bid <ItemName> <amount>");
            return;
        }

        String itemName = args[1];
        String amountStr = args[2];

        AuctionListing listing = facade.findListing(itemName);
        if (listing == null) {
            System.out.println("Error: Item '" + itemName + "' not found.");
            return;
        }


        try {
            double amount = Double.parseDouble(amountStr);
            facade.placeBid(listing, amount);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid bid amount.");
        }
    }
}
