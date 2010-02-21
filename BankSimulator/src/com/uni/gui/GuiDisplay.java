package com.uni.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.uni.main.Statistics;

public class GuiDisplay extends JFrame{

	SpringLayout layout;
	JPanel jp;
	
	private int north = 35;
	private int westLabel = 5;
	private int westText = 125;
	private int padding = 35;
	
	
	public GuiDisplay(){
		super();
		this.setBounds(50, 50, 400, 400);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
				initComponents();
	
	}
	
	private void initComponents(){
		jp = new JPanel();
		layout = new SpringLayout();
		jp.setLayout(layout);
		
		Font f = this.getFont();
		
		//while we have the font set the padding
		FontMetrics fM = this.getFontMetrics(f);
		this.westText = fM.stringWidth("  Accounts Opened:     ");
		
		//biiiig font for heading
		f = f.deriveFont(new Float(20));
		JLabel header = new JLabel("Royal Bank of Jon");
		header.setFont(f);
		
		
		
		jp.add(header);
		
		//addPair("Royal Bank of Jon", "", 90);
		
		addPair("Customers Served:",Statistics.CUSTOMERS_SERVED,0);
		addPair("Accounts Opened:",Statistics.ACCOUNTS_OPENED,20);
		addPair("Accounts Closed:",Statistics.ACCOUNTS_CLOSED,20);
		addPair("Account Deposits:",Statistics.ACCOUNT_DEPOSIT,20);
		addPair("Total:", Statistics.toPoundsAndPence(Statistics.TOTALS_DEPOSTIT),40);
		addPair("Account Withdraw:", Statistics.ACCOUNT_WITHDRAW,20);
		addPair("Total:", Statistics.toPoundsAndPence(Statistics.TOTALS_WITHDRAW),40);
		

        
        super.add(jp);
	}
	
	
	private void addPair(String label, int intMessage, int hOffset){
		String message = intMessage + "";
		addPair(label,message, hOffset);
	}
	
	private void addPair(String label, double doubleMessage, int hOffset){
		String message = doubleMessage + "";
		addPair(label,message, hOffset);
	}
	
	private void addPair(String label, String message, int hOffset){
		JLabel custLabel = new JLabel(label);
		JLabel label2 = new JLabel(message);
		
		Font f = (jp.getFont());
		f = f.deriveFont(Font.PLAIN);
		
		label2.setFont(f);
		
		
		jp.add(custLabel);
        jp.add(label2);
		
        layout.putConstraint(SpringLayout.WEST, custLabel,westLabel+hOffset,SpringLayout.WEST, jp);
        layout.putConstraint(SpringLayout.NORTH, custLabel,north,SpringLayout.NORTH, jp);
		
        layout.putConstraint(SpringLayout.WEST, label2,westText+hOffset,SpringLayout.WEST, jp);
        layout.putConstraint(SpringLayout.NORTH, label2,north,SpringLayout.NORTH, jp);	
        
        north += padding;
        
	}
	
}
