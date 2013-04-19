package com.jquirke.wit;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class CustomerAccountPanel {
	JPanel customerPanel = new JPanel();
	
	public void createPanel3() {
		
		customerPanel.setLayout(null);
		
		JLabel custDetails = new JLabel("Get Customer Details: ");
		custDetails.setForeground(Color.red);
		custDetails.setBounds( 50,10, 500, 40 );
		custDetails.setFont(new Font("Serif", Font.PLAIN,20));
			
	    customerPanel.add(custDetails);
	}
	
	public JPanel getPanel3(){
		
		return customerPanel;
		
		
	}

}
