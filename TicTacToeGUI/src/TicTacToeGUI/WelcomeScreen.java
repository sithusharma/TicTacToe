package TicTacToeGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class WelcomeScreen implements ActionListener
{
	JFrame frame = new JFrame();
	JPanel button_panel = new JPanel();
	JButton welcome_button = new JButton("Two Player");
	JButton AI_button = new JButton("Computer");
	JLabel textField = new JLabel();
	
	WelcomeScreen()
	{
		frame.setTitle("Welcome to Tic-Tac-Toe");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 500);
		
		button_panel.add(welcome_button);
		button_panel.add(AI_button);
		
		frame.add(button_panel);
		frame.setVisible(true);
		
		welcome_button.setFocusable(false);
		welcome_button.addActionListener(this);
		welcome_button.setBounds(200, 250, 100, 50);
		
		AI_button.setFocusable(false);
		AI_button.addActionListener(this);
		AI_button.setBounds(600, 250, 100, 50);
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == welcome_button)
		{
			frame.dispose();
			TicTacToe ttt = new TicTacToe();
		}
		
	}
}
