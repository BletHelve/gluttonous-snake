package play;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import dates.Field;
import dates.Set;
import dates.View;
public class CellMachine 
{
	public static void main(String[] args) 
	{
		Field field = new Field(55,55);//生成一30*30的二维数组field
		Set set = new Set(field); 
		KeyBearing keyBearing=new KeyBearing();
		Timer time =new Timer(200,new SnakeTimer(set,keyBearing));
		View view = new View(field);//做个view视图,把field放进去
		JFrame frame = new JFrame();//做个frame框架
		frame.addKeyListener(keyBearing);//键盘监听器
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭
		frame.setResizable(true);//不可调整大小
		frame.setTitle("贪吃蛇");//标题为Cells
		frame.add(view);//把视图view放入frame框架
		frame.pack();//使框架frame和视图view一样大
		frame.setVisible(true);//显示框架frame
		while (set.getSnake().isAlive())//活着
		{
			set.setEgg();//放置蛋
			time.start(); //走一步
			frame.repaint();//重绘
		}
		if(!(set.getSnake().isAlive()))//死亡
		{
			JOptionPane.showMessageDialog(null, "game over");
			System.exit(0);
		}	
	}
}

