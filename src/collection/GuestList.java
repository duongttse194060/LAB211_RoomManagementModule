/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.util.ArrayList;
import java.util.Scanner;
import menu.Displayer;
import model.Guest;
import tool.Inputter;

/**
 *
 * @author ADMIN
 */
public class GuestList {

    public static ArrayList<Guest> guestList = new ArrayList<>();

    public static void addGuest() {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            String guestId = Inputter.inputGuestId(guestList);
            String fullName = Inputter.inputGuestName();
            String birthDate = Inputter.inputBirthDate();
            String gender = Inputter.inputGender();
            String phoneNumber = Inputter.inputPhoneNumber();
            String guestRoomId = Inputter.inputDestinatedRoomId();
            int rentalDateNumber = Inputter.inputRentalDate();
            String startDate = Inputter.inputStartDate();
            String roommateName = Inputter.inputNameRoomate();

            guestList.add(new Guest(guestId, fullName, birthDate, gender, phoneNumber, guestRoomId, rentalDateNumber, startDate, roommateName));
            System.out.println("Guest registered successfully for room " + guestRoomId + ".");
            System.out.println("Rental from " + startDate + " for " + rentalDateNumber + " days.");

            while (true) {
                System.out.println("Do you want to register another guest? (Y/N)");
                choice = sc.nextLine().trim();
                if (choice.equalsIgnoreCase("n")) {
                    return;
                } else if (choice.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("Your choice is invalid. Please try again. ");
                }
            }
        } while (true);
    }

    public static void updateGuest() {
        Guest foundGuest = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Guest National Id to upgrade: ");
            String id = sc.nextLine();
            foundGuest = searchById(id);
            if (foundGuest == null) {
                System.out.println("This guest does not exist! Please try again: ");
            } else {
                System.out.println("Guest have been found!");
                Displayer.displayGuestInformation(id);
                System.out.println("Enter new information to update or press ENTER to skip: ");
                break;
            }
        }
    }

    public static Guest searchById(String id) {
        for (Guest g : guestList) {
            if (id.equals(g.getGuestId())) {
                return g;
            }
        }
        return null;
    }

}
