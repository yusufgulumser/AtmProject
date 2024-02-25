import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChangePin extends JFrame implements ActionListener{
	
	JButton change,cancel;
	JTextField nField,rField;
	String pin;
	public ChangePin(String pin) {
		this.pin=pin;
		ImageIcon screen=new ImageIcon(ClassLoader.getSystemResource("icons/screen.jpg"));
		Image screen2= screen.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon screen3=new ImageIcon(screen2);
		JLabel image= new JLabel(screen3);
		add(image);
		
		JLabel title= new JLabel("Change your PIN");
		title.setBounds(260,130,200,30);
		title.setFont(new Font("Ariel",Font.BOLD,16));
		title.setForeground(Color.WHITE);
		image.add(title);
		
		JLabel nPin= new JLabel("Enter new PIN");
		nPin.setBounds(140,200,200,30);
		nPin.setFont(new Font("Ariel",Font.BOLD,16));
		nPin.setForeground(Color.WHITE);
		image.add(nPin);
		
		nField = new JTextField();
		nField.setFont(new Font("Ariel",Font.BOLD,26));
		nField.setBounds(300,200,200,30);
		image.add(nField);
		
		JLabel rPin= new JLabel("Re-Enter new PIN");
		rPin.setBounds(140,240,200,30);
		rPin.setFont(new Font("Ariel",Font.BOLD,16));
		rPin.setForeground(Color.WHITE);
		image.add(rPin);
		
		rField = new JTextField();
		rField.setFont(new Font("Ariel",Font.BOLD,26));
		rField.setBounds(300,240,200,30);
		image.add(rField);
		
		change= new JButton("Change");
		change.setFocusable(false);
		change.setBounds(410,286,100,25);
		image.add(change);
		change.addActionListener(this);
		
		cancel= new JButton("Cancel");
		cancel.setFocusable(false);
		cancel.setBounds(130,286,100,25);
		image.add(cancel);
		cancel.addActionListener(this);
		
		
		
		
		setUndecorated(true);
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChangePin("").setVisible(true);;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==change) {
			
		
		try {
			String nPinString=nField.getText();
			String rPinString=rField.getText();
			if (!nPinString.equals(rPinString)) {
				JOptionPane.showMessageDialog(null, "PINs doesn't match");
				return;
			}
			
			if (nPinString.equals("")||rPinString.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter a new PIN");
				return;
			}
			
			Db db= new Db();
			String queryString= "update bank set pin = '"+rPinString+"' where pin = '"+pin+"'";
			String queryString2= "update login set pinNumber = '"+rPinString+"' where pinNumber = '"+pin+"'";
			String queryString3= "update signUpTwo set pinNumber = '"+rPinString+"' where pinNumber = '"+pin+"'";
			db.s.executeUpdate(queryString3);
			db.s.executeUpdate(queryString2);
			db.s.executeUpdate(queryString);
			
			JOptionPane.showMessageDialog(null, "PIN changed");
			setVisible(false);
			new Transactions(pin).setVisible(true);
			
		} catch (Exception e2) {
			System.out.println(e2);
		}
		}else {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
	}

}
