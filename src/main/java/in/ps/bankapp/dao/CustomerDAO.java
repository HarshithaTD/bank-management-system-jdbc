package in.ps.bankapp.dao;

import java.util.ArrayList;

import in.ps.bankapp.dto.Customer;

public interface CustomerDAO {

	//crud operation
	public boolean insertCustomer(Customer c);
	//insert into customer values (0,?,?,?,?,?,sysdate());
	public boolean updateCustomer(Customer c);
	//update customer set fname=?,lname=?,mail=?,password=? where cid=?;
	public boolean deleteCustomer(int cid);
	//delete from customer where cid=?;
	public Customer getCustomer(String mail,int pin);
	//select * from customer where mail=? and password=?;
	public ArrayList<Customer> getCustomer();
	//select * from customer;
	public Customer getCustomer(String mail);
	//select * from customer where mail=? ;
	public Customer getCustomer(int cid);
	
}
