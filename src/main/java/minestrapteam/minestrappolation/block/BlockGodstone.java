package minestrapteam.minestrappolation.block;

import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockGodstone extends Block
{
	public BlockGodstone(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.setBlockMetadataWithNotify(x, y, z, 0, z);
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate());
	}
	
	public int tickRate()
	{
		return 5;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			world.scheduleBlockUpdate(x, y, z, this, this.tickRate());
			AxisAlignedBB axisalignedbb = this.getCollisionBoundingBoxFromPool(world, x, y, z).expand(6, 6, 6);
			
			List<EntityMob> list = world.getEntitiesWithinAABB(EntityMob.class, axisalignedbb);
			for (EntityMob mob : list)
			{
				mob.setFire(20);
			}
		}
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		Tessellator tessellator = Tessellator.instance;
		
		GL11.glPushMatrix();
		
		GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
		
		tessellator.startDrawing(6);
		
		tessellator.setColorRGBA_F(1F, 1F, 1F, 1F);
		tessellator.addVertex(0.0D, 0.0D, 0.0D);
		
		tessellator.setColorRGBA_I(16711935, 0);
		tessellator.addVertex(-0.866D * 50D, 50D, -25D);
		tessellator.addVertex(0.866D * 50D, 50D, -25D);
		tessellator.addVertex(0.0D, 50D, 50D);
		tessellator.addVertex(-0.866D * 50D, 50D, -25D);
		tessellator.draw();
		
		GL11.glPopMatrix();
	}
}