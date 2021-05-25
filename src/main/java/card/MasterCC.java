package card;

public class MasterCC extends CreditCard implements ICreditCard {
    MasterCC(String cardNumber, String expirationDate, String nameOfCard)
    {
        super(cardNumber, expirationDate, nameOfCard, "Master");
    }
}
