import javax.security.auth.login.LoginContext;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class TheMainPage extends JFrame implements ActionListener{
	JButton loginButton,signButton,clearButton;
	JTextField cardTextField;
	JPasswordField passTextField;
	TheMainPage(){
		setLayout(null);
		setTitle("ATM");
		ImageIcon ic1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image ic2= ic1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon ic3=new ImageIcon(ic2);
		JLabel label= new JLabel(ic3);
		label.setBounds(200,10,100,100);
		add(label);
		JLabel text=new JLabel("ATM");
		text.setFont(new Font("Arial",Font.BOLD,38));
		text.setBounds(320,40,100,40);
		add(text);
		JLabel cardNo=new JLabel("CARD NO:");
		cardNo.setFont(new Font("Arial",Font.BOLD,28));
		cardNo.setBounds(120,150,400,40);
		add(cardNo);
		cardTextField = new JTextField();
		cardTextField.setBounds(300,157,250,30);
		cardTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		add(cardTextField);
		JLabel password=new JLabel("PASSWORD:");
		password.setFont(new Font("Arial",Font.BOLD,28));
		password.setBounds(120,220,400,40);
		add(password);
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Courier", Font.PLAIN, 16));
		passTextField.setBounds(300,227,250,30);
		add(passTextField);
		loginButton= new JButton("LOGIN");
		loginButton.setFocusable(false);
		loginButton.setBounds(300,300,125,30);
		loginButton.setBackground(Color.black);
		loginButton.setForeground(Color.white);
		loginButton.addActionListener(this);
		add(loginButton);
		signButton= new JButton("SIGN UP");
		signButton.setFocusable(false);
		signButton.setBounds(430,300,125,30);
		signButton.setBackground(Color.black);
		signButton.setForeground(Color.white);
		signButton.addActionListener(this);
		add(signButton);
		clearButton= new JButton("CLEAR");
		clearButton.setFocusable(false);
		clearButton.setBounds(360,350,120,20);
		clearButton.setBackground(Color.BLUE);
		clearButton.setForeground(Color.white);
		clearButton.addActionListener(this);
		add(clearButton);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,500);
		setVisible(true);
		setLocation(350,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TheMainPage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==loginButton) {
			Db db= new Db();
			String cardNumber=cardTextField.getText();
			String pin= passTextField.getText();
			String query= "select * from login where cardNumber= '"+cardNumber+"' and pinNumber= '"+pin+"'";
			try {
				ResultSet resultset= db.s.executeQuery(query);
				if (resultset.next()) {
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Check your password or card number again");
				}
			} catch (Exception e2) {
				System.out.println(e);
			}
		}else if (e.getSource()==signButton) {
			setVisible(false);
			new SignUpPage().setVisible(true);
		}else if (e.getSource()==clearButton) {
			cardTextField.setText("");
			passTextField.setText("");
		} {
			
		}
		
	}

}
