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
import in.ps.bankapp.dto.Transaction;

public class App {

		static CustomerDAO cdao=new CustomerDAOImpl();
		static AccountDAO adao=new AccountDAOImpl();
		static TransactionDAO tdao=new TransactionDAOImpl();
		static Scanner sc=new Scanner(System.in);
		public static void options(Customer c) {
			
			int choice=0;
			do {
				System.out.println("1. View Accounts");
				System.out.println("2. Deposit");
				System.out.println("3. Transfer Amount");
				System.out.println("4. View Passbook");
				System.out.println("5. Exit");
				choice=sc.nextInt();	
				switch(choice) {
				case 1: ArrayList<Account> list=adao.getAccountByCustomerId(c.getCid());
						for(Account a:list) {
							System.out.println("Account number : "+ a.getAcc_no());
							System.out.println("Account Type : " + a.getAcc_type());
							System.out.println("Balance : "+ a.getBalance());
							System.out.println("Status  : "+ a.getStatus());
							System.out.println("------------------------------------------------------------------------------");
						}
						break;
						
				case 2: ArrayList<Account> acc_list=adao.getAccountByCustomerId(c.getCid());
						for(Account a:acc_list) {
							System.out.println("Account number : "+ a.getAcc_no());
							System.out.println("Account Type : " + a.getAcc_type());
							System.out.println("Balance : "+ a.getBalance());
							System.out.println("Status  : "+ a.getStatus());
							System.out.println("------------------------------------------------------------------------------");
						}
						System.out.println("Enter the Account number:");
						long acc_no=sc.nextLong();
						Account a=adao.getAccount(acc_no);
						if(a!=null) {
							System.out.println("Enter the amount to be deposited");
							double amount=sc.nextDouble();
							a.setBalance(a.getBalance()+amount);
							boolean res=adao.updateAccount(a);
							if(res) {
								Transaction t=new Transaction();
								t.setTransaction_id(TransactionID.generateTransactionId());
								t.setSender_acc(a.getAcc_no());
								t.setReceiver_acc(a.getAcc_no());
								t.setAmount(amount);
								t.setTran_type("SELF");
								t.setBalance(a.getBalance());
								boolean status=tdao.insertTransaction(t);
								if(status) {
									System.out.println("Amount of rs."+amount +" /- has deposited to Account "+acc_no);
								}
								else {
									System.out.println("Failed to deposit the amount ");
								}
							}
							
							else {
									System.out.println("Account status is pending! waiting for admin approval");
								}
						
						}
						else {
							System.out.println("Account is not fount");
						}	
				
				break;
				
				case 3 : ArrayList<Account> transfer_list=adao.getAccountByCustomerId(c.getCid());
						for(Account acc:transfer_list) {
							System.out.println("Account number : "+ acc.getAcc_no());
							System.out.println("Account Type : " + acc.getAcc_type());
							System.out.println("Balance : "+ acc.getBalance());
							System.out.println("Status  : "+ acc.getStatus());
							System.out.println("------------------------------------------------------------------------------");
						}
						System.out.println("enter the account number");
						long sender_acc_no=sc.nextLong();
						Account sender_acc=adao.getAccount(sender_acc_no);
						System.out.println(" Enter the receiver account number:");
						long receiver_acc_no=sc.nextLong();
						Account rec_acc=adao.getAccount(receiver_acc_no);
						System.out.println("enter the amount to be transfered");
						double transfer_amount=sc.nextDouble();
						System.out.println("enter the pin");
						int pin=sc.nextInt();
						
						if(pin==c.getPin()&& sender_acc_no!=receiver_acc_no && sender_acc.getBalance()>transfer_amount && transfer_amount>0) {
							sender_acc.setBalance(sender_acc.getBalance()-transfer_amount);
							rec_acc.setBalance(rec_acc.getBalance()+transfer_amount);
							boolean status1=adao.updateAccount(sender_acc);
							boolean status2=adao.updateAccount(rec_acc);
							if(status1 && status2) {
								long transactionId=TransactionID.generateTransactionId();
								Transaction t1=new Transaction();
								Transaction t2=new Transaction();
								//set the value for t1
								
								t1.setTransaction_id(transactionId);
								t1.setSender_acc(sender_acc_no);
								t1.setReceiver_acc(receiver_acc_no);
								t1.setAmount(transfer_amount);
								t1.setTran_type("DEBIT");
								t1.setBalance(sender_acc.getBalance());
								//set the value for t1
								
								t2.setTransaction_id(transactionId);
								t2.setSender_acc(receiver_acc_no);
								t2.setReceiver_acc(sender_acc_no);
								t2.setAmount(transfer_amount);
								t2.setTran_type("CREDIT");
								t2.setBalance(rec_acc.getBalance());
								
								boolean tr_status1=tdao.insertTransaction(t1);
								boolean tr_status2=tdao.insertTransaction(t2);
								
								if(tr_status1 && tr_status2) {
									System.out.println("Amount of rs "+transfer_amount +" has been tranfered to "+receiver_acc_no);
									
								}
								else {
									System.out.println("Transaction failed");
								}
							}
							else {
								System.out.println("Transaction failed");
							}
						}
						else {
							System.out.println("Transaction failed");
						}
						break;
						
				case 4:ArrayList<Account> pass_list=adao.getAccountByCustomerId(c.getCid());
				        for(Account ac_list:pass_list) {
				            System.out.println("Account number : "+ ac_list.getAcc_no());
				            System.out.println("Account Type : " + ac_list.getAcc_type());
				            System.out.println("Balance : "+ ac_list.getBalance());
				            System.out.println("Status  : "+ ac_list.getStatus());
				            System.out.println("------------------------------------------------------------------------------");
				          }
				        System.out.println("Enter the account number:");
				        long pass_acc_no=sc.nextLong();
				        ArrayList<Transaction>passbook=tdao.getTransactionByCustomerAccno(pass_acc_no);
				        
				        for(Transaction trs:passbook) {
				        	System.out.println("Transaction id:"+trs.getTransaction_id());
				        	System.out.println("Date and Time:"+trs.getDate());
				        	System.out.println("Amount:"+trs.getAmount());
				        	if(trs.getTran_type().equals("CREDIT")) {
				        		System.out.println("From:"+trs.getReceiver_acc());
				            	System.out.println("To:"+trs.getSender_acc());
				        	}
				        	else {
				        	System.out.println("From:"+trs.getSender_acc());
				        	System.out.println("To:"+trs.getReceiver_acc());
				        	}
				        	System.out.println("Transaction type:"+trs.getTran_type());
				        	System.out.println("Balance:"+trs.getBalance());
				        	
				        	System.out.println("-------------------------------------------------------------------");
				        }
				       
				        break;
				
						
				}
				
				
			}while(choice!=5);
			
			}
			
	}
		


