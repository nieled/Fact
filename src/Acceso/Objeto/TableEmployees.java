/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Objeto;

import Acceso.Entidad.MasterEmployee;
import Acceso.Entidad.MasterTitle;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        while (rs.next()) {
            int empNo = rs.getInt(1);
            Date birthDate = rs.getDate(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String gender = rs.getString(5);
            Date hireDate = rs.getDate(6);
            ans = new MasterEmployee(empNo, birthDate, firstName, lastName, gender, hireDate);
        }
        return ans;
    }

    boolean insertEmployee(MasterEmployee me) {
        return false;
    }

    boolean updateEmployee(MasterEmployee me) {
        return false;
    }

    boolean deleteEmployee(int emp_no) {
        return false;
    }
}
