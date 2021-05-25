package card;

public class VisaCC extends CreditCard implements ICreditCard {
    VisaCC(String cardNumber, String expirationDate, String nameOfCard)
    {
        super(cardNumber, expirationDate, nameOfCard, "Visa");
    }
}
