package com.jquirke.wit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class Gui extends JFrame implements ActionListener{
	
	JTabbedPane tabbedPane;
	JPanel topPanel = new JPanel();
	
	
	customerPanel  p1 = new customerPanel();
	InvoicePanel  p2 = new InvoicePanel();
	EditInvoices p4 = new EditInvoices();
	JPanel OptionsPanel = new JPanel();
	InvoicePanel ip = new InvoicePanel();
	SqlQueries con = new SqlQueries();
	JButton newInvoice = new JButton("Create New Invoice");
	JButton newCustomer = new JButton("Create/Get Customer");
	JButton editInvoice = new JButton("Edit Invoice Details");
	JButton editCustomer= new JButton("Edit Customer Details");
	// Borders around the buttons
	
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border raisedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Border redline = BorderFactory.createLineBorder(Color.red);
	
	Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel );  
	
	


	public Gui(){
		
		
		setTitle( "Customer Invoice System John Quirke 2013" );
		setSize( 800, 800 );
		setBackground( Color.blue );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add(topPanel);

		// Create the tab pages
		createOptionsPanel();
		p1.createPanel1();
		p2.createPanel2();
		p4.editInvoicePanel();

		// Create a tabbed pane
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedPane.setUI(new BasicTabbedPaneUI());
		
		tabbedPane.insertTab("Options", new ImageIcon("icon.png"), OptionsPanel(), "tooltip", 0);
		tabbedPane.insertTab("Enter Customer Details", new ImageIcon("icon.png"), p1.getPanel1(), "tooltip", 1);
		tabbedPane.insertTab("Invoice Details", new ImageIcon("icon.png"), p2.getPanel2(), "tooltip", 2);
		tabbedPane.insertTab("Edit Customer Details", new ImageIcon("icon.png"), p4.getPanel4(), "tooltip", 3);
		
		
		
		topPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 5, 5));
		topPanel.add( tabbedPane, BorderLayout.CENTER );
		
		tabbedPane.setSelectedIndex(0);
		
		setLocationRelativeTo(null);
	}
	
public int indexNumber(int number){
		
		return number;
	}

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
	
			
	
	newCustomer.setBounds(240, 225, 300, 75);
	newCustomer.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
	newCustomer.addActionListener(this);
	
	
	
	editInvoice.setBounds(240, 350, 300, 75);
	editInvoice.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
	editInvoice.addActionListener(this);
	
	
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
	tabbedPane.setSelectedIndex(2);
				
	}
if(e.getSource() == newCustomer){
	
	tabbedPane.setSelectedIndex(1);
				
	}
if(e.getSource() == editInvoice ){
	
	
	tabbedPane.setSelectedIndex(3);
				
	}
if(e.getSource() == editCustomer ){
	
	
	tabbedPane.setSelectedIndex(3);
				
	}


}

}