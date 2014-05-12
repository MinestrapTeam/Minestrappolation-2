package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.core.lib.MCReference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWoodBoards extends BlockWoodPanel
{
	public static final String[]	boardTextures	= new String[] { "extradecor" + ":boardsOak", "extradecor" + ":boardsBirch", "extradecor" + ":boardsSpruce", "extradecor" + ":boardsJungle" };
	
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
