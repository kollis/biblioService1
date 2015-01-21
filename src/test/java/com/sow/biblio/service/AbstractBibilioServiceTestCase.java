package com.sow.biblio.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

@ContextConfiguration(locations = { "classpath:spring/test-biblioService1.xml" })
public class AbstractBibilioServiceTestCase extends AbstractTransactionalTestNGSpringContextTests {

	@PersistenceContext
	protected EntityManager em;

	public void setupBeforeMethod() {
	}

}

