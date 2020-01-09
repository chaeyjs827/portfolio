package com.pf.sao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pf.config.ProjectConstants;
import com.pf.dao.MainDao;

@Service
public class MainSao extends ProjectConstants {

	@Autowired
	MainDao mainDao;
	
}
