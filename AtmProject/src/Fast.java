import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import com.mysql.cj.protocol.Resultset;

public class Fast extends JFrame implements ActionListener{
		JButton withDrawal,balance,deposit,fast,pinChange,back;
		String pin;
	public Fast(String pin) {
		this.pin=pin;
		
		ImageIcon screen=new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen2= screen.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon screen3=new ImageIcon(screen2);
		JLabel image= new JLabel(screen3);
		add(image);
		
		JLabel title= new JLabel("SELECT THE AMOUNT");
		title.setBounds(250,110,200,30);
		title.setFont(new Font("Ariel",Font.BOLD,14));
		title.setForeground(Color.WHITE);
		image.add(title);
		
		withDrawal=new JButton("10");
		withDrawal.setFocusable(false);
		withDrawal.setBounds(130,157,110,30);
		image.add(withDrawal);
		withDrawal.addActionListener(this);
		
		balance=new JButton("20");
		balance.setFocusable(false);
		balance.setBounds(410,157,110,30);
		image.add(balance);
		balance.addActionListener(this);
		
		deposit=new JButton("50");
		deposit.setFocusable(false);
		deposit.setBounds(130,198,110,30);
		image.add(deposit);
		deposit.addActionListener(this);
		
		fast=new JButton("100");
		fast.setFocusable(false);
		fast.setBounds(410,198,110,30);
		image.add(fast);
		fast.addActionListener(this);
		
		pinChange=new JButton("200");
		pinChange.setFocusable(false);
		pinChange.setBounds(130,242,110,30);
		image.add(pinChange);
		pinChange.addActionListener(this);
		
		back=new JButton("Back");
		back.setFocusable(false);
		back.setBounds(410,242,110,30);
		image.add(back);
		back.addActionListener(this);
		
		
		
		
		setUndecorated(true);
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Fast("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}else {
			String amountString=((JButton)e.getSource()).getText().substring(0);
			Db db= new Db();
			try {
				ResultSet result= db.s.executeQuery("select * from bank where pin = '" +pin+ "'");
				int balance=0;
				while (result.next()) {
					if (result.getString("type").equals("Deposit")) {
						balance+= Integer.parseInt(result.getString("amount"));
					}else {
						balance-= Integer.parseInt(result.getString("amount"));
					}
					
					Date date= new Date();
					String queryString="insert into bank values('"+pin+"','"+date+"','Withdraw','"+amountString+"')";
					JOptionPane.showMessageDialog(null, "$"+amountString+" withdrawn successfully");
					setVisible(false);
					new Transactions(pin).setVisible(true);
					db.s.executeUpdate(queryString);
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		
	}

}