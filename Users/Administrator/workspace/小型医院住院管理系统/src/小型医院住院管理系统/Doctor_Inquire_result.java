package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 医生查询结果界面
 */
public class Doctor_Inquire_result {
	public Doctor_Inquire_result(String a,String b,String c,String d,String e) {
		//创建窗体对象
		JFrame jf = new JFrame("医生查询结果");
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置关闭事件
		jf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ee){
				jf.setVisible(false);
			}
		});
		//添加label
		Label doctor_id = new Label("医生编号:");
		Label doctor_name = new Label("姓名:");
		Label sex = new Label("性别:");
		Label office_id = new Label("科室号:");
		Label phone = new Label("联系方式");

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		//添加信息
		Label tfdoctor_id = new Label(a);
		Label tfdoctor_name = new Label(b);
		Label tfsex = new Label(c);
		Label tfoffice_id = new Label(d);
		Label tfphone = new Label(e);
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

		jf.setVisible(true);
	}
/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Doctor_Inquire_result doctor_inquire_result = new Doctor_Inquire_result();
	}
	*/
}
