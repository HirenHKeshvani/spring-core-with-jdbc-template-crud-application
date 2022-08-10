package com.deltafixes.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.deltafixes.spring.dao.CustomerDAO;
import com.deltafixes.spring.dto.Customer;

public class DemoBean {
@Autowired
private  CustomerDAO  customerDAO; 

public void setCustomerDAO(CustomerDAO customerDAO){
	this.customerDAO = customerDAO;
}

public void insertCustomer(String custName, String addr){
	Customer customer = new Customer();
	customer.setcustomerName(custName);
	customer.setcustomerAddress(addr);
	int res = customerDAO.insert(customer);
	System.out.println(res + ": Recored Inserted.");
}

public List<Customer> getAllCustomers(){
	return customerDAO.getAllCustomers();
}

public int deleteCustomer(int customerId){
	return customerDAO.deleteCustomer(customerId);
}

public Customer selectCustomer( int customerId){
	return customerDAO.selectCustomer(customerId);
}

public int  updateCustomer(String newName, String newCity, int customerId){
	return customerDAO.updateCustomer(newName, newCity,customerId);
}

public int  updateCustomerName(String custName, int customerId){
	Customer customer = new Customer();
	customer.setcustomerName(custName);
	customer.setCustomerId(customerId);
	
	return customerDAO.updateCustomerName(custName, customerId);
}

public int  updateCustomerCity(String cCity, int cId){
	Customer customer = new Customer();
	customer.setcustomerAddress(cCity);
	customer.setCustomerId(cId);
	return customerDAO.updateCustomerCity(cCity, cId);
}


}
