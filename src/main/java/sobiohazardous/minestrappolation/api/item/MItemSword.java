package sobiohazardous.minestrappolation.api.item;

import java.util.List;

import sobiohazardous.minestrappolation.api.Minestrappolation;
import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemSword extends ItemSword
{
	private boolean ignitesMob = false;
	private ToolMaterial toolMaterial;

	private IIcon overlayIcon;
	private IIcon overlayIcon2;

	private ToolMaterial norm;
	private ToolMaterial bronzePlateMat;

	public MItemSword(ToolMaterial par2EnumToolMaterial, ToolMaterial bronzePlateMat)
	{
		super(par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setCreativeTab(null);
		this.norm = par2EnumToolMaterial;
		this.bronzePlateMat = bronzePlateMat;
	}

	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		if (ignitesMob)
		{
			par2EntityLivingBase.setFire(10);
			par1ItemStack.damageItem(2, par3EntityLivingBase);
		}
		else
		{
			par1ItemStack.damageItem(1, par3EntityLivingBase);
		}
		return true;
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
		overlayIcon = par1IconRegister.registerIcon(MAssetManager.getEOTexture("overlayWeaponSwordBronze"));
		overlayIcon2 = par1IconRegister.registerIcon(MAssetManager.getEOTexture("overlayWeaponSwordBronze2"));
	}

	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (renderPass == 0)
		{
			return itemIcon;
		}
		else if (stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated") && this.toolMaterial.getHarvestLevel() < 5)
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

	public MItemSword setIgnitesMob(boolean ignitesMob)
	{
		this.ignitesMob = true;
		return this;
	}
}
