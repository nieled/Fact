/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Entidad;

/**
 *
 * @author niel
 */
public class Title {

    private int emp_no;
    private String title;

    public Title() {
    }

    public Title(int emp_no, String title) {
        this.emp_no = emp_no;
        this.title = title;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
