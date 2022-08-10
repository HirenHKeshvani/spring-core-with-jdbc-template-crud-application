package com.deltafixes.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.deltafixes.spring.dto.Customer;

public class CustomerRawMapper implements RowMapper<Customer>{

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerId(rs.getInt("custId")); 
        customer.setcustomerName(rs.getString("custname")); 
        customer.setcustomerAddress(rs.getString("city"));
		return customer;
	}

}
