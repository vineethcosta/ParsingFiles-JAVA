package parsingFile;

import card.*;
import org.apache.commons.io.FilenameUtils;

import java.util.List;

public class fileDescription {
    private String sourceFileName ;
    private String destinationFileName ;
    private String fileExtension ;
    private List<ICreditCard> allCreditCards;

    public fileDescription(String sourceFile, String destinationFile , String extension) {
        this.sourceFileName = sourceFile ;
        this.destinationFileName = destinationFile ;
        this.fileExtension = extension ;
    }

    public List<ICreditCard> getAllCreditCards() {
        return allCreditCards;
    }

    public void setAllCards(List<ICreditCard> allCreditCards) {
        this.allCreditCards = allCreditCards;
    }

    public void findExtensionType(){
        this.fileExtension = FilenameUtils.getExtension(this.sourceFileName);
    }
    public String getExtensionType() {
        return fileExtension;
    }

    public void setExtensionType(String extension) {
        this.fileExtension = extension;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }


    public String getDestinationFileName() {
        return destinationFileName;
    }

    public void setDestinationFileName(String destinationFileName) {
        this.destinationFileName = destinationFileName;
    }

}
