package JUnitTest;

import card.*;
import card.ICreditCard;
import org.junit.*;

public class TestJUnit {
    public TestJUnit(){

    }
    @Test
    public void testVisaCreditCard()
    {
        //First get Type of card
        ICreditCard visaCard = CreditCardHandleGet.getCardType("4700000000000001", "", "");
        //THen get card Details like type of card and compare if it is equal to Visa Card
        Assert.assertTrue(visaCard.getCardType().equals("Visa"));
    }
    @Test
    public void testDiscoverCreditCard()
    {
        //First get Type of card
        ICreditCard discoverCard = CreditCardHandleGet.getCardType("6011000000000000", "", "");
        //THen get card Details like type of card and compare if it is equal to Discover Card
        Assert.assertTrue(discoverCard.getCardType().equals("Discover"));
    }
    @Test
    public void testMasterCreditCard()
    {
        //First get Type of card
        ICreditCard masterCard = CreditCardHandleGet.getCardType("5300000000000000", "", "");
        //THen get card Details like type of card and compare if it is equal to Master Card
        Assert.assertTrue(masterCard.getCardType().equals("Master"));
    }
    @Test
    public void testAmericanExpressCreditCard()
    {
        //First get Type of card
        ICreditCard amexCard = CreditCardHandleGet.getCardType("370000000000000", "", "");
        //THen get card Details like type of card and compare if it is equal to American Express Card
        Assert.assertTrue(amexCard.getCardType().equals("AmericanExpress"));
    }

    @Test
    public void testCardError()
    {
        //First get Type of card if number of digits greater than 19
        ICreditCard card = CreditCardHandleGet.getCardType("3700000000000000000000000", "", "");
        //THen get card Details like type of card and compare if it is equal to American Express Card
        Assert.assertTrue(card.getCardType().equals("Error"));
    }

    @Test
    public void testCardUndefined()
    {
        //First get Type of card when number of digits equal less than 19 but credit card type is not defined
        ICreditCard card = CreditCardHandleGet.getCardType("3700000", "", "");
        //THen get card Details like type of card and compare if it is equal to American Express Card
        Assert.assertTrue(card.getCardType().equals("Undefined"));
    }


}
