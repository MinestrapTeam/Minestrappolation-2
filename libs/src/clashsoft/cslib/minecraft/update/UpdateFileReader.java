package clashsoft.cslib.minecraft.update;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import clashsoft.cslib.minecraft.update.updater.IUpdater;

public class UpdateFileReader
{
	public static final UpdateFileReader	instance	= new UpdateFileReader();
	
	public void readFile(IUpdater updater, String[] lines)
	{
		for (String line : lines)
		{
			Update update = this.readLine(line, updater);
			if (update != null)
			{
				CSUpdate.addUpdate(update);
			}
		}
	}
	
	public Update readLine(String line, IUpdater updater)
	{
		int i0 = line.indexOf(':');
		int i1 = line.indexOf('=');
		int i2 = line.lastIndexOf('@');
		
		if (i0 == -1)
		{
			return null;
		}
		
		String key = line.substring(0, i0);
		
		if (updater.keyMatches(key))
		{
			String newVersion = line.substring(i0 + 1, i1);
			String updateNotes = null;
			String updateUrl = null;
			if (i1 != -1)
			{
				updateNotes = line.substring(i1 + 1, i2 == -1 ? line.length() : i2);
			}
			if (i2 != -1)
			{
				updateUrl = line.substring(i2 + 1);
			}
			List<String> notes = updateNotes == null ? Collections.EMPTY_LIST : Arrays.asList(updateNotes.split("\\\\n|\\n|\n"));
			
			return updater.newUpdate(newVersion, notes, updateUrl);
		}
		return null;
	}
}
