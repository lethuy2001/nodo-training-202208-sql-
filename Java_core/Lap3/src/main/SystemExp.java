package main;

import java.util.*;

public class SystemExp {
    static String[] listSt = {"a" , "b" , "c" , "d" , "e"} ;

    public static void main(String[] args) {
//        ArrayListExam();
//        VectorExam();
//          LinkedListExam();
//          SetExample();
          MapExample();
          TreeMapExample();
    }


    public static void VectorExam( ) {
        Vector<Integer> vector = new Vector<>() ;
        vector.add(1) ;
        vector.add(14) ;
        vector.add(8) ;
        vector.add(3) ;

        System.out.println("Size of vector: " + vector.size() );
        System.out.println("Element at 2: " + vector.get(2) );
    }

    public static void ArrayListExam( ){
        List<String> list = new ArrayList<>() ;
        Collections.addAll( list , listSt );

        for( String x : list ){
            System.out.println(x);
        }
    }

    public static void LinkedListExam( ){
        List<String> list = new LinkedList<>( );
        for( String x: listSt ){
            list.add(x) ;
        }
        list.add("a") ;

        Iterator<String> iterator = list.iterator() ;
        while ( iterator.hasNext() ){
            System.out.println( iterator.next() );
        }

//        list.forEach( value -> {
//            System.out.println(value);
//        });
    }

    public static void SetExample( ){
        Set<String> strings = new TreeSet<>() ;
        Arrays.stream(listSt).forEach( value -> {
            strings.add(value) ;
        });

        strings.add("a") ;

        System.out.println("Size of value: " + strings.size() );
        strings.forEach( x -> {
            System.out.println(x);
        });
    }

    public static void MapExample( ){
        Map< Integer , String > map = new HashMap<>() ;
        map.put( 3 , "Lê Minh Thụy") ;
        map.put( null , "Tạ Văn Nam") ;
        map.put( 4 , "Nguyễn Văn A") ;
        map.put( 2 , "Đào Văn Đức") ;

        map.forEach( ( key , value) -> {
            System.out.println( key + " : " + value);
        });
    }

    public static void TreeMapExample( ){
        TreeMap< String , String > map = new TreeMap<>();
        map.put( "a" , "Lê Minh Thụy") ;
        map.put( "d" , "Tạ Văn Nam" ) ;
        map.put( "c" , "Nguyễn Văn A") ;
        map.put( "2" , "Đào Văn Đức") ;

        Iterator<Map.Entry<String , String > > iterator = map.entrySet().iterator() ;
        while ( iterator.hasNext() ){
            Map.Entry< String , String  > entry = iterator.next() ;
            System.out.println( entry.getKey() +  " : " + entry.getValue() ) ;
        }
    }
}
