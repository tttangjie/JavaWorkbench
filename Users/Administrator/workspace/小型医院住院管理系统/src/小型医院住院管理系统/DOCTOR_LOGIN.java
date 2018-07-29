package 小型医院住院管理系统;
import java.awt.event.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class DOCTOR_LOGIN  implements ActionListener{
	JFrame jf = new JFrame();
	JMenuBar doctor_menuBar = new JMenuBar();
	//菜单
	JMenu prescription = new JMenu("药单");
	JMenu drug_manage = new JMenu("药品");
	JMenu other = new JMenu("其他...");
	
	//菜单项
	JMenuItem make_prescription = new JMenuItem("开药单");
	JMenuItem drug_inquire = new JMenuItem("药品查询");
	JMenuItem drug_edit = new JMenuItem("药品修改");
	JMenuItem exit = new JMenuItem("退出登陆");
	
	
	public DOCTOR_LOGIN(){
		super();
		jf.setTitle("医生登陆界面");
		jf.setBounds(200,200,480,320);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将菜单项添加到菜单
		prescription.add(make_prescription);
		drug_manage.add(drug_inquire);
		drug_manage.add(drug_edit);
		other.add(exit);
		//将菜单添加到菜单栏
		doctor_menuBar.add(prescription);
		doctor_menuBar.add(drug_manage);
		doctor_menuBar.add(other);
		//将菜单栏添加到窗体
		jf.setJMenuBar(doctor_menuBar);
		make_prescription.addActionListener(this);
		drug_inquire.addActionListener(this);
		drug_edit.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==make_prescription){
			new Make_Prescription();
			jf.setVisible(false);
		}
		
		if(e.getSource()==drug_inquire){
			new Drug_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==drug_edit){
			new Drug_Edit();
			jf.setVisible(false);
		}
		
		if(e.getSource()==exit){
			new LOGIN();
			jf.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		DOCTOR_LOGIN doctor_login = new DOCTOR_LOGIN();
		doctor_login.jf.setVisible(true);
	}

}
