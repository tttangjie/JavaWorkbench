package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import java.sql.*;
/*
 * 登陆界面
 */
public class LOGIN extends JFrame implements ActionListener{
	//添加JLabel
	JLabel login_id = new JLabel("账    号:");
	JLabel login_password = new JLabel("密    码:");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	//添加文本框
	JTextField tflogin_id = new JTextField(15);
	JPasswordField tflogin_password = new JPasswordField(15);

	//创建窗体对象
	JFrame jf = new JFrame("登陆");
	Connection con;
	
	public LOGIN() {
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置关闭事件
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//添加按钮
		JButton finish = new JButton("登陆");
		finish.addActionListener(this);
		//添加
		p1.add(login_id);
		p1.add(tflogin_id);
		p2.add(login_password);
		p2.add(tflogin_password);
		p3.add(p1);
		p3.add(p2);
		jf.add(p3);
		p4.add(finish);	
		jf.add(p4,BorderLayout.SOUTH);
		
		jf.setVisible(true);	
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand()=="登陆")
		{
			//进行判断，为空则不进行登录操作。
			if(tflogin_id.getText().isEmpty()||tflogin_password.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "请输入用户名和密码", "提示信息", JOptionPane.WARNING_MESSAGE);
				
			}
			else
			//调用登录方法
			{
				this.login();
				jf.setVisible(false);
			}
		}
	}		
	
	public void login() {
		connect s=new connect();
		con=s.getConnection();
		s.SQLverify(tflogin_id.getText(), tflogin_password.getText());
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		LOGIN login = new LOGIN();
	}

}
