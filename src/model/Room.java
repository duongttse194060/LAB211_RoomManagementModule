/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Room {

    private String roomId;
    private String roomName;
    private String roomType;
    private String roomRate;
    private String roomCapacity;
    private String furnitureDescription;

    public Room() {
    }

    public Room(String roomId, String roomName, String roomType, String roomRate, String roomCapacity, String furnitureDescription) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomRate = roomRate;
        this.roomCapacity = roomCapacity;
        this.furnitureDescription = furnitureDescription;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(String roomRate) {
        this.roomRate = roomRate;
    }

    public String getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(String roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getFurnitureDescription() {
        return furnitureDescription;
    }

    public void setFurnitureDescription(String furnitureDescription) {
        this.furnitureDescription = furnitureDescription;
    }

    @Override
    public String toString() {
        return String.format("%-6s | %-17s | %-10s | %7s | %8s | %s",
                roomId, roomName, roomType, roomRate, roomCapacity, furnitureDescription);
    }

}
