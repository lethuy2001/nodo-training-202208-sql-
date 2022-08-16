package runnable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTListenerExam {
    public static void main(String[] args) {
        Frame screen = new Frame() ;
        Button button = new Button("Press me");
        button.setSize(14 , 5 );

        screen.add(button) ;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( null,
                        "welcome to java by Example" , "Java Sample" , JOptionPane.INFORMATION_MESSAGE);
            }
        });
        screen.setSize( 300 , 300 );
        screen.setVisible(true);
    }
}
