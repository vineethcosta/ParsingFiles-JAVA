package card;

public class AmExCC extends CreditCard implements ICreditCard {
    AmExCC(String cardNumber, String expirationDate, String nameOfCard)
    {
        super(cardNumber, expirationDate, nameOfCard, "AmericanExpress");
    }
}
