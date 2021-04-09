package com.epe.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epe.jpa.domain.order.Member;

public class ORDERtest {

	public static void test(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		
		try {
		
			em.find(Member.class, 1);
			em.getReference(Member.class, 2);
			
			
			tx.commit();	
		}catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
	}
}
