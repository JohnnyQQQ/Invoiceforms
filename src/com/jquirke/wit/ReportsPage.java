package com.jquirke.wit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReportsPage implements ActionListener {
	
	JPanel reportPanel = new JPanel();
	Inventory invent = new Inventory();
	JTextField custIdNumber = new JTextField();
	JButton detailsBtn = new JButton("Find Customers Details");
	JLabel invoiceTitle = new JLabel("Reports Page: ");
	JTextField custDetails = new JTextField();
	SqlQueries con = new SqlQueries();
	Colors color = new Colors();
		
	public ReportsPage(){
		
		createReportPanel();
		
	}
	
	
	public void createReportPanel(){
		
		
		reportPanel.setLayout(null);
		reportPanel.setBackground(color.panelCol());
		JLabel invoiceTitle = new JLabel("Reports Page: ");
		
		invoiceTitle.setForeground(color.headingCol());
		invoiceTitle.setBounds( 10,10, 500, 40 );
		invoiceTitle.setFont(new Font("Serif", Font.PLAIN,20));
		
		JLabel salesReports = new JLabel("Sales reports: ");
		salesReports.setBounds(10,40,500,30);
		
		
		
		custIdNumber.setBounds(10,80,100,30);
		
		
		detailsBtn.setBounds(130,80,200,30);
		detailsBtn.addActionListener(this);
		
		custDetails.setBounds(10,130,300,200);
		custDetails.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Purchases", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		
		
		reportPanel.add(custDetails);
		reportPanel.add(detailsBtn);
		reportPanel.add(salesReports);
		reportPanel.add(invoiceTitle);
		reportPanel.add(custIdNumber);
		
		
	}




	public JPanel getReportPagel(){
		
		
		return reportPanel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == detailsBtn ){
			int idNum  = Integer.parseInt(custIdNumber.getText());
			
			String cust = con.customerDetails(idNum);
			custDetails.setText(cust);
			
		}
		
	}



}
