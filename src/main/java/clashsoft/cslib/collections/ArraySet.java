package clashsoft.cslib.collections;

import java.util.*;

import clashsoft.cslib.util.CSArrays;

public class ArraySet<E> extends AbstractSet<E>
{
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	private Object[]	entries;
	
	private int			initialCapacity;
	private int			size			= 0;
	
	private int			currentIndex	= 0;
	

	private transient Object[]	toArray;
	
	public ArraySet()
	{
		this(16);
	}
	
	public ArraySet(int capacity)
	{
		this.initialCapacity = capacity;
		this.entries = new Object[capacity];
	}
	
	@Override
	public int size()
	{
		return size;
	}
	
	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	@Override
	public boolean contains(Object o)
	{
		return CSArrays.contains(entries, o);
	}
	
	@Override
	public Iterator<E> iterator()
	{
		return new ArraySetIterator();
	}
	
	public class ArraySetIterator implements Iterator
	{
		int	currentIndex	= 0;
		
		@Override
		public boolean hasNext()
		{
			return currentIndex < size;
		}
		
		@Override
		public E next()
		{
			E e = (E) entries[currentIndex];
			currentIndex++;
			return e;
		}
		
		@Override
		public void remove()
		{
			ArraySet.this.remove(entries[currentIndex]);
		}
	}
	
	@Override
	public Object[] toArray()
	{
		if (toArray != null)
			return toArray;
		else
		{
			Object[] o = new Object[this.size];
			for (int i = 0, i0 = 0; i < entries.length; i++)
				if (entries[i] != null)
				{
					o[i0] = entries[i];
					i0++;
				}
			Arrays.sort(o);
			return toArray = o;
		}
	}
	
	@Override
	public <T> T[] toArray(T[] a)
	{
		for (int i = 0; i < size; i++)
		{
			a[i] = (T) entries[i];
		}
		return a;
	}
	
	@Override
	public boolean add(E e)
	{
		if (e != null && !contains(e))
		{
			ensureCapacity(++size);
			
			currentIndex = nextIndex();
			entries[currentIndex] = e;
			onChanged();
			return true;
		}
		return false;
	}
	
	protected void onChanged()
	{
		this.toArray = null;
	}
	
	protected void ensureCapacity(int minCapacity)
	{
		if (minCapacity - this.entries.length > 0)
		{
			int oldCapacity = entries.length;
	        int newCapacity = oldCapacity + (oldCapacity >> 1);
	        if (newCapacity - minCapacity < 0)
	            newCapacity = initialCapacity;
	        if (newCapacity - MAX_ARRAY_SIZE > 0)
	            newCapacity = hugeCapacity(minCapacity);
	        this.entries = Arrays.copyOf(entries, newCapacity);
		}
	}
	
	private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
	
	protected int nextIndex()
	{
		for (int i = 0; i < entries.length; i++)
			if (entries[i] == null)
				return i;
		return currentIndex++;
	}
	
	@Override
	public boolean remove(Object o)
	{
		int index = CSArrays.indexOf(entries, o);
		if (index != -1)
		{
			entries[index] = null;
			currentIndex = index;
			--size;
			onChanged();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean containsAll(Collection<?> c)
	{
		for (Object object : c)
			if (!CSArrays.contains(entries, object))
				return false;
		return true;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		boolean value = false;
		for (E e : c)
			if (add(e))
				value = true;
		return value;
	}
	
	@Override
	public boolean retainAll(Collection<?> c)
	{
		Iterator iterator = c.iterator();
		Object entry = null;
		
		while (iterator.hasNext())
		{
			entry = iterator.next();
			if (!contains(entry))
				this.remove(entry);
		}
		
		return false;
	}
	
	@Override
	public boolean removeAll(Collection<?> c)
	{
		boolean value = false;
		for (Object o : c)
			if (remove(o))
				value = true;
		return value;
	}
	
	@Override
	public void clear()
	{
		this.size = 0;
		this.entries = new Object[initialCapacity];
		this.onChanged();
	}
}
