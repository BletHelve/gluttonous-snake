package dates;

import java.util.ArrayList;

import coordinate.Coordinate;
import tings.SnakeBody;

public class Snake 
{
	private Field field;
	private ArrayList<Coordinate> oneSnake=new ArrayList<Coordinate>();
	private int length=0;
	private boolean alive=true;
	Coordinate bearing=new Coordinate(0,1);
	public Snake(Field field)
	{
		this.field=field;
	}
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public ArrayList<Coordinate> getList()
	{
		return oneSnake;
	}
	
	public Coordinate getBearing()
	{
		return bearing;
	}
	public void changeBearing(Coordinate bearing)
	{
		this.bearing=bearing;
	}
	public void watch_action(Coordinate bearing,int speed)
	{
			System.out.print("×ø±ê£º"+this.getHeadCoo().getY()+","+this.getHeadCoo().getX());
			System.out.println("    ËÙ¶È:"+speed);
			Coordinate watchCoo=this.getHeadCoo().regulationXY(bearing);
			switch (field.get(watchCoo).what())
			{
			case "body":
				if(!(this.bearing.opposite(bearing)))
				{
					this.die();
				}
				break;
			case "wall":
				this.die();
				break;
			case "egg":
				this.grow(watchCoo);
				this.changeBearing(bearing);
				break;
			default:
				this.move(watchCoo);
				this.changeBearing(bearing);
				break;
			}
			if(bearing.getX()==0)
			{
				if(bearing.getY()==1)
				{
					System.out.println("right");
				}
				else
				{
					System.out.println("left");
				}
			}
			else
			{
				if(bearing.getX()==-1)
				{
					System.out.println("up");
				}
				else
				{
					System.out.println("down");
				}
			}
	}
	public void grow(Coordinate coo)
	{
		this.changeLength(1);
		SnakeBody body = new SnakeBody();
		field.place(coo,body);
		oneSnake.add(coo);
	}
		private void die()
		{
			this.alive=false;
		}
		
		private void move(Coordinate headCoo)
		{
			this.reduce(this.getTailCoo());
			this.grow(headCoo);
		}
		private void reduce(Coordinate coo)
		{
			this.changeLength(-1);
			field.remove(coo);
			oneSnake.remove(oneSnake.indexOf(coo));
		}	
		private Coordinate getHeadCoo()
			{
				return oneSnake.get(oneSnake.size()-1);
			}
			private Coordinate getTailCoo()
			{
				return oneSnake.get(0);
			}
				private void changeLength(int cl)
				{
					length=length+cl;
				}
}
