package tings;

public class Egg extends Thing //蛋
{
	public int number=1;//蛋的数量

	public Egg() 
	{
		super("egg", 255,255,0);
	}
	
	public int getNumber()//得到蛋的数量
	{
		return number;
	}
	
	public void changeNumber(int n)//改变蛋的数量
	{
		number=n;
	}
}
