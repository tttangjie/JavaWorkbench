package StuAchievement;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class StuFrame extends JFrame implements ActionListener{
	private JButton search;
	private TextField text;
	public StuFrame()
	{
		super("ѧ���ɼ���ѯ");
		this.setSize(500,300);
		this.setLocationRelativeTo(null);//��ܾ���
		JPanel seekP=new JPanel();//���һ����ѯ���
		this.add(seekP,"North");
		seekP.setBackground(Color.lightGray);
		Label num=new Label("ѧ��");
		seekP.add(num);
		text=new TextField("",13);
		seekP.add(text);
		search=new JButton("��ѯ");
		seekP.add(search).setFont(new Font("����",1,12));
		search.addActionListener(this);
		
		/*Label tx=new Label("sssss");
		this.add(tx,"Center");  //�˴���ӳɼ�
*/
		
		this.setVisible(true);
		this.setResizable(false);//�̶����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==search)
		{
			/////////////////////
		}
		
	}

}
