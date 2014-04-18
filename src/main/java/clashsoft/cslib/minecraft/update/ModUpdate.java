package clashsoft.cslib.minecraft.update;

import clashsoft.cslib.minecraft.lang.I18n;

import net.minecraft.entity.player.EntityPlayer;

/**
 * The class ModUpdate.
 * <p>
 * This class stores mod update data and installs updates.
 * 
 * @author Clashsoft
 */
public class ModUpdate
{
	protected String	modName;
	
	protected String	version;
	protected String	newVersion;
	
	protected String[]	updateNotes;
	protected String	url;
	
	protected Boolean	valid;
	protected int		installStatus;
	
	public ModUpdate(String modName, String version, String newVersion, String updateNotes, String updateUrl)
	{
		this(modName, version, newVersion, updateNotes == null ? null : updateNotes.split("\\\\n|\\n|\n"), updateUrl);
	}
	
	public ModUpdate(String modName, String version, String newVersion, String[] updateNotes, String updateUrl)
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
	
	public boolean validate()
	{
		boolean b = this.version != null && this.newVersion != null && this.newVersion.startsWith(CSUpdate.CURRENT_VERSION) && CSUpdate.compareVersion(this.version, this.newVersion) < 0;
		this.valid = Boolean.valueOf(b);
		return b;
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
		else
		{
			return this.version;
		}
	}
	
	public String getUpdateURL()
	{
		return this.url == null ? "[none]" : this.url;
	}
	
	public String[] getUpdateNotes()
	{
		return this.updateNotes;
	}
	
	public boolean isValid()
	{
		if (this.valid == null)
		{
			return this.validate();
		}
		return this.valid.booleanValue();
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
