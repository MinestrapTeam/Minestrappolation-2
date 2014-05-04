package sobiohazardous.mods.minestrappolation.extraores;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cpw.mods.fml.common.Loader;
import sobiohazardous.mods.minestrappolation.extraores.client.gui.ContainerMelter;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItemManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.ModdedMelterRecipeLoader;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		addSmelting(Blocks.cobblestone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		addSmelting(Blocks.mossy_cobblestone, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		addSmelting(Blocks.gravel,new ItemStack(Items.lava_bucket, 1, 0), 0.2F);
		addSmelting(Blocks.stone,new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		addSmelting(Blocks.stonebrick, new ItemStack(Items.lava_bucket,1, 0), 0.8F);
		addSmelting(Blocks.snow, new ItemStack(Items.water_bucket, 1, 0), 0.6F);
		addSmelting(Blocks.ice, new ItemStack(Items.water_bucket,1, 0), 0.7F);
		addSmelting(Blocks.cobblestone_wall, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		// addSmelting(Blocks.obsidian, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		// addSmelting(Blocks.bedrock, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		addSmelting(EOBlockManager.Granite, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		addSmelting(Blocks.glowstone, new ItemStack(EOBlockManager.glowGlass), 0.7F);

		if (Loader.isModLoaded("ExtraDecor"))
		{
			// addSmelting(EDBlockManager.obsidianTile, new
			// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
			// addSmelting(EDBlockManager.bedrockBrick, new
			// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
			//addSmelting(new ItemStack(EDBlockManager.snowBrick), new ItemStack(Items.water_bucket, 1, 0), 0.7F);
			//addSmelting(new ItemStack(EDBlockManager.stones), 0, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
			//addSmelting(new ItemStack(EDBlockManager.stonePillar), new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
			//addSmelting(new ItemStack(EDBlockManager.stones), 1, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		}

		/*
		for (int a = 0; a < meltr.ids.length; a++)
		{
			if (meltr.ids[a] == 0 && meltrs[a] == 0
					&& meltr.amountids[a] == 0 && meltr.xpids[a] == 0
					&& meltr.metaids[1] == 0)
			{
				break;
			}
			else
			{
				System.out.println("BlockID added: " + meltr.ids[a] + " Meta: "
						+ meltr.metaids[a] + " ItemID added: "
						+ meltrs[a] + " Amount: " + meltr.amountids[a]
						+ " XP: " + meltr.xpids[a]);
				addSmelting(meltr.ids[a], meltr.metaids[a], new ItemStack(
						meltrs[a], meltr.amountids[a], 0),
						(float) meltr.xpids[a]);

			}
		}
		 */
	}

	public void addSmelting(Block block, ItemStack output, float experience)
	{
		this.addSmelting(new ItemStack(block), output, experience);
	}
	
	public void addSmelting(Item item, ItemStack output, float experience)
	{
		this.addSmelting(new ItemStack(item), output, experience);
	}

	public void addSmelting(ItemStack input, ItemStack itemStack, float experience)
	{
		melterList.put(input, itemStack);
		this.melterExperience.put(Float.valueOf(experience),Float.valueOf(experience));
	}

	public void addSmelting(ItemStack id, int meta, ItemStack itemStack,float experience)
	{
		metal.put(Arrays.asList(id, meta), itemStack);
		this.melterExperience.put(Arrays.asList(itemStack, itemStack.getItemDamage()),Float.valueOf(experience));
	}

	public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator var2 = this.melterList.entrySet().iterator();
        Entry var3;

        do
        {
            if (!var2.hasNext())
            {
                return null;
            }

            var3 = (Entry)var2.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)var3.getKey()));

        return (ItemStack)var3.getValue();
    }
	
	private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }
	
	public Map getSmeltingList()
	{
		return melterList;
	}

	public float getExperience(ItemStack p_151398_1_)
    {
        Iterator var2 = this.melterExperience.entrySet().iterator();
        Entry var3;

        do
        {
            if (!var2.hasNext())
            {
                return 0.0F;
            }

            var3 = (Entry)var2.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)var3.getKey()));

        return ((Float)var3.getValue()).floatValue();
    }
}