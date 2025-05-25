/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import collection.RoomList;
import model.Room;

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

}
