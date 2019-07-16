package dates;

import coordinate.Coordinate;
import tings.Land;
import tings.Thing;


public class Field //域
{
	private int width;//宽
	private int height;//高
	private Thing[][] field;//存cell对象的field数组
	public Field(int width, int height) 
	{
		this.width = width;//宽赋值
		this.height = height;//高赋值
		field = new Thing[width][height];//宽和高作为cell对象的数组的大小
	}
	
	public int getWidth()//得到宽的值
	{ 
		return width; 
	}
	
	public int getHeight() //得到高的值
	{ 
		return height; 
	}
	
	public void place(Coordinate coo, Thing o)//放入行列坐标，和cell
	{
		field[coo.getX()][coo.getY()] = o;//再把参数的cell放入那个坐标
	}
	
	public Thing get(Coordinate coo) //得到坐标里的cell对象
	{
		return field[coo.getX()][coo.getY()];
	}

	public void clear() //把数组field清空
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
