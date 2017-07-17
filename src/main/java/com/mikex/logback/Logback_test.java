/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author xmtig
 */
@Controller
@RequestMapping(value = "/log_test", method = RequestMethod.GET)
public class Logback_test {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Logback_test.class);
    
    @RequestMapping(value = "")
    public String testLogback(Model model){
        
        LOGGER.debug("testlogback() is executed+++++++++++++++++++========================******************************");
        
        LOGGER.error("this is a test error", new Exception("Testing logback"));
        
        model.addAttribute("msg_logback", "Spring Mvc logback");
        
        return "index";
    }
}
