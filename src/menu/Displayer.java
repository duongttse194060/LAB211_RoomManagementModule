/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import collection.RoomList;
import collection.GuestList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Room;
import model.Guest;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import tool.Inputter;

/**
 *
 * @author ADMIN
 */
public class Displayer {

    public static void displayGuestInformation(String id) {
        Guest g = GuestList.searchById(id);
        Room r = RoomList.searchById(g.getGuestRoomId());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Guest information [National ID: " + g.getGuestId() + "]");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Full name    : " + formatName(g.getGuestName()));
        System.out.println("Phone number : " + g.getGuestPhoneNumber());
        System.out.println("Birth day    : " + g.getGuestBirthdate());
        System.out.println("Gender       : " + g.getGuestGender());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Rental room  : " + g.getGuestRoomId());
        System.out.println("Check in     : " + g.getStartDate());
        System.out.println("Rental days  : " + g.getRentalDate());
        String checkOut = calculateCheckoutDate(g.getStartDate(), g.getRentalDate());
        System.out.println("Check out    : " + checkOut);
        if (g.getGuestRoomateName() != null && !g.getGuestRoomateName().trim().isEmpty()) {
            String foundRoomate = formatName(g.getGuestRoomateName());
            System.out.println("Co-tenant    : " + toTitleCase(foundRoomate));
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Room information:");
        System.out.println("+ ID         : " + r.getRoomId());
        System.out.println("+ Room       : " + r.getRoomName());
        System.out.println("+ Type       : " + r.getRoomType());
        System.out.println("+ Daly rate  : " + r.getRoomRate() + "$");
        System.out.println("+ Capacity   : " + r.getRoomCapacity());
        System.out.println("+ Funiture   : " + r.getFurnitureDescription());
        System.out.println("----------------------------------------------------------------");
    }

    public static void showGuestInfo(String id) {
        Guest g = GuestList.searchById(id);
        Room r = RoomList.searchById(g.getGuestRoomId());
        System.out.println("+ Guest information: ");
        System.out.println("+ Full name: " + toTitleCase(g.getGuestName()));
        System.out.println("+ Phone number: " + g.getGuestPhoneNumber());
        System.out.println("+ Birth day: " + g.getGuestBirthdate());
        System.out.println("+ Gender: " + g.getGuestGender());
        System.out.println("+ Rental room: " + g.getGuestRoomId());
        System.out.println("+ Start date: " + g.getStartDate());
        System.out.println("+ Rental days: " + g.getRentalDate());

        String foundRoomate = g.getGuestRoomateName();
        if (foundRoomate == null || foundRoomate.isEmpty()) {
            System.out.println("This guest currently have no co-teant. ");
        } else {
            System.out.println("+ Co-tenant name: " + toTitleCase(foundRoomate));
        }
    }

    public static void showGuestInfoAfterUpdate(String id) {
        Guest g = GuestList.searchById(id);
        Room r = RoomList.searchById(g.getGuestRoomId());
        System.out.println("+ Guest information [National ID: " + g.getGuestId() + "] after updated: ");
        System.out.println("+ Full name: " + toTitleCase(g.getGuestName()));
        System.out.println("+ Phone number: " + g.getGuestPhoneNumber());
        System.out.println("+ Birth day: " + g.getGuestBirthdate());
        System.out.println("+ Gender: " + g.getGuestGender());
        System.out.println("+ Rental room: " + g.getGuestRoomId());
        System.out.println("+ Start date: " + g.getStartDate());
        System.out.println("+ Rental days: " + g.getRentalDate());

        String foundRoomate = g.getGuestRoomateName();
        if (foundRoomate == null || foundRoomate.isEmpty()) {
            System.out.println("This guest currently have no co-teant. ");
        } else {
            System.out.println("+ Co-tenant name: " + toTitleCase(foundRoomate));
        }
    }

    public static void displayRoomList() {
        if (RoomList.roomList.isEmpty()) {
            System.out.println("Room List is curently empty, not loaded yet.");
            return;
        }
        Collections.sort(RoomList.roomList);
        System.out.println("Printing Room List ...");
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
        System.out.println("RoomID | Room Name         | Type       | Rate    | Capacity | Furniture");
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
        for (Room r : RoomList.roomList) {
            System.out.println(r);
        }
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
    }

    public static void displayVacantRoom() {
        Collections.sort(RoomList.roomList);
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
        System.out.println("RoomID | Room Name         | Type       | Rate    | Capacity | Furniture");
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");

        int count = 0;
        for (Room r : RoomList.roomList) {
            if (RoomList.isRoomAvailable(r.getRoomId())) {
                System.out.println(r);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("All rooms have currently been rented out; no rooms are available! ");
        }
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
    }

    public static void displayGuestListTable() {
        Collections.sort(GuestList.guestList);
        System.out.println("---------------------+------------------------+-------------+---------+-------------------+----------+-------------+--------------+---------------+");
        System.out.println("National ID          | Customer Name          | Birthdate   | Gender  | Phone Number      | Room ID  | Rental Days | Start Date   | Co-tenant      ");
        System.out.println("---------------------+------------------------+-------------+---------+-------------------+----------+-------------+--------------+---------------+");
        for (Guest g : GuestList.guestList) {
            System.out.println(g);
        }
        System.out.println("---------------------+------------------------+-------------+---------+-------------------+----------+-------------+--------------+---------------+");
    }

    public static String toTitleCase(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        String[] array = str.split(" ");
        String result = "";

        for (String word : array) {
            if (word.trim().length() > 0) {
                result += (word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ");
            }
        }
        return result.trim();
    }

    public static String calculateCheckoutDate(String startDate, int rentalDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate checkout = start.plusDays(rentalDays);
        return checkout.format(formatter);
    }

    public static String formatName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "";
        }
        name = toTitleCase(name);
        String[] parts = name.split("\\s+");
        if (parts.length > 1) {
            name = name.trim().replaceAll("\\s+", " ");
            int lastIndexOfSpace = name.lastIndexOf(" ");
            String tempName = name.substring(lastIndexOfSpace + 1);
            String others = name.substring(0, lastIndexOfSpace);
            return tempName + ", " + others;
        }
        return name;
    }

    public static ArrayList<Guest> filterGuestListByMonth(String targetMonth) {

        ArrayList<Guest> filterList = new ArrayList<>();
        for (Guest g : GuestList.guestList) {
            String startDate = g.getStartDate();
            String monthYear = startDate.substring(3);
            if (monthYear.equals(targetMonth)) {
                filterList.add(g);
            }
        }
        return filterList;
    }

    public static double calculateTotalAmount(Room r, ArrayList<Guest> guestsInMonth) {
        double totalAmount = 0;
        double roomRate;
        try {
            roomRate = Double.parseDouble(r.getRoomRate());
        } catch (NumberFormatException e) {
            System.out.println("Invalid room rate format for room: " + r.getRoomId());
            return 0;
        }

        for (Guest g : guestsInMonth) {
            if (g.getGuestRoomId().equals(r.getRoomId())) {
                int rentalDays = g.getRentalDate();
                totalAmount += rentalDays * roomRate;
            }
        }
        return totalAmount;
    }

    public static void displayMonthlyRevenueReport() {
        Collections.sort(RoomList.roomList);
        String targetMonth = Inputter.inputTargetMonth();
        ArrayList<Guest> guestsInMonth = filterGuestListByMonth(targetMonth);
        System.out.println("Monthly Revenue Report - '" + targetMonth + "'");
        System.out.println("-------+-------------------+------------+--------------+-------------");
        System.out.println("RoomID | Room Name         | Type       | Daily Rate   | Amount      ");
        System.out.println("-------+-------------------+------------+--------------+-------------");

        boolean hasData = false;

        for (Room r : RoomList.roomList) {
            double amount = calculateTotalAmount(r, guestsInMonth);
            if (amount > 0) {
                hasData = true;

                System.out.printf("%-6s | %-17s | %-10s | %12.2f | %11.2f%n",
                        r.getRoomId(),
                        r.getRoomName(),
                        r.getRoomType(),
                        Double.parseDouble(r.getRoomRate()),
                        amount);
            }
        }

        if (!hasData) {
            System.out.println("There is no data on guests who have rented rooms.");
        }

        System.out.println("-------+-------------------+------------+--------------+-------------");
    }

    public static double calculateRevenueByRoomType(String targetRoomType) {
        double totalRevenue = 0;
        for (Room r : RoomList.roomList) {
            if (targetRoomType.equals(r.getRoomType())) {
                double roomRate;
                try {
                    roomRate = Double.parseDouble(r.getRoomRate());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Room Daily Rate. Please try again");
                    continue;
                }

                for (Guest g : GuestList.guestList) {
                    if (g.getGuestRoomId().equals(r.getRoomId())) {
                        totalRevenue += roomRate * g.getRentalDate();
                    }
                }
            }
        }
        return totalRevenue;
    }

    public static void displayRevenueReportByRoomType() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> selectedTypes = new ArrayList<>();

        while (true) {

            while (true) {
                System.out.println("Input target Room Type to group and calculate Revenue Report.");
                System.out.println("Enter A to choose Standard Room Type.");
                System.out.println("Enter B to choose Deluxe Room Type.");
                System.out.println("Enter C to choose Superior Room Type.");
                System.out.println("Enter D to choose Suite Room Type.");
                System.out.print("Your choice: ");
                String choice = sc.nextLine().trim();

                String roomType = "";

                if (choice.equalsIgnoreCase("a")) {
                    roomType = "Standard";
                } else if (choice.equalsIgnoreCase("b")) {
                    roomType = "Deluxe";
                } else if (choice.equalsIgnoreCase("c")) {
                    roomType = "Superior";
                } else if (choice.equalsIgnoreCase("d")) {
                    roomType = "Suite";
                } else {
                    System.out.println("Invalid choice. Please choose A, B, C, or D.");
                    continue;
                }

                if (!selectedTypes.contains(roomType)) {
                    selectedTypes.add(roomType);
                } else {
                    System.out.println("You already selected this room type.");
                }
                break;
            }

            while (true) {
                System.out.print("Do you want to choose another Room Type? (Y/N): ");
                String choice = sc.nextLine().trim();
                if (choice.equalsIgnoreCase("n")) {
                    System.out.println("Printing Revenue Report by Room Type.");
                    printRevenueReportFormat(selectedTypes);
                    return;
                } else if (choice.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter Y or N.");
                }
            }
        }
    }

    public static void printRevenueReportFormat(ArrayList<String> selectedTypes) {
        System.out.println("Revenue Report by Room Type ");
        System.out.println("----------------------------");
        System.out.println("Room Type  |  Amount        ");
        System.out.println("----------------------------");

        for (String type : selectedTypes) {
            double revenue = calculateRevenueByRoomType(type);
            System.out.printf("%-10s | $%,.0f\n", type, revenue);
        }

        System.out.println("----------------------------");
    }

}

/* In doanh thu theo từng loại phòng có chi tiết tên phòng ...
    
    public static double calculateRevenueByRoom(Room room) {
        double totalRevenue = 0;
        for (Guest g : GuestList.guestList) {
            double roomRate = Double.parseDouble(room.getRoomRate());
            if (g.getGuestRoomId().equals(room.getRoomId())) {
                totalRevenue += roomRate * g.getRentalDate();
            }
        }

        return totalRevenue;
    }

    public static void printDetailedRevenueReportFormat(ArrayList<String> selectedType) {
        System.out.println("Detail Revenue Report By Room Type: ");
        System.out.println("============================================================================================");
        for (String type : selectedType) {
            System.out.println("Room type: " + type);
            System.out.println("-------+-------------------+------------+---------+----------+--------------------------");
            System.out.println("RoomID | Room Name         | Amount     | Rate    | Capacity | Furniture");
            System.out.println("-------+-------------------+------------+---------+----------+--------------------------");

            boolean hasRoom = false;
            for (Room r : RoomList.roomList) {
                if (r.getRoomType().equals(type)) {
                    double amount = calculateRevenueByRoom(r);
                    if (amount > 0) {
                        hasRoom = true;
                        System.out.printf("%-6s | %-17s | $%10.2f | %7s | %-8s | %-20s\n",
                                r.getRoomId(),
                                r.getRoomName(),
                                amount,
                                r.getRoomRate(),
                                r.getRoomCapacity(),
                                r.getFurnitureDescription());
                    }
                }
            }

            if (!hasRoom) {
                System.out.println("No revenue data available for this room type.");
            }

            System.out.println("========================================================================================");
        }
    }
    
    public static void displayDetailRevenueReportByRoomType() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> selectedTypes = new ArrayList<>();

        while (true) {

            while (true) {
                System.out.println("Input target Room Type to group and calculate Revenue Report.");
                System.out.println("Enter A to choose Standard Room Type.");
                System.out.println("Enter B to choose Deluxe Room Type.");
                System.out.println("Enter C to choose Superior Room Type.");
                System.out.println("Enter D to choose Suite Room Type.");
                System.out.print("Your choice: ");
                String choice = sc.nextLine().trim();

                String roomType = "";

                if (choice.equalsIgnoreCase("A")) {
                    roomType = "Standard";
                } else if (choice.equalsIgnoreCase("B")) {
                    roomType = "Deluxe";
                } else if (choice.equalsIgnoreCase("C")) {
                    roomType = "Superior";
                } else if (choice.equalsIgnoreCase("D")) {
                    roomType = "Suite";
                } else {
                    System.out.println("Invalid choice. Please choose A, B, C, or D.");
                    continue;
                }

                if (!selectedTypes.contains(roomType)) {
                    selectedTypes.add(roomType);
                } else {
                    System.out.println("You already selected this room type.");
                }
                break;
            }

            while (true) {
                System.out.print("Do you want to choose another Room Type? (Y/N): ");
                String choice = sc.nextLine().trim();
                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Printing Revenue Report by Room Type.");
                    printDetailedRevenueReportFormat(selectedTypes);
                    return;
                } else if (choice.equalsIgnoreCase("Y")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter Y or N.");
                }
            }
        }
    }*/
