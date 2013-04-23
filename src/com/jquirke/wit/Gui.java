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
	
	
	private customerPanel  p1 = new customerPanel();
	private InvoicePanel  p2 = new InvoicePanel();
	private EditInvoices p4 = new EditInvoices();
	private ReportsPage p5 = new ReportsPage();
	private JPanel OptionsPanel = new JPanel();
	private InvoicePanel ip = new InvoicePanel();
	private SqlQueries con = new SqlQueries();
	private JLabel systemName = new JLabel("Invoice System Version 1.0 - Click Options Below");
	private JButton newInvoice = new JButton("Create New Invoice");
	private JButton newCustomer = new JButton("Create/Get Customer");
	private JButton editInvoice = new JButton("Edit Invoice Details");
	private JButton editCustomer= new JButton("Edit Customer Details");
	private JButton invReports = new JButton("Invoice Reports");
	// Borders around the buttons
	
	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	private Border raisedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private Border redline = BorderFactory.createLineBorder(Color.red);
	
	private Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel );  
	
	


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
		p5.getReportPagel();

		// Create a tabbed pane
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedPane.setUI(new BasicTabbedPaneUI());
		
		tabbedPane.insertTab("Options", new ImageIcon("icon.png"), OptionsPanel(), "tooltip", 0);
		tabbedPane.insertTab("Enter Customer Details", new ImageIcon("icon.png"), p1.getPanel1(), "tooltip", 1);
		tabbedPane.insertTab("Create Invoice ", new ImageIcon("icon.png"), p2.getPanel2(), "tooltip", 2);
		tabbedPane.insertTab("Edit Customer Details", new ImageIcon("icon.png"), p4.getPanel4(), "tooltip", 3);
		tabbedPane.insertTab("Reports Page", new ImageIcon("icon.png"), p5.getReportPagel(), "tooltip", 4);
		
		
		
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
	
	
	invReports.setBounds(240, 475, 300, 75);
	invReports.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
	invReports.addActionListener(this);
	
	editCustomer.setBounds(240, 600, 300, 75);
	editCustomer.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, Color.red));
	editCustomer.addActionListener(this);
	
	OptionsPanel.add(systemName);
	OptionsPanel.add(newInvoice);
	OptionsPanel.add(newCustomer);
	OptionsPanel.add(editInvoice);
	OptionsPanel.add(editCustomer);
	OptionsPanel.add(invReports);
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

if(e.getSource() == invReports ){
	
	
	tabbedPane.setSelectedIndex(4);
				
	}
}

}