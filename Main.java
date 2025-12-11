import model.AuctionListing;
import model.User;
import patterns.creational.StandardListingBuilder;
import patterns.creational.UserFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Creational Pattern Test ---");

        //  Test Factory Method
        User bob = UserFactory.createUser("Standard", "BobTheBuilder", 100.00);
        User alice = UserFactory.createUser("VIP", "AliceWonder", 5000.00);

        //  Test Builder Pattern
        // Bob wants to sell an old laptop with a reserve price
        AuctionListing bobsLaptop = new StandardListingBuilder(bob, "Retro Thinkpad T420", 150.00)
                .setDescription("Classic keyboard, decent condition.")
                .setReservePrice(250.00)
                .setDurationInHours(48)
                .build();

        // Alice just wants a quick sale, minimum options
        AuctionListing alicesWatch = new StandardListingBuilder(alice, "Gold Watch", 1200.00)
                .build();

        System.out.println(bobsLaptop);
        System.out.println(alicesWatch);

        System.out.println("--- Test Complete ---");
    }
}