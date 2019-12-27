package com.pf.sao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.dao.MainDao;

@Service
public class MemberSao {

	@Autowired
	MainDao memberDao;
	
	public Map<String, Object> testSao() {
		Map<String, Object> returnObj = memberDao.testDao();
		return returnObj;
	}
	
	
}
