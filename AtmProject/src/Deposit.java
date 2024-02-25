import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.management.QueryEval;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
	JButton depositButton,cancelButton;
	JTextField amountField;
	String pin;
	public Deposit(String pin) {
		this.pin=pin;
		ImageIcon screen=new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen2= screen.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon screen3=new ImageIcon(screen2);
		JLabel image= new JLabel(screen3);
		add(image);
		
		JLabel amount= new JLabel("Enter the amount");
		amount.setBounds(260,130,200,30);
		amount.setFont(new Font("Ariel",Font.BOLD,16));
		amount.setForeground(Color.WHITE);
		image.add(amount);
		
		amountField= new JTextField();
		amountField.setBounds(150,200,320,25);
		image.add(amountField);
		
		depositButton= new JButton("Deposit");
		depositButton.setBounds(410,286,100,25);
		image.add(depositButton);
		depositButton.addActionListener(this);
		
		cancelButton= new JButton("Cancel");
		cancelButton.setBounds(130,286,100,25);
		image.add(cancelButton);
		cancelButton.addActionListener(this);
		
		
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new Deposit("");

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==depositButton) {
			String amountValue=amountField.getText();
			Date date= new Date();
			if (amountValue.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount");
			}else {
				try {
					Db db= new Db();
					String queString= "insert into bank values('"+pin+"','"+date+"','Deposit','"+amountValue+"')";
					db.s.execute(queString);
					JOptionPane.showMessageDialog(null, "$"+amountValue+" Deposited Successfully");
					setVisible(false);
					new Transactions(pin).setVisible(true);
				} catch (Exception e2) {
					System.out.println(e);
				}
			}
			
			
			
		}else if (e.getSource()==cancelButton) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
		
	}

}
