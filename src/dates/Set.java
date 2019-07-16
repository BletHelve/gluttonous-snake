package dates;

import coordinate.Coordinate;
import tings.Egg;
import tings.Land;
import tings.Thing;
import tings.Wall;

public class Set
{
	private Field field;
	private Snake snake;
	
	public Set(Field f)
	{
		field=f;
		snake=new Snake(field);
		this.SetLand();
		this.SetWall();
		this.setSnake();
		this.setEgg();
	}
	
	public	Snake getSnake()
	{
		return snake;
	}
	
	public void setEgg()
	{
		int cnt=0;
		for ( int row = 0; row<field.getHeight(); row++ ) 
		{
			for ( int col = 0; col<field.getWidth(); col++ ) 
			{
				Thing thing = field.get(new Coordinate(row, col));//取出cell
				if ( thing.what().equals("egg")) //画格子
				{
					cnt++;
				}
			}
		}
		end:
		for(;cnt<new Egg().getNumber();cnt++)
		{
			Coordinate eggCoo=Coordinate.getRandom(1, field.getWidth()-2,
												   1, field.getHeight()-2);
			for(Coordinate coo:snake.getList())
				{
					if(eggCoo.equal(coo))
					{
						break end;
					}
				}
				field.place(eggCoo,new Egg());
				
			}
	}

	private void SetLand()
	{
		for(int i=0;i<field.getWidth();i++)
		{
			for(int j=0;j<field.getWidth();j++)
			{
				field.place(new Coordinate(i, j), new Land());
			}
		}
	}
	
	private void SetWall()
	{
		for(int j=0;j<field.getWidth();j++)
		{
			int i=0;
			field.place(new Coordinate(i, j), new Wall());
		}
		for(int i=1;i<field.getWidth();i++)
		{
			int j=field.getWidth()-1;
			field.place(new Coordinate(i, j), new Wall());
		}
		for(int j=field.getWidth()-1;j>0;j--)
		{
			int i=field.getWidth()-1;
			field.place(new Coordinate(i, j), new Wall());
		}
		for(int i=field.getWidth()-1;i>0;i--)
		{
			int j=0;
			field.place(new Coordinate(i, j), new Wall());
		}
	}
	
	private void setSnake()
	{
		int y=5;
		int x=field.getHeight()-1-y;
		for(int i=0;i<3;i++)
		{
			snake.grow(new Coordinate(x,y));
			y++;
		}
	}

	
}
