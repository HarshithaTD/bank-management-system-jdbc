package in.ps.bankapp.test;


import java.util.Scanner;

import in.ps.bankapp.dao.CustomerDAO;
import in.ps.bankapp.dao.CustomerDAOImpl;
import in.ps.bankapp.dto.Customer;

public class Password {
	
	 public static void forgot() {
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Enter the mail ID:");
		 String mail=sc.next();
		 CustomerDAO cdao=new CustomerDAOImpl();
		 Customer c=cdao.getCustomer(mail);
		 if(c!=null) {
			 System.out.println("Set a new pin:");
			 int pin=sc.nextInt();
			 System.out.println("Confirm the pin:");
			 int confirm=sc.nextInt();
			 if(pin==confirm) {
				 c.setPin(pin);;
				 boolean res=cdao.updateCustomer(c);
				 if(res) {
					 System.out.println("Password updated");
				 }
				 else {
					 System.out.println("Failed to update");
				 }
			 }
			 else {
			 System.out.println("Pin mismatch");
			 }
		 }
		 else {
			 System.out.println("Account does not exist");
		 }
	 }
	
}
