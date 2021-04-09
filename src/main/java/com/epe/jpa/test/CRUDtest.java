package com.epe.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epe.jpa.domain.User;

public class CRUDtest {

	public static void test(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		//사용하고 버려야 한다. 쓰레드간 공유시 문제가 날 수 있다.
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();	//트랜잭션의 시작
		
		try {
			/* 해당 방법은 정석 적인 실행 방법에 대한 예시이다. em이 JDBC CONNECT를 물고 있기에 무조건 close처리를 해줘야 한다.
			 * 추후에는 해당 과정을 스프링이 해줄꺼다
			 * */
			
			/* insert에 대한 예시 */
			User insertUser = new User();
			insertUser.setId(2L);
			insertUser.setUserName("HelloB");
			em.persist(insertUser);
			
			/* select에 대한  예시*/
			User findUser = em.find(User.class, 1L);	//em.find(객체, PK)
			System.out.println(findUser.getId()+" : "+findUser.getUserName());
			
			/* delete에 대한 예시 */
			User deleteUser = em.find(User.class, 2L);
			em.remove(deleteUser);
			
			/* update에 대한 예시 */
			//tx.commit 시점에 데이터가 변경된게 있는지를 확인하고 변경점이 있다고 하면 update쿼리를 날림
			User updateUser = em.find(User.class, 1L);
			updateUser.setUserName("HelloJPA");
			
			tx.commit();	//트랜잭션의 마지막
		}catch (Exception e) {
			tx.rollback();
		}finally {
			
			em.close();
			
		}
	}
}
