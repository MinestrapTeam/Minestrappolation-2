package sobiohazardous.minestrappolation.extradecor.lib;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class ModdedMelterRecipeLoader {
	public static int[] ids = new int[2000];
	public static int[] itemids = new int[2000];
	
	public  void loadModdedMelter(){
		File file = new File("config/MelterCanMelt.txt");
		String line;
		String num = "";
		String num2 = "";
		int arrayID = 0;
		int iarrayID = 0;
		try {
			if(!file.exists()){
				file.createNewFile();
			}
		
		 FileInputStream stream = new FileInputStream(file);
		 DataInputStream in = new DataInputStream(stream);
		 BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		while((line = br.readLine()) !=null){
			num = line.substring(0, line.indexOf(','));
			num2 = line.substring(line.indexOf(',')+1);
			ids[arrayID] = Integer.parseInt(num);
			itemids[iarrayID] = Integer.parseInt(num2);
		arrayID++;
		iarrayID++;
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		System.out.println("Successfuly loaded custom melter recipes");
		System.out.println(file.getAbsolutePath());
	}

}
