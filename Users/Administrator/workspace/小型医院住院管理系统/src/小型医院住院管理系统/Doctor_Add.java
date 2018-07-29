package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 医生添加界面
 */
public class Doctor_Add implements ActionListener{
	//创建窗体对象
			JFrame jf = new JFrame("医生添加");
			//添加label
			Label doctor_id = new Label("医生编号:");
			Label doctor_name = new Label("姓名:");
			Label sex = new Label("性别:");
			Label office_id = new Label("科室号:");
			Label phone = new Label("联系方式:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			JPanel p5 = new JPanel();
			JPanel p6 = new JPanel();
			JPanel p7 = new JPanel();
			//添加文本框
			TextField tfdoctor_id = new TextField(15);
			TextField tfdoctor_name = new TextField(15);
			TextField tfsex = new TextField(15);
			TextField tfoffice_id = new TextField(15);
			TextField tfphone = new TextField(15);
			//添加按钮
			Button finish = new Button("完成");
			Button back = new Button("返回");
			
			
	public Doctor_Add() {
		
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加
		p1.add(doctor_id);
		p1.add(tfdoctor_id);
		p2.add(doctor_name);
		p2.add(tfdoctor_name);
		p3.add(sex);
		p3.add(tfsex);
		p4.add(office_id);
		p4.add(tfoffice_id);
		p5.add(phone);
		p5.add(tfphone);
		p6.add(p1);
		p6.add(p2);
		p6.add(p3);
		p6.add(p4);
		p6.add(p5);
		jf.add(p6);
		p7.add(finish);
		p7.add(back);
		jf.add(p7,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		back.addActionListener(this);
		
		jf.setVisible(true);
	}
	
public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String doctor_id = tfdoctor_id.getText();
			String doctor_name = tfdoctor_name.getText();
			String sex = tfsex.getText();
			String office_id = tfoffice_id.getText();
			String phone = tfphone.getText();
			connect s = new connect();
			s.getConnection();
			s.DA(doctor_id, doctor_name, sex, office_id,phone);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Doctor_Add doctor_add = new Doctor_Add();
	}

}
