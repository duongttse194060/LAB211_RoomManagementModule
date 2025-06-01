/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Guest implements Serializable, Comparable<Guest> {

    private String guestId;
    private String guestName;
    private String guestBirthdate;
    private String guestGender;
    private String guestPhoneNumber;
    private String guestRoomId;
    private int rentalDate;
    private String startDate;
    private String guestRoomateName;

    public Guest() {
    }

    public Guest(String guestId, String guestName, String guestBirthdate, String guestGender, String guestPhoneNumber, String guestRoomId, int rentalDate, String startDate, String guestRoomateName) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.guestBirthdate = guestBirthdate;
        this.guestGender = guestGender;
        this.guestPhoneNumber = guestPhoneNumber;
        this.guestRoomId = guestRoomId;
        this.rentalDate = rentalDate;
        this.startDate = startDate;
        this.guestRoomateName = guestRoomateName;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestBirthdate() {
        return guestBirthdate;
    }

    public void setGuestBirthdate(String guestBirthdate) {
        this.guestBirthdate = guestBirthdate;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(String guestGender) {
        this.guestGender = guestGender;
    }

    public String getGuestPhoneNumber() {
        return guestPhoneNumber;
    }

    public void setGuestPhoneNumber(String guestPhoneNumber) {
        this.guestPhoneNumber = guestPhoneNumber;
    }

    public String getGuestRoomId() {
        return guestRoomId;
    }

    public void setGuestRoomId(String guestRoomId) {
        this.guestRoomId = guestRoomId;
    }

    public int getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(int rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGuestRoomateName() {
        return guestRoomateName;
    }

    public void setGuestRoomateName(String guestRoomateName) {
        this.guestRoomateName = guestRoomateName;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-22s | %-11s | %-7s | %-17s | %-8s | %-11s | %-12s | %-14s",
                guestId, guestName, guestBirthdate, guestGender, guestPhoneNumber, guestRoomId,
                rentalDate, startDate, guestRoomateName);
    }

    @Override
    public int compareTo(Guest other) {
        return this.guestId.compareToIgnoreCase(other.guestId);
    }

}
