package com.jquirke.wit;
import java.sql.Connection;import java.sql.Statement;
import java.sql.DriverManager;import java.sql.ResultSet;
import java.sql.ResultSetMetaData;import java.sql.SQLException;
import javax.swing.JFrame;import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension; import javax.swing.JTextField;


public class JTablesInfo extends JFrame{
	private static final String JDBC_DRIVER = null;
	private static final String DATABASE_URL = null;

	final static String userName = "root";
	final static String password = "";
	final static String url = "jdbc:mysql://localhost:3306/invoicejava";
	JFrame frame = new JFrame("Frame");
	Statement statement = null;
	int updateQuery = 0;
	JPanel p = new JPanel();


	Connection conn = null;
	// JDBC driver name and database URL  
	String[] columnNames = {"Customer Number","First Name","LastName", "Address", "Telephone"};
	Object[][] data;   


	// constructor
	public JTablesInfo()
	{
		getData();
	}

	
	public void connection(){



		try{
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			conn = DriverManager.getConnection (url, userName, password);
			statement = conn.createStatement();
			java.sql.DatabaseMetaData dbMetaData = conn.getMetaData();
			String productName = dbMetaData.getDatabaseProductName();
			String productVersion = dbMetaData.getDatabaseProductVersion();
		}//end outer try
		catch (Exception e){
			System.err.println ("Cannot connect to database server");
			e.printStackTrace();
		}//end outer catch
	}

	/**
	 * Get the data from the database and return
	 * it in a JTable form and then add to 
	 * the panel
	 */

	public void getData(){

		connection();

		try 
		{

			ResultSet resultSet = statement.executeQuery("SELECT id, fname, lname , address, telephone FROM customers");
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount(); 
			data = new Object[100][numberOfColumns];

			int j=0,k=0;

			while ( resultSet.next() ) 
			{
				for ( int i = 1;i <=numberOfColumns; i++)
				{
					data[j][k] = resultSet.getObject( i );
					k++;

				}
				k=0; j++;
			} // end while


			JTable table = new JTable(data, columnNames );
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			JScrollPane scrollPane = new JScrollPane(table);
			add(scrollPane); 

			p.setLayout(new BorderLayout());
			p.setBounds(20, 430, 650, 300);
			p.setSize(730, 200);

			p.add(scrollPane);


		}  // end try
		catch ( SQLException sqlException ) 
		{
			sqlException.printStackTrace();
			System.exit( 1 );
		} // end catch

		finally // ensure statement and connection are closed properly
		{                                                             
			try {                                                          
				statement.close();                                      
				conn.close();                                     
			} // end try                                               
			catch ( Exception exception ) {                                                          
				exception.printStackTrace();                                     
				System.exit( 1 );                                       
			}                                           
		}                   
	}

/**
 * Retun the panel that will be added to  customers panel
 * 
 */
	public JPanel getTableCustomers(){

		return p;
	}

}// end class AuthorsJTable