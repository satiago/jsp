/**
 * 
 */
package com.demo.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;;

/**
 * @author yangsatiago
 *
 */
public class HibernateSessionFactory {

	private static String CONFIG_FILE = "Hibernate.cfg.xml";
	private static final ThreadLocal threadlocal = new ThreadLocal();
	private static final Configuration cfg = new Configuration();
	private static SessionFactory sessionFactory;

	public static Session currentSession()
	{
		Session session = (Session) threadlocal.get();
		if(session == null)
		{
			if(sessionFactory == null)
			{
				try {
					cfg.configure(CONFIG_FILE);
					ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
					sessionFactory = cfg.buildSessionFactory(serviceregistry);
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			session = sessionFactory.openSession();
			threadlocal.set(session);
		}

		return session;
	}

	public static void closeSession()
	{
		Session session = (Session) threadlocal.get();
		threadlocal.set(null);
		if(session != null)
		{
			session.close();
		}
	}
}
