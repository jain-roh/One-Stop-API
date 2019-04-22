package com.apifront.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginHandler {

	public static boolean Login(Cookie[] cookies) {
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equals("username")) {
				
			}
		}
		return true;
	}
	
}
