/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import menu.Menu;
import collection.RoomList;
import menu.Displayer;
import collection.GuestList;
import tool.Tester;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        GuestList.readFromFile();
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            Menu.function();
            System.out.print("Enter your choice (1-11): ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("You choose option 1: Import Room Data From Text File. ");
                    RoomList.readFile();
                    break;
                case 2:
                    System.out.println("You choose option 2: Display Available Room List. ");
                    Displayer.displayRoomList();
                    break;
                case 3:
                    System.out.println("You choose option 3: Enter Guest Information. ");
                    GuestList.addGuest();
                    break;
                case 4:
                    System.out.println("You choose option 4: Update Guest Stay Information. ");
                    GuestList.updateGuest();
                    break;
                case 5:
                    System.out.println("You choose option 5: Search Guest By National ID. ");
                    GuestList.searchGuestById();
                    break;
                case 6:
                    System.out.println("You choose option 6: Delete Guest Reservation Before Arrival. ");
                    GuestList.removeGuestBooking();
                    break;
                case 7:
                    System.out.println("You choose option 7: List Vacant Rooms. ");
                    Displayer.displayVacantRoom();
                    break;
                case 8:
                    System.out.println("You choose option 8: Monthly Revenue Report. ");
                    Displayer.displayMonthlyRevenueReport();
                    break;
                case 9:
                    System.out.println("You choose option 9: Revenue Report By Room Type. ");
                    Displayer.displayRevenueReportByRoomType();
                    break;
                case 10:
                    System.out.println("You choose option 10: Save Guest Information. ");
                    GuestList.saveData();
                    break;
                case 11:
                    Menu.utilityMenu();
                    break;
                case 12:
                    // Thêm chức năng nhập 1 số x từ bàn phím, sau đó tìm và hiển thị các phòng có Room Rate lớn hơn hoặc bằng x
                    // Và cho biết thêm có bao nhiêu phòng được hiển thị.
                    Displayer.displayRoomListByRoomRate();
                    break;
                default:
                    System.out.println("Invalid choice. Program exited... ");
                    return;
            }
        } while (true);
    }
}
