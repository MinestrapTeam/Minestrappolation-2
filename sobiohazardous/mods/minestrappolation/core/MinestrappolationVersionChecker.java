package sobiohazardous.mods.minestrappolation.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public class MinestrappolationVersionChecker {
	
	public static String checkIfCurrent(String versiontocheck, String urlToCheck, String message){
		boolean upToDate = false;
		try{
			EntityPlayer player;
			URL url = new URL(urlToCheck);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			String version = "";
			while((str = in.readLine()) !=null){
				version = str.substring(8);
				if(str.contains("version=")){
					if(version.equals(versiontocheck)){
						upToDate = true;
					}
				}
			}
			in.close();
		}catch(IOException e){
			System.err.println("Version file not found at: "+urlToCheck);
		}
		if(upToDate == false){
			return message;
		}else{
			return "Minestrappolation is up to date!";
		}
		
	
	}
	
	public static String getVersion(String urlToCheck){
		String version = "";
		try{
			URL url = new URL(urlToCheck);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			
			
			while((str = in.readLine()) !=null){			
				if(str.contains("version=")){
					version = str.substring(8);
				}
			}
			in.close();
		}catch(IOException e){
			System.err.println("Version file not found at: "+urlToCheck);
		}
			return version;
		
	}
	
	public static String getMOTD(String urlToCheck){
		String motd = "";
		try{
			URL url = new URL(urlToCheck);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			
			
			while((str = in.readLine()) !=null){			
				if(str.contains("motd=")){
					motd = str.substring(5);
				}
				if(str.contains("motdcolor=")){
					
				}
					
				}
			in.close();
		}catch(IOException e){
			System.err.println("Version file not found at: "+urlToCheck);
		}
			return motd;
	}
	
	public static EnumChatFormatting getMOTDColor(String urlToCheck){
		String motd = "";
		try{
			URL url = new URL(urlToCheck);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			
			
			while((str = in.readLine()) !=null){						
				if(str.contains("motdcolor=")){
					motd = str.substring(10);
				}
			}
			in.close();
		}catch(IOException e){
			System.err.println("Version file not found at: "+urlToCheck);
		}
		if(motd.equals("red")){
			return EnumChatFormatting.RED;
		}
		if(motd.equals("aqua")){
			return EnumChatFormatting.AQUA;
		}
		if(motd.equals("green")){
			return EnumChatFormatting.GREEN;
		}
		if(motd.equals("black")){
			return EnumChatFormatting.BLACK;
		}
		if(motd.equals("yellow")){
			return EnumChatFormatting.YELLOW;
		}
		if(motd.equals("gold")){
			return EnumChatFormatting.GOLD;
		}
		if(motd.equals("purple")){
			return EnumChatFormatting.DARK_PURPLE;
		}
		if(motd.equals("dark red")){
			return EnumChatFormatting.DARK_RED;
		}
		if(motd.equals("dark green")){
			return EnumChatFormatting.DARK_GREEN;
		}
		if(motd.equals("blue")){
			return EnumChatFormatting.BLUE;
		}
		return EnumChatFormatting.WHITE;
			
	}
	
	public static boolean doesFileExist(String urlToCheck){
		boolean result = false;
		try {
			URL url = new URL(urlToCheck);
			url.openStream();
			result=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
