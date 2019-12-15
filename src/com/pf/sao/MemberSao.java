package com.pf.sao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.dao.MemberDao;

@Service
public class MemberSao {

	@Autowired
	MemberDao memberDao;
	
	public void testSao() {
		memberDao.testDao();
	}
	
	
}
