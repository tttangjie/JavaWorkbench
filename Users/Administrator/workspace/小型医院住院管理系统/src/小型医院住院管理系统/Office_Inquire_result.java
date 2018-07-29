package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 科室查询结果界面
 */
public class Office_Inquire_result {
	public Office_Inquire_result(String a,String b,String c) {
		//创建窗体对象
		JFrame jf = new JFrame("科室查询结果");
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
		Label office_id = new Label("科室编号:");
		Label office_name = new Label("科室名:");
		Label doctor_number = new Label("医生数量:");
		//添加信息
		Label tfoffice_id = new Label(a);
		Label tfoffice_name = new Label(b);
		Label tfdoctor_number = new Label(c);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		//添加
		p1.add(office_id);
		p1.add(tfoffice_id);
		p2.add(office_name);
		p2.add(tfoffice_name);
		p3.add(doctor_number);
		p3.add(tfdoctor_number);
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		jf.add(p4);
		
		jf.setVisible(true);
	}

/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Office_Inquire_result office_inquire_result = new Office_Inquire_result();
	}
*/
}
