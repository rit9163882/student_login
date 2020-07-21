package com.journaldev.spring.controller;

import com.journaldev.spring.model.User;
import com.journaldev.spring.model.Stud;
import com.journaldev.spring.model.StudentProfiles;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

//import org.apache.logging.log4j.BasicConfigurator;
//import org.apache.logging.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {
//	static final Logger logger = LogManager.getLogger(HomeController.class);

	StudentProfiles SP=new StudentProfiles();
	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	InputStream stream = loader.getResourceAsStream("/config.properties");
	Properties prop = new Properties();


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		try{
			//load a properties file from class path, inside static method
			prop.load(stream);

			//get the property value and print it out
			System.out.println(prop.getProperty("user_jsp"));
			System.out.println(prop.getProperty("login_success_jsp"));

		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
//		logger.trace("We've just greeted the user!");
//		logger.debug("debug just greeted the user!");
//		logger.info("info just greeted the user!");
//		logger.warn("Warn just greeted the user!");
//		logger.error("error just greeted the user!");
//		logger.fatal("fatal just greeted the user!");

		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);



		Date tomdate = new Date(date.getTime()+(1000 * 60 * 60 * 24));

		String newdate = dateFormat.format(tomdate);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("tomorrow",newdate);
		return prop.getProperty("home_jsp");
	}
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        if(!user.checkValidity()){
//			logger.debug("Hello invalid user!");
            return prop.getProperty("Invalid_jsp");

        }
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userID", user.getUserID());
        model.addAttribute("emailID", user.getEmailID());
//		logger.debug("Hello valid user!");
        return prop.getProperty("user_jsp");
    }
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student() {
//        System.out.println("student Page Requested, Locale : "+locale);
        return prop.getProperty("student_jsp");
    }

	@RequestMapping(value = "/login_success", method = RequestMethod.POST)
	public String login_success(@Validated Stud st) throws Exception {
//		SP.working();
		SP.setStudProfiles(st);
		return prop.getProperty("login_success_jsp");
	}

	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
//	@ResponseBody
	public String student(@PathVariable("id") String id,Model model) throws Exception {
		Stud s1=SP.getStudProfiles(id);
		if(s1==null){
			return prop.getProperty("student_login_fail_jsp");
		}
//		s1.printStud();
		model.addAttribute("studName", s1.getStudName());
		model.addAttribute("studId", s1.getStudId());
		model.addAttribute("studClass", s1.getStudClass());
		return prop.getProperty("student_login_jsp");
	}


}
