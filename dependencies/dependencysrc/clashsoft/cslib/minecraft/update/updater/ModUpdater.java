package clashsoft.cslib.minecraft.update.updater;

import java.util.Arrays;
import java.util.List;

import clashsoft.cslib.minecraft.update.Update;
import clashsoft.cslib.minecraft.update.UpdateFileReader;

public class ModUpdater extends URLUpdater
{
	protected String	name;
	protected String	acronym;
	protected String	version;
	
	public ModUpdater(String name, String acronym, String version, String url)
	{
		this(name, acronym, version, url, UpdateFileReader.instance);
	}
	
	public ModUpdater(String name, String acronym, String version, String url, UpdateFileReader reader)
	{
		super(url, reader);
		this.name = name;
		this.acronym = acronym;
		this.version = version;
		this.url = url;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String getVersion()
	{
		return this.version;
	}
	
	@Override
	public boolean keyMatches(String key)
	{
		if (this.name != null && this.name.matches(key))
		{
			return true;
		}
		if (this.acronym != null && this.acronym.matches(key))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public Update newUpdate(String newVersion, List<String> notes, String updateURL)
	{
		return new Update(this.name, this.version, newVersion, notes, updateURL);
	}

	@Override
	public String toString()
	{
		return "ModUpdater [name=" + this.name + "; acronym=" + this.acronym + "; version=" + this.version + "; url=" + this.url + "; updateFile=" + Arrays.toString(this.updateFile) + "]";
	}
}
