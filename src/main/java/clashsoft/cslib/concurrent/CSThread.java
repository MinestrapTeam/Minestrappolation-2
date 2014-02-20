package clashsoft.cslib.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import clashsoft.cslib.util.CSLog;

public class CSThread extends Thread
{
	public static boolean DEBUG = true;
	
	public final String name;
	
	private List<Task>			tasks		= new ArrayList();
	private ListIterator<Task>	iterator	= tasks.listIterator();
	
	public CSThread(String name)
	{
		this.name = name;
		this.setName(name);
	}
	
	@Override
	public void run()
	{
		info("Starting Thread " + this.name);
		
		while (iterator.hasNext())
		{
			Task task = iterator.next();
			info("  Starting Task " + task.name);
			task.run();
			info("  Finished Task " + task.name);
			iterator.remove();
		}
		
		info("Finished Thread " + this.name);
	}
	
	public void info(String string)
	{
		if (DEBUG)
		{
			CSLog.info(string);
		}
	}
	
	public void addTask(Task task)
	{
		iterator.add(task);
	}
	
	public int getTaskCount()
	{
		return tasks.size();
	}
}
