package com.pf.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pf.config.ProjectConstants;

@Transactional
@Repository
public class MainDao extends ProjectConstants {
	
	@PersistenceContext
	EntityManager entityManager;

}
