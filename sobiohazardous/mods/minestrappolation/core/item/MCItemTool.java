package sobiohazardous.mods.minestrappolation.core.item;

import java.util.List;
import java.util.Set;

import sobiohazardous.mods.minestrappolation.core.lib.MCConfig;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
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
		return stack.getTagCompound() != null && stack.getTagCompound().getBoolean("bronzePlated");
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		addInformation(this.plateMaterial, stack, list);
	}
	
	protected static void addInformation(ToolMaterial bronzeMaterial, ItemStack stack, List list)
	{
		if (MCConfig.showDur == true && bronzeMaterial != null)
		{
			int dur = bronzeMaterial.getMaxUses();
			
			list.add("Durability: " + Integer.toString(dur - stack.getItemDamage()) + "/" + Integer.toString(dur));
		}
		
		if (isPlated(stack))
		{
			list.add(EnumChatFormatting.GOLD + "Bronze Plated");
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
		String s = "overlayTool" + this.toolType;
		this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getTexture(s + "Bronze"));
		this.overlayIcon2 = iconRegister.registerIcon(MCAssetManager.getTexture(s + "Bronze2"));
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (renderPass == 1 && MCItemTool.isPlated(stack))
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
