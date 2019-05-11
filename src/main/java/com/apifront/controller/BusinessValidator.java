package com.apifront.controller;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.apifront.dao.SignUpDAO;
import com.apifront.pojo.API;
import com.apifront.pojo.Business;

public class BusinessValidator implements Validator{
	@Autowired
	SignUpDAO signupdao;
	public boolean supports(Class clazz) {
	    return BusinessValidator.class.equals(clazz);
	}




	


	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		API api=(API)target;
		
		
	}
}
