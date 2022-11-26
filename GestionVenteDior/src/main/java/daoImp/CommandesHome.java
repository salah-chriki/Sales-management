package daoImp;
// Generated Jun 1, 2022, 2:02:58 PM by Hibernate Tools 5.4.33.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import models.Commandes;

/**
 * Home object for domain model class Commandes.
 * 
 * @see dao.Commandes
 * @author Hibernate Tools
 */
public class CommandesHome {

	private static final Logger logger = Logger.getLogger(CommandesHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Commandes transientInstance) {
		logger.log(Level.INFO, "persisting Commandes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Commandes instance) {
		logger.log(Level.INFO, "attaching dirty Commandes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commandes instance) {
		logger.log(Level.INFO, "attaching clean Commandes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Commandes persistentInstance) {
		logger.log(Level.INFO, "deleting Commandes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Commandes merge(Commandes detachedInstance) {
		logger.log(Level.INFO, "merging Commandes instance");
		try {
			Commandes result = (Commandes) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Commandes findById(java.lang.Integer id) {
		logger.log(Level.INFO, "getting Commandes instance with id: " + id);
		try {
			Commandes instance = (Commandes) sessionFactory.getCurrentSession().get("dao.Commandes", id);
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

	public List findByExample(Commandes instance) {
		logger.log(Level.INFO, "finding Commandes instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("dao.Commandes")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
