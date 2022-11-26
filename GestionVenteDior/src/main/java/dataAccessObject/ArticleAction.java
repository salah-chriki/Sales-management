package dataAccessObject;


import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import models.Articlesprix;
import models.Articlesstock;


public class ArticleAction {
	private int codeArt;
	private String nomArt;
	private String descArt;
	private int prixArt;

	public int getCodeArt() {
		return this.codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}

	public String getNomArt() {
		return this.nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	public String getDescArt() {
		return this.descArt;
	}

	public void setDescArt(String descArt) {
		this.descArt = descArt;
	}

	public int getPrixArt() {
		return this.prixArt;
	}

	public void setPrixArt(int prixArt) {
		this.prixArt = prixArt;
	}

	public List<Articlesprix> getAllProducts() throws Exception {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Articlesprix.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from models.Articlesprix";
		Query<Articlesprix> query = session.createQuery(hql);
		List<Articlesprix> productList = query.list();
		tx.commit();
		session.close();
		return productList;
	}
	
public Articlesprix getArticleById(int codeArt) throws Exception {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Articlesprix.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Articlesprix article = session.get(Articlesprix.class,codeArt);
		tx.commit();
		return article;
	}

public Articlesstock getArticleStockById(int codeArt) throws Exception {
	
	Configuration configuration = new Configuration().configure("hibernateStock.cfg.xml")
			.addAnnotatedClass(Articlesstock.class);
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction tx = session.beginTransaction();
	
	Articlesstock article = session.get(Articlesstock.class,codeArt);
	tx.commit();
	return article;
}

	public Articlesprix find(int id) {
		Articlesprix ap = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Articlesprix.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).getBootstrapServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        ap = (Articlesprix) session.get(Articlesprix.class, id);
        
        tx.commit();
        return ap;}

//		Session session = null;
//		ArticlesPrix ap = null;
//		try {
//			Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
//					.addAnnotatedClass(ArticlesPrix.class);
//			SessionFactory sessionFactory = configuration.buildSessionFactory();
//			session = sessionFactory.getCurrentSession();
//			ap = session.get(ArticlesPrix.class, id);
//			Hibernate.initialize(ap);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (session != null && session.isOpen()) {
//				session.close();
//			}
//		}
//		return ap;
//	}
}
