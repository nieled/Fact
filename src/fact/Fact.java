/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact;

import Acceso.Entidad.MasterTitle;
import Logica.Fachada.HumanResources;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author niel
 */
public class Fact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            Resources.Conexion.Connect();
            HumanResources hr = new HumanResources();
            System.out.println("Success!\nIngrese el codigo de empleado: \n");
            int x = new java.util.Scanner(System.in).nextInt();
            System.out.println(hr.Contratar(x).masterEmployees.get(0).toString());
            Resources.Conexion.Disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Fact.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        ResultSet rs = Resources.Conexion.getQuery("SELECT * FROM TITLES");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + " " + columnValue );
            }
            System.out.println("");
        }
        return null;
         */
    }

}
