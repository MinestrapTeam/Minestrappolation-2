package clashsoft.cslib.collections;

import java.util.LinkedList;
import java.util.Map;

public class LinkedListMap<K, V> extends AbstractListMap<K, V>
{	
	public LinkedListMap()
	{
		this.entries = new LinkedList();
	}
	
	public LinkedListMap(Map<? extends K, ? extends V> m)
	{
		this();
		putAll(m);
	}
}
