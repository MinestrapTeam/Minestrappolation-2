package clashsoft.cslib.concurrent;

public class Task implements Runnable
{
	public String			name;
	public final Runnable	runnable;
	
	public Task(String name, Runnable runnable)
	{
		this.name = name;
		this.runnable = runnable;
	}
	
	@Override
	public void run()
	{
		this.runnable.run();
	}
}
