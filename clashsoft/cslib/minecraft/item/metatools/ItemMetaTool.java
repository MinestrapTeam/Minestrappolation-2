package clashsoft.cslib.minecraft.item.metatools;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemMetaTool extends ItemTool
{
	/** Array of blocks the tool has extra effect against. */
	private Block[]				blocksEffectiveAgainst;
	public float				efficiencyOnProperMaterial	= 4.0F;
	
	/** Damage versus entities. */
	public float				damageVsEntity;
	
	/** The material this tool is made from. */
	protected EnumToolMaterial	toolMaterial;
	
	public String[]				names;
	public String[]				icons;
	private Icon[]				icons2;
	public int[]				colors;
	
	public ItemMetaTool(int par1, float par2, EnumToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock, String[] names, String[] icons, int[] colors)
	{
		super(par1, par2, par3EnumToolMaterial, par4ArrayOfBlock);
		this.toolMaterial = par3EnumToolMaterial;
		this.blocksEffectiveAgainst = par4ArrayOfBlock;
		this.maxStackSize = 1;
		this.setMaxDamage(par3EnumToolMaterial.getMaxUses());
		this.efficiencyOnProperMaterial = par3EnumToolMaterial.getEfficiencyOnProperMaterial();
		this.damageVsEntity = par2 + par3EnumToolMaterial.getDamageVsEntity();
		this.colors = colors;
		this.icons = icons;
		this.icons2 = new Icon[icons.length];
		this.names = names;
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		for (int i = 0; i < icons.length; i++)
		{
			icons2[i] = par1IconRegister.registerIcon(icons[i]);
		}
	}
	
	public int getDamage(int par1)
	{
		return par1 >> 8;
	}
	
	public int getToolType(int par1)
	{
		return par1 & 255;
	}
	
	/**
	 * Gets an icon index based on an item's damage value
	 */
	@Override
	public Icon getIconFromDamage(int par1)
	{
		return icons2[getToolType(par1)];
	}
	
	/**
	 * Returns the strength of the stack against a given block. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		for (int i = 0; i < this.blocksEffectiveAgainst.length; ++i)
		{
			if (this.blocksEffectiveAgainst[i] == par2Block)
			{
				return this.efficiencyOnProperMaterial;
			}
		}
		
		return 1.0F;
	}
	
	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(2, par3EntityLivingBase);
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
	{
		if (Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
		{
			par1ItemStack.damageItem(1, par7EntityLivingBase);
		}
		
		return true;
	}
	
	@Override
	public String getItemDisplayName(ItemStack stack)
	{
		return StatCollector.translateToLocal(names[getDamage(stack.getItemDamage())]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	public boolean isFull3D()
	{
		return true;
	}
	
	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}
	
	/**
	 * Return the name for this tool's material.
	 */
	@Override
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}
	
	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
	{
		return HashMultimap.create();
	}
	
	/** FORGE: Overridden to allow custom tool effectiveness */
	@Override
	public float getStrVsBlock(ItemStack stack, Block block, int meta)
	{
		if (ForgeHooks.isToolEffective(stack, block, meta))
		{
			return efficiencyOnProperMaterial;
		}
		return getStrVsBlock(stack, block);
	}
	
	@Override
	public void setDamage(ItemStack stack, int damage)
	{
		int newDamage = getDamage(damage) | getToolType(stack.getItemDamage());
		stack.itemID = 0;
		stack.setItemDamage(newDamage);
		stack.itemID = this.itemID;
	}
	
	@Override
	public boolean isDamaged(ItemStack stack)
	{
		return getDamage(stack.getItemDamage()) > 0;
	}
	
	@Override
	public int getDamage(ItemStack stack)
	{
		return getDamage(stack.getItemDamage());
	}
	
	@Override
	public int getDisplayDamage(ItemStack stack)
	{
		return getDamage(stack.getItemDamage());
	}
	
	@Override
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < names.length; i++)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
	}
}