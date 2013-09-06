package sobiohazardous.minestrappolation.extraores;

import java.util.HashMap;
import java.util.Map;

import sobiohazardous.minestrappolation.extraores.client.gui.ContainerMelter;
import sobiohazardous.minestrappolation.extraores.lib.ModdedMelterRecipeLoader;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;

public class MelterRecipes
{
private static final MelterRecipes melterBase = new MelterRecipes();

/** The list of smelting results. */
private Map melterList = new HashMap();
private Map melterExperience = new HashMap();


ModdedMelterRecipeLoader meltr = new ModdedMelterRecipeLoader();

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static final MelterRecipes smelting()
	{
	return melterBase;
	}

	private MelterRecipes()
	{
		meltr.loadModdedMelter();
		addSmelting(Block.cobblestone.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.4F);
		addSmelting(Block.cobblestoneMossy.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.6F);
		addSmelting(Block.gravel.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.2F);
		addSmelting(Block.stone.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.5F);
		addSmelting(Block.stoneBrick.blockID, new ItemStack(Item.bucketLava, 1, 0), 0.8F);
		addSmelting(Block.snow.blockID, new ItemStack(Item.bucketWater,1,0), 0.6F);
		addSmelting(Block.ice.blockID, new ItemStack(Item.bucketWater.itemID,1,0), 0.7F);
		
		
		for(int a = 0; a < meltr.ids.length;a++){
			if(meltr.ids[a] == 0 && meltr.itemids[a] == 0 && meltr.amountids[a] ==0 && meltr.xpids[a] == 0){
				break;
			}else{
				System.out.println("BlockID added: " +  meltr.ids[a]+" ItemID added: "+meltr.itemids[a]+" Amount: "+meltr.amountids[a]+" XP: "+meltr.xpids[a]);
				addSmelting(meltr.ids[a], new ItemStack(meltr.itemids[a],meltr.amountids[a],0), (float)meltr.xpids[a]);
				
			}
		}
			
		
	}	

/**
* Adds a smelting recipe.
*/
	public void addSmelting(int id, ItemStack itemStack, float experience)
	{
		melterList.put(Integer.valueOf(id), itemStack);
			this.melterExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
		
		
		
	}

/**
* Returns the smelting result of an item.
*/
public ItemStack getSmeltingResult(int id)
{
return (ItemStack)melterList.get(Integer.valueOf(id));
}

public Map getSmeltingList()
{
return melterList;
}
public float getExperience(int par1)
{
return this.melterExperience.containsKey(Integer.valueOf(par1)) ? ((Float)this.melterExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
}
}