package com.nt.service;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;


@Service("custService") 
public class CustomerMgmtServiceImpl implements ICustomerMgmtService{
	
	
	// Important Note: for PL/SQL Programing no need of ICustomerRepository for both Oracle and MySql.
	
	@Autowired
	private EntityManager em;
	
	
	/*
	 * 
	 * Creating Procedure
	 * ==================
	create or replace NONEDITIONABLE PROCEDURE GET_CUSTS_BY_BILLAMTS_RANGE 
	(
	  DETAILS OUT SYS_REFCURSOR,  
	  MINBUDGET IN FLOAT, 
	  MAXBUDGET IN FLOAT 
	) AS 
	BEGIN
	     open DETAILS FOR
	     SELECT * FROM JPA_CUSTOMER WHERE BILLAMT>=MINBUDGET AND BILLAMT<=MAXBUDGET; 
	  
	END GET_CUSTS_BY_BILLAMTS_RANGE;
	*
	*
	*/

	@Override
	public List<Customer> showCustomerByBillAmtRange(Float start, Float end) {
		
		// Create The StoredProcedureQuery Object.
		
		StoredProcedureQuery query=em.createStoredProcedureQuery("GET_CUSTS_BY_BILLAMTS_RANGE", Customer.class);
		
		// Register IN,OUT mode parameters by specifying their index and mode.
		
		query.registerStoredProcedureParameter(1, Object.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter(2, Float.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Float.class, ParameterMode.IN);
		
		// Set values for IN mode Parameters.
		
		query.setParameter(2, start);
		query.setParameter(3, end);
		
		
		// Execute The PL/SQL Procedure.
		
		List<Customer> list = query.getResultList();
		
		return list;
	}

}
