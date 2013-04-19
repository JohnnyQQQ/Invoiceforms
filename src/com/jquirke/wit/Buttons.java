package com.jquirke.wit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;




public class Buttons {
	
	//BottonListener btnLis = new BottonListener();
	Labels label = new Labels();
	SqlQueries con = new SqlQueries();
	JButton button = new JButton("Search Customers");
	
	


	
	
	
	public JButton addButton(){	
		JButton save = new JButton(" Add ");
		save.setBounds( 690, 270, 150, 20 );
		save.setSize(80,30);
	//	save.addActionListener(btnLis);
		return save;
		}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	
		
			
		}
		
		
		
	}
	

		
		
		

		

		
		


