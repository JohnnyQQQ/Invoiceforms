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

	JPanel editInvoices = new JPanel();
	
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
		
		JTextField editBox = new JTextField(40);
		editBox.setBounds(450, 100, 100, 30);
		
		
		JButton editCustNumber = new JButton("Edit!");
		editCustNumber.setBounds(600, 100, 100, 30);
		editCustNumber.addActionListener(this);
		
		JTextArea custDetails = new JTextArea();
		custDetails.setBounds( 20, 150, 200,175);
		custDetails.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit This Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		//String cust = con.setCustomer();
		//custDetails.setText(cust);
			
		
		
		editInvoices.add(editNotice);
		editInvoices.add(editCustLabel);
		editInvoices.add(editCustNumber);
		editInvoices.add(editBox);
		editInvoices.add(custDetails);
		
		
	}
	
public JPanel getPanel4(){
		
		return editInvoices;		
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


}
