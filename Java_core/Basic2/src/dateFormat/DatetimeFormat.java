package dateFormat;

import SwitchExam.StringSwitchStatement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatetimeFormat {
    public void DateTimeFormatExam ( ){
        Locale locale = new Locale("vi" , "VN") ;
        DateFormat dateFormat
                = new SimpleDateFormat( "EE , dd MMMMM yyyy hh mm ss" , locale);
        Calendar calendar = Calendar.getInstance() ;
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
