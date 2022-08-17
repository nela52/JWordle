package me.an.jw;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class EmptyWindow
{
	public JFrame frame;
	public JPanel container;

	private String title;
	private int closeOperation;

	public EmptyWindow(String title, int closeOperation)
	{
		this.title = title;
		this.closeOperation = closeOperation;
		show();
	}

	public abstract void addComponents();

	private void createAndShowGUI()
	{
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(closeOperation);

		container = new JPanel();
		frame.getContentPane().add(container);

		addComponents();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void show()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
}
