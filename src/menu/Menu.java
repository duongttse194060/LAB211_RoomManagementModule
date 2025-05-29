package menu;

import collection.GuestList;
import java.util.Scanner;
import tool.Tester;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Menu {

    public static void function() {
        System.out.println("\n====================== ROOM MANAGEMENT MENU ======================");
        System.out.println("1. Import Room Data from Text File");
        System.out.println("2. Display Available Room List");
        System.out.println("3. Enter Guest Information");
        System.out.println("4. Update Guest Stay Information");
        System.out.println("5. Search Guest by National ID");
        System.out.println("6. Delete Guest Reservation Before Arrival");
        System.out.println("7. List Vacant Rooms");
        System.out.println("8. Monthly Revenue Report");
        System.out.println("9. Revenue Report by Room Type");
        System.out.println("10. Save Guest Information");
        System.out.println("11. Menu Other Utilities");
        System.out.println("Other - Quit");
        System.out.println("====================================================================");
    }

    public static void utilityMenu() {
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.println("\n====================== UTILITY MANAGEMENT MENU ===================");
            System.out.println("A. Import Sample Guest List 1.");
            System.out.println("B. Import Sample Guest List 2.");
            System.out.println("C. Display All Guests Information.");
            System.out.println("D. Display Data From File.");
            System.out.println("====================================================================");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("a")) {
                Tester.addSampleGuests1();
                break;
            } else if (choice.equalsIgnoreCase("b")) {
                Tester.addSampleGuests2();
                break;
            } else if (choice.equalsIgnoreCase("c")) {
                Displayer.displayGuestListTable();
                break;
            } else if (choice.equalsIgnoreCase("d")) {
                GuestList.readFromFile();
                if (GuestList.guestList == null || GuestList.guestList.isEmpty()) {
                    System.out.println("File guestInfo.dat currently have no data. Please try again");
                } else {
                    System.out.println("Display Guest List Information...");
                    Displayer.displayGuestListTable();
                }
                break;
            } else {
                System.out.println("Invalid input. Please try again. ");
            }
        }
    }

}
