/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.employee;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author xmtig
 */
@Repository(value="employeeDao")
public class EmployeeDao {
    
    @PersistenceContext(name="derby_mem_JPA") private EntityManager em;
    
    @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
    public void persist(Employee employee){        
        em.persist(employee);
    }
    
    public List<Employee> getAllEmployee(){
        TypedQuery<Employee> query = em.createQuery("SELECT e1 from Employee e1 ORDER BY e1.id", Employee.class);
        
        return query.getResultList();
    }
}
