Programming the Initial Check for Drink Types

import java.util.Scanner;

public class DrinkOrder {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("What type of drink would you like to order?");
    // Note use of new line \n to print 3 lines with 1 statement.
    System.out.println("1. Water\n2. Coffee\n3. Tea");
    System.out.print("Drink selection #: ");
    // String variable to hold drink details
    String drinkDetails = "No drink chosen.";
    int choice = input.nextInt();
    // Remove \n left in input to avoid problems with later inputs
    input.nextLine();
    if(choice == 1) {
      drinkDetails = "Water";
    }
    else if(choice == 2) {
      drinkDetails = "Coffee";
    }
    else if(choice == 3) {
      drinkDetails = "Tea";
    }
    else {
      System.out.println("Sorry, not a valid drink selection.");
    }
    // Print out final drink selection
    System.out.println("Your drink selection: " + drinkDetails + ".");
  }
}