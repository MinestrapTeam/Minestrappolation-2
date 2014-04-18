package sobiohazardous.minestrappolation.api.item;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.*;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemPickaxe extends ItemPickaxe
{
	private static final Set field_150915_c = Sets.newHashSet(new Block[]
	{ Blocks.bedrock, Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore,
			Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail });
	private boolean breakBedrock = false;
	private boolean ignites = false;
	private IIcon overlayIcon;
	private IIcon overlayIcon2;
	
	private ToolMaterial norm;
	private ToolMaterial bronzePlateMat;
	
	public MItemPickaxe(ToolMaterial par2EnumToolMaterial, ToolMaterial bronzeMaterial, boolean iginites)
	{
		super(par2EnumToolMaterial);
		this.setCreativeTab(null);
		this.bronzePlateMat = bronzeMaterial;
		this.norm = par2EnumToolMaterial;
		this.ignites = iginites;
	}
	
	public MItemPickaxe(ToolMaterial par2EnumToolMaterial, ToolMaterial bronzeMaterial)
	{
		this(par2EnumToolMaterial, bronzeMaterial, false);
	}
	
	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	// can harvest
	@Override
	public boolean func_150897_b(Block block)
	{
		if (breakBedrock)
		{
			return block == Blocks.bedrock ? this.toolMaterial.getHarvestLevel() == 4
					: block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3
							: (block != Blocks.diamond_block && block != Blocks.diamond_ore ? (block != Blocks.emerald_ore && block != Blocks.emerald_block ? (block != Blocks.gold_block && block != Blocks.gold_ore ? (block != Blocks.iron_block && block != Blocks.iron_ore ? (block != Blocks.lapis_block && block != Blocks.lapis_ore ? (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? (block
									.getMaterial() == Material.rock ? true : (block.getMaterial() == Material.iron ? true : block.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2)
									: this.toolMaterial.getHarvestLevel() >= 1)
									: this.toolMaterial.getHarvestLevel() >= 1)
									: this.toolMaterial.getHarvestLevel() >= 2)
									: this.toolMaterial.getHarvestLevel() >= 2)
									: this.toolMaterial.getHarvestLevel() >= 2);
		}
		return block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3
				: (block != Blocks.diamond_block && block != Blocks.diamond_ore ? (block != Blocks.emerald_ore && block != Blocks.emerald_block ? (block != Blocks.gold_block && block != Blocks.gold_ore ? (block != Blocks.iron_block && block != Blocks.iron_ore ? (block != Blocks.lapis_block && block != Blocks.lapis_ore ? (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? (block
						.getMaterial() == Material.rock ? true : (block.getMaterial() == Material.iron ? true : block.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial
						.getHarvestLevel() >= 2);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (MAPIConfig.showDur == true && !par2EntityPlayer.capabilities.isCreativeMode)
		{
			if(par1ItemStack.stackTagCompound == null)
	    	{
	    		par1ItemStack.stackTagCompound = new NBTTagCompound();
	    	}
			if(par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlating"))
			{
				par3List.add(EnumChatFormatting.GREEN + "Durability: " + EnumChatFormatting.RED + Integer.toString(par1ItemStack.stackTagCompound.getInteger("dur") - par1ItemStack.getItemDamage() + 1) + "/" + Integer.toString(par1ItemStack.stackTagCompound.getInteger("dur") + 1));
				par3List.add(EnumChatFormatting.GOLD + "Bronze Plated");
			}		
			else
			{
				par3List.add(EnumChatFormatting.GREEN + "Durability: " + EnumChatFormatting.RED + Integer.toString(par1ItemStack.stackTagCompound.getInteger("dur") - par1ItemStack.getItemDamage() + 1) + "/" + Integer.toString(par1ItemStack.stackTagCompound.getInteger("dur") + 1));			
			}
		}
	}

	public void breakBedrock(boolean canbreak)
	{
		this.breakBedrock = true;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par7 == 0)
		{
			--par5;
		}

		if (par7 == 1)
		{
			++par5;
		}

		if (par7 == 2)
		{
			--par6;
		}

		if (par7 == 3)
		{
			++par6;
		}

		if (par7 == 4)
		{
			--par4;
		}

		if (par7 == 5)
		{
			++par4;
		}

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else
		{
			if (par3World.getBlock(par4, par5, par6).getMaterial() == Material.air)
			{
				// par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 +
				// 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F,
				// itemRand.nextFloat() * 0.4F + 0.8F);
				if (this.ignites)
				{
					par3World.setBlock(par4, par5, par6, Blocks.fire);
				}
			}

			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}
	}

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		this.updateNBTs(par1ItemStack);
    }
    
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		this.updateNBTs(par1ItemStack);
	}
	
	public void updateNBTs(ItemStack par1ItemStack)
	{
		if(par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlated"))
		{
			this.toolMaterial = this.bronzePlateMat;
    		par1ItemStack.stackTagCompound.setInteger("dur", this.bronzePlateMat.getMaxUses());
		}
		else if(par1ItemStack.stackTagCompound == null)
    	{
    		par1ItemStack.stackTagCompound = new NBTTagCompound();
    	}
		else
		{
			this.toolMaterial = this.norm;
    		par1ItemStack.stackTagCompound.setInteger("dur", this.norm.getMaxUses());
		}
	}

	@Override
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		itemIcon = par1IconRegister.registerIcon(this.getIconString());
		overlayIcon = par1IconRegister.registerIcon(MAssetManager.getEOTexture("overlayToolPickBeonze"));
		overlayIcon2 = par1IconRegister.registerIcon(MAssetManager.getEOTexture("overlayToolPickBronze2"));
	}

	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (renderPass == 0)
		{
			return itemIcon;
		}
		else if(stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated") && this.toolMaterial.getHarvestLevel() < 5)
		{
			return overlayIcon;			
		}
		else if (stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated") && this.toolMaterial.getHarvestLevel() > 4)
		{
			return overlayIcon2;
		}
		else
		{
			return itemIcon;
		}
	}
}
