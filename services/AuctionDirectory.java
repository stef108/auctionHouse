package services;
import model.AuctionListing;
import java.util.ArrayList;
import java.util.List;

public class AuctionDirectory {
  private List<AuctionListing> listings = new ArrayList<>();

  public void addListing(AuctionListing listing) {
    listings.add(listing);
    System.out.println("Directory: Listing '" + listing.getTitle() + "' added to global database.");
  }

  public List<AuctionListing> getAllListings() { return listings; }
}
