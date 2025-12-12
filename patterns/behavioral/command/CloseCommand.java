package patterns.behavioral.command;

import patterns.structural.AuctionSystemFacade;

public class CloseCommand implements Command {
    private final AuctionSystemFacade facade;

    public CloseCommand(AuctionSystemFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: close <ItemName>");
            return;
        }
        facade.closeAuction(args[1]);
    }
}
