package clashsoft.cslib.minecraft.util;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CSWeb
{
	/**
	 * Checks if the website is available.
	 * 
	 * @param url
	 *            the url
	 * @return true, if available
	 */
	public static boolean checkWebsiteAvailable(String url)
	{
		try
		{
			URL url1 = new URL(url);
			
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) url1.openConnection();
			con.setRequestMethod("HEAD");
			int response = con.getResponseCode();
			return response == HttpURLConnection.HTTP_OK;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	/**
	 * Reads a website or downloads its contents.
	 * 
	 * @param url
	 *            the url
	 * @return the lines
	 */
	public static String[] readWebsite(String url)
	{
		try
		{
			URL url1 = new URL(url);
			HttpURLConnection.setFollowRedirects(true);
			HttpURLConnection con = (HttpURLConnection) url1.openConnection();
			con.setDoOutput(false);
			con.setReadTimeout(20000);
			con.setRequestProperty("Connection", "keep-alive");
			con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:16.0) Gecko/20100101 Firefox/20.0");
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			
			BufferedInputStream in = new BufferedInputStream(con.getInputStream());
			int responseCode = con.getResponseCode();
			StringBuffer buffer = new StringBuffer();
			int read;
			while ((read = in.read()) != -1)
			{
				char c = (char) read;
				buffer.append(c);
			}
			return buffer.toString().split("\n");
		}
		catch (Exception ex)
		{
			return new String[] {};
		}
	}
}
