package com.pf.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.pf.config.ProjectConstants;
import com.pf.data.model.Member;

@Transactional
@Repository
public class MemberDao extends ProjectConstants {

	@PersistenceContext
	EntityManager entityManager;
	
	public Map<String, Object> memberLogin() {
		Map<String, Object> returnObj = new HashMap<>();
//
//		Member member = new Member();
//		member.findById("chaeyjs827");
//		
//		Session session = entityManager.unwrap(Session.class);
//		session.save(member);
		
//		Member member = new Member();
//		member.setUserNickname("sleepy");
//		
//		Session session = entityManager.unwrap(Session.class);
//		session.save(member);
		
		returnObj.put("returnCode", "1");
		returnObj.put("returnMsg", "login_success");
		return returnObj;
		
	}
	
	public Map<String, Object> memberCreate() {
		Map<String, Object> returnObj = new HashMap<>();
		returnObj.put("returnCode", "1");
		returnObj.put("returnMsg", "create_success");
		return returnObj;
	}
}
