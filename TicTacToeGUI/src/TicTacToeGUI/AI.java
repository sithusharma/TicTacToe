package TicTacToeGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AI 
{
	AI()
	{
		
	}
	
	public JButton defense(JButton[] buttons)
	{
		for (int i = 0; i < 9; i ++)
		{
			if (buttons[i].getText() == "")
			{
				if (check(buttons[i]))
				{
					return buttons[i];
				}
			}
			
		}
		return null;
	}
	
	public void offense()
	{
		
	}
	
	public boolean check(JButton button)
	{
		return true;
	}
}
