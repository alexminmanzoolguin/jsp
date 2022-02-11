package com.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.util.MySqlProperties;
import com.util.MySqlPropertiesLoader;

public class Conexion {

    private static MySqlPropertiesLoader mysqlPropertiesLoader = new MySqlPropertiesLoader();
	private static MySqlProperties mysqlProperties = mysqlPropertiesLoader.loadMySqlProperties();
    static {
        try {
        	Class.forName(mysqlProperties.getDriver());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }
    
    public static Connection getConexion() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(mysqlProperties.getUrl(), mysqlProperties.getUser(), mysqlProperties.getPassword());
            System.out.println("pasele :)");

        } catch (SQLException e) {
            System.out.println("error, no entra lo siento :(");
            e.printStackTrace();
        }
        
        return conexion;
    }
}
