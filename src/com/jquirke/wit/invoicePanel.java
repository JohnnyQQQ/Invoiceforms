package com.jquirke.wit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;






public class invoicePanel extends JPanel implements ActionListener{
	
	JPanel customers;
	JPanel top = new JPanel();
	SqlQueries con = new SqlQueries();	
	JPanel center = new JPanel();
	
	Labels label = new Labels();	
	TextBoxes textBox = new TextBoxes();
	JTextField custId =new JTextField(10);
	JButton button = new JButton("Search Customers");
	ButtonListener btnLis = new ButtonListener();
	JTextField qty = new JTextField(80);	
	JTextField number = new JTextField(80);	
	JButton save = new JButton(" Add ");
	JTextField Desc = new JTextField();
	JTextField unit = new JTextField();
	JTextField total = new JTextField();
	
	
	
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
		// Centre panel to be customer details
		center.setLayout(null);
		center.setPreferredSize(new Dimension(775, 730));	
		center.add(textBox.customerDetails());	
		
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
	 * add JLabel with invoice number and a dropdown list od the clerk
	 * @return
	 */
	
	public void addInvoiceDetails(){
		
		center.add(label.getInvoiceNumber());
		number.setBounds(430, 25, 150, 20 );
		number.setSize(150,30);	
		String text = con.getInvoiceNumber();
		number.setText(text);
		center.add(number);	
		
		center.add(label.clerkName());
		center.add(textBox.getSalesRep());
		
		
	}
	
	
	/**
	 * Return the panel to the main frame
	 * 
	 */
public JPanel getPanel2(){
	
		return customers;		
	}

public JButton searchButton(){		
	
	button.setBounds(600, 20, 150, 25 );
	button.addActionListener(btnLis);
	return button;
}

/**
 *Add the Actionlistener to get the database
 *customer details and print onto the invoice panel
 *text area
 */
class ButtonListener implements ActionListener{

public void actionPerformed(ActionEvent e) {
	
	String custNum = custId().getText();	
	int custnumber =Integer.parseInt(custNum);
	System.out.println(custNum);
	String text = con.getCustomer(custnumber);
	textBox.customerDetails().setText(text);
	
	
	
}

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
	
	save.setBounds( 690, 270, 150, 20 );
	save.setSize(80,30);
	save.addActionListener(this);
	center.add(save);
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == save){
		
		String qauntity = qty.getText();
		int quan = Integer.parseInt(qauntity);
		String description = Desc.getText();
		String units = unit.getText();
		int costpu = Integer.parseInt(units);
		String totals = total.getText();
		int totalAmt  = Integer.parseInt(totals);
		
	con.insertProduct(quan,description,costpu,totalAmt) ;
	
	System.out.println("Entered product");
				
	}
}


}// end code