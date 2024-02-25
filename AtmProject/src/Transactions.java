import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class Transactions extends JFrame implements ActionListener{
		JButton withDrawal,balance,deposit,fast,pinChange,exit;
		String pin;
	public Transactions(String pin) {
		this.pin=pin;
		
		ImageIcon screen=new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen2= screen.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon screen3=new ImageIcon(screen2);
		JLabel image= new JLabel(screen3);
		add(image);
		
		JLabel title= new JLabel("WELCOME");
		title.setBounds(280,110,100,30);
		title.setFont(new Font("Ariel",Font.BOLD,14));
		title.setForeground(Color.WHITE);
		image.add(title);
		
		withDrawal=new JButton("Withdrawal");
		withDrawal.setFocusable(false);
		withDrawal.setBounds(130,157,110,30);
		image.add(withDrawal);
		withDrawal.addActionListener(this);
		
		balance=new JButton("Balance");
		balance.setFocusable(false);
		balance.setBounds(410,157,110,30);
		image.add(balance);
		balance.addActionListener(this);
		
		deposit=new JButton("Deposit");
		deposit.setFocusable(false);
		deposit.setBounds(130,198,110,30);
		image.add(deposit);
		deposit.addActionListener(this);
		
		fast=new JButton("Fast Cash");
		fast.setFocusable(false);
		fast.setBounds(410,198,110,30);
		image.add(fast);
		fast.addActionListener(this);
		
		pinChange=new JButton("Change PIN");
		pinChange.setFocusable(false);
		pinChange.setBounds(130,242,110,30);
		image.add(pinChange);
		pinChange.addActionListener(this);
		
		exit=new JButton("Exit");
		exit.setFocusable(false);
		exit.setBounds(410,242,110,30);
		image.add(exit);
		exit.addActionListener(this);
		
		
		
		
		setUndecorated(true);
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Transactions("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==exit) {
			System.exit(0);
		}else if (e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pin).setVisible(true);
		}else if (e.getSource()==withDrawal) {
			setVisible(false);
			new Withdraw(pin).setVisible(true);
		}else if (e.getSource()==fast) {
			setVisible(false);
			new Fast(pin).setVisible(true);
		}else if (e.getSource()==pinChange) {
			setVisible(false);
			new ChangePin(pin).setVisible(true);
		}else if (e.getSource()==balance) {
			setVisible(false);
			new Balance(pin).setVisible(true);
		}
	}

}
