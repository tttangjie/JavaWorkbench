package com.frame;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mybaties.util.CaseOperate;
import com.po.MedicalCase;

public class DoctorFrame extends JFrame implements ActionListener {
	private Button ok,reset;
	private TextField tfpno,tfdno,tfmno,tfbno,tfday;
	public DoctorFrame(){
		super("�������");
		this.setSize(450,400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		Label lpno = new Label("���˱��:");
		Label ldno = new Label("����ҽʦ:");
		Label lmno = new Label("ҩƷ����:");
		Label lbno = new Label("��λ���:");
		Label lday = new Label("סԺ����:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();

		//����ı���
		tfpno = new TextField(15);
		tfdno = new TextField(15);
		tfmno = new TextField(15);
		tfbno= new TextField(15);
		tfday = new TextField(15);
		//��Ӱ�ť
		ok = new Button("���");
		reset = new Button("����");
		
		jp1.add(lpno);
		jp1.add(tfpno);
		jp2.add(ldno);
		jp2.add(tfdno);
		jp3.add(lmno);
		jp3.add(tfmno);
		jp4.add(lbno);
		jp4.add(tfbno);
		jp5.add(lday);
		jp5.add(tfday);
		jp6.add(ok).setFont(new Font("����",1,15));
		jp6.add(reset).setFont(new Font("����",1,15));

		
		
		jp1.setBounds(0,10, 300, 40);
		this.add(jp1);
		jp2.setBounds(0,50, 300,40);
		this.add(jp2);
		jp3.setBounds(0,90,300,40);
		this.add(jp3);
		jp4.setBounds(0,130,300,40);
		this.add(jp4);
		jp5.setBounds(0,170,300,40);
		this.add(jp5);
		jp6.setBounds(0,210,300,40);
		this.add(jp6);
		
		ok.addActionListener(this);
		reset.addActionListener(this);
		this.setVisible(true);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent ev){ 
		if(ev.getSource()==reset){
			clear();
		}
		if(ev.getSource()==ok){
			MedicalCase ca=new MedicalCase();
			ca.setPno(tfpno.getText());
			ca.setDno(tfdno.getText());
			ca.setMno(tfmno.getText());
			ca.setBno(tfbno.getText());
			CaseOperate.insertCase(ca);
		}
	}
	public  void clear()  
    {  
        tfpno.setText(" ");  
        tfbno.setText(" ");  
        tfdno.setText(" ");  
        tfmno.setText(" ");  
        tfday.setText(" ");  
    } 
}
