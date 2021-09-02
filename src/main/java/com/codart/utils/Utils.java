package com.codart.utils;

import java.util.Locale;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.text.ParseException;
import java.util.logging.Logger;
import com.codart.model.AccountDTO;
import javax.swing.text.MaskFormatter;
import com.codart.service.CsvReaderService;

/**
 *
 * @author Robson
 */
public class Utils {

    public static String maskFormater(String value) {
        String account = null;
        try {
            MaskFormatter mf = new MaskFormatter("AAAAA-A");
            mf.setValueContainsLiteralCharacters(false);
            account = mf.valueToString(value);
            return account;
        } catch (ParseException ex) {
            Logger.getLogger(AccountDTO.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public static Double formatBalance(String value) {
        Number number = null;
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            number = format.parse(value);
            return number.doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(CsvReaderService.class.getName())
                    .log(Level.WARNING, ex.getMessage());
        }
        return null;
    }

    public static String formatAccount(String value) {
        return value.replaceAll("-", "");
    }
}
