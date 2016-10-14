/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Objeto;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author niel
 */
public class Connection {
    //DB Ports
    private static final String MYSQL_PORT = "3306";
    private static final String MSSQL_PORT = "1433";
    private static final String POSTGRES_PORT = "5432";
    private static final String ORACLE_PORT = "1521";

    // DB Urls
    private static final String MYSQL_URL = "jdbc:mysql://localhost:" + MYSQL_PORT + "/";
    private static final String MSSQL_URL = "jdbc:microsoft:sqlserver://localhost:" + MSSQL_PORT + "/";
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:" + POSTGRES_PORT + "/";
    private static final String ORACLE_URL = "jdbc:oracle://localhost:" + ORACLE_PORT + "/";

    //DB Driver Names
    private static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String MSSQL_DRIVER_NAME = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
    private static final String POSTGRES_DRIVER_NAME = "org.postgresql.Driver";
    private static final String ORACLE_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

    private static final String DB_NAME = "fact";
    private static final String USERNAME = "niel";
    private static final String PASSWORD = "qjkleoiuws";
    
    static Connection conn = null;
    
    public static boolean Connect(){
        System.out.println("Conectandose a la base de datos...");
        String url = POSTGRES_URL;
        String dbName = DB_NAME;
        String driver = POSTGRES_DRIVER_NAME;
        String userName = USERNAME;
        String password = PASSWORD;
        try {
            Class.forName(driver).newInstance();
            Connection.conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Conectado a la base de datos");
            Connection.conn.close();
            System.out.println("Desconectado de la base de datos.");
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar conectarse con la base de datos");
            e.printStackTrace();
            return false;
        }
    }

    
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
}
