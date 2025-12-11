package model;

import java.time.LocalDateTime;
import patterns.creational.StandardListingBuilder;

public class AuctionListing {
    
    private final String title;
    private final double startingPrice; 
    private final User seller;

    private final String description;
    private final double reservePrice;
    private final LocalDateTime endTime;

    public AuctionListing(StandardListingBuilder builder) {
        this.title = builder.getTitle();
        this.startingPrice = builder.getStartingPrice();
        this.seller = builder.getSeller();
        this.description = builder.getDescription();
        this.reservePrice = builder.getReservePrice();
        this.endTime = builder.getEndTime();
    }

    public String getTitle() { return title; }
    public double getStartingPrice() { return startingPrice; }
    public double getReservePrice() { return reservePrice; }
    public User getSeller() { return seller; }

    @Override
    public String toString() {
        return "Listing: " + title + " by [" + seller.getUsername() + "] Starts at: $" + startingPrice +
               (reservePrice > 0 ? " (Reserve: $" + reservePrice + ")" : "");
    }
}  