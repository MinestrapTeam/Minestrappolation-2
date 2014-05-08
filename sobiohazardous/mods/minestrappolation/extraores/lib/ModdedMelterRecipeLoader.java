package sobiohazardous.mods.minestrappolation.extraores.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModdedMelterRecipeLoader
{
	public static int		maxCustomRecipes			= 2000;
	public static int		aliasFilesFound;
	public static int		maxAfterStringFoundValue	= 19;
	
	public static int[]		ids							= new int[maxCustomRecipes];
	public static int[]		metaids						= new int[maxCustomRecipes];
	public static int[]		itemids						= new int[maxCustomRecipes];
	public static int[]		amountids					= new int[maxCustomRecipes];
	public static float[]	xpids						= new float[maxCustomRecipes];
	
	public String			melterinfomessage			= "To make a new melter recipe you add input=BLOCKIDHERE; output=ITEMORBLOCKIDHERE; amount=AMOUNTHERE; xp=AMOUNTHERE; or experience=AMOUNTHERE;. Each recipe must have its own line *XP AND AMOUNT ARE NOT REQUIRED*";
	public String			customRecipeFileName		= "MelterCanMelt.txt";
	public String			melterInfoFileName			= "MelterCanMeltInfo.txt";
	
	public void loadModdedMelter()
	{
		File file = new File("Custom-Plugins");
		file.mkdirs();
		File file2 = new File("Custom-Plugins/" + this.melterInfoFileName);
		File file3 = new File("Custom-Plugins/" + "melter_customRecipes.txt");
		String line;
		String input = "";
		String meta = "";
		String output = "";
		String amount = "";
		String xp = "";
		int aarrayID = 0;
		int arrayID = 0;
		int iarrayID = 0;
		int xarrayID = 0;
		int marrayID = 0;
		int recipesUsed = 0;
		try
		{
			if (!file.exists())
			{
				file.createNewFile();
				System.out.println("Custom melter file created!");
			}
			if (!file3.exists())
			{
				file3.createNewFile();
			}
			FilenameFilter filter = new FilenameFilter()
			{
				
				@Override
				public boolean accept(File arg0, String arg1)
				{
					
					return arg1.startsWith("melter_");
				}
				
			};
			
			File[] fList = file.listFiles(filter);
			
			FileWriter fw = new FileWriter(file2.getAbsoluteFile(), false);
			BufferedWriter bw = new BufferedWriter(fw);
			FileInputStream fstream = new FileInputStream(file2);
			// Get the object of DataInputStream
			DataInputStream in2 = new DataInputStream(fstream);
			
			if (file2.exists())
			{
				file2.delete();
			}
			
			file2.createNewFile();
			
			for (File element : fList)
			{
				FileInputStream stream = new FileInputStream(element);
				DataInputStream in = new DataInputStream(stream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				System.out.println("Loading from: " + element);
				while ((line = br.readLine()) != null)
				{
					line = line.toLowerCase().replaceAll(" ", "");
					if (line.contains("input="))
					{
						input = this.findAlias(line.substring(line.indexOf("input=") + 6, line.lastIndexOf(";", line.indexOf("input=") + maxAfterStringFoundValue)), line.substring(line.indexOf("input=") + 6, line.lastIndexOf(";", line.indexOf("input=") + maxAfterStringFoundValue)));
					}
					else if (line.contains("input=") == false && line.isEmpty() == false)
					{
						input = "1";
						System.out.println("input not found defaulting");
					}
					
					if (line.contains("meta="))
					{
						meta = this.findAlias(line.substring(line.indexOf("meta=") + 5, line.lastIndexOf(";", line.indexOf("meta=") + maxAfterStringFoundValue)), line.substring(line.indexOf("meta=") + 5, line.lastIndexOf(";", line.indexOf("meta=") + maxAfterStringFoundValue)));
					}
					else if (line.contains("meta=") == false && line.isEmpty() == false)
					{
						meta = "0";
						System.out.println("meta not found defaulting");
					}
					
					if (line.contains("output="))
					{
						output = this.findAlias(line.substring(line.indexOf("output=") + 7, line.lastIndexOf(";", line.indexOf("output=") + maxAfterStringFoundValue)), line.substring(line.indexOf("output=") + 7, line.lastIndexOf(";", line.indexOf("output=") + maxAfterStringFoundValue)));
					}
					else if (line.contains("output=") == false && line.isEmpty() == false)
					{
						output = "353";
						System.out.println("output not found defaulting");
					}
					
					if (line.contains("amount="))
					{
						amount = line.substring(line.indexOf("amount=") + 7, line.lastIndexOf(";", line.indexOf("amount=") + 9));
					}
					else if (line.contains("amount=") == false && line.isEmpty() == false)
					{
						amount = "1";
						System.out.println("amount not found defaulting");
					}
					
					if (line.contains("xp="))
					{
						if (line.contains("xp="))
						{
							xp = line.substring(line.indexOf("xp=") + 3, line.lastIndexOf(";", line.indexOf("xp=") + 8));
						}
						
					}
					else if (line.contains("experience="))
					{
						xp = line.substring(line.indexOf("experience=") + 11, line.lastIndexOf(";", line.indexOf("experience=") + 13));
					}
					else if (line.contains("xp=") == false && line.contains("experience=") == false && line.isEmpty() == false)
					{
						xp = ".5";
						System.out.println("xp not found defaulting");
					}
					
					if (line.isEmpty() == false)
					{
						ids[arrayID] = Integer.parseInt(input);
						metaids[marrayID] = Integer.parseInt(meta);
						itemids[iarrayID] = Integer.parseInt(output);
						amountids[aarrayID] = Integer.parseInt(amount);
						xpids[xarrayID] = Float.parseFloat(xp);
						arrayID++;
						marrayID++;
						iarrayID++;
						aarrayID++;
						xarrayID++;
						recipesUsed++;
					}
				}
				br.close();
			}
			
			bw.write(this.melterinfomessage);
			bw.newLine();
			bw.newLine();
			bw.write(recipesUsed + "/" + maxCustomRecipes + " recipes used");
			bw.newLine();
			bw.newLine();
			bw.write("**If any issues are found with this please message one of the Minestappolation team**");
			bw.close();
			in2.close();
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
	
	public String findAlias(String alias, String other)
	{
		File directory = new File("Custom-Plugins");
		String value = "0";
		boolean aliasFound = false;
		
		// get all the files from a directory
		// System.out.println("Minestrappolation: Successfuly loaded metler plugins");
		// System.out.println(directory.getAbsolutePath());
		FilenameFilter filter = new FilenameFilter()
		{
			
			@Override
			public boolean accept(File arg0, String arg1)
			{
				
				return arg1.startsWith("alias_");
			}
			
		};
		
		File[] fList = directory.listFiles(filter);
		aliasFilesFound = fList.length;
		for (File element : fList)
		{
			try
			{
				FileInputStream stream = new FileInputStream(element);
				DataInputStream in = new DataInputStream(stream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String line;
				
				int x;
				while ((line = br.readLine()) != null)
				{
					if (line.length() == 0)
					{
						continue;
					}
					String s1 = line.toLowerCase().replaceAll(" ", "");
					if (s1.contains(alias + "="))
					{
						aliasFound = true;
					}
					
					x = s1.indexOf(alias + "=");
					if (x >= 0)
					{
						value = s1.substring(alias.length() + 1);
						System.out.println(alias + " - Found in: " + element);
						break;
					}
				}
				
				br.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Loaded " + aliasFilesFound + " alias files");
		if (aliasFound == true)
		{
			return value;
		}
		else
		{
			return other;
		}	
	}
}
