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
	
	public static Coordinate getRandom(int Wmin,int Wmax,int Hmin,int Hmax)//�ڷ�Χ�ڣ��������
	{
		return new Coordinate((int)(Wmin+Math.random()*Wmax), (int)(Hmin+Math.random()*Hmax));
	}
	
	public Coordinate regulationXY(Coordinate bearing)//�����ƶ�
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
	
	public boolean equal(Coordinate c)//����������ͬ
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
	
	public boolean opposite(Coordinate c)//���������෴
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
