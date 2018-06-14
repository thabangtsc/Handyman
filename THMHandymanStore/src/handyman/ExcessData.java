package handyman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Random;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.swing.JOptionPane;




public class ExcessData 
{
	
	// Global variables
	 static Connection cn = null;
	 static String url = "jdbc:mysql://localhost:3306/thmstore";
	 static String password = "thabang";
	 static String username = "root";
	 static String DriverPath = "com.mysql.jdbc.Driver"; 
	 static int vID,pID,vOrderNo,pOnHand,pReorderLevel;
	 static String vName,vCoNum,vProvince,Desc;
	static double pUnitPrice;
	/**
	 *  Method to connect to database	 
	 */
	public static void connectDB() 
	{
	
		try
		{
			//Changed here: 
			Class.forName(DriverPath);
			cn = (Connection)DriverManager.getConnection(url,username,password);
			
			if (cn!=null)
			{
				
				JOptionPane.showMessageDialog(null, "Connected to database");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "False query");
		}
	}
	
	/**
	  *  Method to select data from database
	  */
	 public static void SelectVendorProductDB()
		{
			try
			{
				/**
				 *  Call Connection method connectDB() to connect to database
				 */
				connectDB();
				vID = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter vendor id here: "));
				
				PreparedStatement sta = cn.prepareStatement("SELECT * "
						+ " FROM product WHERE product.vendor_v_ID =  '" + vID + "'");
				ResultSet res = sta.executeQuery();
				
				System.out.println("+++=========Products Record(s)========+++");
				
				while (res.next())
				{
					pID= res.getInt("p_ID");
					Desc = res.getString("desc");
					//pOnHand = res.getInt("p_onhand");
					//pReorderLevel = res.getInt("p_reorder_level");
					pUnitPrice = res.getInt("p_unit_price");
					vID= res.getInt("vendor_v_ID");
					
					System.out.println("Product Id: " + vID
						+ "| Description: " + Desc
						//+ "| On Hand: " + pOnHand 
						//+ "| Reorder Level: " + pReorderLevel
						+ "| Unit Price: R" + pUnitPrice
						+ "| Vendor id: " + vID
						+	"\n_______________________________________"); 
					
				}
				
				cn.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage().toString());
				JOptionPane.showMessageDialog(null, "Not connected to database");
			}
		}
	
	/**
	  *  Method to select data from database
	  */
	 public static void SelectProductDB()
		{
			try
			{
				/**
				 *  Call Connection method connectDB() to connect to database
				 */
				connectDB();
				
				PreparedStatement sta = cn.prepareStatement("SELECT * from product");
				ResultSet res = sta.executeQuery();
				
				System.out.println("+++=========Products Record(s)========+++");
				
				while (res.next())
				{
					pID= res.getInt("p_ID");
					Desc = res.getString("desc");
					pOnHand = res.getInt("p_onhand");
					pReorderLevel = res.getInt("p_reorder_level");
					pUnitPrice = res.getInt("p_unit_price");
					vID= res.getInt("vendor_v_ID");
					
					System.out.println("Product Id: " + vID
						+ "| Description: " + Desc
						+ "| On Hand: " + pOnHand 
						+ "| Reorder Level: " + pReorderLevel
						+ "| Unit Price: R" + pUnitPrice
						+ "| Vendor id: " + vID
						+	"\n_______________________________________"); 
					
				}
				
				cn.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage().toString());
				JOptionPane.showMessageDialog(null, "Not connected to database");
			}
		}
	/**
	  *  Method to select data from database
	  */
	 public static void SelectVendorDB()
		{
			try
			{
				/**
				 *  Call Connection method connectDB() to connect to database
				 */
				connectDB();
				
				PreparedStatement sta = cn.prepareStatement("SELECT * from vendor");
				ResultSet res = sta.executeQuery();
				//JOptionPane.showMessageDialog(null, "database table accessed");
				
				System.out.println("+++=========Vendors Record(s)========+++");
				
				while (res.next())
				{
					vID= res.getInt("v_ID");
					vName = res.getString("v_name");
					vCoNum = res.getString("v_c_no");
					vProvince = res.getString("v_province");
					vOrderNo = res.getInt("v_orderNo");
					
					System.out.println("Vendor Id: " + vID
						+ "| Name: " + vName 
						+ "| Contact no: " + vCoNum 
						+ "| Province: " + vProvince
						+ "| Order number " + vOrderNo
						+	"\n_______________________________________"); 
					
				}
				
				cn.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage().toString());
				JOptionPane.showMessageDialog(null, "Not connected to database");
			}
		}
}
