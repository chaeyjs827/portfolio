package com.pf.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.pf.data.model.Member;

@Transactional
@Repository
public class MainDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void testDao() {
		Member member = new Member();
		member.setUserNickname("sleepy");
		
		Session session = entityManager.unwrap(Session.class);
		session.save(member);
	}
}
