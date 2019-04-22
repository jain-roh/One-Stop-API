package com.apifront.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apifront.dao.APIServiceDAO;
import com.apifront.dao.BusinessDAO;
import com.apifront.dao.SignUpDAO;
import com.apifront.dao.UserDAO;
import com.apifront.pojo.API;
import com.apifront.pojo.Billing;
import com.apifront.pojo.User;

@Controller
public class CartController {
	@Autowired
	APIServiceDAO apidao;
	@Autowired
	UserDAO userdao;
	
	@RequestMapping(value = "/addapitobill.do", method = RequestMethod.POST)
	public String home(Locale locale, Model model, HttpServletRequest req) {
		
		User u=(User)req.getSession().getAttribute("user");

		if(u!=null)
		{
			try
			{
			int apiId=Integer.parseInt(req.getParameter("apiid"));
			
			
					API api=new API();
					api.setAPIId(apiId);
					System.out.println(api.getAPIId());
					api=apidao.searchAPI(api).get(0);
					System.out.println(api.getApiName());					
					u.getApi().add(api);
					userdao.saveUser(u);
					Billing billing=new Billing();
					billing.setApi(api);
					billing.setUser(u);
					billing.setStartDate(new Date());
					apidao.creatBilling(billing);
					System.out.println("Success from us");
					

					return "success";
			}
			catch(Exception ex)
			{
				System.out.print(ex.getMessage());
				return "error";
				
			}
			
		}
		return "error";
		//return "home";
	}

	
}
