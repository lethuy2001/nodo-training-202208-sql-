package main;

import java.io.Serializable;

public class PrintMessage implements Runnable , Serializable {

    private String message ;

    public PrintMessage( String ja) {
        this.message = ja ;
    }

    @Override
    public void run() {

    }
}
