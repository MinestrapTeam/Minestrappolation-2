package clashsoft.cslib.minecraft.world;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public final class TeleporterNoPortal extends Teleporter
{
	public TeleporterNoPortal(WorldServer world)
	{
		super(world);
	}
	
	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float f)
	{
		
	}
	
	@Override
	public boolean makePortal(Entity entity)
	{
		return true;
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float f)
	{
		return true;
	}
}