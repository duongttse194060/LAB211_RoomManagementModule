/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;

import collection.GuestList;
import model.Guest;
import menu.Displayer;

/**
 *
 * @author ADMIN
 */
public class Tester {

    public static void addSampleGuests() {
        System.out.println("Adding a sample guest list...");
        GuestList.guestList.add(new Guest("000000000001", "Nguyen Van An", "01/01/1990", "Male", "0912345678", "R101", 3, "10/06/2025", null));
        GuestList.guestList.add(new Guest("000000000002", "Tran Thi Bich", "02/02/1991", "Female", "0923456789", "R102", 8, "11/05/2025", null));
        GuestList.guestList.add(new Guest("000000000003", "Le Hoang Dung", "03/03/1992", "Male", "0934567890", "R103", 5, "12/07/2025", null));
        GuestList.guestList.add(new Guest("000000000004", "Pham Minh Duy", "04/04/1993", "Male", "0945678901", "R104", 4, "13/08/2025", "Tran Thi Mai"));
        GuestList.guestList.add(new Guest("000000000005", "Hoang Thi Ha", "05/05/1994", "Female", "0956789012", "R105", 7, "14/09/2025", null));
        GuestList.guestList.add(new Guest("000000000006", "Vu Thanh Hien", "06/06/1995", "Male", "0967890123", "R106", 2, "15/02/2026", "Le Van Nam"));
        GuestList.guestList.add(new Guest("000000000007", "Do Thi Kim", "07/07/1996", "Female", "0978901234", "R107", 9, "16/03/2024", null));
        GuestList.guestList.add(new Guest("000000000008", "Bui Van Long", "08/08/1997", "Male", "0989012345", "R108", 6, "17/09/2027", "Ho Ngoc Bao Duy"));
        GuestList.guestList.add(new Guest("000000000009", "Dang Thi Mai", "09/09/1998", "Female", "0990123456", "R109", 15, "18/05/2028", "Nguyen Van Cuong"));
        GuestList.guestList.add(new Guest("000000000010", "Tran Van Nam", "10/10/1999", "Male", "0901234567", "R110", 10, "19/05/2029", null));
        System.out.println("Sample guest list added successfully!!!");
        Displayer.displayGuestListTable();
    }

}
