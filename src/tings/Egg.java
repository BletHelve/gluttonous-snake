package tings;

public class Egg extends Thing //��
{
	public int number=1;//��������

	public Egg() 
	{
		super("egg", 255,255,0);
	}
	
	public int getNumber()//�õ���������
	{
		return number;
	}
	
	public void changeNumber(int n)//�ı䵰������
	{
		number=n;
	}
}
