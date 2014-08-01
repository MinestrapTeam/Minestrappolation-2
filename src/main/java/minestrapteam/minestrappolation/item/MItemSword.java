package minestrapteam.minestrappolation.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Multimap;

import minestrapteam.minestrappolation.lib.MTools;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MItemSword extends ItemSword implements IPlatable
{
	private ToolMaterial		material;
	private boolean				ignites;
	
	private Map<String, IIcon>	overlayIcons	= new HashMap();
	
	public MItemSword(ToolMaterial material)
	{
		super(material);
		this.material = material;
	}
	
	public MItemSword(ToolMaterial material, boolean ignites)
	{
		super(material);
		this.material = material;
		this.ignites = ignites;
	}
	
	@Override
	public String getType()
	{
		return "sword";
	}
	
	@Override
	public int getPlatingCount(ItemStack stack)
	{
		return this.material.getHarvestLevel() + 1;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		if (this == MTools.soulsteelSword)
		{
			attacker.worldObj.playSoundAtEntity(attacker, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!attacker.worldObj.isRemote)
			{
				attacker.worldObj.spawnEntityInWorld(new EntityXPOrb(attacker.worldObj, attacker.posX, attacker.posX, attacker.posX, 25));
			}
		}
		return MItemTool.hitEntity(stack, entity, attacker, this.ignites, true);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		MItemTool.addInformation(stack, list);
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
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		return MItemTool.getDigSpeed(super.getDigSpeed(stack, block, metadata), stack);
	}
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		return MItemTool.getMaxDamage(super.getMaxDamage(stack), stack);
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		return MItemTool.getAttributeModifiers(super.getAttributeModifiers(stack), stack);
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
		
		for (Entry<String, IPlating> e : IPlating.platings.entrySet())
		{
			String type = e.getKey();
			IPlating plating = e.getValue();
			
			if (plating.canApply(this))
			{
				StringBuilder builder = new StringBuilder(20);
				builder.append("weapons/").append(type).append("_sword_overlay");
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
