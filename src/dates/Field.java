package dates;

import coordinate.Coordinate;
import tings.Land;
import tings.Thing;


public class Field //��
{
	private int width;//��
	private int height;//��
	private Thing[][] field;//��cell�����field����
	public Field(int width, int height) 
	{
		this.width = width;//��ֵ
		this.height = height;//�߸�ֵ
		field = new Thing[width][height];//��͸���Ϊcell���������Ĵ�С
	}
	
	public int getWidth()//�õ����ֵ
	{ 
		return width; 
	}
	
	public int getHeight() //�õ��ߵ�ֵ
	{ 
		return height; 
	}
	
	public void place(Coordinate coo, Thing o)//�����������꣬��cell
	{
		field[coo.getX()][coo.getY()] = o;//�ٰѲ�����cell�����Ǹ�����
	}
	
	public Thing get(Coordinate coo) //�õ��������cell����
	{
		return field[coo.getX()][coo.getY()];
	}

	public void clear() //������field���
	{
		for ( int i=0; i<height; i++ )
		{
			for ( int j=0; j<width; j++ ) 
			{
				field[i][j] = null;
			}
		}
	}

	public void remove(Coordinate coo)
	{
		field[coo.getX()][coo.getY()]=new Land();
	}
}
