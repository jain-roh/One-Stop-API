package com.apifront.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.apifront.CustomException.UserException;
import com.apifront.pojo.Business;
import com.apifront.pojo.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
public class SignUpDAO extends DAO {

	public SignUpDAO() {
	}

	public User createUser(User u) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userName = :userName");
			q.setString("userName", u.getUserName());
			User user = (User) q.uniqueResult();
			if(user!=null) {
				commit();
				throw new UserException("Username Already exist" + u.getUserName());
			}else
			{
				commit();
				return register(u);
			}
				
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Username Already exist");
		}
	}
	public Business createBusiness(Business b) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Business where userName = :userName");
			q.setString("userName", b.getUserName());
			Business user = (Business) q.uniqueResult();
			if(user!=null) {
				commit();
				throw new UserException("Username Already exist" + b.getUserName());
			}else
			{
				commit();
				return registerBusiness(b);
			}
				
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Username Already exist");
		}
	}
	
	public boolean searchBusiness(Business b) throws UserException {
		begin();
		Query q = getSession().createQuery("from Business where userName = :userName");
		q.setString("userName", b.getUserName());
		Business user = (Business) q.uniqueResult();
		if(user!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public List<Business> fetchBusiness() throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Business");
			//q.setString("userName", b.getUserName());
			List<Business> business = q.list();
			return business;
				
		} catch (HibernateException e) {
			rollback();
			throw e;
			//throw new UserException("Username Already exist");
		}
	}
	
	
	public List<User> fetchUser() throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User");
			//q.setString("userName", b.getUserName());
			List<User> user = q.list();
			return user;
				
		} catch (HibernateException e) {
			rollback();
			throw e;
			//throw new UserException("Username Already exist");
		}
	}
	public User register(User u) throws UserException {
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
	public Business registerBusiness(Business u) throws UserException {
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
	public Business loginBusiness(Business b) throws UserException
	{
		try {
			begin();
			Criteria cr = getSession().createCriteria(Business.class);
			cr.add(Restrictions.eq("userPassword", b.getUserPassword()));
			cr.add(Restrictions.eq("userName", b.getUserName()));
			
			Business user = (Business) cr.uniqueResult();
			if(user==null) {
				throw new UserException("Username Login Failed" + b.getUserName());
			}else
			{
				System.out.print(user.getUserId());
				return user;
			}
				
		} catch (HibernateException e) {
			throw new UserException("Error Loggin In");
		}

	}
	public User loginUser(User u) throws UserException
	{
		try {
			begin();
			Criteria cr = getSession().createCriteria(User.class);
			cr.add(Restrictions.eq("userPassword", u.getUserPassword()));
			cr.add(Restrictions.eq("userName", u.getUserName()));
			
			User user = (User) cr.uniqueResult();
			if(user==null) {
				throw new UserException("Username Login Failed" + u.getUserName());
			}else
			{
				return user;
			}
				
		} catch (HibernateException e) {
			throw new UserException("Error Loggin In");
		}

	}

}
