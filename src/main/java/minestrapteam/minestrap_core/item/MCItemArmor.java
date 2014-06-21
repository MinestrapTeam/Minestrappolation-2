package minestrapteam.minestrap_core.item;

import java.util.List;

import minestrapteam.minestrap_core.util.MCAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MCItemArmor extends ItemArmor implements IPlatable
{
	private String	armorPrefix;
	
	private IIcon	overlayIcon;
	
	public MCItemArmor(ArmorMaterial material, int renderIndex, int type, String armorPrefix)
	{
		super(material, renderIndex, type);
		this.setCreativeTab(null);
		this.armorPrefix = armorPrefix;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int i = super.getMaxDamage();
		return MCItemTool.isPlated(stack) ? i * 2 : i;
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
		
		String s;
		if (this.renderIndex == 0)
		{
			s = "bronze_helmet_overlay";
		}
		else if (this.renderIndex == 1)
		{
			s = "bronze_chestplate_overlay";
		}
		else if (this.renderIndex == 2)
		{
			s = "bronze_leggings_overlay";
		}
		else
		{
			s = "bronze_boots_overlay";
		}
		this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getArmorTexture(s));
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
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		MCItemTool.addInformation(stack, list);
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
		return MCAssetManager.getArmorModel(material + layer);
	}
}
