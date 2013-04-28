//*******************************************
// John Quirke
// Invoice manager assignment
// BSc IT 2012 -2013
//***********************************************

package com.jquirke.wit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class EditInvoices implements ActionListener{

	private JPanel editInvoices = new JPanel();
	private SqlQueries con = new SqlQueries();
	private JTextArea custDetails = new JTextArea();
    
	//Labels
	private JLabel addr = new JLabel("Address: ");
	private JLabel lname = new JLabel( "Last Name: " );
	private JLabel fname = new JLabel( "First Name:" );
	private JLabel editCustLabel = new JLabel("Enter Customer Number to Edit: ");
	private JLabel editNotice = new JLabel("Here You can Edit, Update And Delete customers");
	private JLabel mobTel = new JLabel("Mobile: ");
	
	// Textfields
	private JTextField firstname = new JTextField(80);
	private JTextField editBox = new JTextField(40);
	private JTextField lfield = new JTextField();
	private JTextField addrField = new JTextField(20);
	private JTextField addrField2 = new JTextField(20);
	private JTextField addrField3 = new JTextField(20);
	private JTextField addrField4 = new JTextField(20);
	private JTextField telfield = new JTextField(20);
	private JTextField mobTelfield = new JTextField();
	private JTextField delBox = new JTextField();	
	
	// Buttons
	private JButton editCustNumber = new JButton("Lookup!");
	private JButton edit = new JButton("Edit Customer Details");
	private JButton delInv = new JButton("Delete Invoice");
	
	Colors color = new Colors();
	
	public void editInvoicePanel(){
		
		editInvoices.setLayout(null);
		
		
		editNotice.setForeground(color.headingCol());
		editNotice.setBounds( 50,10, 500, 40 );
		editNotice.setFont(new Font("Serif", Font.PLAIN,20));
		
		
		editCustLabel.setForeground(color.headingCol());
		editCustLabel.setBounds(30, 100, 400, 30);
		editCustLabel.setFont(new Font("Serif", Font.PLAIN,25));
		
		
		editBox.setBounds(450, 100, 100, 30);
		delBox.setBounds(450, 150, 100, 30);
		
		editInvoices.setBackground(color.panelCol());
		
		editCustNumber.setBounds(600, 100, 100, 30);
		editCustNumber.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, color.button()));
		editCustNumber.addActionListener(this);
		
		delInv.setBounds(600, 150, 100, 30);
		delInv.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, color.button()));
		delInv.addActionListener(this);
		
		
		custDetails.setBounds( 20, 150, 200,175);
		custDetails.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit This Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		
			
		editInvoices.add(delInv);
		editInvoices.add(delBox);
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
	
	fname.setBounds( 10, 400, 150, 20 );
	fname.setFont(new Font("Verdana", Font.BOLD,14));
	editInvoices.add(fname);
	
	firstname.setBounds( 100, 400, 150, 20 );
	firstname.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color.button()));
	firstname.setSize(200,30);
	editInvoices.add(firstname);
			
	// Second name	
	lname.setBounds( 350, 400, 150, 20 );	
	lname.setFont(new Font("Verdana", Font.BOLD,14));
	editInvoices.add(lname);
	
	lfield.setBounds( 440, 400, 150, 20 );
	lfield.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color.button()));
	lfield.setSize(200,30);		
	editInvoices.add(lfield);
			
			//Address
	
	addr.setBounds( 10,450, 150, 20 );	
	addr.setFont(new Font("Verdana", Font.BOLD,14));
	editInvoices.add(addr);
	
	addrField.setBounds(100, 450, 150, 20 );
	addrField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color.button()));
	addrField.setSize(200,30);	
	addrField.getText();
	
	addrField2.setBounds( 100, 490, 150, 20 );
	addrField2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color.button()));
	addrField2.setSize(200,30);
	addrField2.getText();
	
	addrField3.setBounds( 100, 530, 150, 20 );
	addrField3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color.button()));
	addrField3.setSize(200,30);
	addrField3.getText();
	
	addrField4.setBounds( 100, 570, 150, 20 );
	addrField4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color.button()));
	addrField4.setSize(200,30);
	addrField4.getText();
			
			
	editInvoices.add(addrField);	
	editInvoices.add(addrField2);		
	editInvoices.add(addrField3);		
	editInvoices.add(addrField4);		
			
			// Telephone numbers
	JLabel tel = new JLabel("Telephone: ");
	tel.setBounds( 350, 500, 150, 20 );
	tel.setFont(new Font("Verdana", Font.BOLD,14));
	editInvoices.add(tel);	
	telfield.setBounds(440, 500, 150, 20 );
	telfield.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, color.button()));
	telfield.setSize(200,30);
	
	telfield.getText();
	editInvoices.add(telfield);
			
			// Mobile
	
	mobTel.setBounds( 350, 550, 150, 20 );
	mobTel.setFont(new Font("Verdana", Font.BOLD,14));
	mobTelfield.setBounds( 440, 550, 150, 20 );
	mobTelfield.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, color.button()));
	mobTelfield.setSize(200,30);
	mobTelfield.getText();	
	editInvoices.add(mobTelfield);	
			
}


public void buttonCustomerEdit(){
	
	
	edit.setBounds( 275, 620, 150, 20 );
	edit.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, color.button()));
	edit.setSize(200,50);
	edit.addActionListener(this);
	editInvoices.add(edit);
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
try{
	if(e.getSource() == editCustNumber ){
		
		String custNum = editBox.getText();	
		int custnumber =Integer.parseInt(custNum);
		String text = con.getCustomer(custnumber);
		custDetails.setText(text);
			}
}catch(Exception num){
	 
	 JOptionPane notice = new JOptionPane();
		notice.showMessageDialog(null, "Please enter a Customer number",null, JOptionPane.WARNING_MESSAGE);
		System.out.println("Confirm pressed");
		System.out.print("No number entered");
}
	
if(e.getSource() == edit ){
	 try{
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
	
	 }catch(Exception num){
		 
		 JOptionPane notice = new JOptionPane();
			notice.showMessageDialog(null, "Please enter a Customer number",null, JOptionPane.WARNING_MESSAGE);
			System.out.println("Confirm pressed");
			System.out.print("No number entered");
			
	 }
		
	}

if(e.getSource() == delInv){
	

	 try{
		 
		JOptionPane.showConfirmDialog (null, "Are you sure you want delete this Invoice ?","Warning", 0);
		
		int delInvoice = Integer.parseInt(delBox.getText());
		
		con.delInvoice(delInvoice);
		
		JOptionPane.showMessageDialog (null, "Invoice Now Deleted","Warning", 0);
		 
	 }catch(Exception del){
		 
		 
	 }
}



}
}// end code
