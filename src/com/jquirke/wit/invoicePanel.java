package com.jquirke.wit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;






public class InvoicePanel extends JPanel implements ActionListener{
	private SqlQueries con = new SqlQueries();	
	//Panels
	private JPanel customers  = new JPanel();
	private JPanel top = new JPanel();
	private JPanel center = new JPanel();
	private JPanel bottom = new JPanel();
	//labels
	private Labels label = new Labels();
	//TextFields
	private JTextField custId =new JTextField(10);
	private JTextField number = new JTextField(80);	
	private JTextField total = new JTextField();
	
	// TextArea
	private JTextArea textArea = new JTextArea();
	private JTextArea invoiceArea = new JTextArea();
	
	//Buttons
	private JButton searchCust = new JButton("Search Customers");
	private JButton addRow = new JButton("Add Product to Invoice");
	private JButton newInv = new JButton("CREATE A NEW INVOICE!");
	private JButton confirm = new JButton("Confirm Order");
	
	//Combo
	private JComboBox combo = new JComboBox();
	
	
	// Borders
	Border compound;
	Border redline = BorderFactory.createLineBorder(Color.red);
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border raisedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	
	Inventory invent = new Inventory();
	String text = con.getInvoiceNumber();
	Colors color = new Colors();
	

	
	public void createPanel2()
	{
		// North Panel
		
		customers.setBackground(color.panelCol());
		customers.setLayout(new BorderLayout());
		customers.setPreferredSize(new Dimension(775, 730));
		
		top.setLayout(null);
		top.setBackground(color.panelCol());
		top.setPreferredSize(new Dimension(775, 75));
		
		top.add(label.findCust());
		top.add(custId());			
		top.add(searchButton());
		
		/* No Space now
		JLabel invoiceTitle = new JLabel("Enter Invoice Details Here: ");
		invoiceTitle.setForeground(Color.red);
		invoiceTitle.setBounds( 10,10, 500, 40 );
		invoiceTitle.setFont(new Font("Serif", Font.PLAIN,20));
		top.add(invoiceTitle);*/
		
		// Centre panel to be customer details
		center.setLayout(null);
		center.setBackground(color.panelCol());
		center.setPreferredSize(new Dimension(775, 730));	
		
		textArea.setBounds( 10, 25, 200,175);
		
		textArea.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		
		// Taken this code out, it shows the last customer in the database on the text Field
		// maybe better if the button pressed does it instead
		// String cust = con.setCustomer();
		// textArea.setText(cust);
		
	  	confirm.setBounds(550, 400, 150,50);
		confirm.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, color.button()));
		confirm.addActionListener(this);
	
		center.add(confirm);
		center.add(textArea);	
		
		// Add to top panel
		customers.add(top, BorderLayout.NORTH);
		customers.add(center, BorderLayout.CENTER);
		
		
		addInvoiceDetails();
		
		enterItems();
		
		
				
	}
	
public JTextField custId(){		
		
		custId.setBounds( 540, 20,50, 25);
	  
		return custId;
	}
	
	/**
	 * Display the invoice number on the invoice and auto increment
	 * when a new invoice is created.
	 * add JLabel with invoice number and a dropdown list of the clerk
	 * @return
	 */
	
	public void addInvoiceDetails(){
		
		center.add(label.getInvoiceNumber());
		number.setBounds(430, 25, 150, 20 );
		number.setSize(150,30);	
			
	    number.setText(text);
		center.add(number);	
		center.add(label.clerkName());
		
		combo.addItem("Select rep");
		combo.addItem("John Quirke");
		combo.addItem("Paddy Purcell");
		combo.addItem("Joe Blogs");
		
		combo.addActionListener(this);
		combo.setBounds(430, 60, 150, 20 );
		
		combo.setSize(150,30);	
		center.add(combo);
		
		invoiceArea.setBounds(20,360, 500, 150);
		invoiceArea.setFont(new Font("Verdana", Font.BOLD,16));
		invoiceArea.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, color.button()));
		center.add(invoiceArea);
		center.add(label.invoiceDetails());
				
		top.add(CreateNewInvoice());
			
	}
	
	
	/**
	 * Return the panel to the main frame
	 * 
	 */
public JPanel getPanel2(){
	
		return customers;		
	}

public JButton searchButton(){		
	
	searchCust.setBounds(600, 20, 150, 25 );
	searchCust.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, color.button()));
	searchCust.addActionListener(this);
	return searchCust;
}

public JButton CreateNewInvoice(){		
	
	newInv.setBounds(10, 10, 230, 60 );
	newInv.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, color.button()));
	newInv.addActionListener(this);
	return newInv;
}



/**
 * Create the entering details part of the invoice
 * The sales clerk will enter invoice data and on 
 * completing the information will be passed to the database
 */

public void enterItems(){
	
	center.add(label.getQty());	
	center.add(label.getDesc());	
	center.add(label.getTotalCost());
	center.add(invent.qtyOptions());
	center.add(invent.stockOnHand());
		

	
 	total.setBounds(400,270, 150, 20 );
	total.setFont(new Font("Verdana", Font.BOLD,16));
	total.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color.button()));
	
	
	total.setSize(140,30);	
	center.add(total);
	
	addRow.setBounds( 550, 270, 150, 20 );
	addRow.setBorder(BorderFactory.createMatteBorder(1, 8, 1, 1, color.button()));
	addRow.setSize(180,30);
	addRow.addActionListener(this);
	
	center.add(addRow );
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == addRow ){
		
		try{
		int quan  = Integer.valueOf((int) invent.qtyOptions().getSelectedItem());	
		String description = (String) invent.stockOnHand().getSelectedItem();
		String invNumber = number.getText();
		int invoiceNum = Integer.parseInt(invNumber);		
		String totals = total.getText();
		int totalAmt  = Integer.parseInt(totals);
		String idNumber = custId.getText();
		int id = Integer.parseInt(idNumber);
		String saleRep = (String) combo.getSelectedItem();
	
		invoiceArea.append("  " + quan + "  " +description+ "  " + totalAmt +"\n" );
		
	con.insertProduct(quan, description,totalAmt, id, saleRep, invoiceNum) ;
		}catch(NumberFormatException nfe){
			
			JOptionPane notice = new JOptionPane();
			notice.showMessageDialog(null, "Please enter a cost price ", text, JOptionPane.WARNING_MESSAGE);
			System.out.println("Confirm pressed");
			System.out.print("No number entered");
		}
	
	//customers.add();
	
	
	System.out.println("Entered product");
				
	}
	
	if(e.getSource() == searchCust){
		try{
		String custNum = custId().getText();	
		int custnumber =Integer.parseInt(custNum);
		String text = con.getCustomer(custnumber);
		textArea.setText(text);
		}catch(Exception f){
			
			JOptionPane notice = new JOptionPane();
			notice.showMessageDialog(null, "Please enter a Customer number", text, JOptionPane.WARNING_MESSAGE);
			System.out.println("Confirm pressed");
			System.out.print("No number entered");
		}
	}
	
if(e.getSource() == newInv ){
		
		String custNum = con.getLastCustomer();	
		custId.setText(con.getLastCustomer());
		int custnumber =Integer.parseInt(custNum);
		String text = con.getCustomer(custnumber);
		textArea.setText(text);
		
	}

if(e.getSource() == confirm ){
	
	 JOptionPane notice = new JOptionPane();

	 notice.showMessageDialog(null, "Thank you your order has been confirmed ", text, JOptionPane.WARNING_MESSAGE);
	System.out.println("Confirm pressed");
	
}



}


}// end code
