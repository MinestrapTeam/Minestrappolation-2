package sobiohazardous.minestrappolation.api.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import sobiohazardous.minestrappolation.api.lib.MAPIReference;

/**
 * 
 * @author SoBiohazardous
 *
 */
public class MAssetManager 
{
	private static boolean isBuild = false;
	
	public static String getMAPITexture(String name)
	{
		return MAPIReference.MODID_MAPI + ":" + name;
	}
	
	public static String getEOTexture(String name)
	{
		return MAPIReference.MODID_EO + ":"  + name;
	}
	
	public static String getEDTexture(String name)
	{
		return MAPIReference.MODID_ED + ":"  + name;
	}
	
	public static String getEMDTexture(String name)
	{
		return MAPIReference.MODID_EMD + ":"  + name;
	}
	
	public static String getEDStonecutterTexture(String name)
	{
		return MAPIReference.MODID_ED + ":"  + "/stoneCutter/" + name;
	}
	
	public static String getEOStoncutterTexture(String name)
	{
		return MAPIReference.MODID_EO + ":" + "/stoneCutter/" + name;
	}
	
	/**
	 * Returns all of the textures with the material prefix and the type in an array. used for metadata material blocks
	 * @param matPrefix
	 * @param type
	 * @return
	 */
	public static String[] getMaterialStringArray(String id, String matPrefix, String type)
	{
		List<String> textures = new ArrayList<>();
		try
		{
			File textureDir = null;
			
			if(!isBuild)
			{
				textureDir = new File("C:\\Users\\Domenic\\Desktop\\Minestrappolation 1.7.2\\src\\main\\resources\\assets\\extradecor\\textures\\blocks\\stoneCutter");
			}
			else
			{
				//File textureDir = new File(getClass().getClassLoader().getResourceAsStream(""));
			}
						
			for(int i = 0; i < textureDir.list().length; i++)
			{
				if(textureDir.list()[i].startsWith(matPrefix + "_" + type))
				{
					textures.add(id + ":/stoneCutter/" + textureDir.list()[i].replaceAll(".png", "")); 
				}
			}
				
		}
		
		catch(Exception e)
		{
			
		} 
		
		//convert the list to an array
		String[] result = new String[textures.size()];
		for(int i = 0; i < textures.size(); i++)
		{
			result[i] = textures.get(i);
		}
		
		return result;
	}
	
	/**
	 * Returns all of the textures with the material prefix in an array. used for metadata material blocks
	 * @param matPrefix
	 * @return
	 */
	public static String[] getMaterialStringArray(String id, String matPrefix)
	{
		List<String> textures = new ArrayList<>();
		try
		{
			File textureDir = null;
			
			if(!isBuild)
			{
				textureDir = new File("C:\\Users\\Domenic\\Desktop\\Minestrappolation 1.7.2\\src\\main\\resources\\assets\\extradecor\\textures\\blocks\\stoneCutter");
			}
			else
			{
				//File textureDir = new File(getClass().getClassLoader().getResourceAsStream(""));
			}
						
			for(int i = 0; i < textureDir.list().length; i++)
			{
				if(textureDir.list()[i].startsWith(matPrefix))
				{
					textures.add(id + ":/stoneCutter/" + textureDir.list()[i].replaceAll(".png", "")); 
				}
			}
				
		}
		
		catch(Exception e)
		{
			
		} 
		
		//convert the list to an array
		String[] result = new String[textures.size()];
		for(int i = 0; i < textures.size(); i++)
		{
			result[i] = textures.get(i);
		}
		
		return result;
	}
	
	/**
	 * Returns all of the textures with the material prefix in an array. Excludes the string param. used for metadata material blocks
	 * @param matPrefix
	 * @return
	 */
	public static String[] getMaterialStringArrayEx(String id, String matPrefix, String exc)
	{
		List<String> textures = new ArrayList<>();
		try
		{
			File textureDir = null;
			
			if(!isBuild)
			{
				textureDir = new File("C:\\Users\\Domenic\\Desktop\\Minestrappolation 1.7.2\\src\\main\\resources\\assets\\extradecor\\textures\\blocks\\stoneCutter");
			}
			else
			{
				//File textureDir = new File(getClass().getClassLoader().getResourceAsStream(""));
			}
						
			for(int i = 0; i < textureDir.list().length; i++)
			{
				if(textureDir.list()[i].startsWith(matPrefix))
				{
					textures.add(id + ":/stoneCutter/" + textureDir.list()[i].replaceAll(".png", "").replaceAll(exc, "")); 
				}
			}
				
		}
		
		catch(Exception e)
		{
			
		} 
		
		//convert the list to an array
		String[] result = new String[textures.size()];
		for(int i = 0; i < textures.size(); i++)
		{
			result[i] = textures.get(i);
		}
		
		return result;
	}
}
