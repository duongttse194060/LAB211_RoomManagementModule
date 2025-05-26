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
import tool.Acceptable;

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
                System.out.println("No guest found with the requested ID!");
            } else {
                System.out.println("Guest have been found!");
                System.out.println("Guest information updated for ID: " + id);
                Displayer.showGuestInfo(id);
                System.out.println("Enter new information to update or press ENTER to skip: ");
                break;
            }
        }

        // Update name
        while (true) {
            System.out.println("Enter new name: ");
            String newName = sc.nextLine();
            if (newName.isEmpty()) {
                System.out.println("Keeping old name...");
                break;
            } else if (Inputter.isValid(newName, Acceptable.FULLNAME_VALID)) {
                foundGuest.setGuestName(newName);
                break;
            } else {
                System.out.println("Invalid name format. Please try again. ");
            }
        }

        // Update birthdate
        while (true) {
            System.out.println("Enter new birthdate (dd/MM/yyyy): ");
            String newBirthDate = sc.nextLine();
            if (newBirthDate.isEmpty()) {
                System.out.println("Keeping old birthdate...");
                break;
            } else if (Inputter.isValidBirthDate(newBirthDate)) {
                foundGuest.setGuestBirthdate(newBirthDate);
                break;
            } else {
                System.out.println("Invalid date format. Please try again. ");
            }
        }

        // Update gender
        while (true) {
            System.out.println("Enter new gender (M/F)");
            String newGender = sc.nextLine();

            if (newGender.isEmpty()) {
                System.out.println("Keeping old guest gender...");
                break;
            } else if (newGender.equalsIgnoreCase("m")) {
                newGender = "Male";
                foundGuest.setGuestGender(newGender);
                System.out.println("Guest gender update to Male.");
                break;
            } else if (newGender.equalsIgnoreCase("f")) {
                newGender = "Female";
                foundGuest.setGuestGender(newGender);
                System.out.println("Guest gender update to Female.");
                break;
            } else {
                System.out.println("Invalid gender. Please try again. ");
            }
        }

        // Update phone number
        while (true) {
            System.out.println("Enter new phone number: ");
            String newPhoneNum = sc.nextLine();

            if (newPhoneNum.isEmpty()) {
                System.out.println("Keeping old phone number: ");
                break;
            } else if (Inputter.isValid(newPhoneNum, Acceptable.PHONENUMBER_VALID)) {
                foundGuest.setGuestPhoneNumber(newPhoneNum);
                break;
            } else {
                System.out.println("Invalid phone number format. Please try again. ");
            }
        }

        // Update desired room id
        while (true) {
            System.out.println("Enter new desired Room ID: ");
            String newRoomId = sc.nextLine();

            if (newRoomId.isEmpty()) {
                System.out.println("Keeping old guest Room ID...");
                break;
            } else if (!RoomList.isExistRoomId(newRoomId)) {
                System.out.println("Room ID does not exist. Please try again. ");
                continue;
            } else if (Inputter.isValid(newRoomId, Acceptable.ROOM_ID_VALID)) {
                foundGuest.setGuestRoomId(newRoomId);
                break;
            } else {
                System.out.println("Invalid Room ID format. Please try again. ");
            }
        }

        // Update number of rental days
        while (true) {
            System.out.println("Enter new number of rental days: ");
            String input = sc.nextLine();

            if (input.isEmpty()) {
                System.out.println("Keeping old number of rental days...");
                break;
            }
            try {
                int newRentDate = Integer.parseInt(input);
                if (newRentDate > 0) {
                    foundGuest.setRentalDate(newRentDate);
                    break;
                } else {
                    System.out.println("Invalid input. Number of rental days should be a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Number of rental days must be an integer number.");
            }
        }

        // Update start date
        while (true) {
            System.out.println("Enter new guest start date (dd/MM/yyyy):");
            String newStartDate = sc.nextLine();

            if (newStartDate.isEmpty()) {
                System.out.println("Keeping old guest start date...");
                break;
            } else if (Inputter.isValidStartDate(newStartDate)) {
                foundGuest.setStartDate(newStartDate);
                break;
            } else {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        // Update co-teant name
        while (true) {
            String foundRoomate = foundGuest.getGuestRoomateName();
            if (foundRoomate == null || foundRoomate.isEmpty()) {
                System.out.println("This guest currently have no co-teant.");
                System.out.println("Do you wish to add a co-teant? (Y/N)");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println("No co-teant added...");
                    return;
                } else if (choice.equalsIgnoreCase("y")) {
                    System.out.println("Add a new co-teant. Enter new co-teant name: ");
                    String inputRoomateName = Inputter.inputNameRoomate();
                    foundGuest.setGuestRoomateName(inputRoomateName);
                    System.out.println("Add new roomate successfully.");
                    break;
                }
            } else {
                System.out.println("Enter new co-teant name or press ENTER to skip:");
                String newRoommateName = sc.nextLine();

                if (newRoommateName.isEmpty()) {
                    System.out.println("Keeping old co-teant name...");
                    break;
                } else if (Inputter.isValid(newRoommateName, Acceptable.FULLNAME_VALID)) {
                    foundGuest.setGuestRoomateName(newRoommateName);
                    break;
                } else {
                    System.out.println("Invalid co-teant name format. Please try again.");
                }
            }

        }
        System.out.println("This customer has been upgraded sucessfully !!! ");
        Displayer.showGuestInfoAfterUpdate(foundGuest.getGuestId());

        // Back to Menu
        while (true) {
            System.out.println("Do you wish to continue upgrade another guest ? (Y/N)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Back to the main menu... ");
                break;
            } else if (answer.equalsIgnoreCase("y")) {
                System.out.println("Continue upgrading... ");
                updateGuest();
                break;
            } else {
                System.out.println("Invalid input, please try again. ");
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
