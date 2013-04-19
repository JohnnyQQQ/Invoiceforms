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
	JTextField number = new JTextField(80);	
	JTextField qty = new JTextField(80);	
	
	String name;

	JTextField total= new JTextField();	
	
	
	
	
	public  JTextArea customerDetails(){		
		textArea.setBounds( 20, 25, 200,175);
		textArea.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		return textArea;		
	}	
	
	
	
	
	
	public String getfirstname(){
			
		
		return "John";
	   
	}
	
	

	
	public JTextField getInvNumber(){		
		
		number.setBounds(430, 25, 150, 20 );
		number.setSize(150,30);	
		
		return number;
	}
	
	public JComboBox getSalesRep(){	
		
		String names[] = {"Select rep","John Quirke","Mary Jones","Paddy Purcell","Joe Blogs"};
		JComboBox combo = new JComboBox(names);
		combo.setBounds(430, 60, 150, 20 );
		combo.setSize(150,30);	
		return combo;
	}
	// Invoice forms
	
	public JTextField setDesc(){		
		JTextField Desc = new JTextField();	
		Desc.setBounds(90,270, 150, 20);
		Desc.setSize(300,30);	
		
		return Desc;
	}
	
	public JTextField setUnit(){		
		JTextField unit= new JTextField();	
		unit.setBounds(390,270, 150, 20 );
		unit.setSize(150,30);	
		
		return unit;
	}
	
	public JTextField setTotal(){		
		
		total.setBounds(540,270, 150, 20 );
		total.setSize(150,30);	
		
		return total;
	}
}// end TextBoxes
