package com.pf.sao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.dao.MainDao;

@Service
public class MemberSao {

	@Autowired
	MainDao memberDao;
	
	public void testSao() {
		memberDao.testDao();
	}
	
	
}
