package patterns.structural;

import model.User;
import model.AuctionListing;
import patterns.creational.StandardListingBuilder;
import patterns.creational.UserFactory;
import services.AuctionDirectory;
import services.BankService;
import services.IBiddingService;

public class AuctionSystemFacade {

    private final AuctionDirectory auctionDirectory;
    private final BankService bankService;
    private final IBiddingService biddingService;

    private User currentUser;

    public AuctionSystemFacade() {
        this.auctionDirectory = new AuctionDirectory();
        this.bankService = new BankService();
        this.biddingService = new SecurityBiddingProxy(this.bankService);
    }

    public void loginOrRegister(String username, String type) {
        this.currentUser = UserFactory.createUser(type, username);
        System.out.println("--logged in as: " + currentUser.getUsername() + " (" + type + " ) | Balance: $" + currentUser.getBalance());
    }

    public void createAuction(String title, double price, String description) {
        if (currentUser == null) {
            System.out.println("Error: You must be logged in to create a listing");
            return;
        }

        boolean feePaid = currentUser.deductListingFee();

        if (!feePaid) {
            System.out.println("Transaction Aborted: Listing not created due to payment failure.");
            return;
        }

        AuctionListing newListing = new StandardListingBuilder(currentUser, title, price)
                .setDescription(description)
                .setDurationInHours(24)
                .build();

        auctionDirectory.addListing(newListing);
    }

    public void placeBid(AuctionListing listing, double amount) {
        if (currentUser == null) {
            System.out.println("Error: Must be logged in to bid.");
            return;
        }

        System.out.println("\n*** " + currentUser.getUsername() + " attempts to bid $" + amount + " ***");

        // The Facade calls the service, which is actually the Proxy
        biddingService.placeBid(currentUser, listing, amount);
    }

    public AuctionListing findFirstListing() {
        if (!auctionDirectory.getAllListings().isEmpty()) {
            return auctionDirectory.getAllListings().getFirst();
        }
        return null;
    }
}
