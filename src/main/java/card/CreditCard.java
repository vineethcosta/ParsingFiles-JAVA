package card;

public class CreditCard implements ICreditCard {
    private String typeOfCard;
    private String expirationDate;
    private String nameOfCard;
    private String creditCardNumber;

    CreditCard(String creditCardNumber, String expirationDate, String nameOfCard, String typeOfCard)
    {
        this.nameOfCard = nameOfCard;
        this.typeOfCard = typeOfCard;
        this.expirationDate = expirationDate;
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardNumber(){
        return this.creditCardNumber;
    }

    public String getCardType(){
        return this.typeOfCard;
    }
}
