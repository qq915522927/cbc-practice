import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    /** Main entry point. */
    public static void main(String args[]) throws ParseException {
        File file = new File(args[0]);
        try {
            FileInputStream stream = new FileInputStream(file);
            Parser parser = new Parser(stream);
            parser.compliation_unit();
        } catch (FileNotFoundException e) {
            System.out.println("Error:");
            e.printStackTrace();;
        }
    }
}
