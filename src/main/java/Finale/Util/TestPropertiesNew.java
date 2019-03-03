package Finale.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesNew {
    private final Properties properties = new Properties();
    private static TestPropertiesNew INSTANCE = null;
    private TestPropertiesNew(){
        try {
           // properties.load(new FileInputStream(new File("./" + System.getProperty("environment") + ".properties")));
            properties.load(new FileInputStream(new File("./environment.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TestPropertiesNew getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TestPropertiesNew();
        }
        return INSTANCE;
    }
    public Properties getProperties() {
        return properties;
    }
}
