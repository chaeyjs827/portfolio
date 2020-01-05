package com.pf.sao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.dao.MemberDao;

@Service
public class MemberSao {

	@Autowired
	MemberDao memberDao;
	
	public Map<String, Object> memberCreate(String userID, String userPW) {
		Map<String, Object> returnObj = memberDao.memberCreate();
		return returnObj;
	}
	
	public Map<String, Object> testSao() {
		Map<String, Object> returnObj = memberDao.testDao();
		return returnObj;
	}
	
	
}
