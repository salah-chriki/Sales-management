package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dataAccessObject.LoginAction;
import dataAccessObject.ProductsAction;
import models.Article;
import models.Users;

public class AuthenticationController extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private LoginAction la = new LoginAction();
	private ProductsAction pa = new ProductsAction();
	private List<Article> listArticles = new ArrayList<Article>();
	private Users user = new Users();
	private String login;
	private String pass;
	private String confirmpassword;
	private String newPass;
	private String activeProducts;

	public LoginAction getLa() {
		return la;
	}

	public void setLa(LoginAction la) {
		this.la = la;
	}

	public ProductsAction getPa() {
		return pa;
	}

	public void setPa(ProductsAction pa) {
		this.pa = pa;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	// Login
	public String login() throws Exception {
		if (la.loginUser(login, pass) == null) {
			addFieldError("loginFail", "The user name or password are incorrect");
			return ERROR;

		} else {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("login", login);
			// display products after login
			listArticles = pa.getAllProducts();
			
			activeProducts="active";
			return SUCCESS;
		}
	}

	// Logout
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("login");

		return SUCCESS;
	}

	// Sign Up
	public String signup() {
		if (pass.equals(confirmpassword)) {
			Users user = new Users(login, pass);
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Users.class);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			if (la.getUserByLogin(login) == null) {
				session.save(user);
				tx.commit();

				return SUCCESS;
			} else {
				addFieldError("userExistError", "The user already exist");
				return ERROR;
			}
		} else {
			addFieldError("passwordError", "password isn't identical");
			return ERROR;
		}

	}

	//Changing the user password
	public String changeUserPassword() {
		Map<String, Object> sessionLogin = ActionContext.getContext().getSession();
		String login = (String) sessionLogin.get("login");
		user = la.getUserByLogin(login);

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		user = session.get(Users.class, user.getCodeUser());
		user.setPass(newPass);
		session.save(user);
		tx.commit();

		return SUCCESS;
	}

	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		super.addFieldError(fieldName, errorMessage);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	public String getActiveProducts() {
		return activeProducts;
	}

	public void setActiveProducts(String activeProducts) {
		this.activeProducts = activeProducts;
	}

}
