package services;

import model.AuctionListing;
import model.User;

public class BiddingEngine implements IBiddingService {

    @Override
    public boolean placeBid(User bidder, AuctionListing listing, double amount) {
        // CHECK: Is the auction active?
        if (!listing.isOpen()) {
            System.out.println("ENGINE: Fail. Auction '" + listing.getTitle() + "' is closed.");
            return false;
        }

        //  CHECK: Is the bid high enough?
        if (amount <= listing.getCurrentPrice()) {
            System.out.println("ENGINE: Fail. Bid $" + amount + " is too low. Current price: $" + listing.getCurrentPrice());
            return false;
        }

        //  CHECK: Are you outbidding yourself? (Optional realism)
        if (bidder.equals(listing.getHighBidder())) {
            System.out.println("ENGINE: Fail. You are already the highest bidder!");
            return false;
        }


        User previousBidder = listing.getHighBidder();

        listing.updateToNewBid(bidder, amount);

        System.out.println("ENGINE: Success! " + bidder.getUsername() + " is now winning '" +
                listing.getTitle() + "' at $" + amount);

        return true;
    }
}
