/**
 * 
 */
package com.demo.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.demo.hibernate.beans.User;
import com.demo.hibernate.util.HibernateSessionFactory;

/**
 * @author yangsatiago
 *
 */
public class UserDAO {

	public User getUser(String username)
	{
		Session session = null;
		Transaction tx = null;
		User user = null;
		
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from User where username=?");
			query.setString(0, username.trim());
			user = (User)query.uniqueResult();
			query = null;
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("错误");
			e.printStackTrace();
			if(tx != null)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		
		return user;
	}
}
