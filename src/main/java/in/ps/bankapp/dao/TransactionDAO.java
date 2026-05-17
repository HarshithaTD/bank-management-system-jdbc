package in.ps.bankapp.dao;

import java.util.ArrayList;

import in.ps.bankapp.dto.Transaction;

public interface TransactionDAO {
	public boolean insertTransaction(Transaction t);
	//INSERT INTO TRANSACTION VALUES(0,?,?,?,?,?,?,SYSDATE());
	public boolean updateTransaction(Transaction t);
	//UPDATE TRANSACTION SET TRANSACTION_ID=?,SENDER_ACC=?,RECEIVER_ACC=?,AMOUNT=?;
	public boolean deleteTransaction(int id);
	//DELETE FROM TRANSACTION WHERE ID=?;
	public Transaction getTransaction(int id);
	////SELECT * FROM TRANSACTION WHERE ID=?;
	public ArrayList<Transaction> getTransactionByCustomerAccno(long acc_no);
	////SELECT * FROM TRANSACTION WHERE sender_acc=?;
	public ArrayList<Transaction> getTransaction();
	//SELECT * FROM TRANSACTION;
}
