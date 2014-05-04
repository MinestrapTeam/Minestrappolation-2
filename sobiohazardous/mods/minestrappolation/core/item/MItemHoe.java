package sobiohazardous.mods.minestrappolation.core.item;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.lib.MConfig;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class MItemHoe extends ItemHoe
{	
	private IIcon overlayIcon;
	private IIcon overlayIcon2;

	private ToolMaterial norm;
	private ToolMaterial bronzePlateMat;
	
	public MItemHoe(ToolMaterial par2EnumToolMaterial, ToolMaterial bronzeMaterial)
	{
        super(par2EnumToolMaterial);
        this.setCreativeTab(null);
        this.bronzePlateMat = bronzeMaterial;
		this.norm = par2EnumToolMaterial;
    }
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (MConfig.showDur == true && !par2EntityPlayer.capabilities.isCreativeMode)
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
			this.theToolMaterial = this.bronzePlateMat;
    		par1ItemStack.stackTagCompound.setInteger("dur", this.bronzePlateMat.getMaxUses());
		}
		else if(par1ItemStack.stackTagCompound == null)
    	{
    		par1ItemStack.stackTagCompound = new NBTTagCompound();
    	}
		else
		{
			this.theToolMaterial = this.norm;
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
		overlayIcon = par1IconRegister.registerIcon(MAssetManager.getEOTexture("overlayToolHoeBronze"));
		overlayIcon2 = par1IconRegister.registerIcon(MAssetManager.getEOTexture("overlayToolHoeBronze2"));
	}

	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (renderPass == 0)
		{
			return itemIcon;
		}
		else if(stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated") && this.theToolMaterial.getHarvestLevel() < 5)
		{
			return overlayIcon;			
		}
		else if (stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated") && this.theToolMaterial.getHarvestLevel() > 4)
		{
			return overlayIcon2;
		}
		else
		{
			return itemIcon;
		}
	}
}
