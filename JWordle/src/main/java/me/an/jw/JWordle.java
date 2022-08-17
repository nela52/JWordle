package me.an.jw;

import javax.swing.UIManager;

public class JWordle
{
	public static final int WORD_LEN = 5;

	public JWordle() throws Exception
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Dictionary.loadDictionary();
		new MainWindow();
	}

	public static void main(String[] args) throws Exception
	{
		new JWordle();
	}
}
