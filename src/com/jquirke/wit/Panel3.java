package com.jquirke.wit;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panel3 {
	JPanel panel3;
	
	public void createPanel3()
	
	
		{
			panel3 = new JPanel();
			panel3.setLayout( new GridLayout( 3, 2 ) );

			panel3.add( new JLabel( "Field 1:" ) );
			panel3.add( new TextArea() );
			panel3.add( new JLabel( "Field 2:" ) );
			panel3.add( new TextArea() );
			panel3.add( new JLabel( "Field 3:" ) );
			panel3.add( new TextArea() );
	

	}
	
	public JPanel getPanel3(){
		
		return panel3;
		
		
	}

}
