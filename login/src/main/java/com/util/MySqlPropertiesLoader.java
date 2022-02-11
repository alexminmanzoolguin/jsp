package com.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MySqlPropertiesLoader {
    private static final String CONFIG_FILE = "config.properties";
    public MySqlProperties loadMySqlProperties() {
        Properties properties = new Properties();
		InputStream inputStream = null;
		MySqlProperties mysqlProperties = new MySqlProperties();
        
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE);
			properties.load(inputStream);
			
			mysqlProperties.setDriver(properties.getProperty("mysql.driver"));
			mysqlProperties.setUrl(properties.getProperty("mysql.url"));
			mysqlProperties.setUser(properties.getProperty("mysql.user"));
			mysqlProperties.setPassword(properties.getProperty("mysql.password"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
        return mysqlProperties;
    }
    
}
