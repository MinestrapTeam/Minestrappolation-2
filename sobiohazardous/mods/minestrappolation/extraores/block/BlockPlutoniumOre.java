package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.core.util.MUtil;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOConfig;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BlockPlutoniumOre extends BlockRadiation
{
	public BlockPlutoniumOre(Material material)
	{
		super(material);
		this.range = 1.5F;
	}
	
	public void registerIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("orePlutonium"));
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return EOItems.Plutonium;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(2);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (EOConfig.shouldOresEffect)
		{
			living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 20, 1, false));
		}
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
		this.spawnParticle(par1World, par2, par3, par4);
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
	}
	
	public void spawnParticle(World world, int x, int y, int z)
	{
		MUtil.spawnParticle(world, x, y, z, world.rand, "mobSpell");
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		this.dropXpOnBlockBreak(world, x, y, z, world.rand.nextInt(6) + 1);
	}
}