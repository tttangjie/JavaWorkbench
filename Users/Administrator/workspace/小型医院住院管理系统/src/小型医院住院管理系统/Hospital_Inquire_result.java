package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 住院查询结果界面
 */
public class Hospital_Inquire_result {
	public Hospital_Inquire_result(String a,String b,String c,String d,String e,String f,String g,String h) {
		//创建窗体对象
		JFrame jf = new JFrame("住院查询结果");
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
		Label patient_id = new Label("病人编号:");
		Label patient_name = new Label("病人姓名:");
		Label sex = new Label("性别:");
		Label age = new Label("年龄:");
		Label patient_phone = new Label("联系方式:");
		Label premoney = new Label("预交费:");
		Label room_id = new Label("病房号:");
		Label bed_number = new Label("床位号:");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		//添加信息
		Label tfpatient_id = new Label(a);
		Label tfpatient_name = new Label(b);
		Label tfsex = new Label(c);
		Label tfage = new Label(d);
		Label tfpatient_phone = new Label(f);
		Label tfpremoney = new Label(e);
		Label tfroom_id = new Label(g);
		Label tfbed_number = new Label(h);
		//添加
		p1.add(patient_id);
		p1.add(tfpatient_id);
		p2.add(patient_name);
		p2.add(tfpatient_name);
		p3.add(sex);
		p3.add(tfsex);
		p4.add(age);
		p4.add(tfage);
		p5.add(patient_phone);
		p5.add(tfpatient_phone);
		p6.add(premoney);
		p6.add(tfpremoney);
		p7.add(room_id);
		p7.add(tfroom_id);
		p8.add(bed_number);
		p8.add(tfbed_number);
		p9.add(p1); 
		p9.add(p2); 
		p9.add(p3); 
		p9.add(p4);
		p9.add(p5);
		p9.add(p6);
		p9.add(p7);
		p9.add(p8);
		jf.add(p9);

		jf.setVisible(true);
	}
/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Hospital_Inquire_result hospital_inquire_result = new Hospital_Inquire_result();
	}
*/
}
