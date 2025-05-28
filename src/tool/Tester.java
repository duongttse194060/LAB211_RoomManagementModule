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

    public static void addSampleGuests1() {
        System.out.println("Adding a sample guest list...");
        GuestList.guestList.add(new Guest("000000000001", "Nguyen Van An", "01/01/1990", "Male", "0912345678", "R101", 3, "10/06/2025", null));
        GuestList.guestList.add(new Guest("000000000002", "Tran Thi Bich", "02/02/1991", "Female", "0923456789", "R102", 8, "11/06/2025", null));
        GuestList.guestList.add(new Guest("000000000003", "Le Hoang Dung", "03/03/1992", "Male", "0934567890", "R103", 5, "12/07/2025", null));
        GuestList.guestList.add(new Guest("000000000004", "Pham Minh Duy", "04/04/1993", "Male", "0945678901", "R104", 4, "13/08/2025", "Tran Thi Mai"));
        GuestList.guestList.add(new Guest("000000000005", "Hoang Thi Ha", "05/05/1994", "Female", "0956789012", "R105", 7, "14/09/2025", null));
        GuestList.guestList.add(new Guest("000000000006", "Vu Thanh Hien", "06/06/1995", "Male", "0967890123", "R106", 2, "15/02/2026", "Le Van Nam"));
        GuestList.guestList.add(new Guest("000000000007", "Do Thi Kim", "07/07/1996", "Female", "0978901234", "R107", 9, "16/03/2024", null));
        GuestList.guestList.add(new Guest("000000000008", "Bui Van Long", "08/08/1997", "Male", "0989012345", "R108", 6, "17/09/2023", "Ho Ngoc Bao Duy"));
        GuestList.guestList.add(new Guest("000000000009", "Dang Thi Mai", "09/09/1998", "Female", "0990123456", "R109", 15, "18/06/2025", "Nguyen Van Cuong"));
        GuestList.guestList.add(new Guest("000000000010", "Tran Van Nam", "10/10/1999", "Male", "0901234567", "R110", 10, "19/06/2025", null));
        System.out.println("Sample guest list added successfully!!!");
        Displayer.displayGuestListTable();
    }

    public static void addSampleGuests2() {
        System.out.println("Adding a second sample guest list...");
        // 4 guest vào phòng loại Standard: R102, R103, R107, R109
        GuestList.guestList.add(new Guest("000000000011", "Nguyen Van B", "11/11/1990", "Male", "0911111111", "R102", 2, "20/06/2025", null));
        GuestList.guestList.add(new Guest("000000000012", "Tran Thi C", "12/12/1991", "Female", "0922222222", "R103", 3, "21/06/2025", null));
        GuestList.guestList.add(new Guest("000000000013", "Do Van D", "13/01/1992", "Male", "0933333333", "R107", 2, "22/06/2025", null));
        GuestList.guestList.add(new Guest("000000000014", "Dang Thi E", "14/02/1993", "Female", "0944444444", "R109", 4, "23/06/2025", null));

        // 2 guest vào phòng loại Deluxe: R101, R104
        GuestList.guestList.add(new Guest("000000000015", "Le Van F", "15/03/1994", "Male", "0955555555", "R101", 4, "24/06/2025", "Pham Van G"));
        GuestList.guestList.add(new Guest("000000000016", "Pham Thi H", "16/04/1995", "Female", "0966666666", "R104", 2, "25/06/2025", null));

        // 2 guest vào phòng loại Superior: R105, R110
        GuestList.guestList.add(new Guest("000000000017", "Hoang Van I", "17/05/1996", "Male", "0977777777", "R105", 3, "26/06/2025", null));
        GuestList.guestList.add(new Guest("000000000018", "Vu Thi J", "18/06/1997", "Female", "0988888888", "R110", 2, "27/06/2025", "Le Van K"));

        // 2 guest vào phòng loại Suite: R108, R117
        GuestList.guestList.add(new Guest("000000000019", "Bui Van L", "19/07/1998", "Male", "0999999999", "R108", 5, "28/06/2025", null));
        GuestList.guestList.add(new Guest("000000000020", "Tran Thi M", "20/08/1999", "Female", "0900000000", "R117", 5, "29/06/2025", "Hoang Van N"));

        System.out.println("Second sample guest list added successfully!!!");
        Displayer.displayGuestListTable();
    }

}
