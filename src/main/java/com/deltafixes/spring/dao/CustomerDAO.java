package com.deltafixes.spring.dao;

import java.util.List;

import com.deltafixes.spring.dto.Customer;

public interface CustomerDAO {
    Customer selectCustomer(int customerId);
    
    List<Customer> getAllCustomers();
    
    int insert(Customer c);

    int deleteCustomer(int customerId);

    int updateCustomerName(String custName,  int customerId);
    
    int updateCustomerCity(String custCity, int customerId);

	int updateCustomer(String nName, String nCity, int nId);
    
    
}

