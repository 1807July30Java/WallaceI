package com.revature.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		try {
			// init(sf);
			// getVsLoad(sf);
			// saveVsPersist(sf);
			updateVsMerge(sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sf.close();
	}

	static void init(SessionFactory sf) {
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		Bear b1 = new Bear("Polo", new Cave(50, "Queens", 7), new BearType(50, "Grizzly", "lol"), 500);
		s.save(b1);

		tx.commit();

		s.close();
	}

	static void getVsLoad(SessionFactory sf) {
		Session s = sf.openSession();

		Bear b = (Bear) s.load(Bear.class, 2850);
		System.out.println(b);

		Cave c = (Cave) s.get(Cave.class, 50);
		c.getBears();

		s.close();

		// watch out for LazyInitializationException!!
		// System.out.println(c.getBears());

		// because we accessed the proxy within the session, this works
		System.out.println(b);
	}

	static void saveVsPersist(SessionFactory sf) {
		Session s = sf.openSession();
		// Transaction tx = s.beginTransaction();

		// save(): return the generated PK, object is not necessarily
		// immediately persistent.
		// Cave c = new Cave("Utah", 4);
		// int newId = (int) s.save(c);
		// System.out.println(s.get(Cave.class, newId));

		// persist(): take a transient object and immediately make it persistent
		// void return type, so no PK immediately given
		// requires a tx. declaration to execute

		BearType bt = new BearType("Polar", "add greenhouse gases to atmosphere");
		s.persist(bt);

		// tx.commit();

		s.close();
	}

	static void updateVsMerge(SessionFactory sf) {

		// c is in transient state
		Cave c = new Cave("Brooklyn", 3);
		System.out.println(c);

		Session s1 = sf.openSession();
		Transaction tx1 = s1.beginTransaction();
		s1.persist(c); // c is in persistent state
		tx1.commit();
		s1.close();

		// c is in detached state
		System.out.println(c);

		Session s2 = sf.openSession();
		Transaction tx2 = s2.beginTransaction();
		try {
			
			Cave c2 = (Cave) s2.get(Cave.class, c.getId());
			
			//c2 is persistent and has same persistence identity as 
			//detached object c
			
			c.setName("Brooklyn 2.0"); //c is still detached 
			
			//reattach to s2
			//s2.update(c);
			//oh no!! NonUniqueObjectException
			
			//merge is fine
			s2.merge(c);
			
			System.out.println(c2);
			
			tx2.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx2.rollback();
		}
		s2.close();
	}
	
	static void funWithNamedQuery(SessionFactory sf) {
		Session s = sf.openSession();
		Query q = s.getNamedQuery("findBearsByType");
		q.setInteger("typeVar", 75);
		List<Bear> bl = q.list();
		System.out.println(bl.size());
		Iterator<Bear> itr = bl.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
		}
		s.close();
	}
	
	static void funwithCascadesAndCacheing(SessionFactory sf) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Cave  c = (Cave) s.get(Cave.class, 175);
		BearType bt = (BearType) s.get(BearType.class, 75);
		Bear b = new Bear("Ferdinand", c, bt, 400);
		//is  in the cache?
		System.out.println(s.contains(c));
		//remove from the cache
//		s.evict(c);
//		System.out.println(s.contains(c));
		s.persist(b);
		Bear b2 = new Bear("Marco2", new Cave("Bronx",6),bt,100);
		tx.commit();
		s.close();
	}
	
	

}
