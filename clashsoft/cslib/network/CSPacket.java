package clashsoft.cslib.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * The class CSPacket.
 * <p>
 * This class adds several {@link Packet} utils.
 * 
 * @author Clashsoft
 * @deprecated Not yet implemented
 */
public class CSPacket
{
	public static class Entry<E>
	{
		public String name;
		public E value;
		public Class type;
		
		public Entry(String name, E value)
		{
			this(name, value, value.getClass());
		}
		
		public Entry(String name, E value, Class type)
		{
			this.name = name;
			this.value = value;
			this.type = type;
		}
	}
	
	public Map<String, Entry> objects = new HashMap<String, Entry>();
	
	public void put(String id, Object value)
	{
		objects.put(id, new Entry(id, value));
	}
	
	
	
	public void write(Packet250CustomPayload packet)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(objects.size() * 16);
		DataOutputStream dos = new DataOutputStream(bos);
		
		for (Entry e : objects.values())
		{
			// Do stuff
		}
	}
}
