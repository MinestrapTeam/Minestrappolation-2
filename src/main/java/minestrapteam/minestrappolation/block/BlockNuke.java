package minestrapteam.minestrappolation.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.entity.EntityNukePrimed;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockNuke extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon	top;
	@SideOnly(Side.CLIENT)
	private IIcon	bottom;
	
	public BlockNuke()
	{
		super(Material.tnt);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getTexture("nuke_side"));
		this.top = iconRegister.registerIcon(MAssetManager.getTexture("nuke_top"));
		this.bottom = iconRegister.registerIcon(MAssetManager.getTexture("nuke_bottom"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.bottom;
		}
		if (side == 1)
		{
			return this.top;
		}
		return this.blockIcon;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		
		if (world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			this.createPrimedEntity(world, x, y, z, null);
			world.setBlockToAir(x, y, z);
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			this.createPrimedEntity(world, x, y, z, null);
			world.setBlockToAir(x, y, z);
		}
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		EntityNukePrimed entity = this.createPrimedEntity(world, x, y, z, explosion.getExplosivePlacedBy());
		if (entity != null)
		{
			entity.fuse = world.rand.nextInt(entity.fuse / 4) + entity.fuse / 8;
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		if (metadata > 0)
		{
			this.createPrimedEntity(world, x, y, z, (EntityLivingBase) null);
		}
	}
	
	public EntityNukePrimed createPrimedEntity(World world, int x, int y, int z, EntityLivingBase owner)
	{
		if (!world.isRemote)
		{
			EntityNukePrimed entity = new EntityNukePrimed(world, x + 0.5F, y + 0.5F, z + 0.5F, owner);
			world.spawnEntityInWorld(entity);
			world.playSoundAtEntity(entity, "game.tnt.primed", 1.0F, 1.0F);
			return entity;
		}
		return null;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (!world.isRemote && entity instanceof EntityArrow)
		{
			EntityArrow arrow = (EntityArrow) entity;
			
			if (arrow.isBurning())
			{
				this.createPrimedEntity(world, x, y, z, arrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase) arrow.shootingEntity : null);
				world.setBlockToAir(x, y, z);
			}
		}
	}
	
	@Override
	public boolean canDropFromExplosion(Explosion explosion)
	{
		return false;
	}
}
