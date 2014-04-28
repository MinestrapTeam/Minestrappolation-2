package clashsoft.cslib.minecraft.update;

import clashsoft.cslib.util.CSLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;

public class CheckUpdateThread extends Thread
{
	public String	modName;
	public String	acronym;
	public String	version;
	public String	updateURL;
	public String[]	updateFile;
	
	private CheckUpdateThread(String modName, String acronym, String version)
	{
		this.modName = modName;
		this.acronym = acronym;
		this.version = version;
	}
	
	public CheckUpdateThread(String updateURL)
	{
		this.updateURL = updateURL;
	}
	
	public CheckUpdateThread(String[] updateFile)
	{
		this.updateFile = updateFile;
	}
	
	public CheckUpdateThread(String modName, String acronym, String version, String updateURL)
	{
		this(modName, acronym, version);
		this.updateURL = updateURL;
	}
	
	public CheckUpdateThread(String modName, String acronym, String version, String[] updateFile)
	{
		this(modName, acronym, version);
		this.updateFile = updateFile;
	}
	
	@Override
	public void run()
	{
		if (!Loader.instance().hasReachedState(LoaderState.INITIALIZATION))
		{
			CSLog.warning("The mod " + this.modName + " is attempting to check for updates, but it hasn't reached the init-state yet.");
		}
		
		ModUpdate update = CSUpdate.getUpdate(this.modName, this.acronym);
		if (update != null)
		{
			// Sync mod name and version
			update.modName = this.modName;
			update.version = this.version;
			return;
		}
		
		if (this.updateFile == null)
		{
			this.updateFile = CSUpdate.getUpdateFile(this.updateURL);
		}
		
		for (String line : this.updateFile)
		{
			update = CSUpdate.readUpdateLine(line, this.modName, this.acronym, this.version);
			CSUpdate.addUpdate(update);
		}
	}
}