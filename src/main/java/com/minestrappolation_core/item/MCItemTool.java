package com.minestrappolation_core.item;

import java.util.List;
import java.util.Set;

import clashsoft.cslib.minecraft.lang.I18n;

import com.minestrappolation_core.MinestrappolationCore;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MCItemTool extends ItemTool
{
	protected boolean		ignites;
	
	private String			toolType;
	
	private IIcon			overlayIcon;
	private IIcon			overlayIcon2;
	
	private ToolMaterial	material;
	private ToolMaterial	plateMaterial;
	
	public MCItemTool(float baseDamage, ToolMaterial material, ToolMaterial plateMaterial, Set<Block> blocks, String type, boolean ignites)
	{
		super(baseDamage, material, blocks);
		this.setCreativeTab(null);
		this.plateMaterial = plateMaterial;
		this.material = material;
		this.toolType = type;
		this.ignites = ignites;
	}
	
	public MCItemTool(float baseDamage, ToolMaterial material, ToolMaterial plateMaterial, Set<Block> blocks, String type)
	{
		this(baseDamage, material, plateMaterial, blocks, type, false);
	}
	
	public static boolean isPlated(ItemStack stack)
	{
		return getPlating(stack) != null;
	}
	
	public static String getPlating(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
			return stack.stackTagCompound.getString("Plating");
		return null;
	}
	
	public static float getPoisonLevel(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			return stack.stackTagCompound.getFloat("PoisonLevel");
		}
		return 0F;
	}
	
	public static void setPoisonLevel(ItemStack stack, float level)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setFloat("PoisonLevel", level);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		float level = getPoisonLevel(stack);
		if (level > 0)
		{
			entity.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 12, 0));
			level -= 0.5F;
			setPoisonLevel(stack, level);
		}
		
		if ("sword".equals(this.toolType))
			stack.damageItem(1, attacker);
		else
			stack.damageItem(2, attacker);
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		addInformation(this.plateMaterial, stack, list);
	}
	
	protected static void addInformation(ToolMaterial bronzeMaterial, ItemStack stack, List list)
	{
		if (MinestrappolationCore.showDurability && bronzeMaterial != null)
		{
			int dur = bronzeMaterial.getMaxUses();
			
			list.add("Durability: " + Integer.toString(dur - stack.getItemDamage()) + "/" + Integer.toString(dur));
		}
		
		String plating = getPlating(stack);
		if (plating != null)
		{
			list.add(EnumChatFormatting.GOLD + plating + " Plated");
		}
		
		float poisonLevel = getPoisonLevel(stack);
		if (poisonLevel > 0F)
		{
			list.add(I18n.getString("item.poisonSword.desc", poisonLevel));
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote && this.ignites)
		{
			Items.flint_and_steel.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
			stack.damageItem(1, player);
			return true;
		}
		return false;
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		this.updateNBTs(stack);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag)
	{
		this.updateNBTs(stack);
	}
	
	protected void updateNBTs(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.getBoolean("bronzePlated"))
		{
			this.toolMaterial = this.plateMaterial;
		}
		else
		{
			this.toolMaterial = this.material;
		}
	}
	
	@Override
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
		
		String s = "bronze_" + this.toolType + "_overlay";
		this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getTexture(s));
		this.overlayIcon2 = iconRegister.registerIcon(MCAssetManager.getTexture(s + "_2"));
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		String plating = MCItemTool.getPlating(stack);
		if (renderPass == 1 && plating != null)
		{
			if (this.toolMaterial.getHarvestLevel() < 5)
			{
				return this.overlayIcon;
			}
			else
			{
				return this.overlayIcon2;
			}
		}
		return this.itemIcon;
	}
}
