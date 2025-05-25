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

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        do {
            Menu.function();
            System.out.print("Enter your choice (1-8): ");
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
                    RoomList.displayAvailableRoom();
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
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Invalid choice. Program exited... ");
                    return;
            }

        } while (true);
    }
}
