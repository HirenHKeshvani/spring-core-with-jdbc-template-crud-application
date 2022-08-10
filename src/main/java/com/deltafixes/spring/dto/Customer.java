package com.deltafixes.spring.dto;

public class Customer {
private int customerId;
private String customerName;
private String customerAddress;

public int getcustomerId(){
	return customerId;
	
}

public void setCustomerId(int customerId){
	this.customerId = customerId;
}

public String getcustomerName(){
	return customerName;
}

public void setcustomerName(String customerName){
	this.customerName = customerName;
}

public String getcustomerAddress(){
	return customerAddress;
}

public void setcustomerAddress(String customerAddress){
	this.customerAddress = customerAddress;
	
}

public String toString(){
	return customerId+ " \t" +customerName+ "\t " +customerAddress;
}
}
