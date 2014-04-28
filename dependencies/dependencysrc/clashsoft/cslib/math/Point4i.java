package clashsoft.cslib.math;

public class Point4i extends Point3i
{
	public int	w;
	
	public Point4i(int x, int y, int z, int w)
	{
		super(x, y, z);
		this.w = w;
	}
	
	public int getW()
	{
		return this.w;
	}
	
	public void setW(int w)
	{
		this.w = z;
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode() ^ this.w;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Point4i)
		{
			return super.equals(obj) && ((Point4i) obj).w == this.w;
		}
		return false;
	}
}
