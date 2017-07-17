/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.employee;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author xmtig
 */
@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
    
    static int iCount = 0;
    
    public EmployeeController() {
        
    }   
    
    @Autowired
    @Qualifier("employeeDao")
    private EmployeeDao employeeDao;
    
    @RequestMapping(value="")
    public String empolyeeTable(Locale locale, Model model)throws JsonGenerationException, JsonMappingException, IOException{       
        
        if(iCount ==0){
            addInitialData_test();
            iCount++;
        }            
        
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = employeeDao.getAllEmployee();
        model.addAttribute("employeeList", mapper.writeValueAsString(employeeList));
	return "/employee/dataTable";
    }
    
    private void addInitialData_test(){
        List<Employee> employeeList = LoadDataService.getEmployeeList();
        int id = 0;
        
        Iterator<Employee> iter = employeeList.iterator();
        while(iter.hasNext()){
            
            Employee employee = iter.next();
            employeeDao.persist(employee);
            
        }       
    }
}
