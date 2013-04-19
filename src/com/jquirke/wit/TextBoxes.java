package com.jquirke.wit;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TextBoxes {
	
	SqlQueries con = new SqlQueries();
	Labels label = new Labels();
	JTextArea textArea = new JTextArea();
	
	JTextField qty = new JTextField(80);	
	
	String name;

	
	
	
	
	
	public  JTextArea customerDetails(){		
		textArea.setBounds( 20, 25, 200,175);
		textArea.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		return textArea;		
	}	
	
	
	public JComboBox getSalesRep(){	
		
		String names[] = {"Select rep","John Quirke","Mary Jones","Paddy Purcell","Joe Blogs"};
		JComboBox combo = new JComboBox(names);
		combo.setBounds(430, 60, 150, 20 );
		combo.setSize(150,30);	
		return combo;
	}


}// end TextBoxes
