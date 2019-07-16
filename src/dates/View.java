package dates;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import coordinate.Coordinate;
import tings.Thing;

public class View extends JPanel
{
	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 16;//尺寸为16
	private Field theField;
	public View(Field field)//把field放入view
	{
		theField = field;
	}
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);//画图形
		for ( int row = 0; row<theField.getHeight(); row++ ) 
		{
			for ( int col = 0; col<theField.getWidth(); col++ ) 
			{
				Thing ting = theField.get(new Coordinate(row, col));//取出cell
				if ( ting != null ) //画格子
				{
					ting.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
				}
			}
		}
	}
	@Override
	public Dimension getPreferredSize() //得到视图大小
	{
		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
	}
}
