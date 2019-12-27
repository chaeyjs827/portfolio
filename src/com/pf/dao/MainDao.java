package com.pf.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class MainDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Map<String, Object> testDao() {
		Map<String, Object> returnObj = new HashMap<String, Object>();
		returnObj.put("returnCode", "1");
		returnObj.put("returnMsg", "success");
		return returnObj;
		
//		Member member = new Member();
//		member.setUserNickname("sleepy");
//		
//		Session session = entityManager.unwrap(Session.class);
//		session.save(member);
	}
}
