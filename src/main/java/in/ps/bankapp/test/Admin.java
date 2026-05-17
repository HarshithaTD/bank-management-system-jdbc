
	package in.ps.bankapp.test;

	import java.util.ArrayList;
	import java.util.Scanner;

	import in.ps.bankapp.dao.AccountDAO;
	import in.ps.bankapp.dao.AccountDAOImpl;
	import in.ps.bankapp.dao.CustomerDAO;
	import in.ps.bankapp.dao.CustomerDAOImpl;
	import in.ps.bankapp.dao.TransactionDAO;
	import in.ps.bankapp.dao.TransactionDAOImpl;
	import in.ps.bankapp.dto.Account;
	import in.ps.bankapp.dto.Customer;

	public class Admin {
		 static AccountDAO adao=new AccountDAOImpl(); 
		 static CustomerDAO cdao=new CustomerDAOImpl(); 
		 static TransactionDAO tdao=new TransactionDAOImpl();
		 static Scanner sc=new Scanner(System.in);
		public static void admin(Customer c) {
			
			int choice=0;
			do {
				System.out.println("1. Approve Customer");
				System.out.println("2. Approve Account");
				System.out.println("3. View all Customers ");
				System.out.println("4. View all Accounts");
				System.out.println("5. View all Transactions");
				System.out.println("6. Block User/Delete Customer");
				System.out.println("7. Block Account");
				System.out.println("8. Delete Account");
				System.out.println("9. My Account");
				System.out.println("10. Back to main menu");
		
				choice=sc.nextInt();
				switch(choice) {
				
				case 1: Customer cu=Admin.customerInfo();
						System.out.println("1. Approve the account");
				        System.out.println("2. Reject the Account");
				        int i=0;
				        i=sc.nextInt();
				        String status=Admin.statusUpdate(i);
				        cu.setStatus(status);
				        boolean res=cdao.updateCustomer(cu);
				        if(res) {
				        	System.out.println("Status Update successful");
				        }
				        else {
				        	System.out.println("Failed to update status");
				        }
				break;
				 case 2: Account a=Admin.accountInfo();
		                System.out.println("1. Approve the account");
		                System.out.println("2. Reject the Account");
		                
		                int j=0;
		                j=sc.nextInt();
		                
					       String stat=Admin.statusUpdate(j);
					       a.setStatus(stat);
					       boolean acc_res=adao.updateAccount(a);
					      if(acc_res) {
					       System.out.println("Account Update successful");
					     }
					     else {
					       System.out.println("Failed to update the Account");
					     }
				           break;
				           
				 case 3: Customer ct=Admin.customerInfo();
				         if(ct!=null) {
				           System.out.println("Customer ID :"+ct.getCid());
				           System.out.println("Customer Fname "+ct.getFname());
				         }
				         break;
	         
	         case 4: Account acc=Admin.accountInfo();
		         if(acc!=null) {
		           System.out.println("Account ID: "+acc.getAcc_id());
		            System.out.println("Account Number: "+acc.getAcc_no());
		            System.out.println("Account Holder ID "+acc.getCid());
		            System.out.println("Balance "+acc.getBalance());
		            System.out.println("----------------------------");
		         }
		         break;
		         
		         case 6: Customer inactive=Admin.customerInfo();
		         if(inactive!=null) {
		           inactive.setStatus("Inactive");
		           boolean inactive_status=cdao.updateCustomer(inactive);
		           if(inactive_status) {
		             System.out.println("Customer account blocked");
		           }
		           else {
		             System.out.println("Failed to block");
		           }
		         }
		         else {
		         System.out.println("No customer found");
		         }
		         break;
	         
	         case 7: Account inactive_acc=Admin.accountInfo();
	         if(inactive_acc!=null) {
	           inactive_acc.setStatus("inactive");
	           boolean inactive_stat=adao.updateAccount(inactive_acc);
	           if(inactive_stat) {
	        	   System.out.println("Account Blocked");
	           }
	           else {
	             System.out.println("Failed to Block");
	           }
	         }
	         else {
	           System.out.println("No Such Account Found");
	         }
	         break;
	         
	         case 8: Account delete_acc=Admin.accountInfo();
	         if(delete_acc!=null) {
		           System.out.println("Are you sure to delete this account(1.yes/2.no)");
		           int confirm=sc.nextInt();
		           if(confirm == 1) {
			             boolean delete_stat=adao.deleteAccount(delete_acc.getAcc_id());
			             if(delete_stat) {
			               System.out.println("Account Deleted Successfully");
			             }
			             else {
				               System.out.println("Failed to delete Account");
				             }
		           }
		           else {
		             System.out.println("Account Deletion cancelled");
		           }
	           }
	         else {
	           System.out.println("Account Not Found");
	         }
	         break;
	         
	         case 9: App.options(c);
	         break;
	         
	         case 10:
	         System.out.println("Going back to main menu..!");
	         break;
	         
	         default:
	           System.out.println("Invalid response!Choose it again");
	         }
	           
	         }
	         while(choice!=10);
	     }
	       
	  public static Customer customerInfo() {
	    ArrayList<Customer> customers=cdao.getCustomer();
	    for(Customer c:customers) {
	      System.out.println("Customer ID: "+c.getCid());
	      System.out.println("Customer First Name: "+c.getFname());
	      System.out.println("Status "+c.getStatus());
	      System.out.println("----------------------------");
	    }
	    
	    System.out.println("Enter the ID: ");  
	    int cid=sc.nextInt();
	    
	    Customer c=cdao.getCustomer(cid);
	    return c;
	  }

	  public static Account accountInfo() {
	    ArrayList<Account> accounts=adao.getAccount();
	    for(Account a: accounts) {
	      System.out.println("Account ID: "+a.getAcc_id());
	      System.out.println("Account Number: "+a.getAcc_no());
	      System.out.println("Customer ID: "+a.getCid());
	      System.out.println("Status : "+a.getStatus());
	      System.out.println("------------------------------------------------");
	    }
	      
	    System.out.println("Enter the Account ID:");
	    int acc_id = sc.nextInt();
	    
	    Account a= adao.getAccount(acc_id);
	    return a;
	  }


	  public static String statusUpdate(int choice) {
	    String status=null;
	    if(choice==1) {
	      status="Active";
	      System.out.println("Status approved");
	    }
	    else if(choice==2) {
	      status="Inactive";
	      System.out.println("Status rejected");
	    }
	    else {
	      System.out.println("Invalid choice!");
	      status="Pending";
	    }
	    return status;
	  }
	  
	         
	           }