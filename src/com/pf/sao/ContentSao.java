package com.pf.sao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.dao.ContentDao;

@Service
public class ContentSao {

	@Autowired
	ContentDao contentDao;
	
}
