package com.apifront.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.apifront.dao.APIServiceDAO;
import com.apifront.dao.DAO;
import com.apifront.dao.SignUpDAO;
import com.apifront.pojo.API;
import com.apifront.pojo.BasicDetails;
import com.apifront.pojo.Billing;
import com.apifront.pojo.Business;
import com.apifront.pojo.User;
import com.apifront.controller.MyPdfViewImpl;

/**
 * Handles requests for the application home page.
 */

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	SignUpDAO signupdao;
	
	@Autowired
	APIServiceDAO apidao;
	
	@RequestMapping(value = "/businessList", method = RequestMethod.GET)
	public String showBusiness(HttpServletRequest request, Model model) {
		//command object
		
		//model.addAttribute("applicant", applicant);
		try
		
		{
		List<Business> business=signupdao.fetchBusiness();
		model.addAttribute("business", business);
		}
		catch(Exception ex)
		{
			return "error";
		}
		return "businessList";
	}	
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String showBuser(HttpServletRequest request, Model model) {
		//command object
		
		//model.addAttribute("applicant", applicant);
		try
		
		{
		List<User> user=signupdao.fetchUser();
		model.addAttribute("user", user);
		}
		catch(Exception ex)
		{
			return "error";
		}
		return "userList";
	}	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showAdmin(HttpServletRequest request, Model model) {
		//command object
		
		//model.addAttribute("applicant", applicant);
		
		return "admin";
	}
	@RequestMapping(value = "/music-service", method = RequestMethod.GET)
	public String showService(HttpServletRequest request, Model model) {
	return "music-service";
	}
	
}
