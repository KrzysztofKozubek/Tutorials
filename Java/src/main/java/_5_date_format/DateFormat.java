package _5_date_format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z", Locale.KOREA);
        String input = "2019-04-07T14:45:13 +0100";

        Date date = null;

        try {
            date = formatter.parse(input);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(formatter.format(new Date()));
        System.out.println(formatter.format(date));
    }
}
