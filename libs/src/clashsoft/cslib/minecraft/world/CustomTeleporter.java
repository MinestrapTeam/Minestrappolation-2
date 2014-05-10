package clashsoft.cslib.minecraft.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public abstract class CustomTeleporter extends Teleporter
{
	private final WorldServer	worldServerInstance;
	private final Random		random;
	private final LongHashMap	destCoordCache	= new LongHashMap();
	private final List			destCoordKeys	= new ArrayList();
	
	public CustomTeleporter(WorldServer world)
	{
		super(world);
		this.worldServerInstance = world;
		this.random = new Random(world.getSeed());
	}
	
	public abstract Block getPortalBlock();
	
	public abstract Block getFrameBlock();
	
	public int getPortalMetadata()
	{
		return 0;
	}
	
	public int getFrameMetadata()
	{
		return 0;
	}
	
	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float yaw)
	{
		if (this.worldServerInstance.provider.dimensionId == 1)
		{
			int i = MathHelper.floor_double(entity.posX);
			int j = MathHelper.floor_double(entity.posY) - 1;
			int k = MathHelper.floor_double(entity.posZ);
			
			int l = 1;
			int i1 = 0;
			for (int i2 = -2; i2 <= 2; ++i2)
			{
				for (int i3 = -2; i3 <= 2; ++i3)
				{
					for (int i4 = -1; i4 < 3; ++i4)
					{
						int i5 = i + i3 * l + i2 * i1;
						int i6 = j + i4;
						int i7 = k + i3 * i1 - (i2 * l);
						
						int i8 = (i4 < 0) ? 1 : 0;
						
						this.worldServerInstance.setBlock(i5, i6, i7, (i8 != 0) ? this.getFrameBlock() : Blocks.air);
					}
				}
			}
			
			entity.setLocationAndAngles(i, j, k, entity.rotationYaw, 0.0F);
			entity.motionX = (entity.motionY = entity.motionZ = 0.0D);
			
			return;
		}
		if (placeInExistingPortal(entity, x, y, z, yaw))
		{
			return;
		}
		
		makePortal(entity);
		placeInExistingPortal(entity, x, y, z, yaw);
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float yaw)
	{
		int i = 128;
		int j = 0;
		int k = 0;
		int l = MathHelper.floor_double(entity.posX);
		int i1 = MathHelper.floor_double(entity.posZ);
		int i2 = 1;
		int i3;
		long l1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
		
		double d1 = -1.0D;
		int d2 = 0;
		int d3;
		if (this.destCoordCache.containsItem(l1))
		{
			PortalPosition localPortalPosition = (PortalPosition) this.destCoordCache.getValueByKey(l1);
			
			d1 = 0.0D;
			j = localPortalPosition.posX;
			d2 = localPortalPosition.posY;
			k = localPortalPosition.posZ;
			localPortalPosition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
			i2 = 0;
		}
		else
		{
			for (i3 = l - i; i3 <= l + i; ++i3)
			{
				d3 = (int) (i3 + 0.5D - entity.posX);
				for (int i5 = i1 - i; i5 <= i1 + i; ++i5)
				{
					double d5 = i5 + 0.5D - entity.posZ;
					for (int d7 = this.worldServerInstance.getActualHeight() - 1; d7 >= 0; --d7)
					{
						if (this.worldServerInstance.getBlock(i3, d7, i5) == this.getPortalBlock())
						{
							while (this.worldServerInstance.getBlock(i3, d7 - 1, i5) == this.getPortalBlock())
							{
								--d7;
							}
							
							double d8 = d7 + 0.5D - entity.posY;
							double d9 = d3 * d3 + d8 * d8 + d5 * d5;
							if ((d1 < 0.0D) || (d9 < d1))
							{
								d1 = d9;
								j = i3;
								d2 = d7;
								k = i5;
							}
						}
					}
				}
			}
		}
		
		if (d1 >= 0.0D)
		{
			i3 = j;
			d3 = d2;
			int i4 = k;
			
			if (i2 != 0)
			{
				this.destCoordCache.add(l1, new PortalPosition(i3, d3, i4, this.worldServerInstance.getTotalWorldTime()));
				this.destCoordKeys.add(Long.valueOf(l1));
			}
			
			double d4 = i3 + 0.5D;
			double d6 = d3 + 0.5D;
			double d8 = i4 + 0.5D;
			int i6 = -1;
			
			if (this.worldServerInstance.getBlock(i3 - 1, d3, i4) == this.getPortalBlock())
				i6 = 2;
			if (this.worldServerInstance.getBlock(i3 + 1, d3, i4) == this.getPortalBlock())
				i6 = 0;
			if (this.worldServerInstance.getBlock(i3, d3, i4 - 1) == this.getPortalBlock())
				i6 = 3;
			if (this.worldServerInstance.getBlock(i3, d3, i4 + 1) == this.getPortalBlock())
				i6 = 1;
			
			int i7 = entity.getTeleportDirection();
			
			if (i6 > -1)
			{
				int i8 = Direction.rotateLeft[i6];
				int i9 = Direction.offsetX[i6];
				int i10 = Direction.offsetZ[i6];
				int i11 = Direction.offsetX[i8];
				int i12 = Direction.offsetZ[i8];
				
				int i13 = ((!(this.worldServerInstance.isAirBlock(i3 + i9 + i11, d3, i4 + i10 + i12))) || (!(this.worldServerInstance.isAirBlock(i3 + i9 + i11, d3 + 1, i4 + i10 + i12)))) ? 1 : 0;
				int i14 = ((!(this.worldServerInstance.isAirBlock(i3 + i9, d3, i4 + i10))) || (!(this.worldServerInstance.isAirBlock(i3 + i9, d3 + 1, i4 + i10)))) ? 1 : 0;
				
				if ((i13 != 0) && (i14 != 0))
				{
					i6 = Direction.rotateOpposite[i6];
					i8 = Direction.rotateOpposite[i8];
					i9 = Direction.offsetX[i6];
					i10 = Direction.offsetZ[i6];
					i11 = Direction.offsetX[i8];
					i12 = Direction.offsetZ[i8];
					
					i3 -= i11;
					d4 -= i11;
					i4 -= i12;
					d8 -= i12;
					i13 = ((!(this.worldServerInstance.isAirBlock(i3 + i9 + i11, d3, i4 + i10 + i12))) || (!(this.worldServerInstance.isAirBlock(i3 + i9 + i11, d3 + 1, i4 + i10 + i12)))) ? 1 : 0;
					i14 = ((!(this.worldServerInstance.isAirBlock(i3 + i9, d3, i4 + i10))) || (!(this.worldServerInstance.isAirBlock(i3 + i9, d3 + 1, i4 + i10)))) ? 1 : 0;
				}
				
				float f1 = 0.5F;
				float f2 = 0.5F;
				
				if ((i13 == 0) && (i14 != 0))
					f1 = 1.0F;
				else if ((i13 != 0) && (i14 == 0))
					f1 = 0.0F;
				else if ((i13 != 0) && (i14 != 0))
				{
					f2 = 0.0F;
				}
				
				d4 += i11 * f1 + f2 * i9;
				d8 += i12 * f1 + f2 * i10;
				
				float f3 = 0.0F;
				float f4 = 0.0F;
				float f5 = 0.0F;
				float f6 = 0.0F;
				
				if (i6 == i7)
				{
					f3 = 1.0F;
					f4 = 1.0F;
				}
				else if (i6 == Direction.rotateOpposite[i7])
				{
					f3 = -1.0F;
					f4 = -1.0F;
				}
				else if (i6 == Direction.rotateRight[i7])
				{
					f5 = 1.0F;
					f6 = -1.0F;
				}
				else
				{
					f5 = -1.0F;
					f6 = 1.0F;
				}
				
				double d10 = entity.motionX;
				double d11 = entity.motionZ;
				entity.motionX = (d10 * f3 + d11 * f6);
				entity.motionZ = (d10 * f5 + d11 * f4);
				entity.rotationYaw = (yaw - (i7 * 90) + i6 * 90);
			}
			else
			{
				entity.motionX = (entity.motionY = entity.motionZ = 0.0D);
			}
			
			entity.setLocationAndAngles(d4, d6, d8, entity.rotationYaw, entity.rotationPitch);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean makePortal(Entity entity)
	{
		int i = MathHelper.floor_double(entity.posX);
		int j = MathHelper.floor_double(entity.posY);
		int k = MathHelper.floor_double(entity.posZ);
		int l = j;
		int i1 = k;
		int i2 = this.random.nextInt(4);
		int i3;
		int i4;
		int i5;
		int i6;
		int i7;
		int i8;
		int i9;
		int i10;
		int i14;
		int i18;
		int i19;
		int i20;
		
		double d1 = -1D;
		int d3 = i;
		int d4 = 0;
		int d5;
		int d6;
		int d7;
		
		for (d5 = i - 16; d5 <= i + 16; ++d5)
		{
			d6 = (int) (d5 + 0.5D - entity.posX);
			for (i4 = k - 16; i4 <= k + 16; ++i4)
			{
				d7 = (int) (i4 + 0.5D - entity.posZ);
				label436:
				for (i7 = this.worldServerInstance.getActualHeight() - 1; i7 >= 0; --i7)
				{
					if (this.worldServerInstance.isAirBlock(d5, i7, i4))
					{
						while ((i7 > 0) && (this.worldServerInstance.isAirBlock(d5, i7 - 1, i4)))
						{
							--i7;
						}
						
						for (i8 = i2; i8 < i2 + 4; ++i8)
						{
							i9 = i8 % 2;
							i10 = 1 - i9;
							
							if (i8 % 4 >= 2)
							{
								i9 = -i9;
								i10 = -i10;
							}
							
							for (int i11 = 0; i11 < 3; ++i11)
							{
								for (i14 = 0; i14 < 4; ++i14)
								{
									for (int i15 = -1; i15 < 4; ++i15)
									{
										i18 = d5 + (i14 - 1) * i9 + i11 * i10;
										i19 = i7 + i15;
										i20 = i4 + (i14 - 1) * i10 - (i11 * i9);
										
										if ((i15 < 0) && (!(this.worldServerInstance.getBlock(i18, i19, i20).getMaterial().isSolid())))
											break label436;
										if ((i15 >= 0) && (!(this.worldServerInstance.isAirBlock(i18, i19, i20))))
											break label436;
									}
								}
							}
							double d8 = i7 + 0.5D - entity.posY;
							double d10 = d6 * d6 + d8 * d8 + d7 * d7;
							if ((d1 < 0.0D) || (d10 < d1))
							{
								d1 = d10;
								d3 = d5;
								l = i7;
								i1 = i4;
								d4 = i8 % 4;
							}
						}
					}
				}
			}
		}
		if (d1 < 0.0D)
		{
			for (d5 = i - 16; d5 <= i + 16; ++d5)
			{
				d6 = (int) (d5 + 0.5D - entity.posX);
				for (i4 = k - 16; i4 <= k + 16; ++i4)
				{
					d7 = (int) (i4 + 0.5D - entity.posZ);
					label792:
					for (i7 = this.worldServerInstance.getActualHeight() - 1; i7 >= 0; --i7)
					{
						if (this.worldServerInstance.isAirBlock(d5, i7, i4))
						{
							while ((i7 > 0) && (this.worldServerInstance.isAirBlock(d5, i7 - 1, i4)))
							{
								--i7;
							}
							
							for (i8 = i2; i8 < i2 + 2; ++i8)
							{
								i9 = i8 % 2;
								i10 = 1 - i9;
								for (int i12 = 0; i12 < 4; ++i12)
								{
									for (i14 = -1; i14 < 4; ++i14)
									{
										int i16 = d5 + (i12 - 1) * i9;
										i18 = i7 + i14;
										i19 = i4 + (i12 - 1) * i10;
										
										if ((i14 < 0) && (!(this.worldServerInstance.getBlock(i16, i18, i19).getMaterial().isSolid())))
											break label792;
										if ((i14 >= 0) && (!(this.worldServerInstance.isAirBlock(i16, i18, i19))))
											break label792;
									}
								}
								double d9 = i7 + 0.5D - entity.posY;
								double d11 = d6 * d6 + d9 * d9 + d7 * d7;
								if ((d1 < 0.0D) || (d11 < d1))
								{
									d1 = d11;
									d3 = d5;
									l = i7;
									i1 = i4;
									d4 = i8 % 2;
								}
							}
						}
					}
				}
			}
		}
		
		d5 = d4;
		
		d6 = d3;
		i3 = l;
		i4 = i1;
		i5 = d5 & 1;
		i6 = 1 - i5;
		
		if ((d5 & 2) >= 2)
		{
			i5 = -i5;
			i6 = -i6;
		}
		int i11;
		int i17;
		if (d1 < 0.0D)
		{
			if (l < 70)
				l = 70;
			if (l > this.worldServerInstance.getActualHeight() - 10)
				l = this.worldServerInstance.getActualHeight() - 10;
			i3 = l;
			
			for (i7 = -1; i7 <= 1; ++i7)
			{
				for (i8 = 1; i8 < 3; ++i8)
				{
					for (i9 = -1; i9 < 3; ++i9)
					{
						i10 = d6 + (i8 - 1) * i5 + i7 * i6;
						i11 = i3 + i9;
						i14 = i4 + (i8 - 1) * i6 - (i7 * i5);
						
						i17 = (i9 < 0) ? 1 : 0;
						
						this.worldServerInstance.setBlock(i10, i11, i14, (i17 != 0) ? this.getFrameBlock() : Blocks.air);
					}
				}
			}
		}
		
		for (i7 = 0; i7 < 4; ++i7)
		{
			for (i8 = 0; i8 < 4; ++i8)
			{
				for (i9 = -1; i9 < 4; ++i9)
				{
					i10 = d6 + (i8 - 1) * i5;
					i11 = i3 + i9;
					i14 = i4 + (i8 - 1) * i6;
					
					i17 = ((i8 == 0) || (i8 == 3) || (i9 == -1) || (i9 == 3)) ? 1 : 0;
					if (i17 != 0)
					{						
						this.worldServerInstance.setBlock(i10, i11, i14, this.getFrameBlock(), this.getFrameMetadata(), 2);
					}
					else
					{
						this.worldServerInstance.setBlock(i10, i11, i14, this.getPortalBlock(), this.getPortalMetadata(), 2);
					}
				}
			}
			
			for (i8 = 0; i8 < 4; ++i8)
			{
				for (i9 = -1; i9 < 4; ++i9)
				{
					i10 = d6 + (i8 - 1) * i5;
					i11 = i3 + i9;
					i14 = i4 + (i8 - 1) * i6;
					
					this.worldServerInstance.notifyBlocksOfNeighborChange(i10, i11, i14, this.worldServerInstance.getBlock(i10, i11, i14));
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void removeStalePortalLocations(long time)
	{
		if (time % 100L == 0L)
		{
			Iterator iterator = this.destCoordKeys.iterator();
			long time1 = time - 600L;
			
			while (iterator.hasNext())
			{
				Long l = (Long) iterator.next();
				PortalPosition localPortalPosition = (PortalPosition) this.destCoordCache.getValueByKey(l.longValue());
				
				if ((localPortalPosition == null) || (localPortalPosition.lastUpdateTime < time1))
				{
					iterator.remove();
					this.destCoordCache.remove(l.longValue());
				}
			}
		}
	}
	
	public class PortalPosition extends ChunkCoordinates
	{
		public long	lastUpdateTime;
		
		public PortalPosition(int x, int y, int z, long lastUpdateTime)
		{
			super(x, y, z);
			this.lastUpdateTime = lastUpdateTime;
		}
	}
}