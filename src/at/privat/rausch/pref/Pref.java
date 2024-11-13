package at.privat.rausch.pref;

import java.io.FileInputStream;
import java.util.Optional;
import java.util.Properties;

public abstract class Pref {
    private static final Properties PREFERENCES;
    private static final String PATH;

    static {
        PREFERENCES = new Properties();
        PATH = "config/config.txt";
        readFromFile(PATH);
    }

    private static void readFromFile(String path) {
        try {
            PREFERENCES.load(new FileInputStream(path));
        }
        catch (Exception e) {
            System.out.println("Error while loading config from file");
        }
    }

    public static Optional<String> getPref(String key) {
        return Optional.ofNullable(PREFERENCES.getProperty(key));
    }
}
