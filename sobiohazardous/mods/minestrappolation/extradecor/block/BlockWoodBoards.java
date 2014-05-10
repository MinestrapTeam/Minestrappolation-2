package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWoodBoards extends BlockWoodPanel
{
	public static final String[]	boardTextures	= new String[] { MReference.ED_MODID + ":boardsOak", MReference.ED_MODID + ":boardsBirch", MReference.ED_MODID + ":boardsSpruce", MReference.ED_MODID + ":boardsJungle" };
	
	public BlockWoodBoards()
	{
		super();
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.iconArray = new IIcon[panelTextures.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(boardTextures[i]);
		}
	}
}
