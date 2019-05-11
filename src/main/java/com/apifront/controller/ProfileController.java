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
import java.util.Set;

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
import com.apifront.pojo.Services;
import com.apifront.pojo.User;
import com.apifront.controller.MyPdfViewImpl;

/**
 * Handles requests for the application home page.
 */

@Controller
public class ProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	SignUpDAO signupdao;
	
	@Autowired
	APIServiceDAO apidao;
	@RequestMapping(value = "/image/upload.htm", method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, Model model) {
		//command object
		
		//model.addAttribute("applicant", applicant);
		Business business=(Business) request.getSession().getAttribute("business");
		model.addAttribute("business",business);
		return "uploadprofileImage";
	}
	@RequestMapping(value = "/image/upload.htm", method = RequestMethod.POST)
	public String handleUpload(@ModelAttribute("business") Business business,BindingResult result,HttpServletRequest request) throws IllegalStateException, IOException {
		//String locaLpath="C:\\Users\\balak\\OneDrive\\Desktop\\Webtools_Lab";
if(result.hasErrors())
{
	System.out.print("Errors");
}
		String locaLpath = "/Users/rohitjain/Documents/uploadedimage/";
		if(business.getPhoto()==null)
		{
			System.out.println("Null Photo");
			System.out.print(business.getName());
		}
		String photoNewName = generateFileName(business.getPhoto());
		
		business.getPhoto().transferTo(new File(locaLpath, photoNewName));
		
		//String resumeNewName = generateFileName(applicant.getResume());
		try
		{
			business.setImageName(photoNewName);
		signupdao.registerBusiness(business);
		}
		catch(Exception ex)
		{
			
		}
		
		return "job-success";
	}
	
	
	private String generateFileName(MultipartFile multiPart) {
		
		return new Date().getTime() + "-" + multiPart.getName().replace(" ", "_");
	}
	
	public String uploadFile(MultipartFile multipartFile) throws Exception {
		String fileName = generateFileName(multipartFile);
		String uploadDir = "uploads/";
		String filePath = uploadDir + fileName;
		try {
			File file = new File(filePath);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();
		} catch (Exception e) {
			throw e;
		}

		return filePath;

	}
	
	@RequestMapping(value = "/uploadImage.htm", method = RequestMethod.POST)
	public String imageChange(Locale locale, Model model,HttpServletRequest req) {
		
		
		
		return "";
	}	
	
	
	@RequestMapping(value = "/lastMonthReport.pdf", method = RequestMethod.GET)
	public View report(Locale locale, Model model,HttpServletRequest req) {
		
	User user=(User)req.getSession().getAttribute("user");
	Billing b=new Billing();
	b.setUser(user);
	b.setPaid(false);
	b.setBilled(true);
	List<Billing> billings=null;
	try
	{
	billings=apidao.searchBilling(b);
	System.out.print(billings.size());
	}
	catch(Exception ex)
	{
		System.out.println("Error");
	}
	View view=new MyPdfViewImpl(billings);
	return view;
	}
	
	@RequestMapping(value = "/apiUses.do", method = RequestMethod.GET)
	public String apiUses(Locale locale, Model model,HttpServletRequest req,HttpServletResponse res) {
	User user=(User)req.getSession().getAttribute("user");
	if(user==null)
	{
		if(req.getSession().getAttribute("business")==null)
		{
			return "home";
		}
	}
	
	try
	{
		Set<API> apis=user.getApi();
		model.addAttribute("api", apis);
	}
	catch(Exception ex)
	{
		System.out.println("Error");
	}
	return "apiUses";
	}
		
	
	@RequestMapping(value = "/apiBusinessList.do", method = RequestMethod.GET)
	public String apiBusinessUses(Locale locale, Model model,HttpServletRequest req) {
	Business user=(Business)req.getSession().getAttribute("business");
	System.out.print(user.getName());
	if(user==null)
	{
		
			return "home";
		
	}
	
	
	try
	{
		Set<API> apis=user.getApi();
		model.addAttribute("api", apis);
	}
	catch(Exception ex)
	{
		System.out.println("Error");
	}
	return "apiBusinessList";
	}
		
		
}
