package coordinate;

public class Coordinate {
	int x;
	int y;
	
	public Coordinate(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public static Coordinate getRandom(int Wmin,int Wmax,int Hmin,int Hmax)//在范围内，随机坐标
	{
		return new Coordinate((int)(Wmin+Math.random()*Wmax), (int)(Hmin+Math.random()*Hmax));
	}
	
	public Coordinate regulationXY(Coordinate bearing)//坐标移动
	{
		return new Coordinate(this.regulationX(bearing.getX()),
							  this.regulationY(bearing.getY()));
	}
	

	private int regulationX(int i)
	{
		return x+i;
	}
	
	private int regulationY(int j)
	{
		return y+j;
	}
	
	public boolean equal(Coordinate c)//两个坐标相同
	{
		if(this.getX()==c.getX()&&this.getY()==c.getY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean opposite(Coordinate c)//两个坐标相反
	{
		if(this.getX()+c.getX()==0&&this.getY()+c.getY()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
