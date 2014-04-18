package clashsoft.cslib.minecraft;

import java.util.Arrays;
import java.util.List;

import clashsoft.cslib.minecraft.common.BaseProxy;
import clashsoft.cslib.minecraft.network.CSNetHandler;
import clashsoft.cslib.minecraft.update.CSUpdate;

public abstract class ClashsoftMod<N extends CSNetHandler> extends BaseMod<N>
{
	public static final List<String>	AUTHORS_CLASHSOFT	= Arrays.asList("Clashsoft");
	
	public ClashsoftMod(BaseProxy proxy, String modID, String name, String version)
	{
		super(proxy, modID, name, version);
		this.authors = AUTHORS_CLASHSOFT;
	}
	
	public ClashsoftMod(BaseProxy proxy, String modID, String name, String acronym, String version)
	{
		super(proxy, modID, name, acronym, version);
		this.authors = AUTHORS_CLASHSOFT;
	}
	
	@Override
	public void updateCheck()
	{
		CSUpdate.updateCheck(this.name, this.acronym, this.version, CSUpdate.CLASHSOFT_UPDATE_NOTES);
	}
}
