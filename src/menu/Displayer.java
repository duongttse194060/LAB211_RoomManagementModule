/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import collection.RoomList;
import collection.GuestList;
import model.Room;
import model.Guest;

/**
 *
 * @author ADMIN
 */
public class Displayer {

    public static void displayRoomList() {
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
        System.out.println("RoomID | Room Name         | Type       | Rate    | Capacity | Furniture");
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
        for (Room r : RoomList.roomList) {
            System.out.println(r);
        }
        System.out.println("-------+-------------------+------------+---------+----------+--------------------------------------------------");
    }

    public static void displayGuestInformation(String id) {
        Guest g = GuestList.searchById(id);
        Room r = RoomList.searchById(g.getGuestRoomId());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Guest information [National ID: " + g.getGuestId() + "]");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Full name    : " + g.getGuestName());
        System.out.println("Phone number : " + g.getGuestPhoneNumber());
        System.out.println("Birth day    : " + g.getGuestBirthdate());
        System.out.println("Gender       : " + g.getGuestGender());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Rental room  : " + g.getGuestRoomId());
        System.out.println("Check in     : " + g.getStartDate());
        System.out.println("Rental days  : " + g.getRentalDate());
        System.out.println("Check out    : ");
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
        System.out.println("+ Full name: " + g.getGuestName());
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
            System.out.println("+ Co-tenant name: " + foundRoomate);
        }
    }

    public static void showGuestInfoAfterUpdate(String id) {
        Guest g = GuestList.searchById(id);
        Room r = RoomList.searchById(g.getGuestRoomId());
        System.out.println("+ Guest information [National ID: " + g.getGuestId() + "] after update successfully: ");
        System.out.println("+ Full name: " + g.getGuestName());
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
            System.out.println("+ Co-tenant name: " + foundRoomate);
        }
    }

}
