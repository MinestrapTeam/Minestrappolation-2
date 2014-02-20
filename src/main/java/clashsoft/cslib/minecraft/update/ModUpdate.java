package clashsoft.cslib.minecraft.update;

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
	public String		modName;
	
	public String		version;
	public String		newVersion;
	
	public List<String>	updateNotes;
	public String		updateUrl;
	
	protected boolean	valid;
	protected int		installStatus;
	
	public ModUpdate(String modName, String version, String newVersion, String updateNotes, String updateUrl)
	{
		this(modName, version, newVersion, CSArrays.asList(updateNotes.split("\\\\n|\\n|\n")), updateUrl);
	}
	
	public ModUpdate(String modName, String version, String newVersion, List<String> updateNotes, String updateUrl)
	{
		this.modName = modName;
		this.version = version;
		this.newVersion = newVersion;
		this.updateNotes = updateNotes;
		this.updateUrl = updateUrl;
		this.validate();
	}
	
	public void validate()
	{
		this.valid = newVersion.startsWith(CSUpdate.CURRENT_VERSION) && CSUpdate.compareVersion(version, newVersion) == -1;
	}
	
	public String getName()
	{
		return this.modName + " " + this.version;
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
	
	public boolean isValid()
	{
		return this.valid;
	}
	
	public boolean hasDownload()
	{
		return this.updateUrl != null && !this.updateUrl.isEmpty();
	}
	
	public String getDownloadedFileName()
	{
		int i = this.updateUrl.lastIndexOf('/');
		String url = i == -1 ? this.updateUrl : this.updateUrl.substring(i);
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
		this.updateUrl = this.updateUrl == null ? update2.updateUrl : this.updateUrl;
		this.installStatus = Math.max(this.installStatus, update2.installStatus);
		this.validate();
	}
}
