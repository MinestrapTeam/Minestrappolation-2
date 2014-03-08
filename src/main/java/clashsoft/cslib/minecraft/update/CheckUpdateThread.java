package clashsoft.cslib.minecraft.update;

import clashsoft.cslib.minecraft.util.CSWeb;

public class CheckUpdateThread extends Thread
{
	public String	modName;
	public String	acronym;
	public String	version;
	
	public String	updateURL;
	public String[]	updateFile;
	
	protected CheckUpdateThread(String modName, String acronym, String version)
	{
		this.setName("UpdateChecker-" + modName);
		
		this.modName = modName;
		this.acronym = acronym;
		this.version = version;
	}
	
	public CheckUpdateThread(String modName, String acronym, String version, String[] updateFile)
	{
		this(modName, acronym, version);
		this.updateFile = updateFile;
	}
	
	public CheckUpdateThread(String modName, String acronym, String version, String url)
	{
		this(modName, acronym, version);
		this.updateURL = url;
	}
	
	@Override
	public void run()
	{
		ModUpdate update = CSUpdate.getUpdate(this.modName, this.version);
		if (update != null)
		{
			return;
		}
		
		if (this.updateFile == null)
		{
			this.updateFile = CSWeb.readWebsite(this.updateURL);
		}
		
		CSUpdate.getUpdate(this.modName, this.acronym, this.version, this.updateFile);
	}
}