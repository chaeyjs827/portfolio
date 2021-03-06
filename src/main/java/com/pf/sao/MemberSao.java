package com.pf.sao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.config.ProjectConstants;
import com.pf.dao.MemberDao;

@Service
public class MemberSao extends ProjectConstants {

	@Autowired
	MemberDao memberDao;
	
	public Map<String, Object> memberCreate(String userID, String userPW) {
		Map<String, Object> returnObj = memberDao.memberCreate();
		return returnObj;
	}
	
	public Map<String, Object> memberLogin(String userID, String userPW) {
		Map<String, Object> returnObj = memberDao.memberLogin();
		return returnObj;
	}
	
	
}
