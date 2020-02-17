package com.pf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pf.config.ProjectConstants;

@Transactional
@Repository
public class ContentDao extends ProjectConstants {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Map<String,Object>> getPortfolioList() {
		List<Map<String,Object>> portfolioList = new ArrayList<>();
//		portfolioList.
		return portfolioList;
	}
	
}
