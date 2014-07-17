package minestrapteam.mcore.item;

import java.util.List;
import java.util.Set;

import clashsoft.cslib.minecraft.lang.I18n;

import com.google.common.collect.ImmutableSet;

import minestrapteam.mcore.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MCItemTool extends ItemTool implements IPlatable
{
	protected boolean	ignites;
	
	private String		toolType;
	
	private IIcon		overlayIcon;
	
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
	
	public static boolean isPlated(ItemStack stack)
	{
		return getPlating(stack) != null;
	}
	
	public static String getPlating(ItemStack stack)
	{
		if (stack.stackTagCompound != null)
		{
			String s = stack.stackTagCompound.getString("Plating");
			return s == null || s.isEmpty() ? null : s;
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
	
	public static void setPlating(ItemStack stack, String plating)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setString("Plating", plating);
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
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		float level = getPoisonLevel(stack);
		if (level > 0)
		{
			entity.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 12, 0));
			level -= 0.5F;
			setPoisonLevel(stack, level);
		}
		
		if ("sword".equals(this.toolType))
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
		String plating = getPlating(stack);
		
		if (plating != null)
		{
			list.add(I18n.getString("item.plating." + plating + ".desc"));
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
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString());
		
		boolean sword = "sword".equals(this.toolType);
		StringBuilder builder = new StringBuilder(20);
		
		if (sword)
		{
			builder.append("weapons/");
		}
		else
		{
			builder.append("tools/");
		}
		
		builder.append("bronze_").append(this.toolType).append("_overlay");
		if (!sword && this.toolMaterial.getHarvestLevel() >= 5)
		{
			builder.append("_2");
		}
		
		this.overlayIcon = iconRegister.registerIcon(MCAssetManager.getTexture(builder.toString()));
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass)
	{
		String plating = getPlating(stack);
		if (renderPass == 1 && plating != null)
		{
			return this.overlayIcon;
		}
		return this.itemIcon;
	}
}
