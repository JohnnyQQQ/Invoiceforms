package com.jquirke.wit;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class SqlQueries {
	
	private static final String JDBC_DRIVER = null;
	private static final String DATABASE_URL = null;
	
	final static String userName = "root";
    final static String password = "";
    final static String url = "jdbc:mysql://localhost:3306/invoicejava";
    
    Statement statement = null;
    int updateQuery = 0;
    private FlowLayout layout; // layout object
    private JTextField txtName;
    String[] columnNames = {"fname","lname","address"};
    Object[][] data;   
    Connection conn = null;
    JScrollPane scrollPane;
   


    
    /* createStatement() is used for create statement object that is used for sending sql statements
    to the specified database. */
    public SqlQueries(){
    	
    	//insertCustomer();
    }
    
    public void connection(){
    	
    	
		
		 try{
				Class.forName ("com.mysql.jdbc.Driver").newInstance ();
				conn = DriverManager.getConnection (url, userName, password);
				statement = conn.createStatement();
				
				//	System.out.println("Conected to database ");
				
				java.sql.DatabaseMetaData dbMetaData = conn.getMetaData();
			     String productName = dbMetaData.getDatabaseProductName();
			//     System.out.println("Database: " + productName);
			     String productVersion = dbMetaData.getDatabaseProductVersion();
			 //    System.out.println("Version: " + productVersion);
			
				
		 }//end outer try
			catch (Exception e){
				System.err.println ("Cannot connect to database server");
				e.printStackTrace();
			}//end outer catch
			

	    	
    }
    
    public void insertCustomer(String fname, String lname, String address, int landline, int mobile, String comments) 
    						
    {
    	
    	try{
    	String firstname = fname;
    	String lastname = lname;
    	String addr = address;
    	int telephone = landline;
    	int mobphone = mobile;
    	String textCommets = comments;  
    	  	
    	
    	connection();
    	
    	//String QueryString = "INSERT INTO customers VALUES ()
    	
    	String QueryString = "INSERT INTO customers (fname, lname, address, telephone, mobile, comments) " 
    			+ " VALUES "
    			+ "(' " + firstname   +	 " '," 
    			+ "' "  + lastname    +  " '," 
    			+ " ' " + addr        +  "',"
    			+ " ' " + telephone   +	 " ',"
    			+  " ' "+ mobphone    +  " ',"
    			+ " ' " + textCommets +  "')";
    	
    	statement.executeUpdate(QueryString);
    	
    	System.out.println("1 record added");
    	
    	}
    	catch (java.lang.NumberFormatException e){
    		
    		System.out.println("number format exception " );
    		 e.printStackTrace();
    	}
    	
    	
    	catch (Exception e){
    		
    		e.printStackTrace();
    	}
    	
    	
    	
    }
    
    /**
     * Returns the contents of the databse by 
     * using a while loop
     * @return 
     */

    
    public void getCustData(){
    	
    	

    	try{
    		
        	connection();
        	
		     statement.executeQuery("SELECT id, fname, lname, address, telephone FROM customers");
			 ResultSet rs = statement.getResultSet ();
			 
			 
				
		
while (rs.next ()){
							
				int id = rs.getInt("id");
				String name = rs.getString("fname");
				String dept = rs.getString("lname");
				String  salary = rs.getString ("address");
				int location = rs.getInt("telephone");
				
				System.out.println(id + "\t" + name + "\t" + dept + "\t" + salary + "\t" + location);
				
			}//end while

			rs.close ();
			statement.close ();
        	
        	}
        	catch (java.lang.NumberFormatException e){
        		
        		System.out.println("number format exception " );
        		 e.printStackTrace();
        		 
        	} catch (Exception e){
			System.err.println ("Cannot connect to database server");
			e.printStackTrace();
        }
   
	
	 }
    
/**
 * Returns a row of the database which has the customers
 * telephone number
 * @param number
 * @return
 */
    
    public String getCustomer(int number){
    	
    	int rowNumber = number;
    	
    	try{
    	 connection();
    	 statement.executeQuery("SELECT id, fname, lname, address, telephone, mobile FROM customers WHERE id =" + rowNumber);
    	 ResultSet rs = statement.getResultSet ();
    	 
    	 rs.first();
    	 
    	 
    	  System.out.println("Customer Number :" + rs.getInt("id") + " ");
          System.out.print("User Name :" + rs.getString("fname")); 
          System.out.println(" " + rs.getString("lname")); 
          System.out.println("Address:" + rs.getString("address")); 
          System.out.println("Telephone" + rs.getString("telephone")); 
          System.out.println("Mobile:  " + rs.getString("mobile")); 
          
          return "Customer: " + rs.getString("fname") + rs.getString("lname")
        		  +"\n" + "Address :" + rs.getString("address") 
        		  +"\n" + "Telephone :" +rs.getString("telephone")
        		  +"\n" + "Mobile number" + rs.getString("mobile") ;
          
          
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}
		return null;
    }
    
    /**
     * Get the invoice number and place it on the invoice form
     */
    
    public void getInvoiceNumber(){
    	
    	try{
    		
    		connection();
    		 statement.executeQuery("SELECT invoice_id FROM invoice ");    		 
        	 ResultSet rs = statement.getResultSet ();    
        	 rs.first();
        	 
        	 System.out.println(rs.getInt("invoice_id"));
        	 
    		
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}
    }
    
    /**
     * Increase the invoice number when 
     * create a new invoice is created
     */
    
    public void increaseInvoiceNumber(){
    	try{
    	
    	connection();
      	String QueryString = "INSERT INTO invoice (newInvoice) " 
    			+ " VALUES "
    			+ "('  New Invoice Number')";
    	
    	statement.executeUpdate(QueryString);
    	
    	
    	System.out.println("Added to invoice number");
    	
    	}
    	catch (java.lang.NumberFormatException e){
    		
    		System.out.println("number format exception " );
    		 e.printStackTrace();
    	}
    	
    	
    	catch (Exception e){
    		
    		e.printStackTrace();
    	}
    	
    	
    }
   
}
    
	       


