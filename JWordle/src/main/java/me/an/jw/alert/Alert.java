package me.an.jw.alert;

public class Alert
{
	public static void showAlert(String message, long time, AlertType type)
	{
		new AlertWindow(message, time, type);
	}
}
