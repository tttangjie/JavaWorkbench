package com.tj.frame;

import java.awt.Button;


import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelFrame extends JFrame implements ActionListener{
	private JPanel jp;
	private Button pok,pback,dok,dback,depok,depback,mok,mback,bok,bback;
	public JPanelFrame(){
		jp=new JPanel(); 
		jp.removeAll();
		jp.setSize(450,400); 
		ImageIcon icon=new ImageIcon("src/com/tj/frame/init.jpg");
		JLabel Imagelabel=new JLabel(icon);
		jp.add(Imagelabel);
		jp.setVisible(true);
		
	}
	
	public void JPAddPatient(){
		Label lpno = new Label("病人编号:");
		Label lpname = new Label("病人姓名:");
		Label lpsex = new Label("病人性别:");
		Label lpage= new Label("病人年龄:");
		Label lpid = new Label("身份证号:");
		Label lptel = new Label("联系方式:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		//添加文本框
		TextField tfpno = new TextField(15);
		TextField tfpname = new TextField(15);
		TextField tfpsex = new TextField(15);
		TextField tfpage= new TextField(15);
		TextField tfpid = new TextField(15);
		TextField tfptel = new TextField(15);
		//添加按钮
		pok = new Button("添加");
		pback = new Button("返回");
		jp.removeAll();
		jp.setSize(450,400); 
		jp.setLayout(null);
		
		jp1.add(lpno);
		jp1.add(tfpno);
		jp2.add(lpname);
		jp2.add(tfpname);
		jp3.add(lpsex);
		jp3.add(tfpsex);
		jp4.add(lpage);
		jp4.add(tfpage);
		jp5.add(lpid);
		jp5.add(tfpid);
		jp6.add(lptel);
		jp6.add(tfptel);
		jp7.add(pok).setFont(new Font("宋体",1,15));
		jp7.add(pback).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		
		jp.add(jp3);
		jp4.setBounds(0,130,300,40);
		jp.add(jp4);
		jp5.setBounds(0,170,300,40);
		jp.add(jp5);
		jp6.setBounds(0,210,300,40);
		jp.add(jp6);
		jp7.setBounds(0, 260, 300, 40);
		jp.add(jp7);
		
		pok.addActionListener(this);
		pback.addActionListener(this);
		jp.setVisible(true);
		
	}
	
	public void JPManagePatient(){
		jp.removeAll();
		jp.setSize(450,400); 
		jp.setBackground(Color.RED);    
		jp.setVisible(true);
	}
	
	public void JPAddDoctor(){
		Label ldno = new Label("医生编号:");
		Label ldname = new Label("医生姓名:");
		Label ldsex = new Label("医生性别:");
		Label ldage= new Label("医生年龄:");
		Label ldid = new Label("身份证号:");
		Label ldtel = new Label("联系方式:");
		Label ldepno = new Label("科室编号:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		JPanel jp8 = new JPanel();
		//添加文本框
		TextField tfdno = new TextField(15);
		TextField tfdname = new TextField(15);
		TextField tfdsex = new TextField(15);
		TextField tfdage= new TextField(15);
		TextField tfdid = new TextField(15);
		TextField tfdtel = new TextField(15);
		TextField tfdepno = new TextField(15);
		//添加按钮
		dok = new Button("添加");
		dback = new Button("返回");
		jp.removeAll();
		jp.setSize(450,400); 
		jp.setLayout(null);
		
		jp1.add(ldno);
		jp1.add(tfdno);
		jp2.add(ldname);
		jp2.add(tfdname);
		jp3.add(ldsex);
		jp3.add(tfdsex);
		jp4.add(ldage);
		jp4.add(tfdage);
		jp5.add(ldid);
		jp5.add(tfdid);
		jp6.add(ldtel);
		jp6.add(tfdtel);
		jp7.add(ldepno);
		jp7.add(tfdepno);
		jp8.add(dok).setFont(new Font("宋体",1,15));
		jp8.add(dback).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,130,300,40);
		jp.add(jp4);
		jp5.setBounds(0,170,300,40);
		jp.add(jp5);
		jp6.setBounds(0,210,300,40);
		jp.add(jp6);
		jp7.setBounds(0, 250, 300, 40);
		jp.add(jp7);
		jp8.setBounds(0, 300, 300, 40);
		jp.add(jp8);
		
		dok.addActionListener(this);
		dback.addActionListener(this);
		jp.setVisible(true);
		
	}
	
	public void JPManageDoctor(){
		jp.removeAll();
		jp.setSize(600,500); 
		jp.setBackground(Color.RED);    
		jp.setVisible(true);
	}	
	
	public void JPAddDepartment(){
		jp.removeAll();
		jp.setSize(600,500); 
		jp.setBackground(Color.BLUE);    
		jp.setVisible(true);
	}
	
	public void JPManageDeptartment(){
		jp.removeAll();
		jp.setSize(600,500); 
		jp.setBackground(Color.RED);    
		jp.setVisible(true);
	}
	
	public void JPAddMedicine(){
		jp.removeAll();
		jp.setSize(600,500); 
		jp.setBackground(Color.BLUE);    
		jp.setVisible(true);
	}
	
	public void JPManageMedicine(){
		jp.removeAll();
		jp.setSize(600,500); 
		jp.setBackground(Color.RED);    
		jp.setVisible(true);
	}
	
	public void JPAddBed(){
		jp.removeAll();
		jp.setSize(600,500); 
		jp.setBackground(Color.BLUE);    
		jp.setVisible(true);
	}
	
	public void JPManageBed(){
		jp.removeAll();
		jp.setSize(600,500); 
		jp.setBackground(Color.RED);    
		jp.setVisible(true);
	}
	
	public JPanel getJp() {
		return jp;
	}
	public void setJp(JPanel jp) {
		this.jp = jp;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==pback){
			jp.removeAll();
			jp.setSize(450,400); 
			ImageIcon icon=new ImageIcon("src/com/tj/frame/hospital_logo.jpg");
			JLabel Imagelabel=new JLabel(icon);
			jp.add(Imagelabel);
			jp.setVisible(true);
		}
		/////////////////
		if(ev.getSource()==pok){
			
		}
		
		if(ev.getSource()==dback){
			jp.removeAll();
			jp.setSize(450,400); 
			ImageIcon icon=new ImageIcon("src/com/tj/frame/hospital_logo.jpg");
			JLabel Imagelabel=new JLabel(icon);
			jp.add(Imagelabel);
			jp.setVisible(true);
		}
		
		////////////////
		if(ev.getSource()==dok){
			
		}
		
	}
	
}
