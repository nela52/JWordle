package me.an.jw.alert;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import me.an.jw.EmptyWindow;

public class AlertWindow extends EmptyWindow
{
	private String message;
	//	private AlertType type;

	protected AlertWindow(String message, long time, AlertType type)
	{
		super(null, JFrame.DISPOSE_ON_CLOSE);
		this.message = message;
		//		this.type = type;
		new Thread(new Runnable()
		{
			public void run()
			{
				try
				{
					Thread.sleep(time);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

				frame.dispose();
			}
		}).start();
	}

	public void addComponents()
	{
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);

		container.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				frame.dispose();
			};
		});

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(5, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		container.add(panel);

		//		BufferedImage image = null;
		//		switch (type)
		//		{
		//		case BAD:
		//			image = ERROR;
		//			break;
		//		case GOOD:
		//			image = CHECK;
		//			break;
		//		case INFO:
		//			image = INFO;
		//			break;
		//		}
		//
		//		panel.add(createSingleComponentPanel(new JLabel(new ImageIcon(image))), BorderLayout.EAST);

		JLabel msgLabel = new JLabel(message);
		msgLabel.setFont(msgLabel.getFont().deriveFont(15f));
		panel.add(msgLabel, BorderLayout.CENTER);
	}
}
