package com.jquirke.wit;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Gui extends JFrame {
	
	JTabbedPane tabbedPane;
	JPanel topPanel = new JPanel();
	OptionsPanel op = new OptionsPanel();
	Panel1 p1 = new Panel1();
	invoicePanel  p2 = new invoicePanel();
	Panel3 p3 = new Panel3();
	Panel4 p4 = new Panel4();
	int number = 2;


	public Gui(){
		
		
		setTitle( "Customer Invoice System John Quirke 2013" );
		setSize( 800, 800 );
		setBackground( Color.blue );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		
		op.createOptionsPanel();
		p1.createPanel1();
		p2.createPanel2();
		p3.createPanel3();
		p4.createPanel4();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedPane.addTab( "Options", op.OptionsPanel());	
		tabbedPane.addTab( "Customer Details", p1.getPanel1());
		tabbedPane.addTab( "Invoice Details", p2.getPanel2() );
		tabbedPane.addTab( "Checkout", p3.getPanel3() );
		tabbedPane.addTab( "Edit Invoice", p4.getPanel4() );
		
		topPanel.add( tabbedPane, BorderLayout.CENTER );
		
		
		//tabbedPane.setSelectedIndex(0);
		swithIndex(number);
		//System.out.println(number);
		setLocationRelativeTo(null);
	}
    // Main method to get things started
	
	public void swithIndex(int newIndex){
		
		number = newIndex;
		tabbedPane.setSelectedIndex(number );
		System.out.println(number);
	}
	

}