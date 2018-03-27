package MainPackage;

import javax.swing.*;

import SeleniumPackage.SeleniumMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUI extends JFrame implements ActionListener
{
	JPanel panel = new JPanel();
	JButton button = new JButton("Submit");
	
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
		//call parent Jframe constructor
		super(title);
		
		//set window variables
		setSize(width,height);
		setResizable(resizable);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		int x = 25;
		int y = 50;
		int w = 90;
		int h = 25;
		
		
		
		
		//create login label and input field
		panel.add(labelLogin);
		labelLogin.setBounds(x, y, w, h);
		panel.add(loginField);
		loginField.setBounds(x + 75, y, w, h);
		
		
		//create password label and input field
		panel.add(labelPassword);
		labelPassword.setBounds(x, y +50, w, h);
		panel.add(passwordField);
		passwordField.setBounds(x+75, y+50, w, h);
		
		//create targetBoard label and input field
		panel.add(labelBoard);
		labelBoard.setBounds(x, y +75, w, h);
		panel.add(boardField);
		boardField.setBounds(x+75, y+75, w, h);
		
		//prep button listener for on click event
		button.addActionListener(this);
		panel.add(button);
		button.setBounds(x + 75, y + 100, w, h);
		
		//after all parts are added to the panel, add the panel to the window and set visibility
		add(panel);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String login = loginField.getText();
		String password = passwordField.getText();
		String boardName = boardField.getText();
		Main.InitializeSelenium(login, password, boardName);
	}
	
}
