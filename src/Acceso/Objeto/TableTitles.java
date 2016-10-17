/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Objeto;

import Acceso.Entidad.MasterTitle;
import Resources.Conexion;
import java.sql.Connection;
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
    
    public List<MasterTitle> selectTitles(MasterTitle mt) throws SQLException {
        List<MasterTitle> ans = new ArrayList<MasterTitle>();
        ResultSet rs = Resources.Conexion.getQuery("SELECT * FROM TITLES WHERE EMP_NO=" + mt.getEmp_no());
        while (rs.next()) {
            int empNo = rs.getInt(1);
            String title = rs.getString(1);
            ans.add(new MasterTitle(empNo, title));
        }
        return ans;
    }

    public boolean insertTitle(MasterTitle mt) throws SQLException {
        Conexion.doQuery("INSERT INTO public.titles(emp_no, title) VALUES ("
                + mt.getEmp_no() + ", "
                + "\'" + mt.getTitle() + "\'"
                + ");");
        return true;
    }

    public boolean updateTitle(MasterTitle oldone, MasterTitle newone) throws SQLException {
        Conexion.doQuery("UPDATE public.titles SET "
                + "emp_no=" + newone.getEmp_no() + ", "
                + "title=\'" + newone.getTitle() + "\' "
                + "WHERE "
                + "emp_no=" + oldone.getEmp_no()
                + " AND title=\'" + oldone.getTitle() + "\'"
                + ";");
        return true;
    }

    public boolean deleteTitle(MasterTitle mt) throws SQLException {
        Conexion.doQuery("DELETE FROM public.titles "
                + "WHERE "
                + "emp_no=" + mt.getEmp_no()
                + " AND title=\'" + mt.getTitle() + "\'"
                + ";");
        return true;
    }
}
