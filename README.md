Here is the "Chain of Command" for a single action, like typing bid 500. Notice how it triggers every single pattern:

User Input: User types bid 500.

Command Pattern: CommandFactory finds BidCommand.

Facade Pattern: BidCommand calls facade.placeBid().

Proxy Pattern: Facade calls proxy.placeBid().

Bank Service: Proxy checks funds (using User logic).

Real Engine: If valid, Proxy calls engine.placeBid().

State Change: Engine updates AuctionListing.

Observer Pattern: AuctionListing notifies all other Users.