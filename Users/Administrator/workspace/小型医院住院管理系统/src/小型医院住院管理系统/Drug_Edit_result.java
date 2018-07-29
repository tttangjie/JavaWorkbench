package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 药品修改结果界面
 */
public class Drug_Edit_result implements ActionListener {
	//创建窗体对象
			JFrame jf = new JFrame("药品修改结果");
			//添加label
			Label drug_name = new Label("药品名称:");
			Label drug_number = new Label("药品增长数量:");
			Label drug_price = new Label("药品价格:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			JPanel p5 = new JPanel();
			//添加文本框
			TextField tfdrug_name = new TextField(15);
			TextField tfdrug_number = new TextField(15);
			TextField tfdrug_price = new TextField(15);
			String id; 
			//添加按钮
			Button finish = new Button("完成");
	public Drug_Edit_result(String id) {
		this.id=id;
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
		
		//添加
		p1.add(drug_name);
		p1.add(tfdrug_name);
		p2.add(drug_number); 
		p2.add(tfdrug_number);
		p3.add(drug_price);
		p3.add(tfdrug_price);
		p4.add(p1);
		p4.add(p2); 
		p4.add(p3); 
		jf.add(p4);
		p5.add(finish);
		jf.add(p5,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String name = tfdrug_name.getText();
			String number = tfdrug_number.getText();
			String price = tfdrug_price.getText();
			connect s = new connect();
			s.getConnection();
			s.DER(id, name, number,price);
			jf.setVisible(false);
		}
		
	}
	
/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Drug_Edit_result drug_edit_result = new Drug_Edit_result();

	}
*/
}
