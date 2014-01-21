package clashsoft.cslib.util;

/**
 * The Class CSVar.
 * This class a wrapper class for variables, it stores their in-code name, their current value and their previous value.
 * 
 * @param <T>
 *            the generic variable type
 */
public class CSVar<T>
{
	/** The in-code name. */
	public final String	name;
	
	/** The value. */
	public T			value;
	
	/** The previous value. */
	public T			prevValue;
	
	/**
	 * Instantiates a new Clashsoft variable.
	 * 
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	public CSVar(String name, T value)
	{
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Sets the new value and sets the previous value.
	 * 
	 * @param value
	 *            the value
	 */
	public void set(T value)
	{
		this.prevValue = this.value;
		this.value = value;
	}
	
	/**
	 * Sets the current value to the previous value.
	 */
	public void unset()
	{
		this.value = this.prevValue;
		this.prevValue = null;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public T get()
	{
		return this.value;
	}
	
	/**
	 * Gets the previous value.
	 * 
	 * @return the previous value
	 */
	public T getPrevious()
	{
		return this.prevValue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.prevValue == null) ? 0 : this.prevValue.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		CSVar other = (CSVar) obj;
		if (this.prevValue == null)
		{
			if (other.prevValue != null)
				return false;
		}
		else if (!this.prevValue.equals(other.prevValue))
			return false;
		if (this.name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!this.name.equals(other.name))
			return false;
		if (this.value == null)
		{
			if (other.value != null)
				return false;
		}
		else if (!this.value.equals(other.value))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return this.name + "=" + this.value + (prevValue != null ? "{" + prevValue + "}" : "");
	}
}
