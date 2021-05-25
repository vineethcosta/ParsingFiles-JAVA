package card;

public class CreditCardHandleGet {
    public static ICreditCard getCardType(String cardNumber, String expirationDate, String nameOfCard)
    {
        for(int i =0; i< cardNumber.length();i++ )
        {
            if(!Character.isDigit(cardNumber.charAt(i)))
            {
                return new CreditCard(cardNumber, expirationDate, nameOfCard, "Error");
            }
        }
        if(cardNumber.length()>19)
        {
            return new CreditCard(cardNumber, expirationDate, nameOfCard, "Error");
        }
        else if(cardNumber.charAt(0) == '5' && (cardNumber.charAt(1)>='1' && cardNumber.charAt(1)<='5') && cardNumber.length()==16)
        {
            return new MasterCC(cardNumber, expirationDate, nameOfCard);
        }
        else if(cardNumber.charAt(0) == '4' && (cardNumber.length()==13 ||cardNumber.length()==16))
        {
            return new VisaCC(cardNumber, expirationDate, nameOfCard);
        }
        else if(cardNumber.charAt(0) == '3' && (cardNumber.charAt(1)=='4' || cardNumber.charAt(1)=='7' )&& cardNumber.length()==15)
        {
            return new AmExCC(cardNumber, expirationDate, nameOfCard);
        }
        else if(cardNumber.startsWith("6011") && cardNumber.length()==16)
        {
            return new DiscoverCC(cardNumber, expirationDate, nameOfCard);
        }
        return new CreditCard(cardNumber, expirationDate, nameOfCard, "Undefined");
    }
}
