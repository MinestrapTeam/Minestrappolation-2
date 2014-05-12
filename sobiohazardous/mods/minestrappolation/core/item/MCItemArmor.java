package sobiohazardous.mods.minestrappolation.core.item;

import sobiohazardous.mods.minestrappolation.core.lib.MCReference;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MCItemArmor extends ItemArmor
{
	private String			armorPrefix;
	
	public ArmorMaterial	material;
	
	private IIcon			overlayIcon;
	
	private ArmorMaterial	normalMaterial;
	private ArmorMaterial	bronzePlateMat;
	
	public MCItemArmor(ArmorMaterial material, ArmorMaterial bronzeMaterial, int renderIndex, int type, String armorPrefix)
	{
		super(material, renderIndex, type);
		this.setCreativeTab(null);
		this.armorPrefix = armorPrefix;
		this.normalMaterial = material;
		this.bronzePlateMat = bronzeMaterial;
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		if (MCItemTool.isPlated(stack))
		{
			this.material = this.bronzePlateMat;
		}
		else
		{
			this.material = this.normalMaterial;
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag)
	{
		if (MCItemTool.isPlated(stack))
		{
			this.material = this.bronzePlateMat;
		}
		else
		{
			this.material = this.normalMaterial;
		}
	}
	
	@Override
	public ArmorMaterial getArmorMaterial()
	{
		return this.material;
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
		
		if (this.renderIndex == 0)
		{
			this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getEOTexture("overlayArmorHelmBronze"));
		}
		else if (this.renderIndex == 1)
		{
			this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getEOTexture("overlayArmorChestBronze"));
		}
		else if (this.renderIndex == 2)
		{
			this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getEOTexture("overlayArmorLegsBronze"));
		}
		else
		{
			this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getEOTexture("overlayArmorBootsBronze"));
		}
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		if (renderPass == 1 && MCItemTool.isPlated(stack))
		{
			return this.overlayIcon;
		}
		return this.itemIcon;
	}
	
	@Override
	public int getColorFromItemStack(ItemStack stack, int renderPass)
	{
		if (renderPass == 0)
		{
			return 421010;
		}
		return 16777215;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		String layer = "1";
		
		String material = this.armorPrefix;
		
		if (slot == 2)
		{
			layer = "2";
		}
		return MCReference.EO_MODID + ":textures/armor/" + material + layer + ".png";
	}
}
