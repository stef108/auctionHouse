package patterns.behavioral.command;

import patterns.structural.AuctionSystemFacade;

public class SeedCommand implements Command {
    private final AuctionSystemFacade facade;

    public SeedCommand(AuctionSystemFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(String[] args) {
        facade.seedData();
    }
}
