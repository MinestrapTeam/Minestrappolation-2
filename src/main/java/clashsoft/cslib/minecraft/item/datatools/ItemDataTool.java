package clashsoft.cslib.minecraft.item.datatools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemDataTool extends ItemTool
{
	public float				toolDamage;
	
	private Set<Block>			blocksEffectiveAgainst;
	
	private String				toolType;
	
	public Map<String, IIcon>	icons	= new HashMap();
	public DataToolSet			toolSet;
	
	public ItemDataTool(float toolDamage, ToolMaterial material, Set<Block> blocksEffectiveAgainst, String type)
	{
		super(toolDamage, material, blocksEffectiveAgainst);
		this.blocksEffectiveAgainst = blocksEffectiveAgainst;
		this.toolType = type;
		this.toolDamage = toolDamage;
		this.setNoRepair();
	}
	
	public static ToolMaterial getToolMaterial(ItemStack stack)
	{
		if (stack != null)
		{
			ItemDataTool item = (ItemDataTool) stack.getItem();
			return item.toolSet.getToolMaterial(stack);
		}
		return null;
	}
	
	public static ItemStack setToolMaterial(ItemStack stack, ToolMaterial toolMaterial)
	{
		if (stack != null)
		{
			ItemDataTool item = (ItemDataTool) stack.getItem();
			return item.toolSet.setToolMaterial(stack, toolMaterial);
		}
		return stack;
	}
	
	public void registerMaterial(ToolMaterial material, String name)
	{
		this.toolSet.registerToolMaterial(material, name);
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		return this.getIconIndex(stack);
	}
	
	@Override
	public IIcon getIconIndex(ItemStack stack)
	{
		return this.icons.get(this.toolSet.getToolMaterial(stack));
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		ToolMaterial tm = this.toolSet.getToolMaterial(stack);
		if (tm != null)
		{
			return tm.getMaxUses();
		}
		return this.toolMaterial.getMaxUses();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		for (String key : this.toolSet.nameToMaterial.keySet())
		{
			IIcon icon = iconRegister.registerIcon(this.toolType + key);
			this.icons.put(key, icon);
		}
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass)
	{
		return this.icons.get(this.toolSet.getMaterialName(stack));
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return StatCollector.translateToLocal(this.toolSet.getMaterialName(stack) + " " + this.toolType);
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (this.blocksEffectiveAgainst.contains(block))
		{
			ToolMaterial tm = this.toolSet.getToolMaterial(stack);
			if (tm == null)
			{
				tm = this.toolMaterial;
			}
			return tm.getEfficiencyOnProperMaterial();
		}
		return 1.0F;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase living, EntityLivingBase living2)
	{
		if (!(this instanceof ItemDataSword || this instanceof ItemDataHoe))
		{
			stack.damageItem(2, living);
		}
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living)
	{
		if (block.getBlockHardness(world, x, y, z) != 0.0D)
		{
			stack.damageItem(1, living);
		}
		return true;
	}
	
	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", this.toolDamage, 0));
		return multimap;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	
	@Override
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}
	
	@Override
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		ToolMaterial tm = this.toolSet.getToolMaterial(stack);
		if (tm == null)
		{
			tm = this.toolMaterial;
		}
		return tm.customCraftingMaterial == repairItem.getItem() ? true : super.getIsRepairable(stack, repairItem);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (ToolMaterial tm : this.toolSet.materials)
		{
			ItemStack stack = new ItemStack(this);
			list.add(this.toolSet.setToolMaterial(stack, tm));
		}
	}
}
