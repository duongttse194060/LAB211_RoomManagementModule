/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import model.Room;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import menu.Displayer;
import model.Guest;
import collection.GuestList;

/**
 *
 * @author ADMIN
 */
public class RoomList {

    public static ArrayList<Room> roomList = new ArrayList<>();

    public static Room dataToObject(String line) {
        String[] parts = line.split(";", 6);
        if (parts.length < 6) {
            return null;
        }
        return new Room(
                parts[0].trim(),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim(),
                parts[4].trim(),
                parts[5].trim()
        );
    }

    public static ArrayList<Room> readFile() {
        roomList.clear();
        String path = "src/data/Active_Room_List.txt";
        int successCount = 0;
        int failCount = 0;
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Room rm = dataToObject(line);
                if (rm == null) {
                    System.out.println("Error! All six fields must be provided per line. Line: " + line);
                    failCount++;
                    continue;
                }
                if (isExistRoomId(rm.getRoomId())) {
                    System.out.println("Error! RoomID must be unique. Line: " + line);
                    failCount++;
                    continue;
                }
                if (isInvalidRate(rm.getRoomRate())) {
                    System.out.println("Error! Daily Rate must be a positive decimal number. Line: " + line);
                    failCount++;
                    continue;
                }
                if (isInvalidCapacity(rm.getRoomCapacity())) {
                    System.out.println("Error! Room Capacity must be a positive integer number. Line: " + line);
                    failCount++;
                    continue;
                }
                roomList.add(rm);
                successCount++;
            }
            System.out.println("Load data from Active_Room_List.txt successfully.");
            System.out.printf("%d rooms successfully loaded.%n", successCount);
            System.out.printf("%d entries failed.%n", failCount);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file Active_Room_List.txt.");
        } catch (IOException e) {
            System.out.println("Cannot read data from Active_Room_List.txt. Please check it.");
        }

        return roomList;
    }

    public static boolean isExistRoomId(String id) {
        for (Room r : roomList) {
            if (id.equals(r.getRoomId())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInvalidRate(String rate) {
        try {
            double dailyRate = Double.parseDouble(rate);
            if (dailyRate <= 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static boolean isInvalidCapacity(String capacity) {
        try {
            int cap = Integer.parseInt(capacity);
            if (cap <= 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static Room searchById(String id) {
        for (Room r : roomList) {
            if (id.equals(r.getRoomId())) {
                return r;
            }
        }
        return null;
    }

    public static boolean isRoomAvailable(String roomId) {
        for (Guest g : GuestList.guestList) {
            if (roomId.equals(g.getGuestRoomId())) {
                return false;
            }
        }
        return true;
    }

}
