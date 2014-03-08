package clashsoft.cslib.minecraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public abstract class BlockCustomPortal extends Block
{
	public static final int[][]	metadataMap	= { { 3, 1 }, { 2, 0 } };
	
	public int					dimensionID;
	
	public BlockCustomPortal(String name, String iconName, int dimensionID)
	{
		super(Material.portal);
		this.setBlockName(name);
		this.setBlockTextureName(iconName);
		this.setHardness(-1F);
		this.setLightLevel(1F);
		this.setTickRandomly(true);
		
		this.dimensionID = dimensionID;
	}
	
	public abstract Block getFrameBlock();
	
	public int getFrameMetadata()
	{
		return 0;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		
		if ((!world.provider.isSurfaceWorld()) || (!world.getGameRules().getGameRuleBooleanValue("doMobSpawning")))
		{
			return;
		}
		
		if (random.nextInt(2000) >= world.difficultySetting.getDifficultyId())
		{
			int i = y;
			while ((!(World.doesBlockHaveSolidTopSurface(world, x, i, z))) && (i > 0))
			{
				--i;
			}
			if ((i <= 0) || (world.getBlock(x, i + 1, z).isNormalCube()))
				return;
			Entity localEntity = ItemMonsterPlacer.spawnCreature(world, 57, x + 0.5D, i + 1.1D, z + 0.5D);
			if (localEntity != null)
				localEntity.timeUntilPortal = localEntity.getPortalCooldown();
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		int i = limitToValidMetadata(world.getBlockMetadata(x, y, z));
		PortalSize size1 = new PortalSize(this, world, x, y, z, 0);
		PortalSize size2 = new PortalSize(this, world, x, y, z, 1);
		
		if (i == 1 && (!size1.isValid() || size1.portals < size1.width * size1.height))
			world.setBlock(x, y, z, Blocks.air);
		else if (i == 2 && (!size2.isValid() || size2.portals < size2.width * size2.height))
			world.setBlock(x, y, z, Blocks.air);
		else if (i == 0 && !size1.isValid() && !size2.isValid())
			world.setBlock(x, y, z, Blocks.air);
	}
	
	public boolean generatePortal(World world, int x, int y, int z)
	{
		PortalSize size1 = new PortalSize(this, world, x, y, z, 0);
		PortalSize size2 = new PortalSize(this, world, x, y, z, 1);
		
		if (size1.isValid() && size1.portals == 0)
		{
			size1.generatePortal();
			return true;
		}
		if (size2.isValid() && size2.portals == 0)
		{
			size2.generatePortal();
			return true;
		}
		
		return false;
	}
	
	public void transferEntity(Entity entity)
	{
		ServerConfigurationManager manager = MinecraftServer.getServer().getConfigurationManager();
		Teleporter teleporter = this.createTeleporter((WorldServer) entity.worldObj);
		int src = entity.dimension;
		int dest = this.getDestination(entity);
		
		if (entity instanceof EntityPlayer)
		{
			manager.transferPlayerToDimension((EntityPlayerMP) entity, this.dimensionID, teleporter);
		}
		else
		{
			manager.transferEntityToWorld(entity, this.dimensionID, DimensionManager.getWorld(src), DimensionManager.getWorld(dest));
		}
	}
	
	public int getDestination(Entity entity)
	{
		return entity.dimension != 0 ? 0 : this.dimensionID;
	}
	
	public abstract Teleporter createTeleporter(WorldServer world);
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int i = limitToValidMetadata(world.getBlockMetadata(x, y, z));
		
		if (i == 0)
		{
			if ((world.getBlock(x - 1, y, z) == this) || (world.getBlock(x + 1, y, z) == this))
				i = 1;
			else
			{
				i = 2;
			}
			
			if ((world instanceof World) && (!(((World) world).isRemote)))
			{
				((World) world).setBlockMetadataWithNotify(x, y, z, i, 2);
			}
		}
		
		float f1 = 0.125F;
		float f2 = 0.125F;
		
		if (i == 1)
		{
			f1 = 0.5F;
		}
		if (i == 2)
		{
			f2 = 0.5F;
		}
		
		this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f2, 0.5F + f1, 1.0F, 0.5F + f2);
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		int i = 0;
		
		if (world.getBlock(x, y, z) == this)
		{
			i = limitToValidMetadata(world.getBlockMetadata(x, y, z));
			
			if (i == 0)
				return false;
			if (i == 2 && side != 5 && side != 4)
				return false;
			if (i == 1 && side != 3 && side != 2)
				return false;
		}
		
		int j = ((world.getBlock(x - 1, y, z) == this) && (world.getBlock(x - 2, y, z) != this)) ? 1 : 0;
		int k = ((world.getBlock(x + 1, y, z) == this) && (world.getBlock(x + 2, y, z) != this)) ? 1 : 0;
		
		int l = ((world.getBlock(x, y, z - 1) == this) && (world.getBlock(x, y, z - 2) != this)) ? 1 : 0;
		int i1 = ((world.getBlock(x, y, z + 1) == this) && (world.getBlock(x, y, z + 2) != this)) ? 1 : 0;
		
		int i2 = ((j != 0) || (k != 0) || (i == 1)) ? 1 : 0;
		int i3 = ((l != 0) || (i1 != 0) || (i == 2)) ? 1 : 0;
		
		if ((i2 != 0) && (side == 4))
			return true;
		if ((i2 != 0) && (side == 5))
			return true;
		if ((i3 != 0) && (side == 2))
			return true;
		return ((i3 != 0) && (side == 3));
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity.ridingEntity == null && entity.riddenByEntity == null)
		{
			entity.setInPortal();
			if (entity.getPortalCooldown() >= entity.getMaxInPortalTime())
			{
				this.transferEntity(entity);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (random.nextInt(100) == 0)
		{
			world.playSound(x + 0.5D, y + 0.5D, z + 0.5D, "portal.portal", 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int i = 0; i < 4; ++i)
		{
			double d1 = x + random.nextFloat();
			double d2 = y + random.nextFloat();
			double d3 = z + random.nextFloat();
			double d4 = (random.nextFloat() - 0.5D) * 0.5D;
			double d5 = (random.nextFloat() - 0.5D) * 0.5D;
			double d6 = (random.nextFloat() - 0.5D) * 0.5D;
			
			int j = random.nextInt(2) * 2 - 1;
			if ((world.getBlock(x - 1, y, z) == this) || (world.getBlock(x + 1, y, z) == this))
			{
				d3 = z + 0.5D + 0.25D * j;
				d6 = random.nextFloat() * 2.0F * j;
			}
			else
			{
				d1 = x + 0.5D + 0.25D * j;
				d4 = random.nextFloat() * 2.0F * j;
			}
			
			world.spawnParticle("portal", d1, d2, d3, d4, d5, d6);
		}
	}
	
	public static int limitToValidMetadata(int metadata)
	{
		return (metadata & 0x3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z)
	{
		return Item.getItemById(0);
	}
	
	@Override
	public int quantityDropped(Random paramRandom)
	{
		return 0;
	}
	
	public static class PortalSize
	{
		public BlockCustomPortal	portalBlock;
		
		private final World			world;
		private final int			metadata;
		private final int			direction2;
		private final int			direction1;
		private int					portals;
		private ChunkCoordinates	chunkPos;
		private int					width;
		private int					height;
		
		public PortalSize(BlockCustomPortal portalBlock, World world, int x, int y, int z, int metadata)
		{
			this.portalBlock = portalBlock;
			this.world = world;
			this.metadata = metadata;
			this.direction1 = metadataMap[metadata][0];
			this.direction2 = metadataMap[metadata][1];
			
			int i = y;
			
			while ((y > i - 21) && y > 0 && this.isBlockValid(x, y - 1, z))
			{
				--y;
			}
			
			int j = this.calculateWidth(x, y, z, this.direction1) - 1;
			
			if (j >= 0)
			{
				this.chunkPos = new ChunkCoordinates(x + j * Direction.offsetX[this.direction1], y, z + j * Direction.offsetZ[this.direction1]);
				this.width = this.calculateWidth(this.chunkPos.posX, this.chunkPos.posY, this.chunkPos.posZ, this.direction2);
				
				if ((this.width < 2) || (this.width > 21))
				{
					this.chunkPos = null;
					this.width = 0;
				}
			}
			
			if (this.chunkPos != null)
				this.height = this.calculateHeight();
		}
		
		public boolean isFrameBlock(int x, int y, int z)
		{
			if (this.world.getBlock(x, y, z) == this.portalBlock.getFrameBlock())
			{
				int i = this.portalBlock.getFrameMetadata();
				return i == -1 || this.world.getBlockMetadata(x, y, z) == i;
			}
			return false;
		}
		
		protected int calculateWidth(int x, int y, int z, int direction)
		{
			int i;
			int j = Direction.offsetX[direction];
			int k = Direction.offsetZ[direction];
			int x1 = 0;
			int z1 = 0;
			
			for (i = 0; i < 22; ++i)
			{
				x1 = x + j * i;
				z1 = z + k * i;
				if (!this.isBlockValid(x1, y, z1))
				{
					break;
				}
				
				if (!isFrameBlock(x1, y - 1, z1))
				{
					break;
				}
			}
			
			if (isFrameBlock(x1, y, z1))
			{
				return i;
			}
			return 0;
		}
		
		protected int calculateHeight()
		{
			int j;
			int k;
			int l;
			for (this.height = 0; this.height < 21; this.height += 1)
			{
				int i = this.chunkPos.posY + this.height;
				
				for (j = 0; j < this.width; ++j)
				{
					k = this.chunkPos.posX + j * Direction.offsetX[metadataMap[this.metadata][1]];
					l = this.chunkPos.posZ + j * Direction.offsetZ[metadataMap[this.metadata][1]];
					
					if (this.isFrameBlock(k, i, l))
					{
						this.portals++;
					}
					else if (!this.isBlockValid(k, i, l))
					{
						break;
					}
					
					if (j == 0)
					{
						if (!isFrameBlock(k + Direction.offsetX[metadataMap[this.metadata][0]], i, l + Direction.offsetZ[metadataMap[this.metadata][0]]))
						{
							break;
						}
					}
					if (j == this.width - 1)
					{
						if (!isFrameBlock(k + Direction.offsetX[metadataMap[this.metadata][1]], i, l + Direction.offsetZ[metadataMap[this.metadata][1]]))
						{
							break;
						}
					}
				}
			}
			
			for (int i = 0; i < this.width; ++i)
			{
				j = this.chunkPos.posX + i * Direction.offsetX[metadataMap[this.metadata][1]];
				k = this.chunkPos.posY + this.height;
				l = this.chunkPos.posZ + i * Direction.offsetZ[metadataMap[this.metadata][1]];
				
				if (this.world.getBlock(j, k, l) != this.portalBlock.getFrameBlock())
				{
					this.height = 0;
					break;
				}
			}
			
			if ((this.height > 21) || (this.height < 3))
			{
				this.chunkPos = null;
				this.width = 0;
				this.height = 0;
				return 0;
			}
			return this.height;
		}
		
		protected boolean isBlockValid(int x, int y, int z)
		{
			Block block = this.world.getBlock(x, y, z);
			return (block.getMaterial() == Material.air || block == Blocks.fire || this.isFrameBlock(x, y, z));
		}
		
		public boolean isValid()
		{
			return ((this.chunkPos != null) && (this.width >= 2) && (this.width <= 21) && (this.height >= 3) && (this.height <= 21));
		}
		
		public void generatePortal()
		{
			for (int i = 0; i < this.width; ++i)
			{
				int j = this.chunkPos.posX + Direction.offsetX[this.direction2] * i;
				int k = this.chunkPos.posZ + Direction.offsetZ[this.direction2] * i;
				
				for (int l = 0; l < this.height; ++l)
				{
					int i1 = this.chunkPos.posY + l;
					this.world.setBlock(j, i1, k, this.portalBlock, this.metadata, 2);
				}
			}
		}
	}
}
