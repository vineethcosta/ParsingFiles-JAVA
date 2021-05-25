package parsingFile;

import card.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class csvParser extends fileDescription implements parser {
    public csvParser(String sourceFile, String destinationFile, String extension) {
        super(sourceFile, destinationFile, extension);
    }

    @Override
    public List<ICreditCard> fileParser(String nameOfFile) {
        String singleLine = "";

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nameOfFile));
            List<ICreditCard> creditCardsList = new ArrayList<>();

            while ((singleLine = br.readLine()) != null) {
                System.out.println(singleLine);
                String[] cardDescription = singleLine.split(",");
                if(cardDescription.length > 0)
                    creditCardsList.add(CreditCardHandleGet.getCardType(cardDescription[0],cardDescription[1],cardDescription[2]));
            }
            super.setAllCards(creditCardsList);
            System.out.println(creditCardsList);
            return creditCardsList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
    public void fileWriter(String sourceFile) {
        List<ICreditCard> cards = this.getAllCreditCards();
        cards.remove(0);
        try {
            FileWriter csvWriter = new FileWriter(this.getDestinationFileName());
            csvWriter.append("CardNumber");
            csvWriter.append(",");
            csvWriter.append("Type");
            csvWriter.append("\n");
            for (ICreditCard card : cards) {
                String sb = card.getCardNumber() + "," + card.getCardType() ;
                csvWriter.append(sb);
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
