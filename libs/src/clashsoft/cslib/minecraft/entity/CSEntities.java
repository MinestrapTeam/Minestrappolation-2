package clashsoft.cslib.minecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class CSEntities
{
	public static void register(String name, int id, Class<? extends Entity> clazz)
	{
		EntityList.addMapping(clazz, name, id);
	}
	
	public static void register(String name, int id, Class<? extends Entity> clazz, int eggColor1, int eggColor2)
	{
		EntityList.addMapping(clazz, name, id, eggColor1, eggColor2);
	}
	
	public static void replace(String name, int id, Class<? extends Entity> clazz)
	{
		EntityList.stringToClassMapping.remove(name);
		EntityList.IDtoClassMapping.remove(Integer.valueOf(id));
		register(name, id, clazz);
	}
	
	public static void replace(String name, int id, Class<? extends Entity> clazz, int eggColor1, int eggColor2)
	{
		EntityList.stringToClassMapping.remove(name);
		EntityList.IDtoClassMapping.remove(Integer.valueOf(id));
		register(name, id, clazz, eggColor1, eggColor2);
	}
}
