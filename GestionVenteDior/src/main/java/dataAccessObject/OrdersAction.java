package dataAccessObject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import models.Articlesprix;
import models.Commandes;

public class OrdersAction {
	
	public List<Commandes> getAllOrders() throws Exception {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Commandes.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from models.Commandes";
		Query<Commandes> query = session.createQuery(hql);
		List<Commandes> ordersList = query.list();
		tx.commit();
		session.close();
		return ordersList;
	}
	
	
}
