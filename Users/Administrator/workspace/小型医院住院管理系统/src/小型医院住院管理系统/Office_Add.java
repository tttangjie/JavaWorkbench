package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 科室添加界面
 */
public class Office_Add implements ActionListener{
	//创建窗体对象
			JFrame jf = new JFrame("科室添加");
			//添加label
			Label office_id = new Label("科室号:");
			Label office_name = new Label("科室名:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			//添加文本框
			TextField tfoffice_id = new TextField(15);
			TextField tfoffice_name = new TextField(15);
			//添加按钮
			Button finish = new Button("完成");
			Button back = new Button("返回");
	
	public Office_Add() {
		
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加
		p1.add(office_id);
		p1.add(tfoffice_id);
		p2.add(office_name);
		p2.add(tfoffice_name);
		p3.add(p1);
		p3.add(p2);
		jf.add(p3);
		p4.add(finish);
		p4.add(back);
		jf.add(p4,BorderLayout.SOUTH);
		finish.addActionListener(this);
		back.addActionListener(this);
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String office_id = tfoffice_id.getText();
			String office_name = tfoffice_name.getText();
			connect s = new connect();
			s.getConnection();
			s.OA(office_id, office_name);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Office_Add office_add = new Office_Add();
	}

}
