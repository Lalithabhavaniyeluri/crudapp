package dao;
import java.sql.*;
import connectionmanager.ConnectionManager;
import model.product;

public class ProductDAO {
	public void addProduct(product p) throws ClassNotFoundException, SQLException 
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="insert into product(prodId,prodname,minsellquantity,prodprice,quantity) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1, p.getProductId());
		ps.setString(2, p.getProductname());
		ps.setInt(3, p.getMinSellQuantity());
		ps.setInt(4, p.getPrice());
		ps.setInt(5,p.getQuantity());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		//1.create the statement 
		Statement st=con.createStatement();
		//2.write and execute the query
		ResultSet rt=st.executeQuery("select * from product");
		//3.Check user name and password
		while(rt.next())
		{
			System.out.println(rt.getInt(1)+"|"+rt.getString(2)+"|"+rt.getInt(3)+"|"+rt.getInt(4)+"|"+rt.getInt(5));
		}
		cm.closeConnection();
	}
	
    public void update(product p) throws ClassNotFoundException, SQLException
    {
    	ConnectionManager cm=new ConnectionManager();
    	Connection con=cm.establishConnection();
    	String que="update product set prodname=?,minsellquantity=?,prodprice=?,quantity=? where prodId=?";
    	PreparedStatement ps=con.prepareStatement(que);
    	ps.setString(1, p.getProductname());
		ps.setInt(2, p.getMinSellQuantity());
		ps.setInt(3, p.getPrice());
		ps.setInt(4,p.getQuantity());
		ps.setInt(5,p.getProductId());
		ps.executeUpdate();
		cm.closeConnection();
    }
    public void deleteProduct(product p) throws ClassNotFoundException, SQLException
    {
    	ConnectionManager cm=new ConnectionManager();
    	Connection con=cm.establishConnection();
    	String que="delete from product where prodId=?";
    	PreparedStatement ps=con.prepareStatement(que);
    	ps.setInt(1, p.getProductId());
    	ps.executeUpdate();
    	cm.closeConnection();
    }
}
