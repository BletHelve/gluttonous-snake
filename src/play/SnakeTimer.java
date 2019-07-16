package play;
import java.awt.event.ActionListener;
import dates.Set;

import java.awt.event.ActionEvent;
 
public class SnakeTimer implements ActionListener
{
	Set set; 
	KeyBearing keyBearing;
	
	public SnakeTimer(Set s,KeyBearing k)
	{
		set=s;
		keyBearing=k;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(keyBearing.reverse())
		{
			set.getSnake().watch_action(keyBearing.getNew(),keyBearing.getSpeed());
			keyBearing.changeNew(keyBearing.getGo());
		}
		else
		{
			set.getSnake().watch_action(keyBearing.getNew(),keyBearing.getSpeed());
			keyBearing.changeGo(keyBearing.getNew());
		}
	} 
}