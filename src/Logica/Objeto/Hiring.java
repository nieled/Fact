/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Objeto;

import Acceso.Entidad.MasterEmployee;
import Acceso.Entidad.MasterTitle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contrataciones
 *
 * @author niel
 */
public class Hiring {

    public List<MasterEmployee> masterEmployees = new ArrayList<MasterEmployee>();

    public boolean createEmployee() {
        return false;
    }

    public boolean getEmployee(int id) {
        try {
            Acceso.Objeto.TableEmployees te = new Acceso.Objeto.TableEmployees();
            this.masterEmployees.add(te.selectEmployee(id));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Hiring.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deleteEmployee() {
        return false;
    }
}
