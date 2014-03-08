package clashsoft.cslib.math;

public class Point3i extends Point2i
{
	public int	z;
	
	public Point3i(int x, int y, int z)
	{
		super(x, y);
		this.z = z;
	}
	
	public int getZ()
	{
		return this.z;
	}
	
	public void setZ(int z)
	{
		this.z = z;
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode() ^ this.z;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Point3i)
		{
			return super.equals(obj) && ((Point3i) obj).z == this.z;
		}
		return false;
	}
}
