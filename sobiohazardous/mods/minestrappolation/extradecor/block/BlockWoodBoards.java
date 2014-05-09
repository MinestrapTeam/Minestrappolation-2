package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWoodBoards extends BlockWoodPanel
{
	public static final String[]	boardTextures	= new String[] { MReference.MODID_ED + ":boardsOak", MReference.MODID_ED + ":boardsBirch", MReference.MODID_ED + ":boardsSpruce", MReference.MODID_ED + ":boardsJungle" };
	
	@SideOnly(Side.CLIENT)
	private IIcon[]					iconArray;
	
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
