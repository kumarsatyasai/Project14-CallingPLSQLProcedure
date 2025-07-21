package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICustomerMgmtService;

@Component
public class PLSQLProcedureProgramingTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;
	
	
	@Override
	public void run(String... args) throws Exception {

		try
		{
			custService.showCustomerByBillAmtRange(1f, 100f).forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
