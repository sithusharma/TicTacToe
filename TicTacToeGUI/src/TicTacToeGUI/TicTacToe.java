package TicTacToeGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener
{
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player_turn;
	boolean aiFlag;
	
	
	public TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic - Tac - Toe");
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,10,800, 100);
		
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(150, 150, 150));
		
		//reset function
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        resetGame();
		    }
		});
		title_panel.add(resetButton, BorderLayout.EAST);
		
		
		for (int i = 0; i < 9; i++)
		{
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textField);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
	}
	







	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i = 0; i < 9; i++)
		{
			if (e.getSource() == buttons[i])
			{
				if(player_turn)
				{
					if(buttons[i].getText() == "")
					{
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("X");
						player_turn = false;
						textField.setText("O Turn");
						checkWin();

						 
					}
				}
				
				
				else
				{
					if(buttons[i].getText() == "")
					{
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("O");
						player_turn = true;
						textField.setText("X Turn");
						checkWin();
					}
				}
				
			}
		}
		
	}
	
	public void firstTurn()
	{
		
		if(random.nextInt(2) == 0)
		{
			player_turn = true;
			textField.setText("X turn");
		}
		else
		{
			player_turn = false;
			textField.setText("O turn");
		}
	}
	
	public void checkWin()
	{
		
		//check X win conditions
		if (	(buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X")
				)
		{
			checkX(0, 1, 2);
			
		}
		if (	(buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")
				)
		{
			checkX(3, 4, 5);
			
		}
		if (	(buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")
				)
		{
			checkX(6, 7, 8);
			
		}
		if (	(buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")
				)
		{
			checkX(0, 3, 6);
			
		}
		if (	(buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")
				)
		{
			checkX(1, 4, 7);
			
		}
		if (	(buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")
				)
		{
			checkX(2, 5, 8);
			
		}
		if (	(buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")
				)
		{
			checkX(0, 4, 8);
			
		}
		if (	(buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")
				)
		{
			checkX(2, 4, 6);
			
		}
		
	
			
		
		//check O win conditions
		if (	(buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O")
				)
		{
			checkO(0, 1, 2);
			
		}
		if (	(buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O")
				)
		{
			checkO(3, 4, 5);
			
		}
		if (	(buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O")
				)
		{
			checkO(6, 7, 8);
			
		}
		if (	(buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O")
				)
		{
			checkO(0, 3, 6);
			
		}
		if (	(buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O")
				)
		{
			checkO(1, 4, 7);
			
		}
		if (	(buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O")
				)
		{
			checkO(2, 5, 8);
			
		}
		if (	(buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O")
				)
		{
			checkO(0, 4, 8);
			
		}
		if (	(buttons[2].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[6].getText() == "O")
				)
		{
			checkO(2, 4, 6);
			
		}
		
	}
	
	public void checkX(int a, int b, int c)
	{
		buttons[a].setForeground(new Color(0, 255, 0));
		buttons[b].setForeground(new Color(0, 255, 0));
		buttons[c].setForeground(new Color(0, 255, 0));
		
		for(int i = 0; i < 9; i++)
		{
			buttons[i].setEnabled(false);
			
		}
		textField.setText("X wins!");
	}
	
	public void checkO(int a, int b, int c)
	{
		buttons[a].setBackground(Color.YELLOW);
		buttons[b].setBackground(Color.YELLOW);
		buttons[c].setBackground(Color.YELLOW);
		
		for(int i = 0; i < 9; i++)
		{
			buttons[i].setEnabled(false);
			
		}
		textField.setText("O wins!");
	}
	
	
	
	
	public void resetGame() {
	    // clear the text on each button and enable them
	    for (int i = 0; i < buttons.length; i++) {
	        buttons[i].setText("");
	        buttons[i].setEnabled(true);
	    }
	    
	    // re-enable the button panel and set the text back to the default
	    button_panel.setEnabled(true);
	    textField.setText("Tic - Tac - Toe");

	    // start a new game with a random first turn
	    firstTurn();
	}
	
}
