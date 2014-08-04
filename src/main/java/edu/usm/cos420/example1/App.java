package edu.usm.cos420.example1;

import edu.usm.cos420.example1.controller.CItemController;
import edu.usm.cos420.example1.view.TextUI;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int choice = TextUI.NO_CHOICE;
        while (choice != TextUI.EXIT) {
          TextUI.displayMenu();
          choice = TextUI.readIntWithPrompt("Enter choice: ");
          CItemController.executeChoice(choice);
        }
    }
}
