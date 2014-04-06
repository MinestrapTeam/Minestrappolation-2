package sobiohazardous.minestrappolation.api.item;

import java.util.List;

import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.src.*;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemShovel extends ItemSpade
{
	private boolean ignites = false;

	private IIcon overlayIcon;

	private ToolMaterial norm;
	private ToolMaterial bronzePlateMat;

	public MItemShovel(ToolMaterial par2EnumToolMaterial, ToolMaterial bronzeMaterial)
	{
		super(par2EnumToolMaterial);
		this.setCreativeTab(null);
		this.bronzePlateMat = bronzeMaterial;
		this.norm = par2EnumToolMaterial;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (MAPIConfig.showDur == true)
		{
			if (par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlating"))
			{
				par3List.add(EnumChatFormatting.GREEN + "Durability: " + EnumChatFormatting.RED + Integer.toString(this.toolMaterial.getMaxUses() - par1ItemStack.getItemDamage() + 1) + "/" + Integer.toString(this.toolMaterial.getMaxUses() + 1));
				par3List.add(EnumChatFormatting.GOLD + "Bronze Plated");
			}
			else
			{
				par3List.add(EnumChatFormatting.GREEN + "Durability: " + EnumChatFormatting.RED + Integer.toString(this.toolMaterial.getMaxUses() - par1ItemStack.getItemDamage() + 1) + "/" + Integer.toString(this.toolMaterial.getMaxUses() + 1));
			}
		}
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

	public void setIgnites(boolean ignites)
	{
		this.ignites = true;
	}

	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlated"))
		{
			this.toolMaterial = this.bronzePlateMat;
		}
		else
		{
			this.toolMaterial = this.norm;
		}
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlated"))
		{
			this.toolMaterial = this.bronzePlateMat;
		}
		else
		{
			this.toolMaterial = this.norm;
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
		overlayIcon = par1IconRegister.registerIcon(MAssetManager.getEOTexture("overlayToolShovelBronze"));
	}

	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (renderPass == 0)
		{
			return itemIcon;
		}
		else if (stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated"))
		{
			return overlayIcon;
		}
		else
		{
			return itemIcon;
		}
	}

	private int colorA = 421010;

	public int getColorFromItemStack(ItemStack par1ItemStack, int renderPass)
	{
		if (renderPass == 0)
		{
			return colorA;
		}
		return 16777215;
	}

}
