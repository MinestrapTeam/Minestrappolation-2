package clashsoft.cslib.minecraft.update.updater;

import java.util.Arrays;
import java.util.List;

import clashsoft.cslib.minecraft.update.Update;
import clashsoft.cslib.minecraft.update.UpdateFileReader;
import clashsoft.cslib.minecraft.util.CSWeb;

public class URLUpdater implements IUpdater
{
	protected String		url;
	protected String[]		updateFile;
	public UpdateFileReader	reader;
	
	public URLUpdater(String url)
	{
		this(url, UpdateFileReader.instance);
	}
	
	public URLUpdater(String url, UpdateFileReader reader)
	{
		this.url = url;
		this.reader = reader;
	}
	
	@Override
	public String getName()
	{
		return null;
	}
	
	@Override
	public String getVersion()
	{
		return null;
	}
	
	@Override
	public String getURL()
	{
		return this.url;
	}
	
	@Override
	public boolean keyMatches(String key)
	{
		return true;
	}
	
	@Override
	public Update newUpdate(String newVersion, List<String> notes, String updateURL)
	{
		return new Update(null, null, newVersion, notes, updateURL);
	}
	
	@Override
	public void checkUpdate()
	{
		this.getFileReader().readFile(this, this.getUpdateFile());
	}
	
	@Override
	public IUpdater setUpdateFile(String[] updateFile)
	{
		this.updateFile = updateFile;
		return this;
	}
	
	@Override
	public String[] getUpdateFile()
	{
		if (this.updateFile == null)
		{
			this.updateFile = CSWeb.readWebsite(this.getURL());
		}
		return this.updateFile;
	}
	
	@Override
	public UpdateFileReader getFileReader()
	{
		return this.reader;
	}
	
	@Override
	public String toString()
	{
		return "URLUpdater [url=" + this.getURL() + "; file=" + Arrays.toString(this.getUpdateFile()) + "]";
	}
	
	@Override
	public boolean reCheck()
	{
		return true;
	}
}
