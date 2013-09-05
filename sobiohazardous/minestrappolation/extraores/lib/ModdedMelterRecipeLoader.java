package sobiohazardous.minestrappolation.extraores.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

import net.minecraft.client.Minecraft;

public class ModdedMelterRecipeLoader 
{
	public static int maxCustomRecipes = 2000;
	public static int[] ids = new int[maxCustomRecipes];
	public static int[] itemids = new int[maxCustomRecipes];
	
	public  void loadModdedMelter()
	{
		File file = new File("config/MelterCanMelt.txt");
		File file2 = new File("config/MelterCanMeltInfo.txt");
		String line;
		String num = "";
		String num2 = "";
		int arrayID = 0;
		int iarrayID = 0;
		int recipesUsed = 0;
		try 
		{
			if(!file.exists())
			{
				file.createNewFile();
				
			}
			
			FileWriter fw = new FileWriter(file2.getAbsoluteFile(),false);
			BufferedWriter bw = new BufferedWriter(fw);
			FileInputStream fstream = new FileInputStream(file2);
			// Get the object of DataInputStream
			DataInputStream in2 = new DataInputStream(fstream);
			
			FileInputStream stream = new FileInputStream(file);
		 	DataInputStream in = new DataInputStream(stream);
		 	BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 	if(file2.exists()){
		 		file2.delete();
		 	}
		 	
		 	file2.createNewFile();
		 	
		 	
		
		 	while((line = br.readLine()) !=null)
		 	{
			 	num = line.substring(0, line.indexOf(','));
			 	num2 = line.substring(line.indexOf(',')+1);
			 	ids[arrayID] = Integer.parseInt(num);
			 	itemids[iarrayID] = Integer.parseInt(num2);
			 	arrayID++;
			 	iarrayID++;
			 	recipesUsed++;
		 	}
		 	
		 	bw.write("To make a new melter recipe you put blockTOMeltID,itemToMeltToID Ex 14,353");
		 	bw.newLine();
		 	bw.write(recipesUsed+"/"+maxCustomRecipes+" recipes used");
		 	bw.close();
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Minestrappolation: Successfuly loaded custom melter recipes");
		System.out.println(file.getAbsolutePath());
	}

}
