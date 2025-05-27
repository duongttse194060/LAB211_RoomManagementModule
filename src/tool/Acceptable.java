/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tool;

/**
 *
 * @author ADMIN
 */
public interface Acceptable {

    public static final String NATIONAL_ID_VALID = "^\\d{12}$";

    public static final String FULLNAME_VALID = "^[A-Za-z][A-Za-z ]{1,24}$";

    public static final String PHONENUMBER_VALID = "^(03|05|07|08|09)\\d{8}$";

    public static final String ROOM_ID_VALID = "^[A-Za-z][0-9]{0,4}$";

    public static final String DATE_VALID = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

    public static final String MONTH_YEAR_VALID = "^(0[1-9]|1[0-2])/\\d{4}$";
}
