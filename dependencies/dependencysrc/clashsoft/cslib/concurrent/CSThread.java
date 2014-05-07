package clashsoft.cslib.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import clashsoft.cslib.util.CSLog;

public class CSThread extends Thread
{
	public static boolean		DEBUG		= true;
	
	public final String			name;
	
	private List<Task>			tasks		= new ArrayList();
	private ListIterator<Task>	iterator	= this.tasks.listIterator();
	
	public CSThread(String name)
	{
		this.name = name;
		this.setName(name);
	}
	
	@Override
	public void run()
	{
		this.info("Starting Thread " + this.name);
		
		while (this.iterator.hasNext())
		{
			Task task = this.iterator.next();
			this.info("  Starting Task " + task.name);
			task.run();
			this.info("  Finished Task " + task.name);
			this.iterator.remove();
		}
		
		this.info("Finished Thread " + this.name);
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
		this.iterator.add(task);
		
		if (!this.isAlive())
		{
			this.start();
		}
	}
	
	public int getTaskCount()
	{
		return this.tasks.size();
	}
}
