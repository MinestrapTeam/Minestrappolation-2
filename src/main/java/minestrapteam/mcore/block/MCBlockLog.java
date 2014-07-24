package minestrapteam.mcore.block;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class MCBlockLog extends BlockLog
{
	private IIcon	topIcon;
	
	public MCBlockLog()
	{
		this.setHardness(2.0F);
		this.setStepSound(soundTypeWood);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcon = iconRegister.registerIcon(this.textureName + "_top");
	}
	
	@Override
	protected IIcon getSideIcon(int metadata)
	{
		return this.blockIcon;
	}
	
	@Override
	protected IIcon getTopIcon(int metadata)
	{
		return this.topIcon;
	}
	
}
