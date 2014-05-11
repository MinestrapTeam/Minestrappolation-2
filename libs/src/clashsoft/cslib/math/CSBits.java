package clashsoft.cslib.math;

public class CSBits
{
	/**
	 * Checks if bit {@code pos} in {@code n} is {@code 1}.
	 * 
	 * @param number
	 *            the number
	 * @param pos
	 *            the position to check
	 * @return true, if {@code (n & 1 << pos) != 0}
	 */
	public static boolean checkBit(long number, int pos)
	{
		return (number & 1 << pos) != 0;
	}
	
	/**
	 * Sets bit 'pos' in Integer 'n' to 'value'.
	 * 
	 * @param number
	 *            the n
	 * @param pos
	 *            the pos
	 * @param value
	 *            the value
	 * @return the int
	 */
	public static long setBit(long number, int pos, boolean value)
	{
		long bitToSet = 1L << pos;
		return value ? number | bitToSet : (number | bitToSet) ^ bitToSet;
	}
	
	public static boolean[] getBits(byte b)
	{
		boolean[] bits = new boolean[8];
		return getBits(b, bits);
	}
	
	public static boolean[] getBits(short s)
	{
		boolean[] bits = new boolean[16];
		return getBits(s, bits);
	}
	
	public static boolean[] getBits(int i)
	{
		boolean[] bits = new boolean[32];
		return getBits(i, bits);
	}
	
	public static boolean[] getBits(long l)
	{
		boolean[] bits = new boolean[64];
		return getBits(l, bits);
	}
	
	public static boolean[] getBits(float f)
	{
		return getBits(Float.floatToRawIntBits(f));
	}
	
	public static boolean[] getBits(double d)
	{
		return getBits(Double.doubleToRawLongBits(d));
	}
	
	public static boolean[] getBits(char c)
	{
		return getBits((int) c);
	}
	
	private static boolean[] getBits(byte b, boolean[] bits)
	{
		bits[0] = (b & 0x1) != 0;
		bits[1] = (b & 0x2) != 0;
		bits[2] = (b & 0x4) != 0;
		bits[3] = (b & 0x8) != 0;
		bits[4] = (b & 0x10) != 0;
		bits[5] = (b & 0x20) != 0;
		bits[6] = (b & 0x40) != 0;
		bits[7] = (b & 0x80) != 0;
		return bits;
	}
	
	private static boolean[] getBits(short s, boolean[] bits)
	{
		getBits((byte) (s & 0xFF), bits);
		bits[8] = (s & 0x100) != 0;
		bits[9] = (s & 0x200) != 0;
		bits[10] = (s & 0x400) != 0;
		bits[11] = (s & 0x800) != 0;
		bits[12] = (s & 0x1000) != 0;
		bits[13] = (s & 0x2000) != 0;
		bits[14] = (s & 0x4000) != 0;
		bits[15] = (s & 0x8000) != 0;
		return bits;
	}
	
	private static boolean[] getBits(int i, boolean[] bits)
	{
		getBits((short) (i & 0xFFFF), bits);
		bits[16] = (i & 0x10000) != 0;
		bits[17] = (i & 0x20000) != 0;
		bits[18] = (i & 0x40000) != 0;
		bits[19] = (i & 0x80000) != 0;
		bits[20] = (i & 0x100000) != 0;
		bits[21] = (i & 0x200000) != 0;
		bits[22] = (i & 0x400000) != 0;
		bits[23] = (i & 0x800000) != 0;
		bits[24] = (i & 0x1000000) != 0;
		bits[25] = (i & 0x2000000) != 0;
		bits[26] = (i & 0x4000000) != 0;
		bits[27] = (i & 0x8000000) != 0;
		bits[28] = (i & 0x10000000) != 0;
		bits[29] = (i & 0x20000000) != 0;
		bits[30] = (i & 0x40000000) != 0;
		bits[31] = (i & 0x80000000) != 0;
		return bits;
	}
	
	private static boolean[] getBits(long l, boolean[] bits)
	{
		getBits((int) (l & 0xFFFFFFFF), bits);
		bits[32] = (l & 0x100000000L) != 0;
		bits[33] = (l & 0x200000000L) != 0;
		bits[34] = (l & 0x400000000L) != 0;
		bits[35] = (l & 0x800000000L) != 0;
		bits[36] = (l & 0x1000000000L) != 0;
		bits[37] = (l & 0x2000000000L) != 0;
		bits[38] = (l & 0x4000000000L) != 0;
		bits[39] = (l & 0x8000000000L) != 0;
		bits[40] = (l & 0x10000000000L) != 0;
		bits[41] = (l & 0x20000000000L) != 0;
		bits[42] = (l & 0x40000000000L) != 0;
		bits[43] = (l & 0x80000000000L) != 0;
		bits[44] = (l & 0x100000000000L) != 0;
		bits[45] = (l & 0x200000000000L) != 0;
		bits[46] = (l & 0x400000000000L) != 0;
		bits[47] = (l & 0x800000000000L) != 0;
		bits[48] = (l & 0x1000000000000L) != 0;
		bits[49] = (l & 0x2000000000000L) != 0;
		bits[50] = (l & 0x4000000000000L) != 0;
		bits[51] = (l & 0x8000000000000L) != 0;
		bits[52] = (l & 0x10000000000000L) != 0;
		bits[53] = (l & 0x20000000000000L) != 0;
		bits[54] = (l & 0x40000000000000L) != 0;
		bits[55] = (l & 0x80000000000000L) != 0;
		bits[56] = (l & 0x100000000000000L) != 0;
		bits[57] = (l & 0x200000000000000L) != 0;
		bits[58] = (l & 0x400000000000000L) != 0;
		bits[59] = (l & 0x800000000000000L) != 0;
		bits[60] = (l & 0x1000000000000000L) != 0;
		bits[61] = (l & 0x2000000000000000L) != 0;
		bits[62] = (l & 0x4000000000000000L) != 0;
		bits[63] = (l & 0x8000000000000000L) != 0;
		return bits;
	}
	
	public static void checkLength(boolean[] bits, int size)
	{
		if (bits.length < size)
		{
			throw new IllegalArgumentException("Bit array to short! Length must be at least " + size);
		}
	}
	
	public static byte getByte(boolean[] bits)
	{
		checkLength(bits, 8);
		return getByte_(bits);
	}
	
	public static short getShort(boolean[] bits)
	{
		checkLength(bits, 16);
		return getShort_(bits);
	}
	
	public static int getInt(boolean[] bits)
	{
		checkLength(bits, 32);
		return getInt_(bits);
	}
	
	public static long getLong(boolean[] bits)
	{
		checkLength(bits, 64);
		return getLong_(bits);
	}
	
	public static float getFloat(boolean[] bits)
	{
		return Float.intBitsToFloat(getInt(bits));
	}
	
	public static double getDouble(boolean[] bits)
	{
		return Double.longBitsToDouble(getLong(bits));
	}
	
	public static char getChar(boolean[] bits)
	{
		return (char) getInt(bits);
	}
	
	private static byte getByte_(boolean[] bits)
	{
		byte b0 = (byte) ((bits[0] ? 0x1 : 0) | (bits[1] ? 0x2 : 0) | (bits[2] ? 0x4 : 0) | (bits[3] ? 0x8 : 0) | (bits[4] ? 0x10 : 0) | (bits[5] ? 0x20 : 0) | (bits[6] ? 0x40 : 0) | (bits[7] ? 0x80 : 0));
		return b0;
	}
	
	private static short getShort_(boolean[] bits)
	{
		byte b0 = getByte_(bits);
		short b1 = (short) ((bits[8] ? 0x100 : 0) | (bits[9] ? 0x200 : 0) | (bits[10] ? 0x400 : 0) | (bits[11] ? 0x800 : 0) | (bits[12] ? 0x1000 : 0) | (bits[13] ? 0x2000 : 0) | (bits[14] ? 0x4000 : 0) | (bits[15] ? 0x8000 : 0));
		return (short) (b0 | b1);
	}
	
	private static int getInt_(boolean[] bits)
	{
		short b0 = getShort_(bits);
		int b3 = (bits[16] ? 0x10000 : 0) | (bits[17] ? 0x20000 : 0) | (bits[18] ? 0x40000 : 0) | (bits[19] ? 0x80000 : 0) | (bits[20] ? 0x100000 : 0) | (bits[21] ? 0x200000 : 0) | (bits[22] ? 0x400000 : 0) | (bits[23] ? 0x800000 : 0);
		int b4 = (bits[24] ? 0x1000000 : 0) | (bits[25] ? 0x2000000 : 0) | (bits[26] ? 0x4000000 : 0) | (bits[27] ? 0x8000000 : 0) | (bits[28] ? 0x10000000 : 0) | (bits[29] ? 0x20000000 : 0) | (bits[30] ? 0x40000000 : 0) | (bits[31] ? 0x80000000 : 0);
		return b0 | b3 | b4;
	}
	
	private static long getLong_(boolean[] bits)
	{
		int b0 = getInt_(bits);
		long b4 = (byte) ((bits[32] ? 0x100000000L : 0) | (bits[33] ? 0x200000000L : 0) | (bits[34] ? 0x400000000L : 0) | (bits[35] ? 0x800000000L : 0) | (bits[36] ? 0x1000000000L : 0) | (bits[37] ? 0x2000000000L : 0) | (bits[38] ? 0x4000000000L : 0) | (bits[39] ? 0x8000000000L : 0));
		long b5 = (byte) ((bits[40] ? 0x10000000000L : 0) | (bits[41] ? 0x20000000000L : 0) | (bits[42] ? 0x40000000000L : 0) | (bits[43] ? 0x80000000000L : 0) | (bits[44] ? 0x100000000000L : 0) | (bits[45] ? 0x200000000000L : 0) | (bits[46] ? 0x400000000000L : 0) | (bits[47] ? 0x800000000000L : 0));
		long b6 = (byte) ((bits[48] ? 0x1000000000000L : 0) | (bits[49] ? 0x2000000000000L : 0) | (bits[50] ? 0x4000000000000L : 0) | (bits[51] ? 0x8000000000000L : 0) | (bits[52] ? 0x10000000000000L : 0) | (bits[53] ? 0x20000000000000L : 0) | (bits[54] ? 0x40000000000000L : 0) | (bits[55] ? 0x80000000000000L : 0));
		long b7 = (byte) ((bits[56] ? 0x100000000000000L : 0) | (bits[57] ? 0x200000000000000L : 0) | (bits[58] ? 0x400000000000000L : 0) | (bits[59] ? 0x800000000000000L : 0) | (bits[60] ? 0x1000000000000000L : 0) | (bits[61] ? 0x2000000000000000L : 0) | (bits[62] ? 0x4000000000000000L : 0) | (bits[63] ? 0x8000000000000000L : 0));
		return b0 | b4 | b5 | b6 | b7;
	}
}
