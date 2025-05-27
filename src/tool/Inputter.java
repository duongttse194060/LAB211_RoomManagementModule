/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;

import java.util.ArrayList;
import model.Guest;
import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import collection.RoomList;
import java.time.format.DateTimeFormatterBuilder;

/**
 *
 * @author ADMIN
 */
public class Inputter {

    public static boolean isValid(String input, String pattern) {
        return input.matches(pattern);
    }

    public static boolean isDupplicatedId(String id, ArrayList<Guest> list) {
        for (Guest g : list) {
            if (g.getGuestId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static String inputGuestId(ArrayList<Guest> list) {
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("Enter Guest National ID Number: ");
            id = sc.nextLine().trim();
            if (!isValid(id, Acceptable.NATIONAL_ID_VALID)) {
                System.out.println("National ID number is invalid. Must be unique and include 12 digits");
            } else if (isDupplicatedId(id, list)) {
                System.out.println("National ID number is already used! Please try another one. ");
            } else {
                break;
            }
        }
        return id;
    }

    public static String inputGuestName() {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("Enter Guest Full Name: ");
            name = sc.nextLine().trim();
            if (isValid(name, Acceptable.FULLNAME_VALID)) {
                break;
            } else {
                System.out.println("Guest name is invalid. Please try again");
            }
        }
        return name;
    }

    public static String inputBirthDate() {
        Scanner sc = new Scanner(System.in);
        String birthDate;

        while (true) {
            System.out.println("Enter Guest Birthday (dd/MM/yyyy): ");
            birthDate = sc.nextLine().trim();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate inputDate = LocalDate.parse(birthDate, formatter);

                if (inputDate.isBefore(LocalDate.now())) {
                    return birthDate;
                } else if (inputDate.isAfter(LocalDate.now())) {
                    System.out.println("Birthdate is invalid. Input date must be in the past (before today).");
                } else {
                    System.out.println("Input date cannot be today. Please choose a past date.");
                }
            } catch (DateTimeException e) {
                System.out.println("Invalid date format, please try again.");
            }
        }
    }

    public static String inputGender() {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Enter Guest Gender (M/F): ");
            input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("M")) {
                System.out.println("Guest Gender is Male. ");
                return "Male";
            } else if (input.equalsIgnoreCase("F")) {
                System.out.println("Guest Gender is Female");
                return "Female";
            } else {
                System.out.println("Invalid input. Please input again (M for Male / F for Female): ");
            }
        }
    }

    public static String inputPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber;
        while (true) {
            System.out.print("Enter Guest Phone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (isValid(phoneNumber, Acceptable.PHONENUMBER_VALID)) {
                break;
            } else {
                System.out.println("Your phone number is invalid, please try again.");
            }
        }
        return phoneNumber;
    }

    public static String inputDestinatedRoomId() {
        Scanner sc = new Scanner(System.in);
        String roomId;
        while (true) {
            System.out.println("Enter Guest Room ID: ");
            roomId = sc.nextLine().trim();
            if (!isValid(roomId, Acceptable.ROOM_ID_VALID)) {
                System.out.println("Invalid Room ID format. Please try again.");
                continue;
            }
            if (!RoomList.isExistRoomId(roomId)) {  // ở đây dùng hàm này để kiểm tra tồn tại
                System.out.println("Room ID does not exist. Please enter a valid Room ID from the list.");
                continue;
            }
            break;
        }

        return roomId;
    }

    public static int inputRentalDate() {
        Scanner sc = new Scanner(System.in);
        String input;
        int rentDate;

        while (true) {
            System.out.println("Enter Number Of Rental Days: ");
            input = sc.nextLine().trim();
            try {
                rentDate = Integer.parseInt(input);
                if (rentDate > 0) {
                    break;
                } else {
                    System.out.println("Invalid input.  Number of rental days must be an positive integer number. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer number. ");
            }
        }
        return rentDate;
    }

    public static String inputStartDate() {
        Scanner sc = new Scanner(System.in);
        String startDate;

        while (true) {
            System.out.println("Enter Start Date (dd/MM/yyyy): ");
            startDate = sc.nextLine().trim();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate inputDate = LocalDate.parse(startDate, formatter);

                if (inputDate.isAfter(LocalDate.now())) {
                    return startDate;
                } else if (inputDate.isBefore(LocalDate.now())) {
                    System.out.println("Starting date is invalid. Input date must be in the future (after today).");
                } else {
                    System.out.println("Starting date cannot be today. Please choose a future date.");
                }
            } catch (DateTimeException e) {
                System.out.println("Invalid date format, please try again.");
            }
        }
    }

    public static String inputNameRoomate() {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Enter Co-teant Name (Optional - Press ENTER to skip): ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Skipping this part...");
                return null;
            }
            if (isValid(input, Acceptable.FULLNAME_VALID)) {
                return input;
            } else {
                System.out.println("Invalid name. Please try again. ");
            }
        }
    }

    public static boolean isValidStartDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(date, formatter);
            LocalDate today = LocalDate.now();
            if (inputDate.isAfter(today)) {
                return true;
            } else if (inputDate.isEqual(today)) {
                System.out.println("Start date cannot be today. Please choose a future date.");
            } else {
                System.out.println("Start date is invalid. Input date must be in the future (after today).");
            }
        } catch (DateTimeException e) {
            System.out.println("Invalid date format, please try again (e.g., dd/MM/yyyy).");
        }
        return false;
    }

    public static boolean isValidBirthDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(date, formatter);
            LocalDate today = LocalDate.now();
            if (inputDate.isBefore(today)) {
                return true;
            } else if (inputDate.isEqual(today)) {
                System.out.println("Birthdate cannot be today. Please choose a past date.");
            } else {
                System.out.println("Birthdate is invalid. Input date must be in the past (before today).");
            }
        } catch (DateTimeException e) {
            System.out.println("Invalid date format, please try again (e.g., dd/MM/yyyy).");
        }
        return false;
    }

    public static boolean checkDateInPast(String date) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(date, dtf);
            return !inputDate.isAfter(LocalDate.now());
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static String inputTargetMonth() {
        Scanner sc = new Scanner(System.in);
        String targetMonth;
        while (true) {
            System.out.println("Input target month (MM/yyyy): ");
            targetMonth = sc.nextLine().trim();
            if (isValid(targetMonth, Acceptable.MONTH_YEAR_VALID)) {
                break;
            } else {
                System.out.println("Invalid input format. Must be (MM/yyyy)");
            }
        }
        return targetMonth;
    }
}
