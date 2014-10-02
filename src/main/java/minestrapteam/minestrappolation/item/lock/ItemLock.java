package minestrapteam.minestrappolation.item.lock;

import java.util.List;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemLock extends ItemKey
{
	public IIcon brokenIcon;
	
	public ItemLock()
	{
		super();
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		String s = super.getUnlocalizedName();
		if (stack.getItemDamage() == 1)
		{
			return s + ".broken";
		}
		return s;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.iconString);
		this.brokenIcon = iconRegister.registerIcon(this.iconString + "_broken");
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return metadata == 1 ? this.brokenIcon : this.itemIcon;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		
		String name = getOwner(stack);
		if (name.isEmpty())
		{
			createNBT(stack, player);
			return false;
		}
		else if (!isOwner(name, player))
		{
			player.addChatMessage(new ChatComponentTranslation("lock.not_owner"));
			return false;
		}
		
		if (world.getBlock(x, y, z) == MBlocks.lockedBlock)
		{
			player.addChatMessage(new ChatComponentTranslation("lock.already_locked"));
			return false;
		}
		
		if (MBlocks.lockedBlock.lock(name, world, x, y, z))
		{
			stack.stackSize--;
			player.addChatMessage(new ChatComponentTranslation("lock.added"));
			return true;
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation("lock.not_applicable"));
		}
		
		return false;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
	}
}
