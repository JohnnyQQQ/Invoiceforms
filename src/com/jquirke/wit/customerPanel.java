package com.jquirke.wit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class customerPanel {
	
	JPanel panel1;
	
    SqlQueries con = new SqlQueries();
	
	Labels label = new Labels();
	JTextArea textArea = new JTextArea();
	JTextField firstname = new JTextField(80);
	JTextField lfield = new JTextField();
	JTextField addrField = new JTextField(20);
	JTextField addrField2 = new JTextField(20);
	JTextField addrField3 = new JTextField(20);
	JTextField addrField4 = new JTextField(20);
	JTextField telfield = new JTextField(20);
	JTextField mobTelfield = new JTextField();
	JTextArea commentsfield = new JTextArea(700,200);
	ButtonListener btnL = new ButtonListener();
	JButton save = new JButton("Save Customer Details");


	
	String input;
	
	public void createPanel1()
	{
		JLabel customerTitle = new JLabel("Please enter Customer Details: ");
		customerTitle.setForeground(Color.red);
		customerTitle.setBounds( 50,10, 500, 40 );
		customerTitle.setFont(new Font("Serif", Font.PLAIN,20));
	    
		panel1 = new JPanel();
		panel1.setLayout( null );
		panel1.setPreferredSize(new Dimension(775, 730));
		
		// First name
		panel1.add(label.enterCustomer());
		firstname.setBounds( 100, 100, 150, 20 );
		firstname.setSize(200,30);
		panel1.add(firstname);
		
		// Second name				
		panel1.add(label.lastName());
		lfield.setBounds( 440, 100, 150, 20 );
		lfield.setSize(200,30);		
		panel1.add(lfield);
		
		//Address
		panel1.add(label.addr());
		addrField.setBounds(100, 150, 150, 20 );
		addrField.setSize(200,30);	
		addrField.getText();
		addrField2.setBounds( 100, 190, 150, 20 );
		addrField2.setSize(200,30);
		addrField2.getText();
		addrField3.setBounds( 100, 230, 150, 20 );
		addrField3.setSize(200,30);
		addrField3.getText();
		addrField4.setBounds( 100, 270, 150, 20 );
		addrField4.setSize(200,30);
		addrField4.getText();
		
		panel1.add(customerTitle);
		panel1.add(addrField);	
		panel1.add(addrField2);		
		panel1.add(addrField3);		
		panel1.add(addrField4);		
		
		// Telephone numbers
		panel1.add(label.getTelephone());	
		telfield.setBounds(440, 200, 150, 20 );
		telfield.setSize(200,30);
		telfield.getText();
		panel1.add(telfield);
		
		// Mobile
		panel1.add(label.getMobile());
		mobTelfield.setBounds( 440, 250, 150, 20 );
		mobTelfield.setSize(200,30);
		mobTelfield.getText();	
		panel1.add(mobTelfield);	
		
		// Comments Box		
		panel1.add(label.getComment());		
		commentsfield.setBounds( 20, 340, 150, 20 );
		commentsfield.setSize(400,50);
		panel1.add(commentsfield);
	    
		
		save.setBounds( 275, 650, 150, 20 );
		save.setSize(200,50);
		save.addActionListener(btnL);
		panel1.add(save);
		
		panel1.add(label.getRecentCust());
		
		makeJTable();
		
	}
	
	
	public JPanel getPanel1(){
		
		return panel1;
		
	}
	
		
		
		

	class ButtonListener implements ActionListener {
		 String fname;
		 String lname;
		 @Override
		 public void actionPerformed(ActionEvent e) {

			 try{
				 
				 fname = firstname.getText();
				 lname = lfield.getText();
				 String address = addrField.getText() + " " + addrField2.getText() + " " + addrField3.getText() +" " + addrField4.getText();
				 String telephone = telfield.getText();
				 int landline  = Integer.parseInt(telephone);
				 String mobphone =  mobTelfield.getText();
				 int mobile  = Integer.parseInt(mobphone);
				 String comments  = commentsfield.getText();
				 con.insertCustomer(fname, lname, address, landline, mobile, comments);
				 confirmMessage();
				 clearBoxes();
				 System.out.println("Sent to database");
				 
				 
			 }catch(Exception ex){

				 JOptionPane warning = new JOptionPane();

				 warning.showMessageDialog(null, "Telephone Numbers must not have spaces and only numbers ", fname, JOptionPane.WARNING_MESSAGE);

				 System.out.print("Number format exception");

			 }
}
	
	
	  }
	/**
	 * Output the past customers that have been entered into the 
	 * database, onto the panel. This will make it easier to find the 
	 * customer by customer number.
	 */
	public void makeJTable(){
		try{
		con.connection();
		
        
		JTablesInfo tablePanel = new JTablesInfo();
		
			    panel1.add(tablePanel.getTableCustomers());
			    
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
			  }


	/**
	 * Cleear the text boxes after the save
	 * button has been pressed
	 */
	
	public void clearBoxes(){
		
		firstname.setText("");
		lfield.setText("");
		addrField.setText("");
		addrField2.setText("");
		addrField3.setText("");
		addrField4.setText("");
		telfield.setText("");
		commentsfield.setText("");
		mobTelfield.setText("");
	}

		   
	public void confirmMessage(){
		
		JOptionPane notification= new JOptionPane();
		notification.showMessageDialog(null, "Thank you, you have entered this customer into the database"
				+ "\n" + "Now Click on the create invoice tab to create invoice");
		
		panel1.revalidate();
		panel1.repaint();
		
		
	}
	
}// end code

