package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerMgmtService {
	
	public List<Customer> showCustomerByBillAmtRange(Float start, Float end);

}
