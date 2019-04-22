package com.apifront.dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.jboss.logging.Logger.Level;

import com.apifront.CustomException.UserException;
import com.apifront.pojo.API;
import com.apifront.pojo.Business;
import com.apifront.pojo.Services;
import com.apifront.pojo.User;;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	
	public List<Services> searchService(Services a) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Services where servicesName = :servicesName");
			q.setString("servicesName", a.getServicesName());
			
			List<Services> services = q.list();
			System.out.print("List fetched");
			commit();
			return services;
				
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Username Already exist");
		}
	}

	
	
	public User saveUser(User u) throws UserException {
		try {
			begin();

			getSession().merge(u);
			commit();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getName(), e);
		}
	}
}
