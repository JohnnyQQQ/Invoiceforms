package com.jquirke.wit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Panel1 {
	
	JPanel panel1;
	
    SqlQueries con = new SqlQueries();
	Buttons buttons = new Buttons();
	Labels label = new Labels();
	TextBoxes text = new TextBoxes();
	JTextArea textArea = new JTextArea();
	JTextField firstname = new JTextField(80);
	JTextField lfield = new JTextField();
	JTextField addrField = new JTextField(20);
	JTextField addrField2 = new JTextField(20);
	JTextField addrField3 = new JTextField(20);
	JTextField addrField4 = new JTextField(20);
	JTextField telfield = new JTextField(20);
	JTextField mobTelfield = new JTextField();
	JTextArea commentsfield = new JTextArea("Enter other relevent details", 700,200);
	ButtonListener btnL = new ButtonListener();
	JButton save = new JButton("Save Customer Details");


	
	String input;
	
	public void createPanel1()
	{
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
		mobTelfield.setBounds( 440, 250, 150, 20 );
		mobTelfield.setSize(200,30);
		mobTelfield.getText();	
		panel1.add(mobTelfield);	
		
		// Comments Box		
		panel1.add(label.getComment());		
		commentsfield.setBounds( 40, 380, 150, 20 );
		commentsfield.setSize(700,200);
		commentsfield.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other Notes :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 11)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		panel1.add(commentsfield);
	    
		
		save.setBounds( 275, 650, 150, 20 );
		save.setSize(200,50);
		save.addActionListener(btnL);
		panel1.add(save);
		
	}
	
	
	public JPanel getPanel1(){
		
		return panel1;
		
	}
	
		
		
		

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		System.out.println("Button Pressed");
			String fname = firstname.getText();
			String lname = lfield.getText();
			String address = addrField.getText() + " " + addrField2.getText() + " " + addrField3.getText() +" " + addrField4.getText();
			String telephone = telfield.getText();
			int landline  = Integer.parseInt(telephone);
			String mobphone =  mobTelfield.getText();
			int mobile  = Integer.parseInt(mobphone);
			String comments  = commentsfield.getText();
			
			//Pass the input into the database
		
		con.insertCustomer(fname, lname, address, landline, mobile, comments);
		
	    
		Gui gu = new Gui();
		gu.swithIndex(3);
		
		
}
	
	
	
	
	  }
}

