package com.demoLogin.net;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	
	
@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView showUser(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("newUser");
		mav.addObject("newUser", new UserBean());
		return mav;
	}

	





@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("newUser") UserBean newUser) {
		
		System.out.println(newUser.getUsername());
		

		ModelAndView mav = null;
		mav = new ModelAndView("userRegistered");
		mav.addObject("msg", newUser.getUsername());
		
		return mav;
	}

}
