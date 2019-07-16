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
		Field field = new Field(55,55);//����һ30*30�Ķ�ά����field
		Set set = new Set(field); 
		KeyBearing keyBearing=new KeyBearing();
		Timer time =new Timer(200,new SnakeTimer(set,keyBearing));
		View view = new View(field);//����view��ͼ,��field�Ž�ȥ
		JFrame frame = new JFrame();//����frame���
		frame.addKeyListener(keyBearing);//���̼�����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�
		frame.setResizable(true);//���ɵ�����С
		frame.setTitle("̰����");//����ΪCells
		frame.add(view);//����ͼview����frame���
		frame.pack();//ʹ���frame����ͼviewһ����
		frame.setVisible(true);//��ʾ���frame
		while (set.getSnake().isAlive())//����
		{
			set.setEgg();//���õ�
			time.start(); //��һ��
			frame.repaint();//�ػ�
		}
		if(!(set.getSnake().isAlive()))//����
		{
			JOptionPane.showMessageDialog(null, "game over");
			System.exit(0);
		}	
	}
}

