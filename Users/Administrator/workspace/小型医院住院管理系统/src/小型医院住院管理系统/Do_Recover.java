package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 出院结算界面
 */
public class Do_Recover implements ActionListener{
	//创建窗体对象
			JFrame jf = new JFrame("出院结算");
			//添加label
			Label patient_id = new Label("病人编号:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			//添加文本框
			final TextField tfpatient_id = new TextField(15);
			//添加按钮
			Button finish = new Button("确定");		
			
	
	public Do_Recover() {
		
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置布局
		jf.setLayout(new FlowLayout());
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加
		p1.add(patient_id);
		p1.add(tfpatient_id);
		jf.add(p1);
		p2.add(finish);
		jf.add(p2);	
		jf.add(p2,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		
		jf.setVisible(true);	
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			jf.setVisible(false);
			String patient_id = tfpatient_id.getText();
			connect s = new connect();
			s.getConnection();
			s.DR(patient_id);
			connect q = new connect();
			q.getConnection();
			q.DP(patient_id);
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Do_Recover do_recover = new Do_Recover();
	}
}
