package com.jquirke.wit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OptionsPanel {
	JPanel OptionsPanel = new JPanel();
	ButtonListener opts = new ButtonListener();
	SqlQueries con = new SqlQueries();	
	
	public void createOptionsPanel()
	{
		OptionsPanel.setLayout(null);
		
		JLabel systemName = new JLabel("Invoice System Version 1.0 - Click Options Below");
	    systemName.setForeground(Color.red);
		systemName.setBounds( 50,10, 500, 40 );
	    systemName.setFont(new Font("Serif", Font.PLAIN,20));
	    
		JButton newInvoice = new JButton("Create New Invoice");
		newInvoice.setBounds(240, 100, 300, 75);
		newInvoice.addActionListener(opts);
		
		JButton newCustomer = new JButton("Create/Get Customer");
		newCustomer.setBounds(240, 225, 300, 75);
		newCustomer.addActionListener(opts);
		
		JButton editInvoice = new JButton("Edit Invoice Details");
		editInvoice.setBounds(240, 350, 300, 75);
		editInvoice.addActionListener(opts);
		
		JButton editCustomer= new JButton("Edit Customer Details");
		editCustomer.setBounds(240, 475, 300, 75);
		editCustomer.addActionListener(opts);
		
		OptionsPanel.add(systemName);
		OptionsPanel.add(newInvoice);
		OptionsPanel.add(newCustomer);
		OptionsPanel.add(editInvoice);
		OptionsPanel.add(editCustomer);
	}
	
	
public JPanel OptionsPanel(){
		
		return OptionsPanel;
		
	}

class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		con.increaseInvoiceNumber();
	}
	
	
}

}
