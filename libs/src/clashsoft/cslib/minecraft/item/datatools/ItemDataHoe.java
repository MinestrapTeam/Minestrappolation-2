package clashsoft.cslib.minecraft.item.datatools;

import java.util.Collections;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.eventhandler.Event;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemDataHoe extends ItemDataTool
{
	public ItemDataHoe(ToolMaterial toolMaterial)
	{
		super(0F, toolMaterial, Collections.EMPTY_SET, "Hoe");
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		return 1F;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		return onItemUse(stack, player, world, x, y, z, side);
	}
	
	public static boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side)
	{
		if (!player.canPlayerEdit(x, y, z, side, stack))
		{
			return false;
		}
		
		UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
		if (MinecraftForge.EVENT_BUS.post(event))
		{
			return false;
		}
		
		if (event.getResult() == Event.Result.ALLOW)
		{
			stack.damageItem(1, player);
			return true;
		}
		
		Block block = world.getBlock(x, y, z);
		
		if (side != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt))
		{
			Block block1 = Blocks.farmland;
			world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
			
			if (world.isRemote)
			{
				return true;
			}
			
			world.setBlock(x, y, z, block1);
			stack.damageItem(1, player);
			return true;
		}
		
		return false;
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
	{
		return HashMultimap.create();
	}
}
