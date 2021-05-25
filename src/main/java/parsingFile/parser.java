package parsingFile;
import card.*;

import java.util.List;

public interface parser {
    public void fileWriter(String sourceFile);
    public List<ICreditCard> fileParser(String sourceFile);
}
