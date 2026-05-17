package in.ps.bankapp.dto;

public class Transaction {
	private int id;
	private long transaction_id;
	private long sender_acc;
	private long receiver_acc;
	private double amount;
	private String tran_type;
	private double balance;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public long getSender_acc() {
		return sender_acc;
	}
	public void setSender_acc(long sender_acc) {
		this.sender_acc = sender_acc;
	}
	public long getReceiver_acc() {
		return receiver_acc;
	}
	public void setReceiver_acc(long receiver_acc) {
		this.receiver_acc = receiver_acc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTran_type() {
		return tran_type;
	}
	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
