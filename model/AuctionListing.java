package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import patterns.behavioral.Observer;
import patterns.creational.StandardListingBuilder;

public class AuctionListing {
    
    private final String title;
    private final double startingPrice; 
    private final User seller;

    private final String description;
    private final double reservePrice;
    private final LocalDateTime endTime;
    private double currentHighBid;
    private User currentHighBidder;
    private boolean isOpen;

    private List<Observer> observers = new ArrayList<>();

    public AuctionListing(StandardListingBuilder builder) {
        this.title = builder.getTitle();
        this.startingPrice = builder.getStartingPrice();
        this.seller = builder.getSeller();
        this.description = builder.getDescription();
        this.reservePrice = builder.getReservePrice();
        this.endTime = builder.getEndTime();
        this.currentHighBid = this.startingPrice;
        this.currentHighBidder = null;
        this.isOpen = true;
    }

    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
             o.update("You are now watching: " + this.title);
        }
    }

    private void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void updateToNewBid(User bidder, double amount) {
        String msg = String.format("New bid on '%s': $%.2f by %s",
                title, amount, bidder.getUsername());

        notifyObservers(msg);

        registerObserver(bidder);

        this.currentHighBid = amount;
        this.currentHighBidder = bidder;
    }

    // Getters for the engine
    public double getCurrentPrice() { return currentHighBid; }
    public User getHighBidder() { return currentHighBidder; }
    public boolean isOpen() {
        return isOpen && LocalDateTime.now().isBefore(endTime);
    }

    // Standard Getters
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