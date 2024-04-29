import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

/**
 * This program enables users to track and record their study time.
 * Users can view their total study time, record a new study time, or exit the program.
 * The times are saved in an external file.
 */

class StudyTimeRecordingProgram {
  // Path to the CSV file where study times are recorded.
  static String timeFile = "timeFile.csv";

  /**
   * Main method that handles the user interface and user input. 
   * The loop continues until a user decides to exit. 
   * User input is processed to trigger different functionalities: 
   * displaying total time, recording time, or exiting.
   */
  public static void main(String[] args) {
    // Enable user input.
    Scanner input = new Scanner(System.in);
    String answer;

    // The main menu continues until the user exits the program.
    // Execute appropriate action based on user choice.
    while (true) {
      // Display the main menu.
      System.out.println("Main menu:");
      System.out.println("1. Show total study time");
      System.out.println("2. Record study time");
      System.out.println("3. Exit");
      System.out.print("Please enter a number: ");
      // Read the user input and assign it to the variable answer.
      answer = input.nextLine();

      
      if(answer.equals("1")){
        show();
      }
      else if(answer.equals("2")){
        System.out.print("Enter the study time (in minutes): ");
        String timeInput = input.nextLine();
        // Validate input and display an error message if necessary.
        try {
          // Assign timeInput to a variable time and convert the value to integer 
          int time = Integer.parseInt(timeInput);
          // Record the time if it is greater than 0.
          if (time > 0) {
            record(time);
          } else {
            System.out.println("Invalid value. Please enter a number bigger than 0.");
          }
        } catch (NumberFormatException ex) {
          System.out.println("Invalid value. Please enter a valid number.");
        }
      }
      else if(answer.equals("3")){
        // Exit the loop and finish the program.
        break;
      }
      else{
        System.out.println("Invalid option. Please try again.");
      }
    }
    // Close the input.
    input.close();
  }

  /**
   * Displays the total accumulated study time by reading from a file. 
   * If the file does not exist or is unreadable, appropriate error messages are displayed.
   */
  public static void show() {
    Path pathToFile = Paths.get(timeFile);
    // Check if the log file exists.
    if (!Files.exists(pathToFile)) {
      System.out.println("No time file found.");
      return;
    }
    int totalTime = 0;
    try {
      // Read each line of the log file and add each study time to the total study time.
      List<String> lines = Files.readAllLines(pathToFile);
      for (String line : lines) {
        totalTime += Integer.parseInt(line);
      }
    } catch (IOException ex) {
      System.out.println("I/O error: " + ex.getMessage());
    } catch (NumberFormatException ex) {
      System.out.println("Number Format Error: " + ex.getMessage());
    }
    // Display the total study time.
    System.out.println("Your total study time is " + totalTime + " minute(s).");
  }

  /**
   * Records a given amount of study time to the file.
   * Handles file writing and ensures that the data is appended if the file already exists.
   */
  public static void record(int time) {
    Path pathToFile = Paths.get(timeFile);
    try {
      // Write the time to the file, creating or appending as necessary.
      Files.write(pathToFile, (time + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (IOException ex) {
      System.out.println("Error writing to file: " + ex.getMessage());
    }
  }
}
