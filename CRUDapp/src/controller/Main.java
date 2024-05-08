package controller;
import java.sql.SQLException;
import java.util.*;
import dao.LoginDAO;
import dao.ProductDAO;
import model.login;
import model.product;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice,option;
		login l=new login();
		LoginDAO ldao=new LoginDAO();
		product p=new product();
		ProductDAO pdao=new ProductDAO();
		do {
			System.out.println("1.Admin \n2.Agent \n3.Exit\n**************************************************\n Enter your choice: " );
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("1.Admin login");
				System.out.println("Enter username:");
				String username=sc.next();
				System.out.println("Enter the password");
				String pass=sc.next();
				l.setUsername(username);
				l.setPassword(pass);
				if(ldao.checkCredential(l))//username.equals('admin')&&pass.equals('admin@123')
				{
					System.out.println("Login Successfull");
					
					do {
						System.out.println("1.Add product \n2.Display product \n3.Update product \n4.Delete Product \n5.logout \n**************************************************\\n Enter your choice:\n");
						option=sc.nextInt();
						switch(option) {
						case 1:
							System.out.println("Add product");
							System.out.println("Enter the productId:");
							int productId=sc.nextInt();
							System.out.println("enter the productname:");
							String productname=sc.next();//nextLine() should not be used!!!!!!
							System.out.println("Enter the minimum sell quantity:");
							int minSellQuantity=sc.nextInt();
							System.out.println("Enter the price");
							int price=sc.nextInt();
							System.out.println("Enter the quantity");
							int quantity=sc.nextInt();
							p.setProductId(productId);
							p.setProductname(productname);
							p.setMinSellQuantity(minSellQuantity);
							p.setPrice(price);
							p.setQuantity(quantity);
							pdao.addProduct(p);
							System.out.println("Porduct added successfully");
							break;
						case 2:
							System.out.println("Display product");
							pdao.display();
							break;
						case 3:
					  		System.out.println("Update Product");
					  		System.out.println("Enter the productId:");
							int productId1=sc.nextInt();
							System.out.println("enter the productname:");
							String productname1=sc.next();//nextLine() should not be used!!!!!!
							System.out.println("Enter the minimum sell quantity:");
							int minSellQuantity1=sc.nextInt();
							System.out.println("Enter the price");
							int price1=sc.nextInt();
							System.out.println("Enter the quantity");
							int quantity1=sc.nextInt();
							p.setProductId(productId1);
							p.setProductname(productname1);
							p.setMinSellQuantity(minSellQuantity1);
							p.setPrice(price1);
							p.setQuantity(quantity1);
					        pdao.update(p);
					        System.out.println("Product updated Successfully");
					        break;
					    case 4:
					      	System.out.println("Delete Product");
					      	System.out.println("Enter the productId:");
							int productId2=sc.nextInt();
							p.setProductId(productId2);
					    	pdao.deleteProduct(p);
					    	System.out.println("Product Deleted Successfully");
					    	break;
					    case 5:
							System.out.println("LogOut");
							break;
						}
				       }while(option!=5);
				}
				else
					System.out.println("Incorrect ");
				break;
			case 2:
				System.out.println("1.Agent login");
				System.out.println("Enter user_name:");
				String username1=sc.next();
				System.out.println("Enter the password:");
				String pass1=sc.next();
				l.setUsername(username1);
				l.setPassword(pass1);
				if(ldao.checkCredential(l))
				{
					System.out.println("Login Successfull");
					
					do 
					{
						System.out.println("1.Display product \n2.logout \n**************************************************  \n Enter your choice:\n");
						System.out.println("Enter your option");
						option=sc.nextInt();
						switch(option)
						{
						case 1: System.out.println("Display Product");
								pdao.display();
								break;
						case 2:System.out.println("LogOut1");
								break;
						}
						
					}while(option!=2);
				}
				else
					System.out.println("Incorrect ");
				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		}while(choice!=3);
		sc.close();
	}

	
}
