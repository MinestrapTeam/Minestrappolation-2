package clashsoft.cslib.minecraft.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BlockImpl extends Block implements ICustomBlock
{
	public BlockImpl(Material material, String name, String iconName)
	{
		super(material);
		this.setBlockName(name);
		this.setBlockTextureName(iconName);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName();
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
		CustomBlock.addInformation(this, stack, list);
	}
}
