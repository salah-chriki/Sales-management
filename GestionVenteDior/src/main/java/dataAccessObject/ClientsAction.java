package dataAccessObject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import models.Clients;

public class ClientsAction {

	public List<Clients> getAllClients() {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clients.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from models.Clients";
		Query<Clients> query = session.createQuery(hql);
		List<Clients> clientsList = query.list();
		tx.commit();
		session.close();
		return clientsList;

	}

	public Clients getClientByEmail(String emailClient) {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clients.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Session session = sessionFactory.getCurrentSession();
			Query<Clients> query = session.createQuery("from models.Clients us where us.emailClient=:emailClient");
			query.setString("emailClient", emailClient);
			return query.uniqueResult();
		} catch (Exception e) {
			return null;
		}

	}

}
