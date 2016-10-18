/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Objeto;

import Acceso.Entidad.MasterEmployee;
import Acceso.Entidad.MasterTitle;
import Acceso.Objeto.QueryEmployees;
import Acceso.Objeto.TableEmployees;
import Acceso.Objeto.TableTitles;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto de negocio
 *
 * @author niel
 */
public class Hiring {

    TableEmployees te = new TableEmployees();
    TableTitles tt = new TableTitles();
    QueryEmployees qe = new QueryEmployees();

    public boolean createEmployee(MasterEmployee me) throws SQLException {
        te.insertEmployee(me);
        return true;
    }
    
    public boolean updateEmployee(MasterEmployee me) throws SQLException {
        te.updateEmployee(me);
        return true;
    }

    public boolean getEmployee(int id) {
        
        return false;
    }
    
    public List<MasterTitle> getTitles(int id) throws SQLException {
        return tt.selectTitles(id);
    }
    
    public boolean getEmployees(){
        return false;
    }

    
    
    public boolean deleteEmployee(int empID) throws SQLException {
        te.deleteEmployee(empID);
        return true;
    }

    public List<MasterEmployee> getMasterEmployees() throws SQLException {
        List<MasterEmployee> ans =  te.selectEmployees();
        return ans;
    }
    
}