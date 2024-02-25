import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class SignUpPage extends JFrame implements ActionListener{

	long rand;
	JTextField nameField,idNoField,motherField,mailField,countryField,cityField,postField,phoneField;
	JRadioButton maleButton,femaleButton,marriedButton,singleButton;
	JButton nextButton;
	JDateChooser birthChooser;
	JLabel formNumber;
	SignUpPage() {
		Random randomNumber= new Random();
		rand= Math.abs((randomNumber.nextLong()%100)+1000L);
		formNumber = new JLabel("APPLICATION " + rand);
		formNumber.setFont(new Font("Ariel",Font.BOLD,36));
		formNumber.setBounds(230, 10, 600, 40);
		add(formNumber);
		
		JLabel perInfo = new JLabel("Personal Information");
		perInfo.setFont(new Font("Ariel",Font.BOLD,20));
		perInfo.setBounds(280, 60, 300, 40);
		add(perInfo);
		
		
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Ariel",Font.BOLD,16));
		name.setBounds(100, 120, 300, 30);
		add(name);
		nameField= new JTextField();
		nameField.setFont(new Font("Ariel",Font.BOLD,14));
		nameField.setBounds(300,120,400,30);
		add(nameField);
		
		JLabel idNo = new JLabel("ID number: ");
		idNo.setFont(new Font("Ariel",Font.BOLD,16));
		idNo.setBounds(100, 170, 300, 30);
		add(idNo);
		idNoField= new JTextField();
		idNoField.setFont(new Font("Ariel",Font.BOLD,14));
		idNoField.setBounds(300,170,400,30);
		add(idNoField);
		
		
		JLabel birth = new JLabel("Birthday: ");
		birth.setFont(new Font("Ariel",Font.BOLD,16));
		birth.setBounds(100, 220, 300, 30);
		add(birth);
		birthChooser=new JDateChooser();
		birthChooser.setBounds(300,220,200,30);
		add(birthChooser);
		
		
		JLabel gender  = new JLabel("Gender: ");
		gender.setFont(new Font("Ariel",Font.BOLD,16));
		gender.setBounds(100, 270, 300, 30);
		add(gender);
		maleButton=new JRadioButton("Male");
		maleButton.setFocusable(false);
		maleButton.setBounds(300,270,60,30);
		maleButton.setBackground(Color.WHITE);
		add(maleButton);
		femaleButton=new JRadioButton("Female");
		femaleButton.setFocusable(false);
		femaleButton.setBounds(450,270,70,30);
		femaleButton.setBackground(Color.WHITE);
		add(femaleButton);
		ButtonGroup genderButtonGroup=new ButtonGroup();
		genderButtonGroup.add(femaleButton);
		genderButtonGroup.add(maleButton);
		
		JLabel mother  = new JLabel("Mother's name: ");
		mother.setFont(new Font("Ariel",Font.BOLD,16));
		mother.setBounds(100, 320, 300, 30);
		add(mother);
		motherField= new JTextField();
		motherField.setFont(new Font("Ariel",Font.BOLD,14));
		motherField.setBounds(300,320,400,30);
		add(motherField);
		
		JLabel phone  = new JLabel("Phone Number: ");
		phone.setFont(new Font("Ariel",Font.BOLD,16));
		phone.setBounds(100, 370, 300, 30);
		add(phone);
		phoneField= new JTextField();
		phoneField.setFont(new Font("Ariel",Font.BOLD,14));
		phoneField.setBounds(300,370,400,30);
		add(phoneField);
		
		JLabel mail  = new JLabel("Email: ");
		mail.setFont(new Font("Ariel",Font.BOLD,16));
		mail.setBounds(100, 420, 300, 30);
		add(mail);
		mailField= new JTextField();
		mailField.setFont(new Font("Ariel",Font.BOLD,14));
		mailField.setBounds(300,420,400,30);
		add(mailField);
		
		JLabel marital  = new JLabel("Marital Status: ");
		marital.setFont(new Font("Ariel",Font.BOLD,16));
		marital.setBounds(100, 470, 300, 30);
		add(marital);
		marriedButton=new JRadioButton("Married");
		marriedButton.setFocusable(false);
		marriedButton.setBounds(300,470,70,30);
		marriedButton.setBackground(Color.WHITE);
		add(marriedButton);
		singleButton=new JRadioButton("Single");
		singleButton.setFocusable(false);
		singleButton.setBounds(450,470,70,30);
		singleButton.setBackground(Color.WHITE);
		add(singleButton);
		ButtonGroup maritalButtonGroup=new ButtonGroup();
		maritalButtonGroup.add(marriedButton);
		maritalButtonGroup.add(singleButton);
		
		JLabel country  = new JLabel("Country: ");
		country.setFont(new Font("Ariel",Font.BOLD,16));
		country.setBounds(100, 520, 300, 30);
		add(country);
		countryField= new JTextField();
		countryField.setFont(new Font("Ariel",Font.BOLD,14));
		countryField.setBounds(300,520,400,30);
		add(countryField);
		
		JLabel city  = new JLabel("City: ");
		city.setFont(new Font("Ariel",Font.BOLD,16));
		city.setBounds(100, 570, 300, 30);
		add(city);
		cityField= new JTextField();
		cityField.setFont(new Font("Ariel",Font.BOLD,14));
		cityField.setBounds(300,570,400,30);
		add(cityField);
		
		JLabel postCode  = new JLabel("Post Code: ");
		postCode.setFont(new Font("Ariel",Font.BOLD,16));
		postCode.setBounds(100, 620, 300, 30);
		add(postCode);
		postField= new JTextField();
		postField.setFont(new Font("Ariel",Font.BOLD,14));
		postField.setBounds(300,620,400,30);
		add(postField);
		
		
		nextButton = new JButton("Next Page");
		nextButton.setFocusable(false);
		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(Color.WHITE);
		nextButton.setBounds(610,680,100,30);
		nextButton.addActionListener(this);
		add(nextButton);
		
		
		
		
		
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setSize(800,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		new SignUpPage();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		String formNumber= "" + rand;
		String name= nameField.getText();
		String idNo= idNoField.getText();
		String birth=((JTextField) birthChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if (maleButton.isSelected()) {
			gender="Male";
		}else if (femaleButton.isSelected()) {
			gender="Female";
		}
		String mother= motherField.getText();
		String phone=phoneField.getText();
		String mail=mailField.getText();
		String marital=null;
		if (marriedButton.isSelected()) {
			marital="Married";
		}else if (singleButton.isSelected()) {
			marital="Single";
		}
		String country= countryField.getText();
		String city=cityField.getText();
		String postCode=postField.getText();
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Check your name again");
			}else {
				Db db= new Db();
				String queryString= "insert into signUp values('"+formNumber+"','"+name+"','"+idNo+"','"+birth+"','"+gender+"','"+mother+"','"+phone+"','"+mail+"','"+marital+"','"+country+"','"+city+"','"+postCode+"')";
				db.s.executeUpdate(queryString);
				
				
			}
			setVisible(false);
			new SignupPage2(formNumber).setVisible(true);
		
		} catch (Exception e2) {
			System.out.println(e);
		}
	}

}
