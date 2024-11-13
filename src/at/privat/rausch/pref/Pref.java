package at.privat.rausch.pref;

import java.io.FileInputStream;
import java.util.Optional;
import java.util.Properties;

public abstract class Pref {
    private static final Properties PREFS;
    private static final String PATH;

    static {
        PREFS = new Properties();
        PATH = "config/config.txt";
        readFromFile(PATH);
    }

    private static void readFromFile(String path) {
        try {
            PREFS.load(new FileInputStream(path));
        }
        catch (Exception e) {
            System.out.println("Error while loading config from file");
        }
    }

    public static Optional<String> getPref(String key) {
        return Optional.ofNullable(PREFS.getProperty(key));
    }
}
