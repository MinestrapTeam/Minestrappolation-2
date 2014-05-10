package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWoodBeveled extends BlockWoodPanel
{
	public static final String[]	beveledTextures	= new String[] { MReference.ED_MODID + ":bevelOak", MReference.ED_MODID + ":bevelBirch", MReference.ED_MODID + ":bevelSpruce", MReference.ED_MODID + ":bevelJungle" };
	
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
