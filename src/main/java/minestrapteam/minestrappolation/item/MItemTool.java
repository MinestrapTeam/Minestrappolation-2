package minestrapteam.minestrappolation.item;

import java.util.*;
import java.util.Map.Entry;

import clashsoft.cslib.minecraft.lang.I18n;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import minestrapteam.minestrappolation.lib.MTools;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemTool extends ItemTool implements IPlatable
{
	public static final UUID	PLATING_UUID	= UUID.fromString("DB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	
	protected boolean			ignites;
	protected boolean			weapon;
	
	private String				toolType;
	private Map<String, IIcon>	overlayIcons	= new HashMap();
	
	public MItemTool(float baseDamage, ToolMaterial material, Set<Block> blocks, String type, boolean ignites)
	{
		super(baseDamage, material, blocks);
		this.toolType = type;
		this.ignites = ignites;
	}
	
	public MItemTool(float baseDamage, ToolMaterial material, Set<Block> blocks, String type)
	{
		this(baseDamage, material, blocks, type, false);
	}
	
	public MItemTool setWeapon()
	{
		this.weapon = true;
		return this;
	}
	
	@Override
	public String getType()
	{
		return this.toolType;
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
			return s == null || s.isEmpty() ? null : IPlating.platings.get(s);
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
		stack.stackTagCompound.setString("Plating", plating == null ? "" : plating.getType());
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
	
	public static boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker, boolean ignites, boolean weapon)
	{
		float level = getPoisonLevel(stack);
		if (level > 0)
		{
			entity.addPotionEffect(new PotionEffect(Potion.poison.id, 20 * 12, 0));
			level -= 0.5F;
			setPoisonLevel(stack, level);
		}
		
		if (ignites)
		{
			entity.setFire(10);
		}
		
		if (weapon)
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
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		return hitEntity(stack, entity, attacker, this.ignites, this.weapon);
	}
	
	public static void addInformation(ItemStack stack, List list)
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
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		addInformation(stack, list);
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
	
	public static float getDigSpeed(float superDigSpeed, ItemStack stack)
	{
		IPlating plating = getPlating(stack);
		if (plating != null)
		{
			return superDigSpeed * plating.getDigSpeed();
		}
		return superDigSpeed;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int meta)
	{
		return getDigSpeed(super.getDigSpeed(stack, block, meta), stack);
	}
	
	public static int getMaxDamage(int superDamage, ItemStack stack)
	{
		IPlating plating = getPlating(stack);
		if (plating != null)
		{
			return superDamage + plating.getDurability();
		}
		return superDamage;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		return getMaxDamage(super.getMaxDamage(stack), stack);
	}
	
	public static Multimap getAttributeModifiers(Multimap multimap, ItemStack stack)
	{
		IPlating plating = getPlating(stack);
		if (plating != null)
		{
			AttributeModifier modifier = new AttributeModifier(PLATING_UUID, "Plating Modifier", plating.getEntityDamage(), 0);
			multimap.put("generic.attackDamage", modifier);
		}
		return multimap;
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		return getAttributeModifiers(super.getAttributeModifiers(stack), stack);
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
		ItemStack thisStack = new ItemStack(this, 1, 0);
		
		for (Entry<String, IPlating> e : IPlating.platings.entrySet())
		{
			String type = e.getKey();
			IPlating plating = e.getValue();
			
			if (plating.canApply(thisStack))
			{
				StringBuilder builder = new StringBuilder(20);
				builder.append("tools/").append(type).append("_").append(this.toolType).append("_overlay");
				if (this.toolMaterial.getHarvestLevel() >= 5)
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
			IPlating plating = getPlating(stack);
			if (plating != null)
			{
				icon = this.overlayIcons.get(plating.getType());
			}
		}
		return icon == null ? this.itemIcon : icon;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living)
	{
		if (this == MTools.soulsteelAxe || this == MTools.soulsteelPickaxe || this == MTools.soulsteelShovel)
		{
			world.playSoundAtEntity(living, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!world.isRemote)
			{
				world.spawnEntityInWorld(new EntityXPOrb(world, x, y, z, 5 + world.rand.nextInt(8)));
				return true;
			}
		}
		return super.onBlockDestroyed(stack, world, block, x, y, z, living);
	}
}
