package SwitchExam;

import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
    public String getTypeOfDay(Calendar calendar ){
        String type = calendar.getDisplayName( Calendar.DAY_OF_WEEK ,
                Calendar.SHORT , new Locale("vi"));

        switch ( type ){
            case "Th 2": return "Start of work week" ;
            case "Th 3":
            case "Th 4": return "Midweek" ;
            case "Th 5":
            case "TH 6": return "End of work week" ;
            case "Th 7":
            case "CN": return "Weekend" ;
        }
        return "Unknown" ;
    }
}
