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
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;






public class InvoicePanel extends JPanel implements ActionListener{
	
	private JPanel customers;
	private JPanel top = new JPanel();
	private SqlQueries con = new SqlQueries();	
	private JPanel center = new JPanel();
	private JPanel bottom = new JPanel();
	private Labels label = new Labels();	
	private JTextField custId =new JTextField(10);
	private JButton searchCust = new JButton("Search Customers");
		
	private JTextField number = new JTextField(80);	
	private JButton addRow = new JButton(" Add ");
	private JTextField Desc = new JTextField();
	private JTextField unit = new JTextField();
	private JTextField total = new JTextField();
	private JTextArea textArea = new JTextArea();
	private JButton newInv = new JButton("CREATE A NEW INVOICE!");
	private JComboBox combo = new JComboBox();
	private JComboBox qty = new JComboBox();
	String text = con.getInvoiceNumber();
	

	
	public void createPanel2()
	{
		// North Panel
		customers = new JPanel();
		customers.setLayout(new BorderLayout());
		customers.setPreferredSize(new Dimension(775, 730));
		
		top.setLayout(null);
		top.setPreferredSize(new Dimension(775, 75));
		
		top.add(label.findCust());
		top.add(custId());			
		top.add(searchButton());
		
		/*
		JLabel invoiceTitle = new JLabel("Enter Invoice Details Here: ");
		invoiceTitle.setForeground(Color.red);
		invoiceTitle.setBounds( 10,10, 500, 40 );
		invoiceTitle.setFont(new Font("Serif", Font.PLAIN,20));
		top.add(invoiceTitle);*/
		
		// Centre panel to be customer details
		center.setLayout(null);
		center.setPreferredSize(new Dimension(775, 730));	
		textArea.setBounds( 10, 25, 200,175);
		textArea.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		String cust = con.setCustomer();
		textArea.setText(cust);
		center.add(textArea);	
		
		// Add to top panel
		customers.add(top, BorderLayout.NORTH);
		customers.add(center, BorderLayout.CENTER);
		
		
		addInvoiceDetails();
		
		enterItems();
		
		
				
	}
	
public JTextField custId(){		
		
		custId.setBounds( 540, 20,50, 25);
		custId.setText(con.getLastCustomer());
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
		//center.add(label.clerkName());
		
		
		combo.addItem("Select rep");
		combo.addItem("John Quirke");
		combo.addItem("Paddy Purcell");
		combo.addItem("Joe Blogs");
		
		combo.addActionListener(this);
		combo.setBounds(430, 60, 150, 20 );
		combo.setSize(150,30);	
		center.add(combo);
		
		
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
	searchCust.addActionListener(this);
	return searchCust;
}

public JButton CreateNewInvoice(){		
	
	newInv.setBounds(10, 10, 230, 60 );
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
	center.add(label.getUnitCost());	
	center.add(label.getTotalCost());
	
	qty.setBounds(10,270, 150, 20 );
	qty.setSize(80,30);
	qty.addItem(1);
	qty.addItem(2);
	qty.addItem(3);
	qty.addItem(4);
	qty.addItem(5);
	qty.addItem(6);
	qty.addItem(7);
	qty.addItem(8);
	qty.addItem(9);
	center.add(qty);
	
	Desc.setBounds(90,270, 150, 20);
	Desc.setSize(300,30);	
	center.add(Desc);
		
	unit.setBounds(390,270, 150, 20 );
	unit.setSize(150,30);	
	center.add(unit);
	
	total.setBounds(540,270, 150, 20 );
	total.setSize(150,30);	
	center.add(total);
	
	addRow.setBounds( 690, 270, 150, 20 );
	addRow.setSize(80,30);
	addRow.addActionListener(this);
	center.add(addRow );
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == addRow ){
		
		
		int quan  = Integer.valueOf((int) qty.getSelectedItem());	
		String description = Desc.getText();
		String units = unit.getText();
		String invNumber = number.getText();
		int invoiceNum = Integer.parseInt(units);
		int costpu = Integer.parseInt(units);
		String totals = total.getText();
		int totalAmt  = Integer.parseInt(totals);
		String idNumber = custId.getText();
		int id = Integer.parseInt(idNumber);
		String saleRep = (String) combo.getSelectedItem();
	
		
		
	con.insertProduct(quan, description,costpu,totalAmt, id, saleRep, invoiceNum) ;
	
	//customers.add();
	customers.revalidate();
	validate();
	
	System.out.println("Entered product");
				
	}
	
	if(e.getSource() == searchCust){
		
		String custNum = custId().getText();	
		int custnumber =Integer.parseInt(custNum);
		String text = con.getCustomer(custnumber);
		textArea.setText(text);
	}
	
if(e.getSource() == newInv ){
		
		String custNum = custId().getText();	
		int custnumber =Integer.parseInt(custNum);
		String text = con.getCustomer(custnumber);
		textArea.setText(text);
	}
}




}// end code
