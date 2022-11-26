package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dataAccessObject.ClientsAction;
import models.Clients;

public class ClientsController extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Clients> clientsList = new ArrayList<Clients>();
	ClientsAction ca = new ClientsAction();
	private int codeClient;
	private String nameClient;
	private String emailClient;
	private String addressClient;
	private String telClient;
	private String activeClients;
	
	
	

	public ClientsAction getCa() {
		return ca;
	}

	public void setCa(ClientsAction ca) {
		this.ca = ca;
	}


	public List<Clients> getClientsList() {
		return clientsList;
	}

	public void setClientsList(List<Clients> clientsList) {
		this.clientsList = clientsList;
	}

	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getAddressClient() {
		return addressClient;
	}

	public void setAddressClient(String addressClient) {
		this.addressClient = addressClient;
	}

	public String getTelClient() {
		return telClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public String addClient() {
		setActiveClients("active");
		if (ca.getClientByEmail(emailClient) != null) {
			addFieldError("clientExistError", "Client already exist");
			return ERROR;
		} else {
			
			Clients client = new Clients(nameClient, emailClient, addressClient, telClient);
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Clients.class);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(client);
			tx.commit();
			session.close();

			// Display Clients
			this.clientsList = ca.getAllClients();

			return SUCCESS;
		}
	}

	public String deleteClient() {
		
		setActiveClients("active");
		Clients client;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clients.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		client = session.get(Clients.class, codeClient);
		session.delete(client);
		tx.commit();
		session.close();

		//Displaying clients after deleting the client
		this.clientsList = ca.getAllClients();

		return SUCCESS;
	}

	public String displayClients() throws Exception {
		
		setActiveClients("active");
		this.clientsList = ca.getAllClients();
		return SUCCESS;
	}

	public String editClient() {

			setActiveClients("active");
			Map<String, Object> sessionLogin = ActionContext.getContext().getSession();
			int codeClient = (int) sessionLogin.get("codeClient");
			Clients client;
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Clients.class);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			client = session.get(Clients.class, codeClient);
			client.setEmailClient(emailClient);
			client.setNameClient(nameClient);
			client.setAddressClient(addressClient);
			client.setTelClient(telClient);
			session.save(client);
			tx.commit();
			session.close();

			// display CLients
			this.clientsList = ca.getAllClients();
			return SUCCESS;
	}

	public String redirect() {
		setActiveClients("active");
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("codeClient", codeClient);
		return SUCCESS;
	}

	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		super.addFieldError(fieldName, errorMessage);
	}

	public String getActiveClients() {
		return activeClients;
	}

	public void setActiveClients(String activeClients) {
		this.activeClients = activeClients;
	}

}
