/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Objeto;

import Acceso.Entidad.MasterTitle;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de Acceso a datos para tabla Titles
 *
 * @author niel
 */
public class TableTitles {

    public List<MasterTitle> selectTitles(int emp_no) throws SQLException {
        List<MasterTitle> ans = new ArrayList<MasterTitle>();
        ResultSet rs = Resources.Conexion.getQuery("SELECT * FROM TITLES WHERE EMP_NO=" + emp_no);
        while (rs.next()) {
            int empNo = rs.getInt(1);
            String title = rs.getString(1);
            ans.add(new MasterTitle(empNo, title));
        }
        return ans;
    }

    boolean insertTitle(MasterTitle mt) {
        return false;
    }

    boolean updateTitle(MasterTitle mt) {
        return false;
    }

    boolean deleteTitle(MasterTitle mt) {
        return false;
    }
}
