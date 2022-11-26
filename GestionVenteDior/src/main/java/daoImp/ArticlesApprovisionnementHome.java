package daoImp;
// Generated Jun 1, 2022, 2:02:58 PM by Hibernate Tools 5.4.33.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import models.ArticlesApprovisionnement;

/**
 * Home object for domain model class ArticlesApprovisionnement.
 * 
 * @see dao.ArticlesApprovisionnement
 * @author Hibernate Tools
 */
public class ArticlesApprovisionnementHome {

	private static final Logger logger = Logger.getLogger(ArticlesApprovisionnementHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ArticlesApprovisionnement transientInstance) {
		logger.log(Level.INFO, "persisting ArticlesApprovisionnement instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ArticlesApprovisionnement instance) {
		logger.log(Level.INFO, "attaching dirty ArticlesApprovisionnement instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(ArticlesApprovisionnement instance) {
		logger.log(Level.INFO, "attaching clean ArticlesApprovisionnement instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(ArticlesApprovisionnement persistentInstance) {
		logger.log(Level.INFO, "deleting ArticlesApprovisionnement instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public ArticlesApprovisionnement merge(ArticlesApprovisionnement detachedInstance) {
		logger.log(Level.INFO, "merging ArticlesApprovisionnement instance");
		try {
			ArticlesApprovisionnement result = (ArticlesApprovisionnement) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public ArticlesApprovisionnement findById(int id) {
		logger.log(Level.INFO, "getting ArticlesApprovisionnement instance with id: " + id);
		try {
			ArticlesApprovisionnement instance = (ArticlesApprovisionnement) sessionFactory.getCurrentSession()
					.get("dao.ArticlesApprovisionnement", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(ArticlesApprovisionnement instance) {
		logger.log(Level.INFO, "finding ArticlesApprovisionnement instance by example");
		try {
			List<?> results = sessionFactory.getCurrentSession().createCriteria("dao.ArticlesApprovisionnement")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
