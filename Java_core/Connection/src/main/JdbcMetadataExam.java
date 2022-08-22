package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class JdbcMetadataExam {
    public static void main(String[] args) throws Exception{
        Connection con = null ;
        try {
            con = ConnectionHelp.getConnection() ;
            DatabaseMetaData metaData = con.getMetaData() ;
            System.out.println("Db version " + metaData.getDatabaseMajorVersion());
            System.out.println("Driver name " + metaData.getDriverName() );
        }finally {
            con.close();
        }
    }
}
