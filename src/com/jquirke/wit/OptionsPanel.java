package com.jquirke.wit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OptionsPanel implements ActionListener{
	JPanel OptionsPanel = new JPanel();
	invoicePanel ip = new invoicePanel();
	SqlQueries con = new SqlQueries();
	JButton newInvoice = new JButton("Create New Invoice");
	
	
	public void createOptionsPanel()
	{
		OptionsPanel.setLayout(null);
		
		JLabel systemName = new JLabel("Invoice System Version 1.0 - Click Options Below");
	    systemName.setForeground(Color.red);
		systemName.setBounds( 50,10, 500, 40 );
	    systemName.setFont(new Font("Serif", Font.PLAIN,20));
	    
		
		newInvoice.setBounds(240, 100, 300, 75);
		newInvoice.addActionListener(this);
		
				
		JButton newCustomer = new JButton("Create/Get Customer");
		newCustomer.setBounds(240, 225, 300, 75);
		newCustomer.addActionListener(this);
		
		
		JButton editInvoice = new JButton("Edit Invoice Details");
		editInvoice.setBounds(240, 350, 300, 75);
		editInvoice.addActionListener(this);
		
		JButton editCustomer= new JButton("Edit Customer Details");
		editCustomer.setBounds(240, 475, 300, 75);
		editCustomer.addActionListener(this);
		
		OptionsPanel.add(systemName);
		OptionsPanel.add(newInvoice);
		OptionsPanel.add(newCustomer);
		OptionsPanel.add(editInvoice);
		OptionsPanel.add(editCustomer);
	}
	
	
public JPanel OptionsPanel(){
		
		return OptionsPanel;
		
	}

public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == newInvoice ){
		
		con.getInvoiceNumber();
		con.increaseInvoiceNumber();
		ip.addInvoiceDetails();
					
		}
	
	
}



}// end code
