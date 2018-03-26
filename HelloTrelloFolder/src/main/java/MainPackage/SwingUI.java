package MainPackage;

import javax.swing.*;

import SeleniumPackage.SeleniumMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUI extends JFrame implements ActionListener
{
	JPanel p = new JPanel();
	JButton b = new JButton("Submit");
	
	JLabel labelLogin = new JLabel("LOGIN:");
	JTextField loginField = new JTextField("", 10);
	
	JLabel labelPassword = new JLabel("PASSWORD:");
	JTextField passwordField = new JTextField("", 10);
	
	JLabel labelBoard = new JLabel("targetBoard:");
	JTextField boardField = new JTextField("", 10);
	
	
	public SwingUI()
	{
		super("Deafault Title");
		setSize(100,100);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public SwingUI(String title, int width, int height, boolean resizable) 
	{
		super(title);
		
		setSize(width,height);
		setResizable(resizable);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b.addActionListener(this);
		
		p.setLayout(null);
		int x = 25;
		int y = 50;
		int w = 90;
		int h = 25;
		
		p.add(labelLogin);
		labelLogin.setBounds(x, y, w, h);
		p.add(loginField);
		loginField.setBounds(x + 75, y, w, h);
		
		p.add(labelPassword);
		labelPassword.setBounds(x, y +50, w, h);
		p.add(passwordField);
		passwordField.setBounds(x+75, y+50, w, h);
		
		p.add(labelBoard);
		labelBoard.setBounds(x, y +75, w, h);
		p.add(boardField);
		boardField.setBounds(x+75, y+75, w, h);
		
		p.add(b);
		b.setBounds(x + 75, y + 100, w, h);
		
		add(p);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String login = loginField.getText();
		String password = passwordField.getText();
		String boardname = boardField.getText();
		SeleniumMain sm = new SeleniumMain(login,password,boardname);
	}
	
}
