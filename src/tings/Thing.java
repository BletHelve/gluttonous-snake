package tings;

import java.awt.Color;
import java.awt.Graphics;
 
public class Thing
{
	private String name;//����
	private Color color;//��ɫ
	
	public Thing(String s,int r,int g,int b)
	{
		name=s;
		color=new Color(r,g,b);
	}
	
	public void changeColor(int x,int y,int z)//�ı䶫������ɫ
	{
		color=new Color(x,y,z);
	}
	
	public void draw(Graphics g, int x, int y, int size)//�������� 
	{
		g.setColor(color);
		g.fillRect(x, y, size, size);

	}
	
	public String what()//ʲô����
	{
		return name;
	}
}

