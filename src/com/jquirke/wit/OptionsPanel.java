package com.jquirke.wit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class OptionsPanel implements ActionListener{
	JPanel OptionsPanel = new JPanel();
	InvoicePanel ip = new InvoicePanel();
	SqlQueries con = new SqlQueries();
	JButton newInvoice = new JButton("Create New Invoice");
	// Borders around the buttons
	
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border raisedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Border redline = BorderFactory.createLineBorder(Color.red);
	
	Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel );  
	
	
	public void createOptionsPanel()
	{
		OptionsPanel.setLayout(null);
		OptionsPanel.setBackground(Color.orange);
		
		JLabel systemName = new JLabel("Invoice System Version 1.0 - Click Options Below");
	    systemName.setForeground(Color.red);
		systemName.setBounds( 50,10, 500, 40 );
	    systemName.setFont(new Font("Serif", Font.PLAIN,20));
	    
		
		newInvoice.setBounds(240, 100, 300, 75);
		newInvoice.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
		newInvoice.addActionListener(this);
		
				
		JButton newCustomer = new JButton("Create/Get Customer");
		newCustomer.setBounds(240, 225, 300, 75);
		newCustomer.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
		newCustomer.addActionListener(this);
		
		
		JButton editInvoice = new JButton("Edit Invoice Details");
		editInvoice.setBounds(240, 350, 300, 75);
		editInvoice.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
		editInvoice.addActionListener(this);
		
		JButton editCustomer= new JButton("Edit Customer Details");
		editCustomer.setBounds(240, 475, 300, 75);
		editCustomer.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
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
