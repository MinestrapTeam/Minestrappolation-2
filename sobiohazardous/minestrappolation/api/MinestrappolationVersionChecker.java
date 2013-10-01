package sobiohazardous.minestrappolation.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;

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
				}else{
					System.err.println("Version file not found at: "+urlToCheck);
				}
			}
			in.close();
		}catch(IOException e){
			
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
				}else{
					System.err.println("Version file not found at: "+urlToCheck);
				}
			}
			in.close();
		}catch(IOException e){
			
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
				}else{
					System.err.println("Version file not found at: "+urlToCheck);
				}
			}
			in.close();
		}catch(IOException e){
			
		}
			return motd;
	}
}
