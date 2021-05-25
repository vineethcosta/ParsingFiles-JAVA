package card;

public class DiscoverCC  extends CreditCard implements ICreditCard {
    DiscoverCC(String cardNumber, String expirationDate, String nameOfCard)
    {
        super(cardNumber, expirationDate, nameOfCard, "Discover");
    }
}