package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UltilsHeper{
    public static void insert( String sql , Object ...obj ) throws Exception{
        try (Connection con = ConnectionHelp.getConnection();
             PreparedStatement stm = con.prepareStatement(sql);
        ){
            con.setAutoCommit(false);
            for( int i=0 ; i<obj.length ; i++ ){
                stm.setObject( i+ 1 , obj[i] );
            }
            stm.executeUpdate() ;
        }
    }

    public static void insertAll( String sql , List st  ) throws  Exception {
        try (Connection con = ConnectionHelp.getConnection();
             PreparedStatement stm = con.prepareStatement(sql) ;
            ){
            con.setAutoCommit(false);
            for( int i=0; i < st.size() ; i++ ){
                stm.setObject( 1 ,( "Trần Văn " + st.get(i)));
                stm.setObject( 2 ,(10 +  (Integer)st.get(i) ) );
                stm.executeUpdate();
            }
            con.rollback();
            System.out.println("Thêm mới thành công");
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }

    public static List<student> findAll(String sql, Object ...obj ) throws Exception {
        List<student> list = new ArrayList<>() ;
        try ( Connection con = ConnectionHelp.getConnection() ;
              PreparedStatement stm = con.prepareStatement(sql) ;
            ){
            con.setAutoCommit(true);
            for ( int i=0 ; i<obj.length ; i++ ){
                stm.setObject( i+1 , obj[i] );
            }

            ResultSet result = stm.executeQuery() ;
            while ( result.next() ){
                student sv = new student() ;
                sv.setId( result.getInt("ID") );
                sv.setName( result.getString("NAME"));
                sv.setAge( result.getInt("AGE"));
                list.add( sv);
            }
        }
        return list ;
    }
}
