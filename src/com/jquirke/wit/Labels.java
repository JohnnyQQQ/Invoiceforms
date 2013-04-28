package com.jquirke.wit;
import java.awt.Font;

import javax.swing.JLabel;



public class Labels {
	
	
	public JLabel findCust(){		
		JLabel enterId = new JLabel("Enter Customer ID: ");
		enterId.setBounds( 400, 20, 150, 25 );		
		return enterId;		
	}
	
	public JLabel enterCustomer(){		
		JLabel fname = new JLabel( "First Name:" );
		fname.setBounds( 10, 100, 150, 20 );
		fname.setFont(new Font("Verdana", Font.PLAIN,14));
		return fname;			
	}
	
	public JLabel lastName(){
	JLabel lname = new JLabel( "Last Name: " );
	lname.setBounds( 350, 100, 150, 20 );	
	lname.setFont(new Font("Verdana", Font.PLAIN,14));
	return lname;
	}
	
	public JLabel addr(){
	JLabel addr = new JLabel("Address: ");
	addr.setBounds( 10,150, 150, 20 );	
	addr.setFont(new Font("Verdana", Font.PLAIN,14));
	return addr;
	}
	
	public JLabel getTelephone(){		
		JLabel tel = new JLabel("Telephone: ");
		tel.setBounds( 350, 200, 150, 20 );
		tel.setFont(new Font("Verdana", Font.PLAIN,14));
		return tel;
	}
	
	public JLabel getMobile(){		
		JLabel mobTel = new JLabel("Mobile: ");
		mobTel.setBounds( 350, 250, 150, 20 );
		mobTel.setFont(new Font("Verdana", Font.PLAIN,14));
		return mobTel;
	}
	
	public JLabel getComment(){		
		JLabel comments = new JLabel( "Comments: " );
		comments.setBounds( 10, 320, 150, 20 );	
		comments.setFont(new Font("Verdana", Font.PLAIN,14));
		return comments;
	}
	
	public JLabel getRecentCust(){		
		JLabel comments = new JLabel( "Recent Customers " );
		comments.setBounds( 10, 400, 150, 20 );	
		comments.setFont(new Font("Verdana", Font.PLAIN,14));
		return comments;
	}
	
	
	public JLabel getInvoiceNumber(){		
		JLabel invoiceNumber = new JLabel("Invoice Number :");
		invoiceNumber.setBounds( 300, 25, 150, 20 );
		invoiceNumber.setFont(new Font("Verdana", Font.PLAIN,14));
		return invoiceNumber;		
	}
	
	public JLabel clerkName(){		
		JLabel clerk= new JLabel("Sales rep: ");
		clerk.setBounds( 300,60, 150, 20 );
		clerk.setFont(new Font("Verdana", Font.PLAIN,14));
		return clerk;		
	}
	
	public JLabel getQty(){		
		JLabel qty= new JLabel("QTY");
		qty.setBounds( 20,250, 150, 20 );
		qty.setFont(new Font("Verdana", Font.BOLD,14));
		return qty;		
	}
	
	public JLabel getDesc(){		
		JLabel desc= new JLabel(" DESCRIPTION ");
		desc.setBounds( 150,250, 150, 20 );
		desc.setFont(new Font("Verdana", Font.BOLD,14));
		return desc;		
	}
	

	
	public JLabel getTotalCost(){		
		JLabel tc= new JLabel("TOTAL COST  €");
		tc.setBounds( 400,250, 150, 20 );
		tc.setFont(new Font("Verdana", Font.BOLD,14));
		return tc;		
	}
	
	public JLabel invoiceDetails(){		
		JLabel invDetails = new JLabel("Invoice details: ");
		invDetails.setBounds( 20,330, 150, 20 );
		invDetails.setFont(new Font("Verdana", Font.BOLD,14));
		return invDetails;		
	}
}// end labels
