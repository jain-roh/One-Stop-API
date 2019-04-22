package com.apifront.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.jboss.logging.Logger.Level;

import com.apifront.CustomException.UserException;
import com.apifront.pojo.API;
import com.apifront.pojo.Billing;
import com.apifront.pojo.Services;
import com.apifront.pojo.User;;

public class APIServiceDAO extends DAO {

	public APIServiceDAO() {
	}

	public List<API> searchAPI(API a) throws UserException {
		try {
			begin();
			Criteria countQuery = getSession().createCriteria(API.class).add(Example.create(a));
			countQuery.setProjection(Projections.rowCount());

			Query q = getSession().createQuery("from API");
			
			List<API> apis = q.list();
				System.out.print("List fetched");
				commit();
			return apis;
				
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Username Already exist");
		}
	}

	public long fetchApiCount(boolean active) throws UserException{
		try
		{
		API api=new API();
		api.setApiActive(active);
		
		begin();
		Criteria countQuery = getSession().createCriteria(API.class).add(Example.create(api));
		countQuery.setProjection(Projections.rowCount());
		//countQuery.setBoolean("active", active);
		Long countResults = (Long) countQuery.uniqueResult();
		commit();
		return countResults;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			throw new UserException(ex.getMessage());
		}
		
	}
	public List<API> fetchAPI(int lastPageNumber,int pageSize) throws UserException {
		try {

			begin();

			Query q = getSession().createQuery("from API");
			q.setFirstResult(lastPageNumber);
			q.setMaxResults(pageSize);
			
			List<API> apis = q.list();
System.out.print("List fetched");
commit();
			return apis;
				
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Username Already exist");
		}
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

	
	
	public API creatAPI(API a) throws UserException {
		try {
			begin();
			getSession().save(a);
			commit();
			return a;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public Billing creatBilling(Billing b) throws UserException {
		try {
			begin();
			getSession().save(b);
			commit();
			return b;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	public User creatService(User u) throws UserException {
		try {
			begin();
			getSession().save(u);
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
