package com.example.SpringWith_DB;

import java.util.List;

import com.example.SpringWith_DB.Customer;

public interface CustomerDao {

		public List<Customer> getAllCustomer();
		public void createCustomer(Customer thecustomer);

}
