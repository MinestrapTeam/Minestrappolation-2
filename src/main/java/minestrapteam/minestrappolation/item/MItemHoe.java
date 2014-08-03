package minestrapteam.minestrappolation.item;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cpw.mods.fml.common.eventhandler.Event;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class MItemHoe extends ItemHoe implements IPlatable
{
	private Map<String, IIcon>	overlayIcons	= new HashMap();
	
	public MItemHoe(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public String getType()
	{
		return "sword";
	}
	
	@Override
	public int getPlatingCount(ItemStack stack)
	{
		return this.theToolMaterial.getHarvestLevel() + 1;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
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
	public int getMaxDamage(ItemStack stack)
	{
		return MItemTool.getMaxDamage(super.getMaxDamage(stack), stack);
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
		
		for (Entry<String, IPlating> e : IPlating.platings.entrySet())
		{
			String type = e.getKey();
			IPlating plating = e.getValue();
			
			if (plating.canApply(this))
			{
				StringBuilder builder = new StringBuilder(20);
				builder.append("weapons/").append(type).append("_hoe_overlay");
				if (this.theToolMaterial.getHarvestLevel() >= 5)
				{
					builder.append("_2");
				}
				String textureName = MAssetManager.getTexture(builder.toString());
				this.overlayIcons.put(type, iconRegister.registerIcon(textureName));
			}
		}
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		IIcon icon = null;
		if (renderPass == 1)
		{
			IPlating plating = MItemTool.getPlating(stack);
			if (plating != null)
			{
				icon = this.overlayIcons.get(plating.getType());
			}
		}
		return icon == null ? this.itemIcon : icon;
	}
}
