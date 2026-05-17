package in.ps.bankapp.test;

import java.util.Scanner;

import in.ps.bankapp.dao.AccountDAO;
import in.ps.bankapp.dao.AccountDAOImpl;
import in.ps.bankapp.dao.CustomerDAO;
import in.ps.bankapp.dao.CustomerDAOImpl;
import in.ps.bankapp.dto.Customer;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<--LOGIN PAGE-->");
		System.out.println("Enter the Mail Id:");
		String mail=sc.next();
		System.out.println("Enter the pin: ");
		int pin=sc.nextInt();
		
		//jdbc
		
		CustomerDAO cdao=new CustomerDAOImpl();
		AccountDAO adao=new AccountDAOImpl();
		
		Customer c=cdao.getCustomer(mail, pin);
		//if the user provides the exact mail and pin , his account will be fetched and stored inside the customer object.
		if(c!=null) {
			System.out.println("Login successfully ");
			if(c.getCid()==1) {
				System.out.println("welcome admin");
				Admin.admin(c);
			}
			else {
				System.out.println("welcome " + c.getFname());
				App.options(c);
			}
		}
		else {
			System.out.println("failed to login");
		}
		
		
		
		
	}
	
	
	
}
