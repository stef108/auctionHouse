package patterns.behavioral.command;

import patterns.structural.AuctionSystemFacade;

public class LoginCommand implements Command {
    private final AuctionSystemFacade facade;

    public LoginCommand(AuctionSystemFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute(String[] args) {
        // Expected syntax: login <username> <type>
        if (args.length < 3) {
            System.out.println("Usage: login <username> <VIP/STANDARD>");
            return;
        }
        String username = args[1];
        String type = args[2];
        facade.loginOrRegister(username, type);
    }
}
