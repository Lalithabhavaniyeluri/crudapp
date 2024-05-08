package dao;
import java.sql.*;
import java.sql.SQLException;

import connectionmanager.ConnectionManager;
import model.login;

public class LoginDAO {
	public boolean checkCredential(login l) throws ClassNotFoundException, SQLException
	{
		//1.get the details from login.javafiles
		String username=l.getUsername();
		String password=l.getPassword();
		//2. jdbc connection to get details from our login table 
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		//3.create the statement 
		Statement st=con.createStatement();
		//4.write and execute the query
		ResultSet rt=st.executeQuery("select * from login");
		//5.Check username and password
		while(rt.next())
		{
			if(username.equals(rt.getString("username"))&& password.equals(rt.getString("password")))
			{
				cm.closeConnection();
				return true;
			}
		}
		cm.closeConnection();
		return false;
	}
}
