package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.core.lib.MCReference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWoodBeveled extends BlockWoodPanel
{
	public static final String[]	beveledTextures	= new String[] { "extradecor" + ":bevelOak", "extradecor" + ":bevelBirch", "extradecor" + ":bevelSpruce", "extradecor" + ":bevelJungle" };
	
	public BlockWoodBeveled()
	{
		super();
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.iconArray = new IIcon[beveledTextures.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(beveledTextures[i]);
		}
	}
}
