import parsingFile.*;
public class TestApp { public  static void main(String [] args)
    {
        try {
            String source = args[0];
            String destination = args[1];
            String extension = source.substring(source.lastIndexOf(".") + 1).trim();

            System.out.println(source);
            parser fileParser = null;
            if (extension.equals("csv")) {
                fileParser = new csvParser(source, destination, extension);
            } else if (extension.equals("json")) {
                fileParser = new jsonParser(source, destination, extension);
            } else if (extension.equals("xml")) {
                fileParser = new xmlParser(source, destination, extension);
            } else {
                System.out.println("Unknown Format");
            }
            fileParser.fileParser(source);
            fileParser.fileWriter(destination);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
