/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Objeto;

import Acceso.Entidad.MasterEmployee;
import Acceso.Entidad.MasterTitle;
import Resources.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.translation.messages_bg;

/**
 * Objeto de Acceso a datos para tabla Empleados
 *
 * @author niel
 */
public class TableEmployees {

    public MasterEmployee selectEmployee(int emp_no) throws SQLException {
        // List<MasterEmployee> ans = new ArrayList<MasterEmployee>();
        MasterEmployee ans = null;
        ResultSet rs = Resources.Conexion.getQuery("SELECT * FROM EMPLOYEES WHERE EMP_NO=" + emp_no);

        rs.next();
        int empNo = rs.getInt(1);
        Date birthDate = rs.getDate(2);
        String firstName = rs.getString(3);
        String lastName = rs.getString(4);
        String gender = rs.getString(5);
        Date hireDate = rs.getDate(6);
        ans = new MasterEmployee(empNo, birthDate, firstName, lastName, gender, hireDate);

        return ans;
    }

    public List<MasterEmployee> selectEmployees() throws SQLException {
        // List<MasterEmployee> ans = new ArrayList<MasterEmployee>();
        List<MasterEmployee> ans = new ArrayList<MasterEmployee>();
        ResultSet rs = Resources.Conexion.getQuery("SELECT * FROM EMPLOYEES");

        while (rs.next()) {
            int empNo = rs.getInt(1);
            Date birthDate = rs.getDate(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String gender = rs.getString(5);
            Date hireDate = rs.getDate(6);
            ans.add(new MasterEmployee(empNo, birthDate, firstName, lastName, gender, hireDate));
        }
        return ans;
    }

    public boolean insertEmployee(MasterEmployee me) throws SQLException {
        PreparedStatement pst = Conexion.prepStmt("INSERT INTO public.employees(emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?, ?, ?, ?, ?, ?);");
        pst.setInt(1, me.getEmp_no());
        pst.setDate(2, me.getBirth_date());
        pst.setString(3, me.getFirst_name());
        pst.setString(4, me.getLast_name());
        pst.setString(5, me.getGender());
        pst.setDate(6, me.getHire_date());
        pst.executeUpdate();
        return true;
    }

    public boolean updateEmployee(MasterEmployee me) throws SQLException {
        PreparedStatement pst = Conexion.prepStmt("UPDATE public.employees SET emp_no=?, birth_date=?, first_name=?, last_name=?, gender=?, hire_date=? WHERE emp_no=?;");
        pst.setInt(1, me.getEmp_no());
        pst.setDate(2, me.getBirth_date());
        pst.setString(3, me.getFirst_name());
        pst.setString(4, me.getLast_name());
        pst.setString(5, me.getGender());
        pst.setDate(6, me.getHire_date());
        // The emp_no value to change
        pst.setInt(7, me.getEmp_no());
        pst.executeUpdate();
        return true;
    }

    public boolean deleteEmployee(MasterEmployee me) throws SQLException {
        PreparedStatement pst = Conexion.prepStmt("DELETE FROM public.employees WHERE emp_no=?;");
        pst.setInt(1, me.getEmp_no());
        pst.executeUpdate();
        return true;
    }
    
    public boolean deleteEmployee(int empNum) throws SQLException {
        PreparedStatement pst = Conexion.prepStmt("DELETE FROM public.employees WHERE emp_no=?;");
        pst.setInt(1, empNum);
        pst.executeUpdate();
        return true;
    }
}
