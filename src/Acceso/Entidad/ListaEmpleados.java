/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso.Entidad;

import java.sql.Date;

/**
 *
 * @author niel
 */
public class ListaEmpleados {
    private int emp_no;
    private Date birth_date;
    private String first_name, last_name;
    private String gender;
    private Date hire_date;
    private String title;

    public ListaEmpleados() {
    }

    public ListaEmpleados(int emp_no, Date birth_date, String first_name, String last_name, String gender, Date hire_date, String title) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
        this.title = title;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ListaEmpleados{" + "emp_no=" + emp_no + ", birth_date=" + birth_date + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender + ", hire_date=" + hire_date + ", title=" + title + '}';
    }
    
    
}
