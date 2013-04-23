package com.jquirke.wit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class EditInvoices implements ActionListener{

	private JPanel editInvoices = new JPanel();
	private SqlQueries con = new SqlQueries();
	private JButton editCustNumber = new JButton("Lookup!");
	private JTextArea custDetails = new JTextArea();
	private JTextField editBox = new JTextField(40);
	private Labels label = new Labels();
	private JTextField firstname = new JTextField(80);
	private JTextField lfield = new JTextField();
	private JTextField addrField = new JTextField(20);
	private JTextField addrField2 = new JTextField(20);
	private JTextField addrField3 = new JTextField(20);
	private JTextField addrField4 = new JTextField(20);
	private JTextField telfield = new JTextField(20);
	private JTextField mobTelfield = new JTextField();
	private JButton edit = new JButton("Edit Customer Details");
	
	public void editInvoicePanel(){
		
		editInvoices.setLayout(null);
		
		JLabel editNotice = new JLabel("Here You can Edit, Update And Delete customers");
		editNotice.setForeground(Color.red);
		editNotice.setBounds( 50,10, 500, 40 );
		editNotice.setFont(new Font("Serif", Font.PLAIN,20));
		
		JLabel editCustLabel = new JLabel("Enter Customer Number to Edit: ");
		editCustLabel.setForeground(Color.red);
		editCustLabel.setBounds(30, 100, 400, 30);
		editCustLabel.setFont(new Font("Serif", Font.PLAIN,25));
		
		
		editBox.setBounds(450, 100, 100, 30);
		
		
		
		editCustNumber.setBounds(600, 100, 100, 30);
		editCustNumber.addActionListener(this);
		
		
		custDetails.setBounds( 20, 150, 200,175);
		custDetails.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit This Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		
			
				
		editInvoices.add(editNotice);
		editInvoices.add(editCustLabel);
		editInvoices.add(editCustNumber);
		editInvoices.add(editBox);
		editInvoices.add(custDetails);
		editCustomerDetails();
		buttonCustomerEdit();
		
		
	}
	
public JPanel getPanel4(){
		
		return editInvoices;		
	}

public void editCustomerDetails(){
	
	// First name
	JLabel fname = new JLabel( "First Name:" );
	fname.setBounds( 10, 400, 150, 20 );
	fname.setFont(new Font("Verdana", Font.PLAIN,14));
	editInvoices.add(fname);
	firstname.setBounds( 100, 400, 150, 20 );
	firstname.setSize(200,30);
	editInvoices.add(firstname);
			
			// Second name	
	JLabel lname = new JLabel( "Last Name: " );
	lname.setBounds( 350, 400, 150, 20 );	
	lname.setFont(new Font("Verdana", Font.PLAIN,14));
	editInvoices.add(lname);
	lfield.setBounds( 440, 400, 150, 20 );
	lfield.setSize(200,30);		
	editInvoices.add(lfield);
			
			//Address
	JLabel addr = new JLabel("Address: ");
	addr.setBounds( 10,450, 150, 20 );	
	addr.setFont(new Font("Verdana", Font.PLAIN,14));
	editInvoices.add(addr);
	addrField.setBounds(100, 450, 150, 20 );
	addrField.setSize(200,30);	
	addrField.getText();
	addrField2.setBounds( 100, 490, 150, 20 );
	addrField2.setSize(200,30);
	addrField2.getText();
	addrField3.setBounds( 100, 530, 150, 20 );
	addrField3.setSize(200,30);
	addrField3.getText();
	addrField4.setBounds( 100, 570, 150, 20 );
	addrField4.setSize(200,30);
	addrField4.getText();
			
			
	editInvoices.add(addrField);	
	editInvoices.add(addrField2);		
	editInvoices.add(addrField3);		
	editInvoices.add(addrField4);		
			
			// Telephone numbers
	JLabel tel = new JLabel("Telephone: ");
	tel.setBounds( 350, 500, 150, 20 );
	tel.setFont(new Font("Verdana", Font.PLAIN,14));
	editInvoices.add(tel);	
	telfield.setBounds(440, 500, 150, 20 );
	telfield.setSize(200,30);
	telfield.getText();
	editInvoices.add(telfield);
			
			// Mobile
	JLabel mobTel = new JLabel("Mobile: ");
	mobTel.setBounds( 350, 550, 150, 20 );
	mobTel.setFont(new Font("Verdana", Font.PLAIN,14));
	editInvoices.add(mobTelfield);	
	mobTelfield.setBounds( 440, 550, 150, 20 );
	mobTelfield.setSize(200,30);
	mobTelfield.getText();	
	editInvoices.add(mobTelfield);	
			
}


public void buttonCustomerEdit(){
	
	
	edit.setBounds( 275, 650, 150, 20 );
	edit.setSize(200,50);
	edit.addActionListener(this);
	editInvoices.add(edit);
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	

	if(e.getSource() == editCustNumber ){
		
		String custNum = editBox.getText();	
		int custnumber =Integer.parseInt(custNum);
		String text = con.getCustomer(custnumber);
		custDetails.setText(text);
		
	}
	
if(e.getSource() == edit ){
	
	String custNum = editBox.getText();	
	int rowNumber =Integer.parseInt(custNum);
	
	String fname = firstname.getText();
	String lname = lfield.getText();
	String address = addrField.getText() + " " + addrField2.getText() + " " + addrField3.getText() +" " + addrField4.getText();
	String telephone = telfield.getText();
	int landline  = Integer.parseInt(telephone);
	String mobphone =  mobTelfield.getText();
	int mobile  = Integer.parseInt(mobphone);
	con.UpdateCustomer(fname, lname, address, landline, mobile, rowNumber);
	System.out.print("Edit Button Pressed");
		
	}
}




}// end code
