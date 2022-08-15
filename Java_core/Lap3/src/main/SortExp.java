package main;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SortExp {
    public static void main(String[] args) {
//        CollectionExam2();
//        CollectionOperation();
//        ConllectionUtils();
        ConcurrencyTest3();
    }

    public static void CollectionExam () {
        Short[] values = { 1 ,3 ,4 , 5 ,6, 7 ,8 , 2} ;
        List<Short> list = new ArrayList<>();
        Collections.addAll( list , values ) ;
        Collections.reverse(list);
        Collections.sort( list , ( a , b ) -> b.compareTo(a)) ;
        for( Short x : list ){
            System.out.println(x);
        }
    }

    public static void CollectionExam2() {
        String[] value = {"Tu" , "An" , "Hoa" , "Hien"} ;
        List<String> list = new ArrayList<>() ;
        Collections.addAll( list , value ) ;
//
        Collections.sort( list , (a , b ) -> b.compareTo(a));
        for( String x : list ){
            System.out.println(x);
        }
        // Vị trí âm -1 vì dã bị sắp xếp
        System.out.println( "Vi trí thứ: " + Collections.binarySearch( list , "An"));
    }

    public static void CollectionOperation() {
        List<Integer> list = new  ArrayList<>( Arrays.asList( 4 , 6, 4, 9 ,2 ,1 )) ;

        int k = list.stream().filter( v -> v > 5 )
                .reduce( 0, ( total , a) -> total + a )
        ;

        Consumer<Integer> myConsumer = n -> {
            System.out.println(n);
            if( n < 5 ) {
                System.out.println(n);
                return;
            }
        };
        myConsumer.accept(65);

        Scanner sc = new Scanner(System.in );
        while ( true ){
            System.out.println("Nhập số: ");
            int value = sc.nextInt() ;
            myConsumer.accept(value);
        }
    }

    public static void ConllectionUtils( ){
        List<Integer> listInt = new ArrayList<>();
        Predicate<Integer> test = v -> v > 5 ;
        Consumer<Integer> myConsumer = n -> listInt.add(n) ;
        Scanner sc = new Scanner(System.in) ;
        while ( true ){
             System.out.println("Nhập số: ");
             int value = sc.nextInt() ;
             if( value <= 0 ) break;
             if( test.test( value))  myConsumer.accept(value);
        }
        System.out.println("List danh sách");
        listInt.forEach( x -> System.out.println(x));
    }

    public static void ConcurrencyTest( ){
        List<Integer> list = new ArrayList<>() ;
        Collections.addAll( list , 1 ,2 ,4 ,5 ,5 ,9) ;

        System.out.println("Trước khi xóa");
        list.forEach( x -> System.out.println(x));
        for ( int i=0 ; i<list.size() ; i++ ){
            if( list.get(i) == 5 ){
                list.remove( list.get(i));
            }
        }
        System.out.println("Sau khi xóa");
        list.forEach( x -> System.out.println(x));

     }

    public static void ConcurrencyTest2( ){
        List<Integer> list = new ArrayList<>() ;
        Collections.addAll( list , 1 ,2 ,4 ,5 ,5 ,9) ;

        System.out.println("Trước khi xóa");
        list.forEach( x -> System.out.println(x));

//        list.forEach( x -> {
//            if( x == 5 ) list.remove(x);
//        });
        list.removeIf( v -> { return v == 5; });

        System.out.println("Sau khi xóa");
        list.forEach( x -> System.out.println(x));
    }

    public static void ConcurrencyTest3( ){
        List<Integer> list = new ArrayList<>() ;
        Collections.addAll( list , 1 ,2 ,4 ,5 ,5 ,9) ;

        System.out.println("Trước khi xóa");
        list.forEach( x -> System.out.println(x));

//        Iterator<Integer> iterator = list.iterator() ;
//        while ( iterator.hasNext() ){
//            if( iterator.next() == 5 ){
//                iterator.remove();
//            }
//        }
        list.removeAll(Collections.singleton(5)) ;
        System.out.println("Sau khi xóa") ;
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next() );
//        }
        list.forEach( x -> System.out.println(x));

    }
}
