import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupPage2 extends JFrame implements ActionListener{ 
	JRadioButton radio1,radio2,radio3,radio4;
	JCheckBox check1,check2,check3,check4,check5,check6;
	JButton submitButton,backButton;
	String formNumber;
	
	SignupPage2(String formNumber) {
		this.formNumber=formNumber;
		JLabel titleJLabel= new JLabel("Account Details");
		titleJLabel.setFont(new Font("Ariel",Font.BOLD,22));
		titleJLabel.setBounds(350,30, 300, 40);
		add(titleJLabel);
		
		JLabel acctype= new JLabel("Account Type: ");
		acctype.setFont(new Font("Ariel",Font.BOLD,22));
		acctype.setBounds(100, 130, 200, 40);
		add(acctype);
		radio1= new JRadioButton("Saving Account");
		radio1.setBounds(100,190,170,20);
		radio1.setFocusable(false);
		radio1.setFont(new Font("Ariel",Font.BOLD,16));
		radio1.setBackground(Color.WHITE);
		add(radio1);
		radio2= new JRadioButton("Business Account");
		radio2.setBounds(350,190,170,20);
		radio2.setFocusable(false);
		radio2.setFont(new Font("Ariel",Font.BOLD,16));
		radio2.setBackground(Color.WHITE);
		add(radio2);
		radio3= new JRadioButton("Fixed Deposit Account");
		radio3.setBounds(100,250,220,20);
		radio3.setFocusable(false);
		radio3.setFont(new Font("Ariel",Font.BOLD,16));
		radio3.setBackground(Color.WHITE);
		add(radio3);
		radio4= new JRadioButton("Current Account");
		radio4.setBounds(350,250,170,20);
		radio4.setFocusable(false);
		radio4.setFont(new Font("Ariel",Font.BOLD,16));
		radio4.setBackground(Color.WHITE);
		add(radio4);
		ButtonGroup accGroup=new ButtonGroup();
		accGroup.add(radio1);
		accGroup.add(radio2);
		accGroup.add(radio3);
		accGroup.add(radio4);
		
		JLabel cardNumber= new JLabel("Card Number");
		cardNumber.setFont(new Font("Ariel",Font.BOLD,22));
		cardNumber.setBounds(100, 310, 200, 40);
		add(cardNumber);
		JLabel cnumber= new JLabel("5040-XXXX-XXXX-XXXX");
		cnumber.setFont(new Font("Ariel",Font.BOLD,20));
		cnumber.setBounds(350, 310, 300, 40);
		add(cnumber);
		
		JLabel pinNumber= new JLabel("PIN");
		pinNumber.setFont(new Font("Ariel",Font.BOLD,22));
		pinNumber.setBounds(100, 380, 200, 40);
		add(pinNumber);
		JLabel pnumber= new JLabel("****");
		pnumber.setFont(new Font("Ariel",Font.BOLD,30));
		pnumber.setBounds(350, 380, 100, 40);
		add(pnumber);
		
		JLabel services= new JLabel("Services: ");
		services.setBounds(100,470,170,20);
		services.setFont(new Font("Ariel",Font.BOLD,22));
		add(services);
		check1=new JCheckBox("ATM Card");
		check1.setBounds(100,510,200,40);
		check1.setFocusable(false);
		check1.setBackground(Color.WHITE);
		check1.setFont(new Font("Ariel",Font.BOLD,15));
		add(check1);
		check2=new JCheckBox("Online Services");
		check2.setBounds(350,510,200,40);
		check2.setFocusable(false);
		check2.setBackground(Color.WHITE);
		check2.setFont(new Font("Ariel",Font.BOLD,15));
		add(check2);
		check3=new JCheckBox("Credit Services");
		check3.setBounds(600,510,200,40);
		check3.setFocusable(false);
		check3.setBackground(Color.WHITE);
		check3.setFont(new Font("Ariel",Font.BOLD,15));
		add(check3);
		check4=new JCheckBox("Insurance Services");
		check4.setBounds(100,570,200,40);
		check4.setFocusable(false);
		check4.setBackground(Color.WHITE);
		check4.setFont(new Font("Ariel",Font.BOLD,15));
		add(check4);
		check5=new JCheckBox("Foreign Currency Services");
		check5.setBounds(350,570,250,40);
		check5.setFocusable(false);
		check5.setBackground(Color.WHITE);
		check5.setFont(new Font("Ariel",Font.BOLD,15));
		add(check5);
		check6=new JCheckBox("Retirement Planning");
		check6.setBounds(600,570,200,40);
		check6.setFocusable(false);
		check6.setBackground(Color.WHITE);
		check6.setFont(new Font("Ariel",Font.BOLD,15));
		add(check6);
		
		submitButton=new JButton("Submit");
		submitButton.setBackground(Color.BLACK);
		submitButton.setForeground(Color.WHITE);
		submitButton.setFocusable(false);
		submitButton.setBounds(600,650,120,40);
		add(submitButton);
		submitButton.addActionListener(this);
		
		backButton=new JButton("Back");
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.setFocusable(false);
		backButton.setBounds(100,650,120,40);
		add(backButton);
		backButton.addActionListener(this);
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(850,800);
		setVisible(true);
		setLocation(350,10);
	}
	
	
	
	public static void main(String[] args) {
		new SignupPage2("");
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitButton) {
			String acctype=null;
			if(radio1.isSelected()) {
				acctype="Saving Account";
			}else if (radio2.isSelected()) {
				acctype=" Business Account";
			}else if (radio3.isSelected()) {
				acctype="Fixed Deposit Account";
			}else if (radio4.isSelected()) {
				acctype="Current Account";
			}
			
			Random randomNumber=new Random();
			String cardNumber=""+ Math.abs((randomNumber.nextLong()%90000000)+5040936000000000L);
			String pinNumber=""+ Math.abs((randomNumber.nextLong()%9000L)+1000L);
			String services="";
			if (check1.isSelected()) {
				services=services+"ATM Card";
			}else if (check2.isSelected()) {
				services=services+"Online Services";
			}else if (check3.isSelected()) {
				services=services+"Credit Services";
			}else if (check4.isSelected()) {
				services=services+"Insurance Services";
			}else if (check5.isSelected()) {
				services=services+"Foreign Currency Services";
			}else if (check6.isSelected()) {
				services=services+"Retirement Planning";
			}
			
			try {
				if(acctype=="") {
					JOptionPane.showMessageDialog(null, "Pick an account type");
				}else {
					Db db=new Db();
					String query2="insert into signupTwo values('"+formNumber+"','"+acctype+"','"+cardNumber+"','"+pinNumber+"','"+services+"')";
					String query22="insert into login values('"+formNumber+"','"+cardNumber+"','"+pinNumber+"')";
					db.s.execute(query2);
					db.s.execute(query22);
					
					JOptionPane.showMessageDialog(null, "Your Card Number: "+ cardNumber + "\nYour PIN: " + pinNumber);
					
					setVisible(false);
					new Deposit(pinNumber).setVisible(false);
				}
			} catch (Exception e2) {
				System.out.println(e);
			}
			
			
		}else if (e.getSource()==backButton) {
			setVisible(false);
			new TheMainPage().setVisible(true);
		}
		
	}

}
