package patterns.behavioral.command;

import patterns.structural.AuctionSystemFacade;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandFactory(AuctionSystemFacade facade) {
        // Register available commands
        commands.put("login", new LoginCommand(facade));
        commands.put("create", new CreateListingCommand(facade));
        commands.put("bid", new BidCommand(facade));

        commands.put("close", new CloseCommand(facade));
        commands.put("seed", new SeedCommand(facade));
    }

    public void executeCommand(String input) {
        String[] parts = input.trim().split("\\s+"); // Split by spaces
        if (parts.length == 0) return;

        String commandName = parts[0].toLowerCase();
        Command command = commands.get(commandName);

        if (command != null) {
            command.execute(parts);
        } else {
            System.out.println("Unknown command: " + commandName);
        }
    }
}
