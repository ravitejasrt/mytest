package com.nareshit.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
private static SessionFactory sessionFactory;
static{
	Configuration cfg=new Configuration();
	cfg.configure("com/nareshit/cfg/hibernate.cfg.xml");
	sessionFactory=cfg.buildSessionFactory();
}
public static Session getSession(){
	Session session=null;
	if(sessionFactory!=null){
		session=sessionFactory.openSession();
	}
	return session;
}
}
