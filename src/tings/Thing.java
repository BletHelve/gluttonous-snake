package tings;

import java.awt.Color;
import java.awt.Graphics;
 
public class Thing
{
	private String name;//名称
	private Color color;//颜色
	
	public Thing(String s,int r,int g,int b)
	{
		name=s;
		color=new Color(r,g,b);
	}
	
	public void changeColor(int x,int y,int z)//改变东西的颜色
	{
		color=new Color(x,y,z);
	}
	
	public void draw(Graphics g, int x, int y, int size)//画出东西 
	{
		g.setColor(color);
		g.fillRect(x, y, size, size);

	}
	
	public String what()//什么东西
	{
		return name;
	}
}

