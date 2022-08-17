package me.an.jw;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Dictionary
{
	private static final Hashtable<Integer, String> words = new Hashtable<Integer, String>();
	private static final Random r = new Random();

	private static int toHash(String word)
	{
		int hash = 7;
		for (int i = 0; i < word.length(); i++)
			hash = hash * 31 + word.charAt(i);
		return hash;
	}

	public static void loadDictionary()
	{
		try
		{
			List<String> lines = Files.readAllLines(new File(JWordle.class.getResource("/dictionary.txt").toURI()).toPath());
			for (String line : lines)
			{
				if (line.length() != JWordle.WORD_LEN)
					continue;
				words.put(toHash(line.toLowerCase()), line.toLowerCase());
			}
		} catch (IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}

	public static boolean isValidWord(String word)
	{
		return words.get(toHash(word.toLowerCase())) != null;
	}

	public static String randomWord()
	{
		return words.values().toArray(new String[0])[r.nextInt(words.size())];
	}
}
