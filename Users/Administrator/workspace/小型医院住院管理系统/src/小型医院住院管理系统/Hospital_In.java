package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 住院处理界面
 */
public class Hospital_In implements ActionListener{
	//创建窗体对象
			JFrame jf = new JFrame("住院处理");
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
			JPanel p10 = new JPanel();
			//添加文本框
			TextField tfpatient_id = new TextField(15);
			TextField tfpatient_name = new TextField(15);
			TextField tfsex = new TextField(15);
			TextField tfage = new TextField(15);
			TextField tfpatient_phone = new TextField(15);
			TextField tfpremoney = new TextField(15);
			TextField tfroom_id = new TextField(15);
			TextField tfbed_number = new TextField(15);	
			//添加按钮
			Button finish = new Button("完成");
			Button back = new Button("返回");
			
	public Hospital_In() {
		
		//设置大小
		jf.setSize(300, 400);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		p10.add(finish);
		p10.add(back);
		jf.add(p10,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		back.addActionListener(this);
		
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String patient_id = tfpatient_id.getText();
			String patient_name = tfpatient_name.getText();
			String sex = tfsex.getText();
			String age = tfage.getText();
			String patient_phone = tfpatient_phone.getText();
			String premoney = tfpremoney.getText();
			String room_id = tfroom_id.getText();
			String bed_number = tfbed_number.getText();
			connect s = new connect();
			s.getConnection();
			s.HIN(patient_id,patient_name,sex,age,patient_phone,premoney,room_id,bed_number);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Hospital_In hospital_in = new Hospital_In();

	}

}
