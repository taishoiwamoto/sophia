import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

class EnterFileName {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter existing file name: ");
    String fileName = input.nextLine();
    File inputFile = new File(fileName);
    // Warn if file doesn't exist
    if(! Files.exists(inputFile.toPath())) {
      System.out.println("The file " + fileName + " does not exist.");
    }
    // Then warn if user doesn't have read permission 
    else if(! Files.isReadable(inputFile.toPath())) {
      System.out.println("User doesn't have read permission on " + fileName + ".");
    }
    // If file exists and can be read by user, try to read it.
    // Other I/O errors may be possible, sot try/catch needed, but such
    // errors are much less likely. 
    else {
      try { 
        List<String> lines = Files.readAllLines(inputFile.toPath());
        System.out.println(inputFile.getName() + " contains " + lines.size() + " lines.");
      }
      catch(IOException ex) {
        System.out.println("File error: " + ex.getMessage());
      }
    }
  }
}
