package com.deltafixes.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deltafixes.spring.dto.Customer;

public  class CustomerDAOImpl implements CustomerDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Customer c) {
		String custName = c.getcustomerName();
		String custAddress = c.getcustomerAddress();
		int rows = jdbcTemplate.update("insert into customer(custname,city) values(?,?)",custName,custAddress);
		return rows;
	}
	
	public List<Customer> getAllCustomers(){  
		 return jdbcTemplate.query("select * from customer",new RowMapper<Customer>(){  
		    public Customer mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Customer customer = new Customer();  
		        customer.setCustomerId(rs.getInt(1)); 
		        customer.setcustomerName(rs.getString(2)); 
		        customer.setcustomerAddress(rs.getString(3));  
		      
		        return customer;  
		    }  
		    });  
		}
	
    public int deleteCustomer(int customerId) {
        String query = "DELETE from customer where custid=?";
        return jdbcTemplate.update(query, new Object[] {
            Integer.valueOf(customerId)
        });

    }


	

	public Customer selectCustomer(int customerId) {
		String sql = "select * from customer where custid = ?";      
		return jdbcTemplate.queryForObject(sql, new CustomerRawMapper(), customerId);
				
	}

	public int updateCustomerName(String custName, int customerId) {
	
        String sql = "UPDATE customer set custname = ? where custid=?";
        return jdbcTemplate.update(sql, custName,customerId);
       
	}

	public int updateCustomerCity(String custCity,int customerId) {
		String sql = "UPDATE customer set city = ? where custid=?";
		return jdbcTemplate.update(sql,custCity,customerId);
	}

	public int updateCustomer(String name,String  city,int id) {
		String sql = "UPDATE customer set custname = ?,city = ? where custid=?";
		return jdbcTemplate.update(sql, name,city, id);
		
	}

}
