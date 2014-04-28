package clashsoft.cslib.minecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class CSEntityProperties implements IExtendedEntityProperties
{
	public static final String	IDENTIFIER	= "CSEP";
	
	public final Entity			entity;
	public NBTTagCompound		data;
	
	public CSEntityProperties(Entity entity)
	{
		this.entity = entity;
	}
	
	public static CSEntityProperties get_(Entity entity)
	{
		return (CSEntityProperties) entity.getExtendedProperties(IDENTIFIER);
	}
	
	public static CSEntityProperties get(Entity entity)
	{
		CSEntityProperties ep = get_(entity);
		return ep == null ? set_(entity, new CSEntityProperties(entity)) : ep;
	}
	
	public static CSEntityProperties set_(Entity entity, CSEntityProperties ep)
	{
		entity.registerExtendedProperties(IDENTIFIER, ep);
		return ep;
	}
	
	public static CSEntityProperties set(Entity entity, CSEntityProperties ep)
	{
		CSEntityProperties ep2 = get_(entity);
		if (ep2 == null)
		{
			set_(entity, ep);
			return ep;
		}
		else
		{
			copy(ep, ep2);
			return ep2;
		}
	}
	
	public static void copy(CSEntityProperties src, CSEntityProperties dest)
	{
		dest.data = src.data;
	}
	
	@Override
	public void init(Entity entity, World world)
	{
	}
	
	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		this.data = nbt.getCompoundTag(IDENTIFIER);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound nbt)
	{
		nbt.setTag(IDENTIFIER, this.data);
	}
}
