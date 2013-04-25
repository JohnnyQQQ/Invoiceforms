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

public class ReportsPage {
	
	JPanel reportPanel = new JPanel();
	Inventory invent = new Inventory();
	
	Colors color = new Colors();
	
	private SqlQueries con = new SqlQueries();	
	
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
		
		
		JTextField custIdNumber = new JTextField();
		custIdNumber.setBounds(10,80,100,30);
		
		JButton detailsBtn = new JButton("Find Customers Details");
		detailsBtn.setBounds(130,80,200,30);
		
		reportPanel.add(detailsBtn);
		reportPanel.add(salesReports);
		reportPanel.add(invoiceTitle);
		reportPanel.add(custIdNumber);
		
		
	}




	public JPanel getReportPagel(){
		
		
		return reportPanel;
	}



}
