package clashsoft.playerinventoryapi.lib;

import java.util.ArrayList;

import clashsoft.cslib.reflect.CSReflection;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;

public class FakeArrayList extends ArrayList
{
	private static final long	serialVersionUID	= 5436247638996771146L;
	
	public int					fakeLength;
	
	public FakeArrayList(int fakeLength)
	{
		this.fakeLength = fakeLength;
	}
	
	@Override
	public int size()
	{
		String clazz = CSReflection.getCallerClassName();
		if (PlayerInventoryAPI.proxy.isMinecraftClassName(clazz))
		{
			return this.fakeLength;
		}
		return super.size();
	}
}