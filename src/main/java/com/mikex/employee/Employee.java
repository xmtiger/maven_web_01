/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.employee;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
       
    @Id @GeneratedValue
    private Long id;

    private String Name;
    private String Desgination;
    private String Salary;
    private String Country;

    public Employee() {
    }
	
    public Employee(String name, String desgination, String salary, String country) {
            this.Name = name;
            this.Desgination = desgination;
            this.Salary = salary;
            this.Country = country;
    }

    public String getName() {
            return Name;
    }

    public void setName(String name) {
            this.Name = name;
    }

    public String getDesgination() {
            return Desgination;
    }

    public void setDesgination(String desgination) {
            this.Desgination = desgination;
    }

    public String getSalary() {
            return Salary;
    }

    public void setSalary(String salary) {
            this.Salary = salary;
    }

    public String getCountry() {
            return Country;
    }

    public void setCountry(String country) {
            this.Country = country;
    }
	
}