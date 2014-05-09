package clashsoft.cslib.minecraft.update;

import clashsoft.cslib.minecraft.update.updater.IUpdater;
import clashsoft.cslib.util.CSLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;

public class CheckUpdateThread extends Thread
{
	public IUpdater updater;
	public String modName;
	public String version;
	
	public CheckUpdateThread(IUpdater updater)
	{
		this.modName = updater.getName();
		this.version = updater.getVersion();
	}
	
	@Override
	public void run()
	{
		if (!Loader.instance().hasReachedState(LoaderState.INITIALIZATION))
		{
			CSLog.warning("The mod " + this.modName + " is attempting to check for updates, but it hasn't reached the init-state yet.");
		}
		
		Update update = CSUpdate.getUpdate(this.modName);
		if (update != null)
		{
			// Sync mod name and version
			update.modName = this.modName;
			update.version = this.version;
			return;
		}
		
		this.updater.checkUpdate();
	}
}