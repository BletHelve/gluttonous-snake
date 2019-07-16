package dates;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import coordinate.Coordinate;
import tings.Thing;

public class View extends JPanel
{
	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 16;//�ߴ�Ϊ16
	private Field theField;
	public View(Field field)//��field����view
	{
		theField = field;
	}
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);//��ͼ��
		for ( int row = 0; row<theField.getHeight(); row++ ) 
		{
			for ( int col = 0; col<theField.getWidth(); col++ ) 
			{
				Thing ting = theField.get(new Coordinate(row, col));//ȡ��cell
				if ( ting != null ) //������
				{
					ting.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
				}
			}
		}
	}
	@Override
	public Dimension getPreferredSize() //�õ���ͼ��С
	{
		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
	}
}
