package number;

import java.util.logging.Logger;

public class SaiSoException extends Exception {
    private String so ;
    public SaiSoException( String value ){
        this.so = value ;
    }

    public String getMessage( ){
        return "Giá trị\"" + so + "\" Khong phải là số" ;
    }
}
