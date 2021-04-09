package com.epe.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epe.jpa.domain.User;

public class JPQLtest {

	public static void test(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		//사용하고 버려야 한다. 쓰레드간 공유시 문제가 날 수 있다.
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			
			List<User> resultList = em.createQuery("select m from Member as m", User.class)
					.setFirstResult(0)	//pageNation설정가능
					.setMaxResults(9)
					.getResultList();
			
			for (User member : resultList) {
				System.out.println(member.getId()+":"+member.getUserName());
			}
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
	}
}
