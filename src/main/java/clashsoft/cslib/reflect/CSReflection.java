package clashsoft.cslib.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clashsoft.cslib.util.CSLog;

/**
 * The class CSReflection.
 * <p>
 * This class adds several utils for "hacking" into the JVM, also known as Reflection.
 * 
 * @author Clashsoft
 */
public class CSReflection
{
	// Caller-sensitive
	
	public static Class getCallerClass()
	{
		try
		{
			return Class.forName(getCallerClassName());
		}
		catch (ClassNotFoundException ex)
		{
			CSLog.error(ex);
			return null;
		}
	}
	
	public static String getCallerClassName()
	{
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		String callerClassName = null;
		
		for (int i = 1; i < stElements.length; i++)
		{
			StackTraceElement ste = stElements[i];
			String className = ste.getClassName();
			
			if (!CSReflection.class.getName().equals(className) && !className.startsWith("java.lang.Thread"))
			{
				if (callerClassName == null)
					callerClassName = className;
				else if (!callerClassName.equals(className))
					return ste.getClassName();
			}
		}
		
		return null;
	}
	
	// Methods
	
	public static Method getMethod(Class clazz, String... methodNames)
	{
		Method[] methods = clazz.getDeclaredMethods();
		for (String methodName : methodNames)
		{
			for (int i = 0; i < methods.length; i++)
			{
				Method method = methods[i];
				if (methodName.equals(method.getName()))
					return method;
			}
		}
		CSLog.error(new NoSuchFieldException("Field not found! (Class: " + clazz + "; Expected field names: " + Arrays.toString(methodNames)));
		return null;
	}
	
	// Method invocation
	
	public static <T, R> R invokeStatic(Class<? super T> clazz, Object[] args, String... methodNames)
	{
		return invoke(clazz, null, args, methodNames);
	}
	
	public static <T, R> R invoke(T instance, Object[] args, String... methodNames)
	{
		return invoke((Class<T>) instance.getClass(), instance, args, methodNames);
	}
	
	public static <T, R> R invoke(Class<? super T> clazz, T instance, Object[] args, String... methodNames)
	{
		try
		{
			Method m = getMethod(clazz, methodNames);
			m.setAccessible(true);
			return (R) m.invoke(instance, args);
		}
		catch (Exception ex)
		{
			CSLog.error(ex);
			return null;
		}
	}
	
	// Fields
	
	public static <T> T[] getStaticObjects(Class clazz, Class<T> fieldType, boolean subtypes)
	{
		return getObjects(clazz, null, fieldType, subtypes);
	}
	
	public static <T> T[] getObjects(Class clazz, Object instance, Class<T> fieldType, boolean subtypes)
	{
		List list = new ArrayList();
		Field[] fields = clazz.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++)
		{
			try
			{
				Field field = fields[i];
				Class c = field.getType();
				Object o = field.get(instance);
				if (c == fieldType || (subtypes && fieldType.isAssignableFrom(c)))
				{
					list.add(o);
				}
			}
			catch (Exception ex)
			{
			}
		}
		
		return (T[]) list.toArray();
	}
	
	public static Field getField(Class clazz, String... fieldNames) throws NoSuchFieldException
	{
		Field[] fields = clazz.getDeclaredFields();
		for (String fieldName : fieldNames)
		{
			for (int i = 0; i < fields.length; i++)
			{
				Field field = fields[i];
				if (fieldName.equals(field.getName()))
					return field;
			}
		}
		CSLog.error(new NoSuchFieldException("Field not found! (Class: " + clazz + "; Expected field names: " + Arrays.toString(fieldNames)));
		return null;
	}
	
	public static int getFieldID(Class clazz, String... fieldNames) throws NoSuchFieldException
	{
		Field[] fields = clazz.getDeclaredFields();
		for (String fieldName : fieldNames)
		{
			for (int i = 0; i < fields.length; i++)
			{
				Field field = fields[i];
				if (fieldName.equals(field.getName()))
					return i;
			}
		}
		CSLog.error(new NoSuchFieldException("Field not found! (Class: " + clazz + "; Expected field names: " + Arrays.toString(fieldNames)));
		return -1;
	}
	
	public static String getFieldName(Class clazz, int fieldID)
	{
		return getField(clazz, fieldID).getName();
	}
	
	public static Field getField(Class clazz, int fieldID)
	{
		return clazz.getDeclaredFields()[fieldID];
	}
	
	// Field getters
	
	public static <T, R> R getStaticValue(Class<? super T> clazz, String... fieldNames)
	{
		return getValue(clazz, null, fieldNames);
	}
	
	public static <T, R> R getValue(T instance, String... fieldNames)
	{
		return getValue((Class<T>) instance.getClass(), instance, fieldNames);
	}
	
	public static <T, R> R getValue(Class<? super T> clazz, T instance, String... fieldNames)
	{
		try
		{
			Field f = getField(clazz, fieldNames);
			f.setAccessible(true);
			return (R) f.get(instance);
		}
		catch (Exception ex)
		{
			CSLog.error(ex);
			return null;
		}
	}
	
	public static <T, R> R getStaticValue(Class<? super T> clazz, int fieldID)
	{
		return getValue(clazz, null, fieldID);
	}
	
	public static <T, R> R getValue(T instance, int fieldID)
	{
		return getValue((Class<? super T>) instance.getClass(), instance, fieldID);
	}
	
	public static <T, R> R getValue(Class<? super T> clazz, T instance, int fieldID)
	{
		try
		{
			Field f = getField(clazz, fieldID);
			f.setAccessible(true);
			return (R) f.get(instance);
		}
		catch (Exception ex)
		{
			CSLog.error(ex);
			return null;
		}
	}
	
	// Field setters
	
	public static <T, V> void setStaticValue(Class<? super T> clazz, V value, String... fieldNames)
	{
		setValue(clazz, null, value, fieldNames);
	}
	
	public static <T, V> void setValue(T instance, V value, String... fieldNames)
	{
		setValue((Class<? super T>) instance.getClass(), instance, value, fieldNames);
	}
	
	public static <T, V> void setValue(Class<? super T> clazz, T instance, V value, String... fieldNames)
	{
		try
		{
			Field f = getField(clazz, fieldNames);
			f.setAccessible(true);
			f.set(instance, value);
		}
		catch (Exception ex)
		{
			CSLog.error(ex);
		}
	}
	
	public static <T, V> void setStaticValue(Class<? super T> clazz, V value, int fieldID)
	{
		setValue(clazz, null, value, fieldID);
	}
	
	public static <T, V> void setValue(T instance, V value, int fieldID)
	{
		setValue((Class<? super T>) instance.getClass(), instance, value, fieldID);
	}
	
	public static <T, V> void setValue(Class<? super T> clazz, T instance, V value, int fieldID)
	{
		try
		{
			Field f = getField(clazz, fieldID);
			f.setAccessible(true);
			f.set(instance, value);
		}
		catch (Exception ex)
		{
			CSLog.error(ex);
		}
	}
	
	// Instances
	
	/**
	 * Creates a new instance of T using the parameters.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param c
	 *            the c
	 * @param parameters
	 *            the parameters
	 * @return the t
	 * @see ImmutableObjectFactory#createObject(Class, Object...)
	 */
	public static <T> T createInstance(Class<T> c, Object... parameters)
	{
		Class[] parameterTypes = new Class[parameters.length];
		for (int i = 0; i < parameters.length; i++)
		{
			if (parameters[i] != null)
				parameterTypes[i] = parameters[i].getClass();
		}
		
		try
		{
			Constructor<T> constructor = c.getConstructor(parameterTypes);
			return constructor.newInstance(parameters);
		}
		catch (Exception ex)
		{
			return null;
		}
	}
}
