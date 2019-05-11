package com.apifront.controller;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apifront.dao.DAO;
import com.apifront.dao.SignUpDAO;
import com.apifront.pojo.API;
import com.apifront.pojo.BasicDetails;
import com.apifront.pojo.Business;
import com.apifront.pojo.User;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	SignUpDAO signupdao;
	
	
	
	@RequestMapping(value = "/signup1.htm", method = RequestMethod.POST)
	public String homeSignIn(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		try
		{
//		User u=new User();
//		u.setUserName(request.getParameter("username"));
//		u.setName(request.getParameter("name"));
//		u.setUserPassword(request.getParameter("userpassword"));
//		signupdao.createUser(u);
//		Cookie username=new Cookie("username", u.getUserName());
//		Cookie userpassword=new Cookie("userpassword", u.getUserPassword());
//		response.addCookie(username);
//		response.addCookie(userpassword);
//		
		
		return "user";

		}
		catch(Exception ex) {
			logger.info(ex.getMessage());
			return "user";
		}
	}

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Business b=(Business)req.getSession().getAttribute("business");
		if(b==null)
		{
			User user=(User)req.getSession().getAttribute("user");
			if(user==null)
			{
			return "home";	
			}
			else
			{
				return "user";
			}
		}
		return "business";
		//return "home";
	}
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public void logout(Locale locale, Model model,HttpServletRequest req,HttpServletResponse res) {
	
		try
		{
			req.getSession().invalidate();
		res.sendRedirect("/controller/");
		}
		catch(Exception ex)
		{
			
		}
	}
	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
	public String homeRegister(Locale locale, Model model,HttpServletRequest req,HttpServletResponse res) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if(req.getParameter("type").equals("business")){
			
		Business b=new Business();
		b.setUserName(req.getParameter("userName"));
		b.setUserPassword(req.getParameter("userPassword"));
		b.setName(req.getParameter("name"));
		//BusinessValidator businessvalidator=new BusinessValidator();
		//businessvalidator.validate(b, errors);
		try
		{
		b=signupdao.createBusiness(b);
		req.getSession().setAttribute("business", b);
		return "business";
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
			try
			{
				model.addAttribute("error", "Username Exist");
				return "home";
			}
			catch(Exception ex)
			{
				return "error";

			}
		}
		}
		else
		{
			User u=new User();
			u.setUserName(req.getParameter("userName"));
			u.setUserPassword(req.getParameter("userPassword"));
			u.setName(req.getParameter("name"));

			try
			{
			u=signupdao.createUser(u);
			req.getSession().setAttribute("user", u);
			return "user";
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
				try
				{
					model.addAttribute("error", "Username Exist");
				return "home";

				}
				catch(Exception ex)
				{
					return "error";

				}

			}
		}
		
	}
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String loginPost(Locale locale, Model model,HttpServletRequest req) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if(req.getParameter("type").equals("business"))
		{
			try
			{
			Business b=new Business();
			b.setUserName(req.getParameter("userName"));
			b.setUserPassword(req.getParameter("userPassword"));
			b=signupdao.loginBusiness(b);
			if(b==null)
			{
				model.addAttribute("error", "Username or Wrong Password");
				return "home";
			}
			
			else
			{
			HttpSession session=req.getSession();
			session.setAttribute("business", b);
			return "business";
			
				
			}
			
			}
			catch(Exception ex)

		{
				
				model.addAttribute("error", "Username or Wrong Password");
				return "home";
		}
			
		}
		else
		{
			User u=new User();
			u.setUserName(req.getParameter("userName"));
			u.setUserPassword(req.getParameter("userPassword"));
			try
			{
			u=signupdao.loginUser(u);
			if(u==null)
			{
				model.addAttribute("error", "Username or Wrong Password");
				return "home";
			}
			else
			{
			HttpSession session=req.getSession();
			session.setAttribute("user", u);
			return "user";
			}
			}
			catch(Exception ex)
			{
				model.addAttribute("error", "Username or Wrong Password");
				return "home";
			}

		}
		
	}
	
}
