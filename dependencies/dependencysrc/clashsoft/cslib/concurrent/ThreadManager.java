package clashsoft.cslib.concurrent;

public class ThreadManager
{
	public final String name;
	public final int cores;
	private CSThread[] threads;
	
	public ThreadManager(String name)
	{
		this(name, Runtime.getRuntime().availableProcessors());
	}
	
	public ThreadManager(String name, int cores)
	{
		this.name = name;
		this.cores = cores;
		this.threads = new CSThread[cores];
		
		for (int i = 0; i < cores; i++)
		{
			this.threads[i] = new CSThread(name + "-" + i);
		}
	}
	
	public void addTask(Runnable runnable)
	{
		CSThread thread = getLeastOccupiedThread();
		String name = thread.name + ":" + thread.getTaskCount();
		thread.addTask(new Task(name, runnable));
	}
	
	public void addTask(Task task)
	{
		CSThread thread = getLeastOccupiedThread();
		thread.addTask(task);
	}
	
	public CSThread getLeastOccupiedThread()
	{
		CSThread[] threads = this.threads;
		int min = 0;
		int thread = 0;
		
		for (int i = 0; i < this.cores; i++)
		{
			CSThread t = threads[i];
			if (min == 0)
			{
				return t;
			}
			else
			{
				int taskCount = t.getTaskCount();
				if (taskCount < min)
				{
					min = taskCount;
					thread = i;
				}
			}
		}
		
		return threads[thread];
	}
}
