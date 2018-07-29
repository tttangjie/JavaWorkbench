package 小型医院住院管理系统;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
@SuppressWarnings("serial")

public class ADMINISTRATOR_LOGIN implements ActionListener{
	JFrame jf = new JFrame();
	JMenuBar administrator_menuBar = new JMenuBar();
	//菜单
			JMenu hospital_manage = new JMenu("住院管理");
			JMenu office_manage = new JMenu("科室管理");
			JMenu doctor_manage = new JMenu("医生管理");
			JMenu recover  = new JMenu("出院处理");
			JMenu other = new JMenu("其他...");
			//菜单项
			JMenuItem hospital_in = new JMenuItem("住院处理");
			JMenuItem hospital_inquire = new JMenuItem("住院查询");
			JMenuItem office_add = new JMenuItem("科室添加");
			JMenuItem office_inquire = new JMenuItem("科室查询");
			JMenuItem doctor_add = new JMenuItem("医生添加");
			JMenuItem doctor_delete = new JMenuItem("医生删除");
			JMenuItem doctor_inquire = new JMenuItem("医生查询");
			JMenuItem do_rceover = new JMenuItem("出院结算");
			JMenuItem exit = new JMenuItem("退出登陆");
	public ADMINISTRATOR_LOGIN(){
		super();
		jf.setTitle("管理员登陆界面");
		jf.setBounds(200,200,480,320);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将菜单项添加到菜单
		hospital_manage.add(hospital_in);
		hospital_manage.add(hospital_inquire);
		office_manage.add(office_add);
		office_manage.add(office_inquire);
		doctor_manage.add(doctor_add);
		doctor_manage.add(doctor_delete);
		doctor_manage.add(doctor_inquire);
		recover.add(do_rceover);
		other.add(exit);
		//将菜单添加到菜单栏
		administrator_menuBar.add(hospital_manage);
		administrator_menuBar.add(office_manage);
		administrator_menuBar.add(doctor_manage);
		administrator_menuBar.add(recover);
		administrator_menuBar.add(other);
		//将菜单栏添加到窗体
		jf.setJMenuBar(administrator_menuBar);
		hospital_in.addActionListener(this);
		hospital_inquire.addActionListener(this);
		office_add.addActionListener(this);
		office_inquire.addActionListener(this);
		doctor_add.addActionListener(this);
		doctor_delete.addActionListener(this);
		doctor_inquire.addActionListener(this);
		do_rceover.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==hospital_in){
			new Hospital_In();
			jf.setVisible(false);
		}
		
		if(e.getSource()==hospital_inquire){
			new Hospital_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==office_add){
			new Office_Add();
			jf.setVisible(false);
		}
		
		if(e.getSource()==office_inquire){
			new Office_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==doctor_add){
			new Doctor_Add();
			jf.setVisible(false);
		}
		
		if(e.getSource()==doctor_delete){
			new Doctor_Delete();
			jf.setVisible(false);
		}
		
		if(e.getSource()==doctor_inquire){
			new Doctor_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==do_rceover){
			new Do_Recover();
			jf.setVisible(false);
		}

		if(e.getSource()==exit){
			new LOGIN();
			jf.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
		administrator_login.jf.setVisible(true);
	}

}
