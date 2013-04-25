package com.jquirke.wit;

import javax.swing.JComboBox;

public class Inventory {
	
	
	private JComboBox qty = new JComboBox();
	private JComboBox  Desc = new JComboBox ();
	
	public JComboBox qtyOptions(){
		
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
		
		return qty;
	}
	
	public JComboBox stockOnHand(){
		
		Desc.setBounds(90,270, 150, 20);
		Desc.setSize(300,30);
		Desc.addItem("Empress Single Bed");
		Desc.addItem("Empress DoubleBed");
		Desc.addItem("Chester 3 Piece Suite");
		Desc.addItem("Oxford Leather Suite");
		Desc.addItem("Tulsa Dining Table and 6 chairs");
		Desc.addItem("Arizona Dining set 4 chairs");
		Desc.addItem("Vienna 2ft coffeetable");
		Desc.addItem("Mahogany half moon table");
		Desc.addItem("Vanessa Pine 4'6 Bed");
		Desc.addItem("Naples Chunky 4'6 bed");
		Desc.addItem("Oregeon Kingsize leather bed");
		Desc.addItem("Solid Oak armchair");
		Desc.addItem("Twist dining set and 4 chairs");
		Desc.addItem("Computer Stool");
		
		return Desc;
		
		
		
		
		
		
	}

}
