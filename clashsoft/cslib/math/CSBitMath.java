package clashsoft.cslib.math;

import java.util.Arrays;

public class CSBitMath
{
	public static boolean[]	MINUS_ONE_BITS	= CSBits.getBits(-1L);
	public static boolean[]	ZERO_BITS		= CSBits.getBits(0L);
	public static boolean[]	ONE_BITS		= CSBits.getBits(1L);
	
	public static boolean[] not(boolean[] bits)
	{
		boolean[] b = new boolean[bits.length];
		return not_(bits, b);
	}
	
	public static boolean[] negative(boolean[] bits)
	{
		boolean[] b = new boolean[bits.length];
		return negative_(bits, b);
	}
	
	public static boolean[] bitshiftLeft(boolean[] bits, int n)
	{
		boolean[] b = new boolean[bits.length];
		return bitshift_left_(bits, b, n);
	}
	
	public static boolean[] bitshiftRight(boolean[] bits, int n)
	{
		boolean[] b = new boolean[bits.length];
		return bitshift_right_(bits, b, n, true);
	}
	
	public static boolean[] bitshiftRightUnsigned(boolean[] bits, int n)
	{
		boolean[] b = new boolean[bits.length];
		return bitshift_right_(bits, b, n, false);
	}
	
	public static boolean[] add(boolean[] bits1, boolean[] bits2)
	{
		// Pad them to same length
		int len = bits1.length > bits2.length ? bits1.length : bits2.length;
		bits1 = Arrays.copyOf(bits1, len);
		bits2 = Arrays.copyOf(bits2, len);
		
		// Prevent overflow, make the results bigger
		boolean[] b = new boolean[len + 1];
		return add_(bits1, bits2, b);
	}
	
	public static boolean[] substract(boolean[] bits1, boolean[] bits2)
	{
		// Pad them to same length
		int len = bits1.length > bits2.length ? bits1.length : bits2.length;
		bits1 = Arrays.copyOf(bits1, len);
		bits2 = Arrays.copyOf(bits2, len);
		
		// Prevent overflow, make the results bigger
		boolean[] b = new boolean[len + 1];
		return substract_(bits1, bits1, b);
	}
	
	public static boolean[] multiply(boolean[] bits1, boolean[] bits2)
	{
		// Pad them to same length
		int len = bits1.length > bits2.length ? bits1.length : bits2.length;
		bits1 = Arrays.copyOf(bits1, len);
		bits2 = Arrays.copyOf(bits2, len);
		
		// Prevent overflow, make the results bigger
		boolean[] b = new boolean[len + 1];
		return multiply_(bits1, bits2, b);
	}
	
	public static boolean[] and(boolean[] bits1, boolean[] bits2)
	{
		// Pad them to same length
		int len = bits1.length > bits2.length ? bits1.length : bits2.length;
		bits1 = Arrays.copyOf(bits1, len);
		bits2 = Arrays.copyOf(bits2, len);
		
		// Prevent overflow, make the results bigger
		boolean[] b = new boolean[len + 1];
		return and_(bits1, bits2, b);
	}
	
	public static boolean[] or(boolean[] bits1, boolean[] bits2)
	{
		// Pad them to same length
		int len = bits1.length > bits2.length ? bits1.length : bits2.length;
		bits1 = Arrays.copyOf(bits1, len);
		bits2 = Arrays.copyOf(bits2, len);
		
		// Prevent overflow, make the results bigger
		boolean[] b = new boolean[len + 1];
		return or_(bits1, bits2, b);
	}
	
	public static boolean[] xor(boolean[] bits1, boolean[] bits2)
	{
		// Pad them to same length
		int len = bits1.length > bits2.length ? bits1.length : bits2.length;
		bits1 = Arrays.copyOf(bits1, len);
		bits2 = Arrays.copyOf(bits2, len);
		
		// Prevent overflow, make the results bigger
		boolean[] b = new boolean[len + 1];
		return xor_(bits1, bits2, b);
	}
	
	private static boolean[] not_(boolean[] src, boolean[] dest)
	{
		int len = src.length;
		for (int i = 0; i < len; i++)
			dest[i] = !src[i];
		return dest;
	}
	
	private static boolean[] negative_(boolean[] src, boolean[] dest)
	{
		return add_(not_(src, dest), ONE_BITS, dest);
	}
	
	private static boolean[] bitshift_left_(boolean[] src, boolean[] dest, int n)
	{
		int len = src.length;
		System.arraycopy(src, 0, dest, n, len - n);
		return dest;
	}
	
	private static boolean[] bitshift_right_(boolean[] src, boolean[] dest, int n, boolean signed)
	{
		int len = src.length;
		System.arraycopy(src, n, dest, 0, len - n);
		if (signed)
			dest[len - 1] = src[len - 1];
		return dest;
	}
	
	private static boolean[] add_(boolean[] src1, boolean[] src2, boolean[] dest)
	{
		int len = src1.length;
		boolean carry = false;
		
		for (int i = 0; i < len; i++)
		{
			if (src1[i] && src2[i])
			{
				dest[i] = carry;
				carry = true;
			}
			else if (src1[i] || src2[i])
			{
				dest[i] = !carry;
			}
			else
			{
				dest[i] = carry;
				carry = false;
			}
		}
		
		// Check Overflow
		if (carry)
		{
			dest[len - 1] = true;
		}
		
		return dest;
	}
	
	private static boolean[] multiply_(boolean[] src1, boolean[] src2, boolean[] dest)
	{
		int len = src1.length;
		// Implementation
		return dest;
	}
	
	private static boolean[] substract_(boolean[] src1, boolean[] src2, boolean[] dest)
	{
		return add_(src1, not_(src2, dest), dest);
	}
	
	private static boolean[] and_(boolean[] src1, boolean[] src2, boolean[] dest)
	{
		int len = src1.length;
		for (int i = 0; i < len; i++)
			dest[i] = src1[i] & src2[i];
		return dest;
	}
	
	private static boolean[] or_(boolean[] src1, boolean[] src2, boolean[] dest)
	{
		int len = src1.length;
		for (int i = 0; i < len; i++)
			dest[i] = src1[i] | src2[i];
		return dest;
	}
	
	private static boolean[] xor_(boolean[] src1, boolean[] src2, boolean[] dest)
	{
		int len = src1.length;
		for (int i = 0; i < len; i++)
			dest[i] = src1[i] ^ src2[i];
		return dest;
	}
}
