package minestrapteam.minestrappolation.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.item.tool.MItemTool;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MItemArmor extends ItemArmor implements IPlatable
{
	private String				part;
	
	private Map<String, IIcon>	overlayIcons	= new HashMap();
	
	public MItemArmor(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
		this.setCreativeTab(null);
		
		if (type == 0)
		{
			this.part = "helmet";
		}
		else if (type == 1)
		{
			this.part = "chestplate";
		}
		else if (type == 2)
		{
			this.part = "leggings";
		}
		else if (type == 3)
		{
			this.part = "boots";
		}
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		return MItemTool.getMaxDamage(super.getMaxDamage(stack), stack);
	}
	
	@Override
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.iconString);
		ItemStack thisStack = new ItemStack(this, 1, 0);
		
		for (Entry<String, IPlating> e : IPlating.platings.entrySet())
		{
			String type = e.getKey();
			IPlating plating = e.getValue();
			
			if (!plating.canApply(thisStack))
			{
				continue;
			}
			
			String textureName = MItemTool.getPlatingTexture(plating, this.part, 0);
			this.overlayIcons.put(type, iconRegister.registerIcon(textureName));
		}
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		IIcon icon = null;
		if (renderPass == 1)
		{
			IPlating plating = MItemTool.getPlating(stack);
			if (plating != null)
			{
				icon = this.overlayIcons.get(plating.getType());
			}
		}
		return icon == null ? this.itemIcon : icon;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		MItemTool.addInformation(stack, list);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (type == null)
		{
			String material = this.getArmorMaterial().name().toLowerCase();
			String slot1 = slot == 2 ? "_2" : "_1";
			return MAssetManager.getArmorModel(material + slot1);
		}
		else
		{
			IPlating plating = MItemTool.getPlating(stack);
			if (plating != null)
			{
				String slot1 = slot == 2 ? "_overlay_2" : "_overlay_1";
				return MAssetManager.getArmorModel(plating.getType() + slot1);
			}
			return null;
		}
	}
	
	@Override
	public String getType()
	{
		return this.part;
	}
	
	@Override
	public String getMaterialName()
	{
		return this.getArmorMaterial().name();
	}
	
	@Override
	public int getPlatingCount(ItemStack stack)
	{
		ArmorMaterial material = this.getArmorMaterial();
		switch (material)
		{
		case CHAIN:
			return 1;
		case CLOTH:
			return 1;
		case IRON:
			return 2;
		case GOLD:
			return 3;
		case DIAMOND:
			return 4;
		default:
			String name = material.name();
			// TODO Move to CSLib
			for (ToolMaterial toolMaterial : ToolMaterial.values())
			{
				if (toolMaterial.name().equalsIgnoreCase(name))
				{
					return toolMaterial.getHarvestLevel() + 1;
				}
			}
			return 1;
		}
	}
	
	@Override
	public boolean isPlatable(ItemStack stack)
	{
		return true;
	}
}
