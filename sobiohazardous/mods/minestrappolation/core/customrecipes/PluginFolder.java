package sobiohazardous.mods.minestrappolation.core.customrecipes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PluginFolder {
	public static String[] aliasname = {"stone","dirt","cobblestone","planks","sand","gravel","goldore","ironore","coalore","wood","glass","lapisore","sandstone","lavabucket","waterbucket","bricks","goldblock",
		"ironblock","diamondblock","diamondore","snow","clay","endstone","stonebrick","jackolantern","netherrack","soulsand","glowstone","pumpkin","bookshelf","dandelion","poppy","brownmushroom","redmushroom","tnt","cobweb","sponge",
		"gunpowder","feather","string","bread","wheat","rawporkchop","cookedporkchop","goldapple","redstone"};
	public static int[] aliasvalue = {1,3,4,5,12,13,14,15,16,17,20,21,24,327,326,45,41,42,57,56,80,82,121,98,91,87,88,89,86,47,37,38,39,40,46,30,19,
		289,288,287,297,296,319,320,322,331};
	
	public static String[] minename = {"radiantore"};
	public static int[] minevalue = {3054};
	
	public void createPluginFolder(){
		File directory = new File("Custom-Plugins");
        directory.mkdirs();
        if(directory.exists() == false){
        	try {
				directory.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
	}
	
	public void createVanillaandMinestrappolationAlias(){
		File vanilla = new File("Custom-Plugins/alias_Vanilla.txt");
		File minestrap = new File("Custom-Plugins/alias_Minestrappolation.txt");
		
			try {
				if(!vanilla.exists()){
					vanilla.createNewFile();
					
					
					
				}
				if(!minestrap.exists()){
					minestrap.createNewFile();
				}
				
				FileWriter fw = new FileWriter(vanilla.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				FileWriter fw2 = new FileWriter(minestrap.getAbsoluteFile(),true);
				BufferedWriter bw2 = new BufferedWriter(fw2);
			
				BufferedReader br = new BufferedReader(new FileReader(vanilla));
				BufferedReader br2 = new BufferedReader(new FileReader(minestrap));
				
				if(br.readLine() == null){
					for(int i = 0; i < aliasname.length; i++){
						bw.write(aliasname[i]+"="+aliasvalue[i]);
						bw.newLine();
					}
				}
				if(br2.readLine() == null){
					for(int i = 0; i < minename.length; i++){
						bw2.write(minename[i]+"="+minevalue[i]);
						bw2.newLine();
					}
				}
				
				
				
				bw.close();
				bw2.close();
			
				System.out.println("Minestrappolation: Created alias files succesfully");
		
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
