package minestrapteam.minestrappolation.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.mcore.util.MCAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemCharm extends Item
{
	public static final String[]	geneNames	= new String[] { "pig", "cow", "chicken", "sheep", "horse" };
	
	@SideOnly(Side.CLIENT)
	private IIcon[]					geneIcons;
	
	public ItemCharm()
	{
		super();
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return this.geneIcons[metadata % this.geneIcons.length];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + geneNames[stack.getItemDamage() % ItemCharm.geneNames.length];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 5; ++i)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.geneIcons = new IIcon[geneNames.length];
		
		for (int i = 0; i < geneNames.length; ++i)
		{
			this.geneIcons[i] = iconRegister.registerIcon(MCAssetManager.getMobTexture(geneNames[i] + "_charm"));
		}
	}
}
