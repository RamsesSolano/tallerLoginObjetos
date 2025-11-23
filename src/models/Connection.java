
package models;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author AdminSena
 */
public class Connection {
    Properties properties = new Properties();
    File propertiesFile = new File("config.properties");
    try {
        FileInputStream info = new FileInputStream(propertiesFile);
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
    
    
    
}
