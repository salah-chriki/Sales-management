package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dataAccessObject.ClientsAction;
import dataAccessObject.OrdersAction;
import dataAccessObject.ProductsAction;
import models.Article;
import models.Articlesstock;
import models.Clients;
import models.Commandes;

public class OrdersController extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Commandes> ordersList = new ArrayList<Commandes>();
	List<Article> listArticles = new ArrayList<Article>();
	private Map<String, Object> session1;

	private int codeCmd;
	private String client;
	private int codeArt;
	private int qteCmd;
	private Date dateCmd;
	private List<Clients> clientsList = new ArrayList<Clients>();

	private String activeOrders;

	public List<Clients> getClientsList() {
		return clientsList;
	}

	public void setClientsList(List<Clients> clientsList) {
		this.clientsList = clientsList;
	}

	public int getCodeCmd() {
		return codeCmd;
	}

	public void setCodeCmd(int codeCmd) {
		this.codeCmd = codeCmd;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	public Map<String, Object> getSession() {
		return session1;
	}

	public void setSession(Map<String, Object> session) {
		this.session1 = session;
	}

	public List<Commandes> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Commandes> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
	public String execute() throws Exception {
		setActiveOrders("active");
		OrdersAction orders = new OrdersAction();
		this.ordersList = orders.getAllOrders();

		return SUCCESS;
	}

	public String addOrder() throws Exception {
		
		setActiveOrders("active");
		
		Configuration configurationStock = new Configuration().configure("hibernateStock.cfg.xml")
				.addAnnotatedClass(Articlesstock.class);
		SessionFactory sessionFactoryStock = configurationStock.buildSessionFactory();
		Session sessionStock = sessionFactoryStock.getCurrentSession();
		Transaction txStock = sessionStock.beginTransaction();

		// Subtracting quantity from stock table
		Articlesstock as = sessionStock.get(Articlesstock.class, codeArt);
		if (as.getQteArt() > qteCmd && qteCmd > 0) {
			
			Commandes cmd = new Commandes(client, codeArt, qteCmd, dateCmd);
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Commandes.class);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(cmd);
			tx.commit();

			OrdersAction orders = new OrdersAction();
			this.ordersList = orders.getAllOrders();

			int qte = as.getQteArt() - qteCmd;
			as.setQteArt(qte);
			sessionStock.saveOrUpdate(as);
			txStock.commit();
			return SUCCESS;
		} else {
			addFieldError("quantityError", "Enter a valide quantity");
			ProductsAction aa = new ProductsAction();
			this.listArticles = aa.getAllProducts();

			ClientsAction ca = new ClientsAction();
			this.clientsList = ca.getAllClients();
			return ERROR;
		}

	}

	public String editOrder() throws Exception {
		setActiveOrders("active");
		
		ProductsAction aa = new ProductsAction();
		this.listArticles = aa.getAllProducts();

		ClientsAction ca = new ClientsAction();
		this.clientsList = ca.getAllClients();
		session1 = ActionContext.getContext().getSession();
		session1.put("codeCmd", codeCmd);

		return SUCCESS;
	}

	public String editOrder2() throws Exception {
		
		setActiveOrders("active");
		
		session1 = ActionContext.getContext().getSession();
		int codeCmd = (int) session1.get("codeCmd");
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Commandes.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Commandes cmd = session.get(Commandes.class, codeCmd);
		cmd.setClient(client);
		cmd.setCodeArt(codeArt);
		cmd.setDateCmd(dateCmd);
		cmd.setQteCmd(qteCmd);
		session.saveOrUpdate(cmd);
		tx.commit();

		OrdersAction orders = new OrdersAction();
		this.ordersList = orders.getAllOrders();

		return SUCCESS;
	}

	public String addOrderLoader() throws Exception {

		setActiveOrders("active");
		
		ProductsAction aa = new ProductsAction();
		this.listArticles = aa.getAllProducts();

		ClientsAction ca = new ClientsAction();
		this.clientsList = ca.getAllClients();

		return SUCCESS;
	}

	public String deleteOrder() throws Exception {

		setActiveOrders("active");
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Commandes.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Commandes cmd = session.get(Commandes.class, codeCmd);
		session.delete(cmd);
		tx.commit();

		OrdersAction orders = new OrdersAction();
		this.ordersList = orders.getAllOrders();

		return SUCCESS;
	}

	public String getActiveOrders() {
		return activeOrders;
	}

	public void setActiveOrders(String activeOrders) {
		this.activeOrders = activeOrders;
	}

}
