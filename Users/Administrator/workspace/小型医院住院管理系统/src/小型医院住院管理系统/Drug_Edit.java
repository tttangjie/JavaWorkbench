package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 药品修改界面
 */
public class Drug_Edit implements ActionListener{
	//创建窗体对象
			JFrame jf = new JFrame("药品修改");
			//添加label
			Label drug_id = new Label("药品编号:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			//添加文本框
			final TextField tfdrug_id = new TextField(15);
			//添加按钮
			Button finish = new Button("修改");
			Button back = new Button("返回");
			
	public Drug_Edit() {
		
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置布局
		jf.setLayout(new FlowLayout());
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加
		p1.add(drug_id);
		p1.add(tfdrug_id);
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
			String drug_id = tfdrug_id.getText();
			connect s = new connect();
			s.getConnection();
			s.DE(drug_id);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			DOCTOR_LOGIN doctor_login = new DOCTOR_LOGIN();
    		doctor_login.jf.setVisible(true);
		}
		
	}
	/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Drug_Edit drug_edit = new Drug_Edit();
	}
*/
}
