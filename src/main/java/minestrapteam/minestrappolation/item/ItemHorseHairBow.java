package minestrapteam.minestrappolation.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.mcore.util.MCAssetManager;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemHorseHairBow extends ItemBow
{
	protected IIcon[]	iconArray;
	
	public ItemHorseHairBow()
	{
		this.maxStackSize = 1;
		this.setMaxDamage(500);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int duration)
	{
		int j = this.getMaxItemUseDuration(stack) - duration;
		
		ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;
		
		boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
		
		if (flag || player.inventory.hasItem(Items.arrow))
		{
			if (!flag)
			{
				player.inventory.consumeInventoryItem(Items.arrow);
			}
			
			if (world.isRemote)
			{
				return;
			}
			
			float f = j / 13F;
			f = (f * f + f * 2.0F) / 3.0F;
			
			if (f < 0.1D)
			{
				return;
			}
			
			if (f > 1.0F)
			{
				f = 1.0F;
			}
			
			EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);
			
			if (f == 1.0F)
			{
				entityarrow.setIsCritical(true);
			}
			
			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
			
			if (k > 0)
			{
				entityarrow.setDamage(3D + k * 0.5D);
			}
			
			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
			
			if (l > 0)
			{
				entityarrow.setKnockbackStrength(l);
			}
			
			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
			{
				entityarrow.setFire(100);
			}
			
			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
			
			if (flag)
			{
				entityarrow.canBePickedUp = 2;
			}
			
			world.spawnEntityInWorld(entityarrow);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		String texture = MCAssetManager.getWeaponTexture("horse_hair_bow");
		this.itemIcon = iconRegister.registerIcon(texture);
		this.iconArray = new IIcon[3];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(texture + "_" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (player.getItemInUse() == null)
		{
			return this.itemIcon;
		}
		int pull = stack.getMaxItemUseDuration() - useRemaining;
		if (pull >= 18)
		{
			return this.iconArray[2];
		}
		else if (pull > 13)
		{
			return this.iconArray[1];
		}
		else if (pull > 0)
		{
			return this.iconArray[0];
		}
		return this.iconArray[0];
	}
}
