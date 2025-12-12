import model.AuctionListing;
import patterns.behavioral.command.CommandFactory;
import patterns.structural.AuctionSystemFacade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuctionSystemFacade facade = new AuctionSystemFacade();
        CommandFactory commandFactory = new CommandFactory(facade);
        Scanner scanner = new Scanner(System.in);

        facade.seedData();

        System.out.println("==========================================");
        System.out.println("      TERMINAL TRADER v1.0 - DASHBOARD    ");
        System.out.println("==========================================");

        System.out.println("Commands: ");
        System.out.println("  - login <name> <VIP/STANDARD>");
        System.out.println("  - create <price> <title>");
        System.out.println("  - bid <item> <amount>");
        System.out.println("  - status");
        System.out.println("  - exit");
        System.out.println("============================");

        boolean running = true;
        while (running) {
            System.out.print("\n> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("Markets closed!");
            } else if (input.equalsIgnoreCase("status")) {
                facade.showMarketStatus();
            } else {
                commandFactory.executeCommand(input);
            }
        }
        scanner.close();
    }
}