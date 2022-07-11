/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Define;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author duong
 */
public class DateUitils {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat sdfdefaul = new SimpleDateFormat("yyyy-MM-dd");

    public String getCurrentDate() {
        Date date = new Date();
        return sdf.format(date);
    }

    public String convertExpiDate(String expDate) throws ParseException {
        Date date = sdfdefaul.parse(expDate);
        return sdf.format(date);
    }
    
    public int checkDay(String txtCheckInDate, String txtCheckOutDate) {
        int days = -1;
        try {
            java.util.Date checkInDate = sdfdefaul.parse(txtCheckInDate);
            java.util.Date checkOutDate = sdfdefaul.parse(txtCheckOutDate);
            long diff = checkOutDate.getTime() - checkInDate.getTime();
            
            days = (int) (diff / (1000 * 60 * 60 * 24));

        } catch (Exception e) {
        }
        return days;
    }
}
