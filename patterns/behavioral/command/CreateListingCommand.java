package patterns.behavioral.command;

import patterns.structural.AuctionSystemFacade;

public class CreateListingCommand implements Command {
    private final AuctionSystemFacade facade;

    public CreateListingCommand(AuctionSystemFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(String[] args) {
        // Expected syntax: create <price> <title...>
        if (args.length < 3) {
            System.out.println("Usage: create <startPrice> <Title...>");
            return;
        }
        try {
            double price = Double.parseDouble(args[1]);

            // Recombine the rest of the arguments into the title
            String title = "";
            for(int i = 2; i < args.length; i++) {
                title += args[i] + " ";
            }

            facade.createAuction(title.trim(), price, "Created via Console");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid price format.");
        }
    }
}
