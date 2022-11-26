package dataAccessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionContext;

import models.Article;
import models.Articlesprix;
import models.Articlesstock;

public class ProductsAction {
	
	public List<Article> getAllProducts() throws Exception {
		Map<String, Object> sessionprod = ActionContext.getContext().getSession();
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articlesprix.class);
		Configuration configuration1 = new Configuration().configure("hibernateStock.cfg.xml").addAnnotatedClass(Articlesstock.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		SessionFactory sessionFactory1 = configuration1.buildSessionFactory();
		
			if (!sessionFactory.getCurrentSession().getTransaction().isActive() && !sessionFactory1.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().getTransaction().begin();
				sessionFactory1.getCurrentSession().getTransaction().begin();
			}
			Session session = sessionFactory.getCurrentSession();
			Session session1 = sessionFactory1.getCurrentSession();
			Query<Articlesprix> query=session.createQuery("from models.Articlesprix ");
			Query<Articlesstock> query1=session1.createQuery("from models.Articlesstock ");
			List<Articlesprix> list= query.getResultList();
			List<Articlesstock> list1=query1.getResultList();
			List<Article> listFinal=new ArrayList<Article>();
			int code;
			String nom;
			int prix;
			int qte;
			for(int i=0;i<list.size();i++) {
				code=list1.get(i).getCodeArt();
				 nom=list.get(i).getNomArt();
				 prix=list.get(i).getPrixArt();
				 qte=list1.get(i).getQteArt();
				Article article=new Article(code, nom, prix, qte);
				listFinal.add(article);
			}
			
			return listFinal;
	}

}
