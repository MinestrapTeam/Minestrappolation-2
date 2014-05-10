package clashsoft.cslib.math;

public class Point2i
{
	public int x;
	public int y;
	
	public Point2i(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return this.x;
	}

	public Point2i setX(int x)
	{
		this.x = x;
		return this;
	}

	public int getY()
	{
		return this.y;
	}

	public Point2i setY(int y)
	{
		this.y = y;
		return this;
	}
	
	public boolean isPoint(int x, int y)
	{
		return this.x == x && this.y == y;
	}
	
	public boolean isPointInRegion(int x1, int y1, int x2, int y2)
	{
		return this.x >= x1 && this.x <= x2 && this.y >= y1 && this.y <= y2;
	}

	@Override
	public int hashCode()
	{
		return this.x ^ this.y;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2i other = (Point2i) obj;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "[" + this.x + ";" + this.y + "]";
	}
}
