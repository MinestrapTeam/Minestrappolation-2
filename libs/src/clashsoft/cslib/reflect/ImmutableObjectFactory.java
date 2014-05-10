package clashsoft.cslib.reflect;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * A factory for creating immutable objects.
 * <p>
 * If an object with the same class and the same constructor arguments is
 * stored, the stored one will be returned and no new object will be created.
 * 
 * @author Clashsoft
 */
public class ImmutableObjectFactory
{
	/** The objects. */
	public static Map<Class, Map<Object[], Object>>	objects	= new HashMap<Class, Map<Object[], Object>>();
	
	/**
	 * Creates a new immutable object. If an object with the same class and the
	 * same constructor arguments is stored, the stored one will be returned and
	 * no new object will be created.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            the class
	 * @param args
	 *            the arguments
	 * @return the type
	 */
	public static <T> T createObject(Class<T> clazz, Object... args)
	{
		Class[] classes = new Class[args.length];
		for (int i = 0; i < args.length; i++)
		{
			if (args[i] != null)
			{
				classes[i] = args[i].getClass();
			}
			else
			{
				classes[i] = Object.class;
			}
		}
		return createObject(clazz, classes, args);
	}
	
	/**
	 * Creates a new immutable object. If an object with the same class and the
	 * same constructor arguments is stored, the stored one will be returned and
	 * no new object will be created.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            the class
	 * @param argsTypes
	 *            the argument types
	 * @param args
	 *            the arguments
	 * @return the t
	 */
	public static <T> T createObject(Class<T> clazz, Class[] argsTypes, Object... args)
	{
		Map<Object[], Object> map = objects.get(clazz);
		if (map != null)
		{
			Object obj = map.get(args);
			if (obj != null)
			{
				return cast(clazz, obj);
			}
		}
		else
		{
			try
			{
				Constructor c = clazz.getConstructor(argsTypes);
				Object obj = c.newInstance(args);
				addToMap(clazz, args, obj);
				return cast(clazz, obj);
			}
			catch (Exception ex)
			{
			}
		}
		return null;
	}
	
	/**
	 * Casts an object to the class
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            the class
	 * @param object
	 *            the object
	 * @return the t
	 */
	public static <T> T cast(Class<T> clazz, Object object)
	{
		return (T) object;
	}
	
	/**
	 * Checks if the class is immutable, throws an exception if not.
	 * 
	 * @param clazz
	 *            the class
	 */
	public static final void checkImmutable(Class clazz)
	{
		if (!isImmutable(clazz))
		{
			throw new IllegalArgumentException(clazz + " is not immutable! Sign with @Immutable annotation");
		}
	}
	
	/**
	 * Checks if the class is immutable
	 * 
	 * @param clazz
	 *            the class
	 * @return true, if is immutable
	 */
	public static boolean isImmutable(Class clazz)
	{
		if (clazz == null)
		{
			return false;
		}
		if (clazz.isPrimitive())
		{
			return true;
		}
		if (clazz.isAssignableFrom(Number.class) || clazz.isAssignableFrom(String.class))
		{
			return true;
		}
		if (clazz.isAnnotationPresent(Immutable.class))
		{
			return true;
		}
		if (clazz.getSimpleName().toLowerCase().startsWith("immutable"))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Adds the construction to the map.
	 * 
	 * @param clazz
	 *            the class
	 * @param args
	 *            the args
	 * @param object
	 *            the object
	 */
	public static void addToMap(Class clazz, Object[] args, Object object)
	{
		Map<Object[], Object> map = objects.get(clazz);
		if (map == null)
		{
			map = new HashMap();
		}
		map.put(args, object);
		objects.put(clazz, map);
	}
}
