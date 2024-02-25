import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.colorchooser.ColorSelectionModel;

public class Balance extends JFrame implements ActionListener{
	JButton backButton;

	String pin;
	
	public Balance(String pin) {
		this.pin=pin;
		
		ImageIcon screen=new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen2= screen.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon screen3=new ImageIcon(screen2);
		JLabel image= new JLabel(screen3);
		add(image);
		
		backButton= new JButton("Back");
		backButton.setFocusable(false);
		backButton.setBounds(130,286,100,25);
		image.add(backButton);
		backButton.addActionListener(this);
		
		Db db= new Db();
		int balance=0;
		
		try {
			ResultSet result= db.s.executeQuery("select * from bank where pin = '" +pin+ "'");
			while (result.next()) {
				
				if (result.getString("type").equals("Deposit")) {
					balance+= Integer.parseInt(result.getString("amount"));
				}else {
					balance-= Integer.parseInt(result.getString("amount"));
				}}
			}catch (Exception e) {
					System.out.println(e);
				}
		
		JLabel value=new JLabel("Your Balance is $" + balance);
		value.setForeground(Color.WHITE);
		value.setFont(new Font("Ariel",Font.BOLD,16));
		value.setBounds(240,200,200,20);
		image.add(value);
				
		
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Balance("");

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==backButton) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
		
	}

}
