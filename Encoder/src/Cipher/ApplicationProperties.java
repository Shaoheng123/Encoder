package Cipher;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    private Properties properties;

    public ApplicationProperties() {

        properties = new Properties();
        // Load properties from config file
        // Initialize 'properties' field
            try (InputStream inputStream = getClass().getResourceAsStream("/resources/config.properties")) {
                properties.load(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getReferenceTable() {
        return properties.getProperty("REFERENCE.TABLE");
    }

    public int getInputTextLimit() {
        return  Integer.parseInt(properties.getProperty("INPUT.TEXT.LIMIT"));
    }

    public int getFrameWidth() {
        return  Integer.parseInt(properties.getProperty("FRAME.WIDTH"));
    }

    public int getFrameHeight() {
        return  Integer.parseInt(properties.getProperty("FRAME.HEIGHT"));
    }

}
