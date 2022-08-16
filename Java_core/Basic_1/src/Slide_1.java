import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Slide_1 {
    Scanner sc = new Scanner(System.in) ;
    public static void main(String[] args) {
//        bai1();
//       NumberExample( 9 , 3);
//        PersonTest();
//        ArrayExample();
//        System.out.println( "Values: " + IfElseEx(6));
//         System.out.println(add( 2 , 3 , 5, 4 , 6 ) ) ;
//          StringExample( "say hello to everyone" );
//           StringExampel1( "say hello hiên");
//           MultoArrayExample();
            MathExample( 4 , -8 , 47.1 , 1.79);
    }

    public static void bai1( ){
        System.out.println("Hello world");
        System.out.println("5 + 7 = " + (5 + 7 )) ;
    }

    public static void NumberExample( float a , float b ){
        System.out.println( a + " + " + b + " = " + (a + b ) );
        System.out.println( a + " - " + b + " = " + (a - b ) );
        System.out.println( a + " * " + b + " = " + (a * b ) );
        System.out.println( a + " / " + b + " = " + (a / b ) );
    }

    public static void PersonTest ( ){
        student sv = new student( "Thụy") ;
        System.out.println( "Name of student: " + sv.getName());
    }

    public static String IfElseEx( double a ){
        if(  a > 8  ) return  "Giỏi" ;
        else if ( a >= 6) return "Khá" ;
        else if ( a >= 5) return  "Trung bình" ;
        else return "Kém" ;
    }

    public static void SwitchExample( int a ){
        switch ( a ) {
            case 0: System.out.println("Bad");
                    break;
            case  1: System.out.println("OKi");
                     break;
            default: System.out.println("Invalid");
        }
    }

    public static void ArrayExample( ){
        float [] values = { 4.5f , 5.0f , 6.0f , 9.4f} ;

        float total = 0 ;
        float max = values[0] ;
        for( float x : values ){
            total  += x ;
            if( max <= x ){
                max = x ;
            }
        }

        System.out.println("The total value of array is: " + total);
        System.out.println("The max value of array is: " + max );
    }

    private static int add( int ...values ){
        int total = 0 ;
        for(  int x : values ){
            total += x ;
        }
        return total ;
    }

    private static void StringExample( String text ){
        char[] a =  { 'w' , 'o' , 'r' , 'l' , 'd' } ;
        String sv = new String( a ) ;

        System.out.println("Vị trí của hello là: " + text.indexOf("hello"));
        System.out.println("Giá trị của a: "  + sv );
        System.out.println("Concat: " + ' ' + text.concat(sv));
        System.out.println( "hello java".equals(text) ) ;

        byte [] bytes = text.getBytes() ;
        for( byte x: bytes ){
            System.out.println( (int)x ) ;
        }
    }

    private static void StringExampel1( String text ) {
        int i =  0 ;
        while ( i < text.length() ){
            char c = text.charAt(i) ;
            if( c == ' '){
                i++ ;
                continue;
            }
            System.out.println("Character at " + i + " is " + c);
            i++ ;
        }

        byte[] bytes = { 99 , -58 , -80 , -31 , -69 , -101 , 112 , 44 ,32 ,
        104 , 105 , -31 , -70 ,-65 , 112 , 44 , 32 , 103 , 105 , -31 , -70 , -65 , 116} ;
        try {
            String sk = new String ( bytes , "utf-8" ) ;
            System.out.println("Giá trị: " + sk );
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }

    public static void MultoArrayExample ( ) {
        String [][] values = {
                {"Hiên" , "Xấu" , "Xa"} ,
                {"A" , "B" , "C" }
        };

        for( int i=0 ; i < values.length ; i++ ){
            for ( int j=0 ; j < values[i].length ; j++ ){
                System.out.print( values[i][j] + "" );
            }
            System.out.println("");
        }
    }

    public static void MathExample( int i , int j , double x , double y ){
        System.out.println("| " + j + " |" + Math.abs(j));
        System.out.println("| " + i + " |" + Math.abs(i));
        System.out.println(x + " làm tròn " + Math.round(x));
        System.out.println(i + " làm tròn lên" + Math.ceil(i));
        System.out.println(y + " làm tròn lên" + Math.ceil(y));
        System.out.println(x + " làm tròn xuống" + Math.floor(i));
        System.out.println( "min(" + x + "," + y +")" + Math.min( x, y)) ;
        System.out.println("Pi là: " + Math.PI );
        double angle = 45 * 2 * Math.PI/360 ;
        double values = 0.707 ;
        System.out.println(  "cos(" + x + ") = "  + Math.cos(angle));
        System.out.println(  "acos(" + x + ") = "  + Math.acos(values));
        System.out.println("exp(0.0) là: " +  Math.exp(0.0));
        System.out.println("log(10.0) là: " +  Math.log(10.0));
        System.out.println("pow( 2 , 2 ) là: " +  Math.pow( 2.0 , 2.0 ));
        System.out.println(" Ramdom "  + Math.random());
    }
}
