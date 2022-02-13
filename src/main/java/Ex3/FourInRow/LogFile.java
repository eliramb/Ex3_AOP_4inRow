package Ex3.FourInRow;

import java.io.File;  // Import the File class
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.StandardOpenOption;

public class LogFile {
    String FullPath = "c:\\logFile.txt";
    public void CreateLogFile(String fullPath) {
       try {
           FullPath = fullPath;
           File myObj = new File(fullPath);
           if (myObj.createNewFile()) {
               //System.out.println("Log File created: " + myObj.getName());
           } else {
              // System.out.println("File already exists.");
           }
       }
       catch (Exception e) {

       }
    }

    public  void writeToFile(String text) throws IOException {
        Path fileName = Path.of(FullPath);
        Files.writeString(fileName, text+System.lineSeparator(), StandardOpenOption.APPEND);
    }

}