package in.ps.bankapp.dao;

import java.util.ArrayList;

import in.ps.bankapp.dto.Account;

public interface AccountDAO {
	public boolean insertAccount(Account a);
	//INSERT INTO ACCOUNT VALUES(0,?,?,?,?,SYSDATE());
	public boolean updateAccount(Account a);
	//UPDATE ACCOUNT SET ACC_TYPE=?, BALANCE=? where acc_id=?;
	public boolean deleteAccount(int acc_id);
	//delete from accounts where acc_id=?;
	public Account getAccount(int acc_id);
	//select * from account where acc_id=?;
	public ArrayList<Account> getAccountByCustomerId(int cid);
	//select * from account where cid=?;
	public ArrayList<Account> getAccount();
	//select * from account;
	public Account getAccount(long acc_no);
	//select * from account where acc_no=? and status="ACTIVE";
}
