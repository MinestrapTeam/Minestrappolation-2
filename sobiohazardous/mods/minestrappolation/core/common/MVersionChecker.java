package sobiohazardous.mods.minestrappolation.core.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MVersionChecker
{
	public static final String versionURL = "https://raw.githubusercontent.com/SoBiohazardous/Minestrappolation-Recode/master/version.txt";
	
	private static List<String>	updateFile;
	
	public static void readUpdateFile(String url)
	{
		updateFile = new ArrayList();
		try
		{
			URL url1 = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(url1.openStream()));
			String str;
			while ((str = in.readLine()) != null)
			{
				updateFile.add(str);
			}
			in.close();
		}
		catch (IOException e)
		{
			System.err.println("Version file not found at: " + url);
		}
	}
	
	protected static void loadFile(String url)
	{
		if (updateFile == null)
		{
			readUpdateFile(url);
		}
	}
	
	public static String updateCheck(String version, String url)
	{
		loadFile(url);
		
		boolean upToDate = false;
		String newVersion = null;
		
		for (String str : updateFile)
		{
			if (str.contains("version="))
			{
				newVersion = str.substring(8);
				if (version.equals(newVersion))
				{
					upToDate = true;
				}
			}
		}
		
		if (!upToDate)
		{
			return "You are using a outdated version. Version " + newVersion + " of Minestrappolation is out!";
		}
		else
		{
			return "Minestrappolation is up to date!";
		}	
	}
	
	public static String getMOTD(String url)
	{
		loadFile(url);
		
		String motd = "";
		String color = null;
		for (String str : updateFile)
		{
			if (str.contains("motd="))
			{
				motd = str.substring(5);
			}
			if (str.contains("motdcolor="))
			{
				color = str.substring(10);
			}
		}
		
		if (color != null)
			return "\u00a7" + color + motd;
		return motd;
	}
	
	public static boolean doesFileExist(String urlToCheck)
	{
		boolean result = false;
		try
		{
			URL url = new URL(urlToCheck);
			url.openStream();
			result = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
