package number;

public class tryCatchExam {
    public int toNumber( String a ){
        try {
            Integer integer = Integer.valueOf(a) ;
            return integer;
        }catch ( NumberFormatException e){
            e.printStackTrace();
        }
        return -1 ;
    }

    public int toNumber1( String a ) throws SaiSoException {
        try {
            Integer integer = Integer.valueOf(a) ;
            return integer;
        }catch ( NumberFormatException e ){
            throw new SaiSoException(a) ;
        }
    }
}
