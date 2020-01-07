package com.pf.sao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.config.ProjectConstants;
import com.pf.dao.ContentDao;

@Service
public class ContentSao extends ProjectConstants {

	@Autowired
	ContentDao contentDao;
	
}
