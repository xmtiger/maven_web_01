package com.mikex.guest;
 
import com.mikex.employee.Employee;
import com.mikex.employee.LoadDataService;
import java.io.IOException;
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
 
@Controller
@RequestMapping(value="/guest")
public class GuestController {
 
    @Autowired
    @Qualifier("guestDao")
    private GuestDao guestDao;
 
    @RequestMapping(value="")
    public @ResponseBody ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            guestDao.persist(new Guest(name));
 
        // Prepare the result view (guest.jsp):
        return new ModelAndView("/guest", "guestDao", guestDao);
               
    }
    
    @RequestMapping(value="/one")
    public String test01(Locale locale, Model model) throws JsonGenerationException, JsonMappingException, IOException{
               
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeList = LoadDataService.getEmployeeList();
        model.addAttribute("employeeList", mapper.writeValueAsString(employeeList));
	return "/DataTableJsp/dataTable02";
    }
    
    
}