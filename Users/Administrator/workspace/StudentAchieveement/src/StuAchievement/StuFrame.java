package StuAchievement;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class StuFrame extends JFrame implements ActionListener{
	private JButton search;
	private TextField text;
	public StuFrame()
	{
		super("学生成绩查询");
		this.setSize(500,300);
		this.setLocationRelativeTo(null);//框架居中
		JPanel seekP=new JPanel();//添加一个查询面板
		this.add(seekP,"North");
		seekP.setBackground(Color.lightGray);
		Label num=new Label("学号");
		seekP.add(num);
		text=new TextField("",13);
		seekP.add(text);
		search=new JButton("查询");
		seekP.add(search).setFont(new Font("楷体",1,12));
		search.addActionListener(this);
		
		/*Label tx=new Label("sssss");
		this.add(tx,"Center");  //此处添加成绩
*/
		
		this.setVisible(true);
		this.setResizable(false);//固定框架
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==search)
		{
			/////////////////////
		}
		
	}

}
