package dateFormat;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MessageFormatExam {
    public void Mess(){
        DateFormat dateFormat = new SimpleDateFormat("EEEEE  , dd MMMMM yyyy " , new Locale("vi"));

        String message = MessageFormat.format( "Hello {0} Today is {1}" , "Thụy"
                , dateFormat.format( Calendar.getInstance().getTime() )  );
        System.out.println( message );
    }

}
