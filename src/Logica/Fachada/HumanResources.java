/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Fachada;

import Logica.Objeto.Hiring;

/**
 *
 * @author niel
 */
public class HumanResources {

    

    public Logica.Objeto.Hiring Contratar(int id) {
        Logica.Objeto.Hiring hiring = new Logica.Objeto.Hiring();
        hiring.getEmployee(id);
        return hiring;
    }
}
