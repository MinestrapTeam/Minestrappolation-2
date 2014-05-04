package sobiohazardous.mods.minestrappolation.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.FMLFileResourcePack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.util.ResourceLocation;
import sobiohazardous.mods.minestrappolation.core.lib.MReference;

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
		return MReference.MODID_MAPI + ":" + name;
	}
	
	public static String getEOTexture(String name)
	{
		return MReference.MODID_EO + ":"  + name;
	}
	
	public static String getEDTexture(String name)
	{
		return MReference.MODID_ED + ":"  + name;
	}
	
	public static String getEMDTexture(String name)
	{
		return MReference.MODID_EMD + ":"  + name;
	}
	
	public static String getEDStonecutterTexture(String name)
	{
		return MReference.MODID_ED + ":"  + "stoneCutter/" + name;
	}
	
	public static String getEOStonecutterTexture(String name)
	{
		return MReference.MODID_EO + ":" + "stoneCutter/" + name;
	}
	
	/**
	 * Returns all of the textures with the material prefix and the type in an array. used for metadata material blocks
	 * @param matPrefix
	 * @param type
	 * @return
	 */
	@Deprecated
	public static String[] getMaterialStringArray(String id, String matPrefix, String type)
	{
		List<String> textures = new ArrayList<>();
		try
		{
			//TODO Find a fix!
			File textureDir = new File(System.getProperty("user.dir") + "/assets/extradecor/textures/blocks/stoneCutter/");
			
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
	@Deprecated
	public static String[] getMaterialStringArray(String id, String matPrefix)
	{
		List<String> textures = new ArrayList<>();
		try
		{
			//TODO Find a fix!
			File textureDir = new File(System.getProperty("user.dir") + "/assets/extradecor/textures/blocks/stoneCutter/");
			
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
	@Deprecated
	public static String[] getMaterialStringArrayEx(String id, String matPrefix, String exc)
	{
		List<String> textures = new ArrayList<>();
		try
		{
			//TODO Find a fix!
			File textureDir = new File(System.getProperty("user.dir") + "/assets/extradecor/textures/blocks/stoneCutter/");

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
