package minestrapteam.mcore.item;

import java.util.*;
import java.util.Map.Entry;

import clashsoft.cslib.minecraft.lang.I18n;

import com.google.common.collect.ImmutableSet;

import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.minestrappolation.item.ItemPlating;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MCItemTool extends ItemTool implements IPlatable
{
	protected boolean			ignites;
	protected boolean			weapon;
	
	private String				toolType;
	private Map<String, IIcon>	overlayIcons	= new HashMap();
	
	public MCItemTool(float baseDamage, ToolMaterial material, Set<Block> blocks, String type, boolean ignites)
	{
		super(baseDamage, material, blocks);
		this.toolType = type;
		this.ignites = ignites;
	}
	
	public MCItemTool(float baseDamage, ToolMaterial material, Set<Block> blocks, String type)
	{
		this(baseDamage, material, blocks, type, false);
	}
	
	public MCItemTool setWeapon()
	{
		this.weapon = true;
		return this;
	}
	
	@Override
	public int getPlatingCount(ItemStack stack)
	{
		return this.toolMaterial.getHarvestLevel() + 1;
	}
	
	public static boolean isPlated(ItemStack stack)
	{
		return getPlating(stack) != null;
	}
	
	public static IPlating getPlating(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			String s = stack.stackTagCompound.getString("Plating");
			return s == null ? null : IPlating.platings.get(s);
		}
		return null;
	}
	
	public static float getPoisonLevel(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			return stack.stackTagCompound.getFloat("PoisonLevel");
		}
		return 0F;
	}
	
	public static void setPlating(ItemStack stack, IPlating plating)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setString("Plating", plating.getType());
	}
	
	public static void setPoisonLevel(ItemStack stack, float level)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setFloat("PoisonLevel", level);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return this.weapon ? EnumAction.block : EnumAction.none;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return this.weapon ? 72000 : 0;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (this.weapon)
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		return stack;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		float level = getPoisonLevel(stack);
		if (level > 0)
		{
			entity.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 12, 0));
			level -= 0.5F;
			setPoisonLevel(stack, level);
		}
		
		IPlating plating = getPlating(stack);
		if (plating != null)
		{
			float f = plating.getDigSpeed() * 1.25F;
			entity.attackEntityFrom(DamageSource.causeMobDamage(attacker), f);
		}
		
		if (this.ignites)
		{
			entity.setFire(10);
		}
		
		if (this.weapon)
		{
			stack.damageItem(1, attacker);
		}
		else
		{
			stack.damageItem(2, attacker);
		}
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		addInformation(stack, list);
	}
	
	protected static void addInformation(ItemStack stack, List list)
	{
		IPlating plating = getPlating(stack);
		if (plating != null)
		{
			list.add(I18n.getString("item.plating." + plating.getType() + ".desc"));
		}
		
		float poisonLevel = getPoisonLevel(stack);
		if (poisonLevel > 0F)
		{
			list.add(I18n.getString("item.poison_sword.desc", poisonLevel));
		}
	}
	
	@Override
	public int getHarvestLevel(ItemStack stack, String toolClass)
	{
		int level = super.getHarvestLevel(stack, toolClass);
		if (level == -1 && toolClass != null && toolClass.equals(this.toolType))
		{
			return this.toolMaterial.getHarvestLevel();
		}
		
		return level;
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack)
	{
		return this.toolType != null ? ImmutableSet.of(this.toolType) : super.getToolClasses(stack);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote && this.ignites)
		{
			Items.flint_and_steel.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
			stack.damageItem(4, player);
			return true;
		}
		return false;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
	{
		IPlating plating = getPlating(stack);
		if (plating != null)
		{
			return super.getDigSpeed(stack, block, meta) * plating.getDigSpeed();
		}
		return super.getDigSpeed(stack, block, meta);
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		IPlating plating = getPlating(stack);
		if (plating != null)
		{
			return super.getMaxDamage(stack) + plating.getDurability();
		}
		return super.getMaxDamage(stack);
	}
	
	@Override
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
		
		for (Entry<String, IPlating> e : ItemPlating.platings.entrySet())
		{
			String type = e.getKey();
			IPlating plating = e.getValue();
			
			if (plating.canApply(this.toolType))
			{
				boolean sword = "sword".equals(this.toolType);
				StringBuilder builder = new StringBuilder(20);
				builder.append(sword ? "weapons/" : "tools/").append(type).append("_").append(this.toolType).append("_overlay");
				if (!sword && this.toolMaterial.getHarvestLevel() >= 5)
				{
					builder.append("_2");
				}
				String textureName = MCAssetManager.getTexture(builder.toString());
				this.overlayIcons.put(type, iconRegister.registerIcon(textureName));
			}
		}
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		IPlating plating = getPlating(stack);
		if (renderPass == 1 && plating != null)
		{
			return this.overlayIcons.get(plating.getType());
		}
		return this.itemIcon;
	}
}
