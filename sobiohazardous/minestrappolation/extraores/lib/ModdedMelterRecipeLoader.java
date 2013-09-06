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
	public static int[] amountids = new int[maxCustomRecipes];
	public static float[] xpids = new float[maxCustomRecipes];
	
	public  void loadModdedMelter()
	{
		File file = new File("config/MelterCanMelt.txt");
		File file2 = new File("config/MelterCanMeltInfo.txt");
		String line;
		String input = "";
		String output = "";
		String amount = ""; 
		String xp = ""; 
		int aarrayID = 0;
		int arrayID = 0;
		int iarrayID = 0;
		int xarrayID = 0;
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
		 		line = line.toLowerCase().replaceAll(" ", "");
		 		if(line.contains("input=")){
					input = line.substring(line.indexOf("input=")+6,line.lastIndexOf(";", line.indexOf("input=")+11));
				}else
				if(line.contains("input=") == false && line.isEmpty() == false){
					input = "1";
					System.out.println("input not found defaulting");
				}
				
				if(line.contains("output=")){
					output = line.substring(line.indexOf("output=")+7,line.lastIndexOf(";", line.indexOf("output=")+11));
				}else
				if(line.contains("output=") == false &&line.isEmpty() == false){
					output = "353";
					System.out.println("output not found defaulting");
				}
				
				if(line.contains("amount=")){
					amount = line.substring(line.indexOf("amount=")+7,line.lastIndexOf(";", line.indexOf("amount=")+11));
				}else
				if(line.contains("amount=") == false &&line.isEmpty() == false){
					amount = "1";
					System.out.println("amount not found defaulting");
				}
				
				if(line.contains("xp=")){
					if(line.contains("xp=")){
						xp = line.substring(line.indexOf("xp=")+3,line.lastIndexOf(";", line.indexOf("xp=")+8));
					}
					
					
				}else if(line.contains("experience=")){
					xp = line.substring(line.indexOf("experience=")+11,line.lastIndexOf(";", line.indexOf("experience=")+12));
				}
				else	if(line.contains("xp=") == false && line.contains("experience=") == false &&line.isEmpty() == false){
					xp = ".5";
					System.out.println("xp not found defaulting");
				}
		 		
		 		
		 		if(line.isEmpty() == false){
					ids[arrayID] = Integer.parseInt(input);
					itemids[iarrayID] = Integer.parseInt(output);
					amountids[aarrayID] = Integer.parseInt(amount);
					xpids[xarrayID] = Float.parseFloat(xp);
					arrayID++;
					iarrayID++;
					aarrayID++;
					xarrayID++;
					recipesUsed++;
				}
		 	}
		 	
		 	bw.write("To make a new melter recipe you add input=BLOCKIDHERE; output=ITEMORBLOCKIDHERE; amount=AMOUNTHERE; xp=AMOUNTHERE; each recipe must have its own line *XP AND AMOUNT ARE NOT REQUIRED*");
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
