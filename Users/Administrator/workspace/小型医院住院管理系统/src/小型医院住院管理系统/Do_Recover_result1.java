package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 出院结算结果1-找钱界面
 */
public class Do_Recover_result1 implements ActionListener{
	//创建窗体对象
			JFrame jf = new JFrame("找钱");
			//添加按钮
			Button finish = new Button("确定");
	public Do_Recover_result1(float a) {
		
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//添加label
		Label out_money = new Label("找钱:");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		//添加文本框
		String m=a+"";
		Label tfout_money = new Label(m);
		
		//添加
		p1.add(out_money);
		p1.add(tfout_money);
		jf.add(p1);
		p2.add(finish);
		jf.add(p2,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
	}
	
	/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Do_Recover_result1 do_recover_result1 = new Do_Recover_result1();
	}
*/
}
