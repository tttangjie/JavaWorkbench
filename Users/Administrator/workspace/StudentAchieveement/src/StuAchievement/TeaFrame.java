package StuAchievement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TeaFrame extends JFrame implements ActionListener{
	private Button ok,cancel;
	private TextField name,pass;
	public TeaFrame()
	{
		super("教师登陆");
		this.setSize(200,130);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		this.add(new Label("admin       "));
		name=new TextField("Teacher",10);
		this.add(name);
		this.add(new Label("password"));
		pass=new TextField(10);
		this.add(pass);
		ok=new Button("ok");
		cancel=new Button("cancel");
		this.add(ok);
		this.add(cancel);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		this.setVisible(true);
		this.setResizable(false);//固定框架
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		public void actionPerformed(ActionEvent ev) {
			if(ev.getSource()==ok)
			{
				if(pass.getText().equals("123"))///////////////
				{
					this.setVisible(false);
					new MenuFrame();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"密码输入错误，请输入正确的密码！");
				}
			}
			else if(ev.getSource()==cancel)
			{
				 this.dispose();//点击按钮仅关闭窗口
				 new InitialInterface("医院管理系统");
			}
	}
}
