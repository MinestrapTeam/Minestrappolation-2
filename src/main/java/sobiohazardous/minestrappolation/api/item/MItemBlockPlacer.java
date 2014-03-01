package sobiohazardous.minestrappolation.api.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MItemBlockPlacer extends ItemBlock 
{

	public MItemBlockPlacer(Block p_i45328_1_) 
	{
		super(p_i45328_1_);
	}

	public void registerIcons(IIconRegister r)
	{
		itemIcon = r.registerIcon("Minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
	
	//TODO test icons
	


}
