package parsingFile;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import card.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class jsonParser extends fileDescription implements parser {
    public jsonParser(String sourceFile, String destinationFile, String extensionType) {
        super(sourceFile, destinationFile, extensionType);
    }

    @Override
    public List<ICreditCard> fileParser(String fileName) {
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(Paths.get(fileName));
            JsonArray jsonParser = (JsonArray) Jsoner.deserialize(br);
            List<ICreditCard> creditCards = new ArrayList<>();

            jsonParser.forEach(creditCard -> {
                JsonObject cardJsonObject = (JsonObject) creditCard;
                String expirationDate = (String) cardJsonObject.get("ExpirationDate") ;
                String nameOfCardHolder = (String) cardJsonObject.get("NameOfCardholder") ;
                String cardNumber = ((BigDecimal) cardJsonObject.get("CardNumber")).toString() ;

                creditCards.add(CreditCardHandleGet.getCardType(cardNumber,expirationDate,nameOfCardHolder));
            });
            br.close();
            this.setAllCards(creditCards);
            return creditCards;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void fileWriter(String fileName) {
        List<ICreditCard> cards = this.getAllCreditCards();
        BufferedWriter reader = null;
        try {
            reader = Files.newBufferedWriter(Paths.get(fileName));
            JsonArray cardsOutput = new JsonArray();
            for (ICreditCard card : cards) {
                JsonObject finalCard = new JsonObject();
                finalCard.put("CardNumber", card.getCardNumber());
                finalCard.put("Type", card.getCardType());
                cardsOutput.add(finalCard);
            }
            Jsoner.serialize(cardsOutput, reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
