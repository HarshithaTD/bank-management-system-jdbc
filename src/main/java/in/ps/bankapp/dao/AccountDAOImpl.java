
package in.ps.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.ps.bankapp.connection.Connector;
import in.ps.bankapp.dto.Account;
import in.ps.bankapp.dto.Customer;

public class AccountDAOImpl implements AccountDAO {
	private Connection con;
	
	public AccountDAOImpl() {
		this.con=Connector.getCon();
	}
	@Override
	public boolean insertAccount(Account a) {
		String query="INSERT INTO ACCOUNT VALUES( 0,?,?,?,?,SYSDATE(),?)";
		int i=0;
		try {
		PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, a.getAcc_no());
			ps.setInt(2, a.getCid());
			ps.setString(3, a.getAcc_type());
			ps.setDouble(4,a.getBalance());
			ps.setString(5, a.getStatus());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
		return false;
	}
		
	}

	@Override
	public boolean updateAccount(Account a) {
		String query="UPDATE ACCOUNT  SET ACC_NO=?,CID=?,ACC_TYPE=?,BALANCE=?,STATUS=? WHERE ACC_ID=?";
		int i=0;
		try {
		PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, a.getAcc_no());
			ps.setInt(2, a.getCid());
			ps.setString(3, a.getAcc_type());
			ps.setDouble(4,a.getBalance());
			ps.setString(5, a.getStatus());
			ps.setInt(6, a.getAcc_id());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
		return false;
	  }
	}

	@Override
	public boolean deleteAccount(int acc_id) {
		String query="DELETE FROM ACCOUNT WHERE ACC_ID=?";
		int i=0;
		try {
		PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,acc_id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
		return false;
	}
	}

	@Override
	public Account getAccount(int acc_id) {
		String query="SELECT * FROM ACCOUNT WHERE ACC_ID=?";
		Account a=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, acc_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				a=new Account();
				a.setAcc_id(rs.getInt("acc_id"));
				a.setAcc_no(rs.getLong("acc_no"));
				a.setCid(rs.getInt("cid"));
				a.setAcc_type(rs.getString("acc_type"));
				a.setBalance(rs.getDouble("balance"));
				a.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ArrayList<Account> getAccountByCustomerId(int cid) {
		String query="SELECT * FROM ACCOUNT WHERE CID=?";
		ArrayList<Account> list=new ArrayList<>();
		Account a=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				a=new Account();
				a.setAcc_id(rs.getInt("acc_id"));
				a.setAcc_no(rs.getLong("acc_no"));
				a.setCid(rs.getInt("cid"));
				a.setAcc_type(rs.getString("acc_type"));
				a.setBalance(rs.getDouble("balance"));
				a.setStatus(rs.getString("status"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Account> getAccount() {
		String query="SELECT * FROM ACCOUNT ";
		ArrayList<Account> list=new ArrayList<>();
		Account a=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				a=new Account();
				a.setAcc_id(rs.getInt("acc_id"));
				a.setAcc_no(rs.getLong("acc_no"));
				a.setCid(rs.getInt("cid"));
				a.setAcc_type(rs.getString("acc_type"));
				a.setBalance(rs.getDouble("balance"));
				a.setStatus(rs.getString("status"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Account getAccount(long acc_no) {
		String query="SELECT * FROM ACCOUNT WHERE ACC_NO=? AND STATUS='ACTIVE'";
		Account a=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, acc_no);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				a=new Account();
				a.setAcc_id(rs.getInt("acc_id"));
				a.setAcc_no(rs.getLong("acc_no"));
				a.setCid(rs.getInt("cid"));
				a.setAcc_type(rs.getString("acc_type"));
				a.setBalance(rs.getDouble("balance"));
				a.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	

}
