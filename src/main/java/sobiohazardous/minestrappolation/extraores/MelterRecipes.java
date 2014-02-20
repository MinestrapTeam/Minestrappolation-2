package sobiohazardous.minestrappolation.extraores;


import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extraores.client.gui.ContainerMelter;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
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
private Map metal = new HashMap();

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
		addSmelting(80, new ItemStack(Item.bucketWater,1,0), 0.6F);
		addSmelting(Block.ice.blockID, new ItemStack(Item.bucketWater.itemID,1,0), 0.7F);
		addSmelting(Block.cobblestoneWall.blockID, new ItemStack(Item.bucketLava.itemID,1,0), 0.7F);
		//addSmelting(Block.obsidian.blockID, new ItemStack(EOItemManager.bucketMagma.itemID,1,0), 0.7F);
		//addSmelting(Block.bedrock.blockID, new ItemStack(EOItemManager.bucketMagma.itemID,1,0), 0.7F);
		addSmelting(EOBlockManager.Granite.blockID, new ItemStack(Item.bucketLava.itemID,1,0), 0.7F);
		addSmelting(Block.glowStone.blockID, new ItemStack(EOBlockManager.glowGlass), 0.7F);
		
		
		if(ModLoader.isModLoaded("ExtraDecor")){
			//addSmelting(EDBlockManager.obsidianTile.blockID, new ItemStack(EOItemManager.bucketMagma.itemID,1,0), 0.7F);
			//addSmelting(EDBlockManager.bedrockBrick.blockID, new ItemStack(EOItemManager.bucketMagma.itemID,1,0), 0.7F);
			addSmelting(EDBlockManager.snowBrick.blockID, new ItemStack(Item.bucketWater.itemID,1,0), 0.7F);
			addSmelting(EDBlockManager.stones.blockID,0, new ItemStack(Item.bucketLava.itemID,1,0), 0.7F);
			addSmelting(EDBlockManager.stonePillar.blockID, new ItemStack(Item.bucketLava.itemID,1,0), 0.7F);
			addSmelting(EDBlockManager.stones.blockID,1, new ItemStack(Item.bucketLava.itemID,1,0), 0.7F);
		}
		
		
		
		for(int a = 0; a < meltr.ids.length;a++){
			if(meltr.ids[a] == 0 && meltr.itemids[a] == 0 && meltr.amountids[a] ==0 && meltr.xpids[a] == 0 && meltr.metaids[1] == 0){
				break;
			}else{
				System.out.println("BlockID added: " +  meltr.ids[a]+" Meta: "+meltr.metaids[a]+" ItemID added: "+meltr.itemids[a]+" Amount: "+meltr.amountids[a]+" XP: "+meltr.xpids[a]);
				addSmelting(meltr.ids[a],meltr.metaids[a], new ItemStack(meltr.itemids[a],meltr.amountids[a],0), (float)meltr.xpids[a]);
				
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
	
	public void addSmelting(int id,int meta, ItemStack itemStack, float experience)
	{
		metal.put(Arrays.asList(id, meta), itemStack);
		this.melterExperience.put(Arrays.asList(itemStack.itemID, itemStack.getItemDamage()), Float.valueOf(experience));
		
		
		
	}

/**
* Returns the smelting result of an item.
*/

	public ItemStack getSmeltingResult(ItemStack item)
	 {
	 if (item == null)
	 {
	 return null;
	 }
	 ItemStack ret = (ItemStack)metal.get(Arrays.asList(item.itemID, item.getItemDamage()));
	 if (ret != null)
	 {
	 return ret;
	 }
	 return (ItemStack)melterList.get(Integer.valueOf(item.itemID));
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