package clashsoft.cslib.math;

import java.util.Random;

public class CSMath
{
	private static float[]	sinTable	= new float[65536];
	private static int[]	multiplyDeBruijnBitPosition;
	
	static
	{
		for (int i = 0; i < 65536; ++i)
		{
			sinTable[i] = (float) Math.sin(i * 3.141592653589793D * 2.0D / 65536.0D);
		}
		
		multiplyDeBruijnBitPosition = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
	}
	
	public static int abs(int i)
	{
		return i >= 0 ? i : -i;
	}
	
	public static long abs(long l)
	{
		return l >= 0 ? l : -l;
	}
	
	public static float abs(float f)
	{
		return f >= 0.0F ? f : -f;
	}
	
	public static double abs(double d)
	{
		return d >= 0.0D ? d : -d;
	}
	
	public static double abs_max(double d, double max)
	{
		if (d < 0.0D)
		{
			d = -d;
		}
		if (max < 0.0D)
		{
			max = -max;
		}
		return d > max ? d : max;
	}
	
	public static int floor_float(float f)
	{
		int i = (int) f;
		return f < i ? i - 1 : i;
	}
	
	public static int floor_double(double d)
	{
		int i = (int) d;
		return d < i ? i - 1 : i;
	}
	
	public static int ceiling_float(float f)
	{
		int i = (int) f;
		return f > i ? i + 1 : i;
	}
	
	public static int ceiling_double_int(double d)
	{
		int i = (int) d;
		return d > i ? i + 1 : i;
	}
	
	public static float sin(float f)
	{
		return sinTable[(int) (f * 10430.378F) & 0xFFFF];
	}
	
	public static float cos(float f)
	{
		return sinTable[(int) (f * 10430.378F + 16384.0F) & 0xFFFF];
	}
	
	public static float sqrt_float(float f)
	{
		return (float) Math.sqrt(f);
	}
	
	public static float sqrt_double(double d)
	{
		return (float) Math.sqrt(d);
	}
	
	public static int truncateDoubleToInt(double d)
	{
		return (int) (d + 1024.0D) - 1024;
	}
	
	public static int bucketInt(int i, int factor)
	{
		if (i < 0)
		{
			return -((-i - 1) / factor) - 1;
		}
		return i / factor;
	}
	
	public static int clamp_int(int i, int min, int max)
	{
		if (i < min)
		{
			return min;
		}
		if (i > max)
		{
			return max;
		}
		return i;
	}
	
	public static long clamp_long(long l, long min, long max)
	{
		if (l < min)
		{
			return min;
		}
		if (l > max)
		{
			return max;
		}
		return l;
	}
	
	public static float clamp_float(float f, float min, float max)
	{
		if (f < min)
		{
			return min;
		}
		if (f > max)
		{
			return max;
		}
		return f;
	}
	
	public static double clamp_double(double d, double min, double max)
	{
		if (d < min)
		{
			return min;
		}
		if (d > max)
		{
			return max;
		}
		return d;
	}
	
	public static double denormalizeClamp(double min, double max, double d)
	{
		if (d < 0.0D)
		{
			return min;
		}
		if (d > 1.0D)
		{
			return max;
		}
		return min + (max - min) * d;
	}
	
	public static int randomIntClamp(Random rand, int min, int max)
	{
		if (min >= max)
		{
			return min;
		}
		return rand.nextInt(max - min + 1) + min;
	}
	
	public static float randomFloatClamp(Random rand, float min, float max)
	{
		if (min >= max)
		{
			return min;
		}
		return rand.nextFloat() * (max - min) + min;
	}
	
	public static double randomDoubleClamp(Random rand, double min, double max)
	{
		if (min >= max)
		{
			return min;
		}
		return rand.nextDouble() * (max - min) + min;
	}
	
	public static double average(int[] ints)
	{
		int i = 0;
		
		for (int j : ints)
		{
			i += j;
		}
		
		return i / ints.length;
	}
	
	public static double average(long[] longs)
	{
		long l1 = 0L;
		
		for (long l2 : longs)
		{
			l1 += l2;
		}
		
		return l1 / longs.length;
	}
	
	public static double average(float[] doubles)
	{
		float f1 = 0L;
		
		for (float f2 : doubles)
		{
			f1 += f2;
		}
		
		return f1 / doubles.length;
	}
	
	public static double average(double[] doubles)
	{
		double d1 = 0L;
		
		for (double d2 : doubles)
		{
			d1 += d2;
		}
		
		return d1 / doubles.length;
	}
	
	public static float angle_float(float f)
	{
		f %= 360.0F;
		if (f >= 180.0F)
		{
			f -= 360.0F;
		}
		if (f < -180.0F)
		{
			f += 360.0F;
		}
		return f;
	}
	
	public static double angle_double(double d)
	{
		d %= 360.0D;
		if (d >= 180.0D)
		{
			d -= 360.0D;
		}
		if (d < -180.0D)
		{
			d += 360.0D;
		}
		return d;
	}
	
	public static int parseInt(String str, int _default)
	{
		int i = _default;
		try
		{
			i = Integer.parseInt(str);
		}
		catch (Throwable t)
		{
		}
		return i;
	}
	
	public static int parseInt(String str, int _default, int max)
	{
		int i = _default;
		try
		{
			i = Integer.parseInt(str);
		}
		catch (Throwable t)
		{
		}
		if (i < max)
		{
			i = max;
		}
		return i;
	}
	
	public static double parseDoubleWithDefault(String str, double _default)
	{
		double d = _default;
		try
		{
			d = Double.parseDouble(str);
		}
		catch (Throwable t)
		{
		}
		return d;
	}
	
	public static double parseDoubleWithDefaultAndMax(String str, double _default, double max)
	{
		double d = _default;
		try
		{
			d = Double.parseDouble(str);
		}
		catch (Throwable t)
		{
		}
		if (d < max)
		{
			d = max;
		}
		return d;
	}
	
	public static int powerOfTwo(int i)
	{
		int j = i - 1;
		j |= j >> 1;
		j |= j >> 2;
		j |= j >> 4;
		j |= j >> 8;
		j |= j >> 16;
		return j + 1;
	}
	
	public static boolean isPowerOfTwo(int i)
	{
		return (i & -i) != 0;
	}
	
	private static int calculateLogBaseTwoDeBruijn(int i)
	{
		i = isPowerOfTwo(i) ? i : powerOfTwo(i);
		return multiplyDeBruijnBitPosition[(int) (i * 125613361L >> 27) & 0x1F];
	}
	
	public static int calculateLogBaseTwo(int i)
	{
		return calculateLogBaseTwoDeBruijn(i) - (isPowerOfTwo(i) ? 0 : 1);
	}
}
