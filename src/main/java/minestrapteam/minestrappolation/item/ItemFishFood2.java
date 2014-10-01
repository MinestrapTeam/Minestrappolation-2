package minestrapteam.minestrappolation.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemFishFood2 extends MItemFood
{
	private final boolean	cooked;
	
	public ItemFishFood2(FoodType foodType, boolean cooked)
	{
		super(foodType, 0, 0.0F);
		this.cooked = cooked;
	}
	
	@Override
	public int func_150905_g(ItemStack stack)
	{
		FishType fishtype = FishType.getFishType(stack);
		return this.cooked && fishtype.isCookable ? fishtype.cookedHealAmount : fishtype.rawHealAmount;
	}
	
	@Override
	public float func_150906_h(ItemStack stack)
	{
		FishType fishtype = FishType.getFishType(stack);
		return this.cooked && fishtype.isCookable ? fishtype.cookedSaturationModifier : fishtype.rawSaturationModifier;
	}
	
	@Override
	public String getPotionEffect(ItemStack stack)
	{
		return FishType.getFishType(stack) == FishType.PUFFERFISH ? PotionHelper.field_151423_m : null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		FishType[] fishTypes = FishType.values();
		int len = fishTypes.length;
		
		for (int i = 0; i < len; ++i)
		{
			FishType fishtype = fishTypes[i];
			fishtype.registerIcons(iconRegister, this.foodType);
		}
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		FishType fishtype = FishType.getFishType(stack);
		
		if (fishtype == FishType.PUFFERFISH)
		{
			player.addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 3));
			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2));
			player.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 1));
		}
		
		super.onFoodEaten(stack, world, player);
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		FishType fishtype = FishType.getFishType(metadata);
		return this.cooked && fishtype.isCookable ? fishtype.cookedIcon : fishtype.rawIcon;
	}
	
	@Override
	public void getSubItems(Item stack, CreativeTabs tab, List list)
	{
		FishType[] afishtype = FishType.values();
		int i = afishtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			FishType fishtype = afishtype[j];
			
			if (!this.cooked || fishtype.isCookable)
			{
				list.add(new ItemStack(this, 1, fishtype.ordinal()));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		FishType fishtype = FishType.getFishType(stack);
		return this.getUnlocalizedName() + "." + fishtype.getName() + "." + (this.cooked && fishtype.isCookable ? "cooked" : "raw");
	}
	
	@Override
	public IIcon getFoodIcon(ItemStack stack)
	{
		FishType type = FishType.getFishType(stack);
		return this.cooked && type.isCookable ? type.cookedIcon : type.rawIcon;
	}
	
	@Override
	public IIcon getFriedIcon(ItemStack stack)
	{
		FishType type = FishType.getFishType(stack);
		return this.cooked && type.isCookable ? type.cookedFriedIcon : type.rawFriedIcon;
	}
	
	@Override
	public IIcon getSpoiledIcon(ItemStack stack)
	{
		FishType type = FishType.getFishType(stack);
		return this.cooked && type.isCookable ? type.cookedSpoiledIcon : type.rawSpoiledIcon;
	}
	
	public static enum FishType
	{
		COD("cod", 2, 0.1F, 5, 0.6F), SALMON("salmon", 2, 0.1F, 6, 0.8F), CLOWNFISH("clownfish", 1, 0.1F), PUFFERFISH("pufferfish", 1, 0.1F);
		
		private final String		name;
		
		public IIcon				rawIcon;
		public IIcon				cookedIcon;
		public IIcon				rawFriedIcon;
		public IIcon				rawSpoiledIcon;
		public IIcon				cookedFriedIcon;
		public IIcon				cookedSpoiledIcon;
		
		private final int			rawHealAmount;
		private final float			rawSaturationModifier;
		private final int			cookedHealAmount;
		private final float			cookedSaturationModifier;
		
		private boolean				isCookable;
		
		private FishType(String name, int rawHealAmount, float rawSaturationModifier, int cookedHealAmount, float cookedSaturationModifier)
		{
			this.name = name;
			this.rawHealAmount = rawHealAmount;
			this.rawSaturationModifier = rawSaturationModifier;
			this.cookedHealAmount = cookedHealAmount;
			this.cookedSaturationModifier = cookedSaturationModifier;
			this.isCookable = true;
		}
		
		private FishType(String name, int rawHealAmount, float rawSaturationModifier)
		{
			this.name = name;
			this.rawHealAmount = rawHealAmount;
			this.rawSaturationModifier = rawSaturationModifier;
			this.cookedHealAmount = 0;
			this.cookedSaturationModifier = 0.0F;
			this.isCookable = false;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister iconRegister, FoodType foodType)
		{
			String string = "fish_" + this.name;
			this.rawIcon = iconRegister.registerIcon(string + "_raw");
			if (foodType.isSpoilable())
			{
				this.rawSpoiledIcon = iconRegister.registerIcon(string + "_raw_spoiled");
			}
			
			if (foodType.isFriable())
			{
				this.rawFriedIcon = iconRegister.registerIcon(string + "_raw_fried");
			}
			
			if (this.isCookable)
			{
				this.cookedIcon = iconRegister.registerIcon(string + "_cooked");
				
				if (foodType.isSpoilable())
				{
					this.cookedSpoiledIcon = iconRegister.registerIcon(string + "_cooked_spoiled");
				}
				
				if (foodType.isFriable())
				{
					this.cookedFriedIcon = iconRegister.registerIcon(string + "_cooked_fried");
				}
			}
		}
		
		public static FishType getFishType(int id)
		{
			FishType fishtype = values()[id];
			return fishtype == null ? COD : fishtype;
		}
		
		public static FishType getFishType(ItemStack stack)
		{
			return stack.getItem() instanceof ItemFishFood2 ? getFishType(stack.getItemDamage()) : COD;
		}
	}
}