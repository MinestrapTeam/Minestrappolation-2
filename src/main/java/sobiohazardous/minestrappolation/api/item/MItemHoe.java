package sobiohazardous.minestrappolation.api.item;

import java.util.List;

import sobiohazardous.minestrappolation.api.Minestrappolation;
import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class MItemHoe extends ItemHoe
{	
	private IIcon overlayIcon;
	
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
		if (MAPIConfig.showDur == true)
		{
			if(par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlating"))
			{
				par3List.add(EnumChatFormatting.GREEN + "Durability: " + EnumChatFormatting.RED + Integer.toString(this.theToolMaterial.getMaxUses() - par1ItemStack.getItemDamage() + 1) + "/" + Integer.toString(this.theToolMaterial.getMaxUses() + 1));
				par3List.add(EnumChatFormatting.GOLD + "Bronze Plated");
			}
			else
			{
				par3List.add(EnumChatFormatting.GREEN + "Durability: " + EnumChatFormatting.RED + Integer.toString(this.theToolMaterial.getMaxUses() - par1ItemStack.getItemDamage() + 1) + "/" + Integer.toString(this.theToolMaterial.getMaxUses() + 1));
			}
		}
	}
	
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlated"))
		{
			this.theToolMaterial = this.bronzePlateMat;
		}
		else
		{
			this.theToolMaterial = this.norm;
		}
    }
    
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if(par1ItemStack.stackTagCompound != null && par1ItemStack.stackTagCompound.getBoolean("bronzePlated"))
		{
			this.theToolMaterial = this.bronzePlateMat;
		}
		else
		{
			this.theToolMaterial = this.norm;
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
	}

	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (renderPass == 0)
		{
			return itemIcon;
		}
		else if(stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated"))
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
