package clashsoft.cslib.minecraft.update;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.entity.player.EntityPlayer;

/**
 * The class ModUpdate.
 * <p>
 * This class stores mod update data and installs updates.
 * 
 * @author Clashsoft
 */
public class Update
{
	protected String		modName;
	
	protected String		version;
	protected String		newVersion;
	
	protected List<String>	updateNotes;
	protected String		url;
	
	protected int			compare	= -999;
	protected int			installStatus;
	
	public Update(String modName, String version, String newVersion, List<String> updateNotes, String updateUrl)
	{
		this.modName = modName;
		this.version = version;
		this.newVersion = newVersion;
		this.updateNotes = updateNotes;
		this.url = updateUrl;
	}
	
	public void setMod(String name, String version)
	{
		this.modName = name;
		this.version = version;
	}
	
	public int validate()
	{
		if (this.compare == -999 && this.version != null && this.newVersion != null && this.newVersion.startsWith(CSUpdate.CURRENT_VERSION))
		{
			this.compare = CSUpdate.compareVersion(this.version, this.newVersion);
		}
		return this.compare;
	}
	
	public String getModName()
	{
		return this.modName;
	}
	
	public String getVersion()
	{
		return this.version == null ? "" : this.version;
	}
	
	public String getNewVersion()
	{
		return this.newVersion == null ? this.getVersion() : this.newVersion;
	}
	
	public String getName()
	{
		return this.getModName() + " " + this.getNewVersion();
	}
	
	public String getVersionChanges()
	{
		if (this.isValid())
		{
			return this.version + " -> " + this.newVersion;
		}
			return this.version;
	}
	
	public String getUpdateURL()
	{
		return this.url == null ? "[none]" : this.url;
	}
	
	public List<String> getUpdateNotes()
	{
		return this.updateNotes;
	}
	
	public boolean isValid()
	{
		return this.validate() < 0;
	}
	
	public boolean isCurrent()
	{
		return this.validate() == 0;
	}
	
	public boolean hasDownload()
	{
		return this.url != null && !this.url.isEmpty();
	}
	
	private String getFileType()
	{
		if (this.url == null)
		{
			return "zip";
		}
		int i = this.url.lastIndexOf('.');
		return i == -1 ? "zip" : this.url.substring(i + 1);
	}
	
	public String getDownloadedFileName()
	{
		return String.format("%s %s.%s", this.modName, this.newVersion, this.getFileType());
	}
	
	public String getStatus()
	{
		if (!this.isValid())
		{
			return I18n.getString("update.invalid");
		}
		else if (this.installStatus == -1)
		{
			return I18n.getString("update.list.install.error");
		}
		else if (this.installStatus == 0)
		{
			return I18n.getString("update.list.install.notstarted");
		}
		else if (this.installStatus == 1)
		{
			return I18n.getString("update.list.install.installing");
		}
		else if (this.installStatus == 2)
		{
			return I18n.getString("update.list.install.installed");
		}
		return "Unknown";
	}
	
	public void install(EntityPlayer player)
	{
		new InstallUpdateThread(this, player).start();
	}
}
