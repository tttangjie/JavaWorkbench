package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 医生删除界面
 */
public class Doctor_Delete implements ActionListener{
	//创建窗体对象
			JFrame jf = new JFrame("医生删除");
			//添加label
			Label doctor_id = new Label("医生编号:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			//添加文本框
			TextField tfdoctor_id = new TextField(15);
			//添加按钮
			Button finish = new Button("删除");
			Button back = new Button("返回");		
			
	
	public Doctor_Delete() {
		
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置布局
		jf.setLayout(new FlowLayout());
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加
		p1.add(doctor_id);
		p1.add(tfdoctor_id);
		jf.add(p1);
		p2.add(finish);
		p2.add(back);
		jf.add(p2);	
		jf.add(p2,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		back.addActionListener(this);
		
		jf.setVisible(true);	
	}

public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String doctor_id = tfdoctor_id.getText();
			connect s = new connect();
			s.getConnection();
			s.DD(doctor_id);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Doctor_Delete doctor_delete = new Doctor_Delete();
	}

}
