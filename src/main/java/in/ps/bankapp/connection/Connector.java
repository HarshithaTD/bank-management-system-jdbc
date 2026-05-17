
package in.ps.bankapp.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connector {
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_app", "root", "tiger1");
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
