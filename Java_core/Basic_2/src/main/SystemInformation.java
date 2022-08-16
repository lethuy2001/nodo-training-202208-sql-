package main;

import SwitchExam.StringSwitchStatement;
import character.CharacterExam;
import dateFormat.DatetimeFormat;
import dateFormat.MessageFormatExam;
import enumExample.EnumExam;
import enumExample.StreamArrayExam;
import enumExample.array;
import number.SaiSoException;
import number.tryCatchExam;

import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemInformation {
    private final static Logger LOGGER = Logger.getLogger(Throwable.class.getName()) ;

    public static void main(String[] args) {
        StringSwitchStatement sws = new StringSwitchStatement();
        DatetimeFormat df = new DatetimeFormat();
        MessageFormatExam mfe = new MessageFormatExam() ;
        EnumExam ee = new EnumExam();
        CharacterExam ce = new CharacterExam();
        tryCatchExam tce = new tryCatchExam();
        StreamArrayExam sae = new StreamArrayExam() ;
        array a = new array();

        Calendar calendar = Calendar.getInstance() ;

//      Date time format
//        df.DateTimeFormatExam();
//        System.out.println(sws.getTypeOfDay(Calendar.getInstance()));
//
//        calendar.set(Calendar.DATE , calendar.get(Calendar.DATE) - 1) ;
//        System.out.println("Ngày hôm qua là: " +
//                sws.getTypeOfDay( calendar) );

//      Message format
//        mfe.Mess();

//        System.out.println(EnumExam.VnDay.valueOf(calendar) );
//      Character
//        System.out.println( ce.countDigit("Hello 84738") );
//        System.out.println( ce.countDigit2("hello 53333"));

//      Kiểm tra số
//        String value = "83gg" ;
//        System.out.println( "Message: "+ value + ( tce.toNumber(value) == -1 ? " không phải là số" : " là số")  );
//
//        try {
//            System.out.println( tce.toNumber1(value));
//        }catch ( SaiSoException e){
//           Logger.getLogger(Level.WARNING );
//            System.err.println( e.getMessage() );
//        }

//        Sắp xếp
        Integer[] arr = { 1 , 4 ,7 ,5 ,2 } ;
//        a.SortArray(arr);
//        sae.streamArr(arr);
//        sae.ConcatenateStringTest();
        sae.IntStreamExam();
    }
}
