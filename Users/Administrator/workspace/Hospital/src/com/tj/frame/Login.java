package com.tj.frame;

import java.awt.Button;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Login extends JFrame implements ActionListener{
	private JRadioButton doc,admin;
	private Button login,reset;
	private TextField name,pass;
	ButtonGroup bg;
	public Login(String title)
	{
		super(title);
		this.setSize(280,330);
		this.setLocationRelativeTo(null);//��ܾ���
		ImageIcon icon=new ImageIcon("src/com/tj/frame/hospital_logo.jpg");//����logo
		JLabel Imagelabel=new JLabel(icon);
		this.add(Imagelabel);
		this.setLayout(new FlowLayout());
		
		
		this.add(new Label("User         "));
		name=new TextField(17);
		this.add(name);
		this.add(new Label("password"));
		pass=new TextField(17);
		this.add(pass);
		
		doc = new JRadioButton(" ҽ��  ",true);
		admin = new JRadioButton(" ����Ա  ");
		this.add(doc).setFont(new Font("����",1,17));
		this.add(admin).setFont(new Font("����",1,17));
		bg = new ButtonGroup();
		bg.add(doc);
		bg.add(admin);
		
		
		login=new Button("           login           ");
		reset=new Button("           reset           ");
		this.add(login); 
		this.add(reset);
		login.addActionListener(this);
		reset.addActionListener(this);
		
		
		this.setVisible(true);
		this.setResizable(false);//�̶����
		this.addWindowListener(new WinClose());
	
	}
	
	public void actionPerformed(ActionEvent ev)//��ť�¼��ļ���
	{
		if(ev.getSource()==login)	{
			if(doc.isSelected()==true){
				this.setVisible(false);
				
			}
			if(admin.isSelected()){
				this.setVisible(false);
				new AdminFrame();
			}
		}
		else if(ev.getSource()==reset){
			clear();
		}
	}
	
	//����ı���������  
    public  void clear()  
    {  
        name.setText(" ");  
        pass.setText(" ");  
    }  
	
	class WinClose implements WindowListener
	{
		public void windowClosing(WindowEvent ev)
		{
			System.exit(0);
		}
		public void windowOpened(WindowEvent ev){}
		public void windowActivated(WindowEvent ev){}
		public void windowDeactivated(WindowEvent ev){}
		public void windowClosed(WindowEvent ev){}
		public void windowIconified(WindowEvent ev){}
		public void windowDeiconified(WindowEvent ev){}	
	}
}
