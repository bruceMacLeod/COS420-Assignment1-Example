package edu.usm.cos420.example1.controller;

import edu.usm.cos420.example1.view.TextUI;

public class CItemController {
	
	public static void executeChoice (int choice) {
	    System.out.println();
	    if (choice == TextUI.LENGTH)
	      System.out.println("Length is ");
	    else if (choice == TextUI.WIDTH)
	      System.out.println("Width is ");
	    else if (choice == TextUI.AREA)
	      System.out.println("Area is ");
	    else if (choice == TextUI.PERIMETER)
	      System.out.println("Perimeter is ");
	    else if (choice == TextUI.EXIT)
	      System.out.println("Goodbye.");
	  }
	  
}
