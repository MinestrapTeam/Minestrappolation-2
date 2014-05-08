package sobiohazardous.mods.minestrappolation.core.customrecipes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import clashsoft.cslib.collections.primitive.IntArrayList;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomSmeltingLoader
{
	public static File			customPluginsDir			= new File("Custom-Plugins");
	
	static
	{
		customPluginsDir.mkdirs();
	}
	
	public static List<Item>	inputList					= new ArrayList();
	public static List<Item>	outputList					= new ArrayList();
	public static IntArrayList	amountList					= new IntArrayList();
	public static int			maxAfterStringFoundValue	= 19;
	
	public void loadCustomFuels()
	{
		try
		{
			File[] fList = customPluginsDir.listFiles();
			
			for (File element : fList)
			{
				if (element.getName().startsWith("smelt_"))
				{
					int l = 0;
					FileInputStream stream = new FileInputStream(element);
					DataInputStream in = new DataInputStream(stream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					System.out.println("Loading from: " + element);
					
					String line;
					while ((line = br.readLine()) != null)
					{
						processLine(line, l);
						l++;
					}
					br.close();
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.addFuels();
	}
	
	public void processLine(String line, int lineNumber)
	{
		line = line.toLowerCase().replaceAll(" ", "");
		
		String input = "1";
		String output = "353";
		int amount = 1;
		
		int inputIndex = line.indexOf("input=");
		int outputIndex = line.indexOf("output=");
		int amountIndex = line.indexOf("amount=");
		
		if (inputIndex != -1)
		{
			input = line.substring(inputIndex + 6, line.lastIndexOf(";", inputIndex + maxAfterStringFoundValue));
		}
		else if (!line.isEmpty())
		{
			System.out.println("Input not found - defaulting to 1");
		}
		
		if (outputIndex != -1)
		{
			output = line.substring(outputIndex + 7, line.lastIndexOf(";", outputIndex + maxAfterStringFoundValue));
		}
		else if (!line.isEmpty())
		{
			System.out.println("Output not found - defaulting to 353");
		}
		
		if (line.contains("amount="))
		{
			String amount1 = line.substring(amountIndex + 7, line.lastIndexOf(";", amountIndex + 11));
			amount = Integer.parseInt(amount1);
		}
		else if (!line.isEmpty())
		{
			System.out.println("Amount not found - defaulting to 1");
		}
		
		if (!line.isEmpty())
		{
			inputList.add(GameData.getItemRegistry().getObject(input));
			outputList.add(GameData.getItemRegistry().getObject(output));
			amountList.add(amount);
		}
	}
	
	private void addFuels()
	{
		for (int i = 0; i < inputList.size(); i++)
		{
			Item input = inputList.get(i);
			Item output = outputList.get(i);
			if (input != null && output != null)
			{
				GameRegistry.addSmelting(input, new ItemStack(output, amountList.get(i), 0), 1F);
			}
		}
	}
}
