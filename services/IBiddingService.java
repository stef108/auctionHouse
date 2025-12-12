package services;

import model.AuctionListing;
import model.User;

public interface IBiddingService {
    boolean placeBid(User bidder, AuctionListing listing, double amount);
}
