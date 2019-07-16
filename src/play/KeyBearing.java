package play;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import coordinate.Coordinate;

public class KeyBearing implements KeyListener
{
	private int speed=1;
	private Coordinate goBearing=new Coordinate(0, 1);
	private Coordinate newBearing=new Coordinate(0, 1);
	private Coordinate right=new Coordinate(0,1);
	private Coordinate left=new Coordinate(0,-1);
	private Coordinate up=new Coordinate(-1,0);
	private Coordinate down=new Coordinate(1,0);
	
	public void keyPressed(KeyEvent e)//¼üÅÌ·½Ïò¼ü²Ù×÷ 
	{
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			this.newBearing=right;
			break;
		case KeyEvent.VK_LEFT:
			this.newBearing=left;
			break;
		case KeyEvent.VK_UP:
			this.newBearing=up;
			break;
		case KeyEvent.VK_DOWN:
			this.newBearing=down;
			break;
		default:
			break;
		}

	}
	
	public boolean reverse()
	{
		
		if(!(newBearing.opposite(goBearing)))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public Coordinate getGo()
	{
		return goBearing;
	}
	
	public Coordinate getNew()
	{
		return newBearing;
	}
	
	public void changeGo(Coordinate coo)
	{
		goBearing=coo;
	}
	
	public void changeNew(Coordinate coo)
	{
		newBearing=coo;
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
	
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}
	
	public int getSpeed()
	{
		return speed;
	}
}
