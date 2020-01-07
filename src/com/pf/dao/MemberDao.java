package com.pf.dao;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pf.config.ProjectConstants;

@Transactional
@Repository
public class MemberDao extends ProjectConstants {
	public Map<String, Object> memberLogin() {
		Map<String, Object> returnObj = new HashMap<>();
		returnObj.put("returnCode", "1");
		returnObj.put("returnMsg", "login_success");
		return returnObj;
		
//		Member member = new Member();
//		member.setUserNickname("sleepy");
//		
//		Session session = entityManager.unwrap(Session.class);
//		session.save(member);
	}
	
	public Map<String, Object> memberCreate() {
		Map<String, Object> returnObj = new HashMap<>();
		returnObj.put("returnCode", "1");
		returnObj.put("returnMsg", "create_success");
		return returnObj;
	}
}
