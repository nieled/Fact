/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author niel
 */
public class Conexion {

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

    public static boolean Connect() {
        System.out.println("Conectandose a la base de datos...");
        String url = POSTGRES_URL;
        String dbName = DB_NAME;
        String driver = POSTGRES_DRIVER_NAME;
        String userName = USERNAME;
        String password = PASSWORD;
        try {
            Class.forName(driver).newInstance();
            Conexion.conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Conectado a la base de datos");
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar conectarse con la base de datos");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Disconnect() throws SQLException {
        Conexion.conn.close();
        System.out.println("Desconectado de la base de datos.");
        return true;
    }

    public static ResultSet getQuery(String query) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    
    public static boolean doQuery(String query) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        st.close();
        return true;
    }
    
    public static PreparedStatement prepStmt(String query) throws SQLException {
        PreparedStatement pst = conn.prepareStatement(query);
        return pst;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

}
