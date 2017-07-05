package com.itheima.bos.crm.cxfservice;

import java.util.List;

import javax.jws.WebService;

import com.itheima.bos.crm.domain.Customer;

@WebService
public interface ICustomerService {
	List<Customer> findAll();
}
