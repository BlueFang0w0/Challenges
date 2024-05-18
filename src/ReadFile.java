import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {
    public static void processFile(){
        // Task consists of three parts.
        // 1. File location.
        // 2. Test for file.
        // 3. Read the file and output its contents.

        File textFile = new File("src/files/Sample Text.txt"); // File location.

        if(textFile.exists()){ //Testing for file.
            System.out.println("File Located.");
        }else{
            System.out.println("Absolute Path: " + textFile.getAbsolutePath());
            System.out.println("Parent Directory: " + textFile.getParent());
        }

        try{
            String line;
            Scanner stdin = new Scanner(textFile);
            while(stdin.hasNextLine()){ // Output the file contents.
                line = stdin.nextLine();
                System.out.println(line);
            }
        }
        catch (
                FileNotFoundException a){
        }
    }

}
