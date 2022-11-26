package dataAccessObject;

import models.Users;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int codeUser;
	private String login;
	private String pass;

	public int getCodeUser() {
		return this.codeUser;
	}

	public void setCodeUser(int codeUser) {
		this.codeUser = codeUser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Users getUserByLogin(String login) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Session session = sessionFactory.getCurrentSession();
			Query<Users> query=session.createQuery("from models.Users us where us.login=:login");
			query.setString("login", login);
			return (Users) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}
	public Users loginUser(String login, String pass) {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Session session = sessionFactory.getCurrentSession();
			Query<Users> query=session.createQuery("from models.Users us where us.login=:login and us.pass=:pass");
			query.setString("login", login);
			query.setString("pass", pass);
			return (Users) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}


}