package in.ps.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.ps.bankapp.connection.Connector;
import in.ps.bankapp.dto.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	private Connection con;
	
	public CustomerDAOImpl() {
		this.con=Connector.getCon();
	}
	@Override
	public boolean insertCustomer(Customer c) {
		String query="INSERT INTO CUSTOMER VALUES (0,?,?,?,?,?,SYSDATE(),?)";
		int i=0;
		try {
		PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setLong(3, c.getPhone());
			ps.setString(4, c.getMail());
			ps.setInt(5, c.getPin());
			ps.setString(6, c.getStatus());
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
	public boolean updateCustomer(Customer c) {
		String query="UPDATE CUSTOMER SET FNAME=?,LNAME=?,PHONE=?,MAIL=?,PASSWORD=?,STATUS=? WHERE CID=?";
		int i=0;
		try {
		PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, c.getFname());
			ps.setString(2, c.getLname());
			ps.setLong(3, c.getPhone());
			ps.setString(4, c.getMail());
			ps.setInt(5, c.getPin());
			ps.setString(6, c.getStatus());
			ps.setInt(7,c.getCid());
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
	public boolean deleteCustomer(int cid) {
		String query="DELETE FROM CUSTOMER  WHERE CID=?";
		int i=0;
		try {
		PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,cid);
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
	public Customer getCustomer(String mail, int pin) {
		String query="SELECT * FROM CUSTOMER WHERE MAIL=? AND PASSWORD=?";
		Customer c=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setInt(2, pin);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setCid(rs.getInt("cid"));
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
				c.setPhone(rs.getLong("phone"));
				c.setMail(rs.getString("mail"));
				c.setPin(rs.getInt("password"));
				c.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<Customer> getCustomer() {
		ArrayList<Customer> list=new ArrayList<>();
		String query="SELECT * FROM CUSTOMER ";
		Customer c=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setCid(rs.getInt("cid"));
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
				c.setPhone(rs.getLong("phone"));
				c.setMail(rs.getString("mail"));
				c.setPin(rs.getInt("password"));
				c.setStatus(rs.getString("status"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Customer getCustomer(String mail) {
		String query="SELECT * FROM CUSTOMER WHERE MAIL=? ";
		Customer c=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setCid(rs.getInt("cid"));
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
				c.setPhone(rs.getLong("phone"));
				c.setMail(rs.getString("mail"));
				c.setPin(rs.getInt("password"));
				c.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	
	public Customer getCustomer(int cid) {
		String query="SELECT * FROM CUSTOMER WHERE CID=? ";
		Customer c=null;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setCid(rs.getInt("cid"));
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
				c.setPhone(rs.getLong("phone"));
				c.setMail(rs.getString("mail"));
				c.setPin(rs.getInt("password"));
				c.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	

}
