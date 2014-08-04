package edu.usm.cos420.example1.view;

import java.util.Scanner;

public class TextUI {
 
  // User menu choices:
  public static final int NO_CHOICE = 0;
  public static final int LENGTH = 1;
  public static final int WIDTH = 2;
  public static final int AREA = 3;
  public static final int PERIMETER = 4;
  public static final int NEW = 5;
  public static final int EXIT = 6;
  
  private static Scanner in = new Scanner(System.in); 
  
  /**
   * Run the user interface.
   */
  public void start () {
  }

 
  /**
   * Display top level menu.
   */
  public static void displayMenu () {
    System.out.println();
    System.out.println("Enter the number denoting the action " +
                       "to perform:");
    System.out.println( "Display length.............." + LENGTH);
    System.out.println("Display width..............." + WIDTH);
    System.out.println("Display area................" + AREA);
    System.out.println("Display perimeter..........." + PERIMETER);
    System.out.println("Create new rectangle........" + NEW);
    System.out.println("Exit........................" + EXIT);
  }

  /**
   * Execute user's menu choice.
   */
  private void executeChoice (int choice) {
    System.out.println();
    if (choice == LENGTH)
      System.out.println("Length is ");
    else if (choice == WIDTH)
      System.out.println("Width is ");
    else if (choice == AREA)
      System.out.println("Area is ");
    else if (choice == PERIMETER)
      System.out.println("Perimeter is ");
    else if (choice == EXIT)
      System.out.println("Goodbye.");
  }
  
  /**
   * Read an int from system in with the speciifed prompt.
   */
  public static int readIntWithPrompt (String prompt) {
    System.out.print(prompt); System.out.flush();
    int choice = in.nextInt();
//    in.readLine();
    return choice;
  }
  
}
