package patterns.creational;

import java.time.LocalDateTime;
import model.AuctionListing;
import model.User;

public class StandardListingBuilder implements IListingBuilder {

    // Holding state of the object being build
    private String title;
    private double startingPrice;
    private User seller;
    private String description = "";
    private double reservePrice = 0.0;
    private LocalDateTime endTime = LocalDateTime.now().plusDays(7);

    public StandardListingBuilder(User seller, String title, double startingPrice) {
        this.seller = seller;
        this.title = title;
        this.startingPrice = startingPrice;
    }

    @Override
    public IListingBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    
    @Override
    public IListingBuilder setReservePrice(double reservePrice) {
        this.reservePrice = reservePrice;
        return this;
    }
    
    @Override
    public IListingBuilder setDurationInHours(int hours) {
        this.endTime = LocalDateTime.now().plusHours(hours);
        return this;
    }

    @Override
    public AuctionListing build() {
        if (reservePrice > 0 && reservePrice <= startingPrice) {
            throw new IllegalStateException("Reserve price must be higher than starting price.");
        }

        return new AuctionListing(this);
    }

    public String getTitle() { return title; }
    public double getStartingPrice() { return startingPrice; }
    public User getSeller() { return seller; }
    public String getDescription() { return description; }
    public double getReservePrice() { return reservePrice; }
    public LocalDateTime getEndTime() { return endTime; }
    
}
    