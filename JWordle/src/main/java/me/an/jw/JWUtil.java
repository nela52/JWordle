package me.an.jw;

public class JWUtil
{
	public static void sleep(long time)
	{
		try
		{
			Thread.sleep(time);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
