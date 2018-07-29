package StuAchievement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class InitialInterface extends JFrame implements ActionListener{
	private JButton Stu,Tea;
	public InitialInterface(String title)
	{
		super(title);
		this.setSize(380,160);
		this.setLocationRelativeTo(null);//��ܾ���
		ImageIcon icon=new ImageIcon("src/StuAchievement/logo_school.jpg");//����logo
		JLabel Imagelabel=new JLabel(icon);
		this.add(Imagelabel);
		this.setLayout(new FlowLayout());
		Stu=new JButton("�ɼ���ѯ");
		this.add(Stu).setFont(new Font("����",1,17));
		Stu.addActionListener(this);
		Tea=new JButton("��ʦ��½");
		this.add(Tea).setFont(new Font("����",1,17));
		Tea.addActionListener(this);
		this.setVisible(true);
		this.setResizable(false);//�̶����
		this.addWindowListener(new WinClose());
	
	}
	
	public void actionPerformed(ActionEvent ev)//��ť�¼��ļ���
	{
		if(ev.getSource()==Stu)	{
			this.setVisible(false);
			new StuFrame();
			
		}
		else if(ev.getSource()==Tea){
			new TeaFrame();
			this.setVisible(false);
		}
	}
	class WinClose implements WindowListener
	{
		public void windowClosing(WindowEvent ev)
		{
			System.exit(0);
		}
		public void windowOpened(WindowEvent ev){}
		public void windowActivated(WindowEvent ev){}
		public void windowDeactivated(WindowEvent ev){}
		public void windowClosed(WindowEvent ev){}
		public void windowIconified(WindowEvent ev){}
		public void windowDeiconified(WindowEvent ev){}
			
	}
}
