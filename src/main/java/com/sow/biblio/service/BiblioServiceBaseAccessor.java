package com.sow.biblio.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;


public class BiblioServiceBaseAccessor {
	
	@PersistenceUnit
    protected EntityManagerFactory emf; 
    
	@PersistenceContext
    protected EntityManager em;

	protected EntityManager em() {
		return em;
	}

	protected EntityManagerFactory emf() {
		return emf;
	}

}
