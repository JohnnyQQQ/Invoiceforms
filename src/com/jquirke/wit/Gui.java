package com.jquirke.wit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class Gui extends JFrame {
	
	JTabbedPane tabbedPane;
	JPanel topPanel = new JPanel();
	OptionsPanel op = new OptionsPanel();
	customerPanel  p1 = new customerPanel();
	InvoicePanel  p2 = new InvoicePanel();
	
	EditInvoices p4 = new EditInvoices();
	int number = 3;


	public Gui(){
		
		
		setTitle( "Customer Invoice System John Quirke 2013" );
		setSize( 800, 800 );
		setBackground( Color.blue );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add(topPanel);

		// Create the tab pages
		op.createOptionsPanel();
		p1.createPanel1();
		p2.createPanel2();
		p4.editInvoicePanel();

		// Create a tabbed pane
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedPane.setUI(new BasicTabbedPaneUI());
		
		tabbedPane.addTab( "Options", op.OptionsPanel());	
		tabbedPane.addTab( "Enter Customer Details", p1.getPanel1());
		tabbedPane.addTab( "Invoice Details", p2.getPanel2() );
		tabbedPane.addTab( "Edit Invoice", p4.getPanel4() );
		
		topPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 5, 5));
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