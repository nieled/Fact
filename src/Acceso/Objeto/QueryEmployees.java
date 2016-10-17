/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Objeto;

import Acceso.Entidad.ListaEmpleados;
import Resources.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Objeto de Acceso a datos para querys de Empleados
 * @author niel
 */
public class QueryEmployees {
    public ListaEmpleados searchByID(int id) throws SQLException {
        PreparedStatement pst = Conexion.prepStmt("SELECT * FROM public.employees, public.titles WHERE public.employees.emp_no=public.titles.emp_no;");
        ResultSet rs = pst.executeQuery();
        rs.next();
        ListaEmpleados le = new ListaEmpleados(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(8));
        return le;
    }
    
    public ListaEmpleados searchByName(String name){
        return null;
    }
}
