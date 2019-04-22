package com.apifront.controller;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apifront.dao.APIServiceDAO;
import com.apifront.dao.BusinessDAO;
import com.apifront.dao.DAO;
import com.apifront.dao.SignUpDAO;
import com.apifront.pojo.API;
import com.apifront.pojo.BasicDetails;
import com.apifront.pojo.Business;
import com.apifront.pojo.Services;
import com.apifront.pojo.User;


/**
 * Handles requests for the application home page.
 */
@Controller
public class APIservicesController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	APIServiceDAO apidao;
	@Autowired
	BusinessDAO businessdao;
	
	@RequestMapping(value = "/addapi.do", method = RequestMethod.GET)
	public String addApi(Locale locale, Model model,HttpServletRequest req,HttpServletResponse response) 
		{
		
//		Business b=new Business();
//		b.setBusinessId(1);
//		try
//		{
//		b=businessdao.searchBusiness(b);
//		
//		}
//		catch(Exception ex)
//		{
//			
//		}
//		API api=new API();
//		api.setAPIId(3);
//		api.setApiActive(true);
//		
//		model.addAttribute("API",new API());
		Business b=(Business)req.getSession().getAttribute("business");
		if(b==null)
		{
			return "home";

		}
		else
		{
			
			model.addAttribute("API",new API());
			return "addapi";
		}
		}
	@RequestMapping(value = "/addapi.do", method = RequestMethod.POST)
	public String addApiDO(Locale locale, Model model, @ModelAttribute("API") API api,HttpServletRequest req) 
		{
	
		Business b=(Business)req.getSession().getAttribute("business");
		try
		{
		//b=businessdao.searchBusiness(b);
			
		//b.getApi().add(api);
		api.setBusiness(b);
		api.setApiActive(true);
		apidao.creatAPI(api);
		
		//businessdao.saveBusiness(b);
		return "business";
		}
		catch(Exception ex)
		{
			System.out.print(ex.getMessage());
			return "api";
		}
		
			
		}
	
	
	@RequestMapping(value = "/apilist.htm", method = RequestMethod.GET)
	public ModelAndView apiList(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		try
		{
			int pageNum;
			long maxCount=apidao.fetchApiCount(true);
			boolean showNext=true;
			boolean showPrev=false;
			int nextPageNum;
			int prevpageNum;
			if(request.getParameter("q")!=null)
			{
				pageNum=Integer.parseInt(request.getParameter("q"));
			}
			else
			{
				pageNum=0;
			//pageNum=apidao.fetchApiCount(true);
			}
			
			if(((pageNum+1)*12)>=maxCount)
			{
				showNext=false;
			}
			
			if((pageNum*12)>0)
			{
				showPrev=true;
			}
			nextPageNum=pageNum+1;
			prevpageNum=pageNum-1;
			List<API> apis=apidao.fetchAPI(pageNum*12,12);

		
		

			ModelAndView mv=new ModelAndView("apilist");
			mv.addObject("nextD", showNext);
			mv.addObject("prevD", showPrev);
			mv.addObject("nextPage", nextPageNum);
			mv.addObject("prevPage", prevpageNum);
			mv.addObject("apis",apis);

		return mv;
}
catch(Exception ex)
{
	System.out.print(ex.getMessage());
	return new ModelAndView("home");
}

		}
		
	

	@RequestMapping(value = "/api.htm", method = RequestMethod.GET)
	public ModelAndView apiView(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		try
		{
			User u=(User)request.getSession().getAttribute("user");

			int apiId=Integer.parseInt(request.getParameter("q"));
			API api=new API();
			api.setAPIId(apiId);
		
			api=apidao.searchAPI(api).get(0);
			if(api==null)
			{
				return new ModelAndView("error");
			}
			else
			{
			ModelAndView mv=new ModelAndView("api");
			mv.addObject("api", api);
			mv.addObject("user", u);

			return mv;
			}

}
catch(Exception ex)
{
	System.out.print(ex.getMessage());
	return new ModelAndView("home");
}

		}
		

	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public ModelAndView homeSignIn(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		try
		{
		API a=new API();
		a.setApiName(request.getParameter("q"));

		
		List<API> apis=apidao.searchAPI(a);
		Services s=new Services();
		s.setServicesName(request.getParameter("q"));
		
		

		List<Services> services=apidao.searchService(s);
		ModelAndView mv=new ModelAndView("search");
		mv.addObject("apis",apis);
		mv.addObject("services",services);

		return mv;

		}
		catch(Exception ex) {
			logger.info(ex.getMessage());
			return new ModelAndView("search");

		}
	}

	
}
