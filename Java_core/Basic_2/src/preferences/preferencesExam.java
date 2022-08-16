package preferences;

import java.util.prefs.Preferences;

public class preferencesExam {
    public static void main(String[] args) {
        Preferences preferences = Preferences.userNodeForPackage(preferencesExam.class);

        System.out.println("Old Value = " + preferences.get( "data1" , "No value"));

        preferences.put("data1" , "value " + System.currentTimeMillis() );
        System.out.println( "New value = " + preferences.get("data1" , "No value"));
    }
}
