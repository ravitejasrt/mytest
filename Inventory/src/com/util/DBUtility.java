package com.util;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtility {
	private static Connection connection = null;

    public  Connection getConnection() {

        if (connection != null)
            return connection;
        else {
            try {
                String driver = "oracle.jdbc.driver.OracleDriver";
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                String user = "system";
                String password ="manager";	
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }

    }

}
