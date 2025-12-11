package patterns.creational;

import model.AuctionListing;

public interface IListingBuilder {
    IListingBuilder setDescription(String description);
    IListingBuilder setReservePrice(double reservePrice);
    IListingBuilder setDurationInHours(int hours);

    AuctionListing build();
}
