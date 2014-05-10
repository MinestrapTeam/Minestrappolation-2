package clashsoft.cslib.concurrent;

public class ThreadManager
{
	public final String	name;
	public final int	cores;
	private CSThread[]	threads;
	
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
		CSThread thread = this.getLeastOccupiedThread();
		String name = thread.name + ":" + thread.getTaskCount();
		thread.addTask(new Task(name, runnable));
	}
	
	public void addTask(Task task)
	{
		CSThread thread = this.getLeastOccupiedThread();
		thread.addTask(task);
	}
	
	public CSThread getLeastOccupiedThread()
	{
		CSThread[] threads = this.threads;
		int cores = this.cores;
		int min = -1;
		int thread = 0;
		
		for (int i = 0; i < cores; i++)
		{
			CSThread t = threads[i];
			int taskCount = t.getTaskCount();
			if (min == -1)
			{
				min = taskCount;
			}
			else
			{
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
