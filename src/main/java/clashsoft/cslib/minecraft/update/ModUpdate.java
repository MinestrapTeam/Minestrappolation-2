package clashsoft.cslib.minecraft.update;

import java.util.Collections;
import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.util.CSArrays;

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
	private String			modName;
	
	private String			version;
	private String			newVersion;
	
	private List<String>	updateNotes;
	private String			url;
	
	private boolean			valid;
	protected int				installStatus;
	
	public ModUpdate(String modName, String version, String newVersion, String updateNotes, String updateUrl)
	{
		this(modName, version, newVersion, CSArrays.asList(updateNotes.split("\\\\n|\\n|\n")), updateUrl);
	}
	
	public ModUpdate(String modName, String version, String newVersion, List<String> updateNotes, String updateUrl)
	{
		this.setMod(modName, version);
		this.newVersion = newVersion;
		this.updateNotes = updateNotes;
		this.url = updateUrl;
		this.validate();
	}
	
	public void setMod(String name, String version)
	{
		this.modName = name;
		this.version = version;
	}
	
	public void validate()
	{
		this.valid = newVersion.startsWith(CSUpdate.CURRENT_VERSION) && CSUpdate.compareVersion(version, newVersion) == -1;
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
	
	public List<String> getUpdateNotes()
	{
		return this.updateNotes == null ? Collections.EMPTY_LIST : this.updateNotes;
	}
	
	public boolean isValid()
	{
		return this.valid;
	}
	
	public boolean hasDownload()
	{
		return this.url != null && !this.url.isEmpty();
	}
	
	public String getDownloadedFileName()
	{
		int i = this.url.lastIndexOf('/');
		String url = i == -1 ? this.url : this.url.substring(i);
		return url.replace('+', ' ');
	}
	
	public String getStatus()
	{
		if (installStatus == -1)
		{
			return I18n.getString("update.list.install.error");
		}
		else if (installStatus == 0)
		{
			return I18n.getString("update.list.install.notstarted");
		}
		else if (installStatus == 1)
		{
			return I18n.getString("update.list.install.installing");
		}
		else if (installStatus == 2)
		{
			return I18n.getString("update.list.install.installed");
		}
		return "Unknown";
	}
	
	public void install(EntityPlayer player)
	{
		new InstallUpdateThread(this, player).start();
	}
	
	public void combine(ModUpdate update2)
	{
		this.modName = this.modName == null ? update2.modName : this.modName;
		this.version = this.version == null ? update2.version : this.version;
		this.newVersion = this.newVersion == null ? update2.newVersion : this.newVersion;
		this.url = this.url == null ? update2.url : this.url;
		this.installStatus = Math.max(this.installStatus, update2.installStatus);
		this.validate();
	}
}
