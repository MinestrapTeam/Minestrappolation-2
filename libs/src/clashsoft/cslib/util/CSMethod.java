package clashsoft.cslib.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * The class CSMethod.
 * <p>
 * Use this class for providing optional arguments.
 * 
 * @author Clashsoft
 * @param <R>
 *            the return type of this class
 */
public abstract class CSMethod<R> implements Callable
{
	/** Stores arguments **/
	private Map<String, Object>	args	= new HashMap<String, Object>();
	
	/**
	 * Constructor for separated key/value-sets.
	 * 
	 * @param argvalues
	 *            the argument values
	 * @param argkeys
	 *            the argument key names
	 */
	public CSMethod(String[] argkeys, Object[] argvalues)
	{
		if (argvalues.length != argkeys.length)
		{
			throw new IllegalArgumentException("Name and value array must be of same size!");
		}
		
		for (int i = 0; i < argkeys.length; i++)
		{
			this.args.put(argkeys[i], argvalues[i]);
		}
	}
	
	/**
	 * Constructor for key/value-sets in the same array. Every second object
	 * should be the value.
	 * 
	 * @param args
	 *            the arguments
	 */
	public CSMethod(Object... args)
	{
		String name = "";
		for (int i = 0; i < args.length; i++)
		{
			if ((i & 1) == 0 && args[i] instanceof String)
			{
				name = (String) args[i];
			}
			else
			{
				this.args.put(name, args[i]);
			}
		}
	}
	
	/**
	 * Sets argument {@code key} to {@code value}
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 * @return the old value
	 */
	public <T> T setArg(String key, T value)
	{
		return (T) this.args.put(key, value);
	}
	
	/**
	 * Removes argument {@code key}
	 * 
	 * @param key
	 *            the key
	 * @return the old value
	 */
	public <T> T removeArg(String key)
	{
		return (T) this.args.remove(key);
	}
	
	/**
	 * Returns the value of the argument {@code key}
	 * 
	 * @param key
	 *            the key
	 * @return the value
	 */
	public <T> T getArg(String key)
	{
		return (T) this.args.get(key);
	}
	
	@Override
	public final R call()
	{
		return this.run();
	}
	
	/**
	 * Runs this method.
	 * 
	 * @return the return
	 */
	public abstract R run();
}
