package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ҽ����ӽ���
 */
public class Doctor_Add implements ActionListener{
	//�����������
			JFrame jf = new JFrame("ҽ�����");
			//���label
			Label doctor_id = new Label("ҽ�����:");
			Label doctor_name = new Label("����:");
			Label sex = new Label("�Ա�:");
			Label office_id = new Label("���Һ�:");
			Label phone = new Label("��ϵ��ʽ:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			JPanel p5 = new JPanel();
			JPanel p6 = new JPanel();
			JPanel p7 = new JPanel();
			//����ı���
			TextField tfdoctor_id = new TextField(15);
			TextField tfdoctor_name = new TextField(15);
			TextField tfsex = new TextField(15);
			TextField tfoffice_id = new TextField(15);
			TextField tfphone = new TextField(15);
			//��Ӱ�ť
			Button finish = new Button("���");
			Button back = new Button("����");
			
			
	public Doctor_Add() {
		
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���
		p1.add(doctor_id);
		p1.add(tfdoctor_id);
		p2.add(doctor_name);
		p2.add(tfdoctor_name);
		p3.add(sex);
		p3.add(tfsex);
		p4.add(office_id);
		p4.add(tfoffice_id);
		p5.add(phone);
		p5.add(tfphone);
		p6.add(p1);
		p6.add(p2);
		p6.add(p3);
		p6.add(p4);
		p6.add(p5);
		jf.add(p6);
		p7.add(finish);
		p7.add(back);
		jf.add(p7,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		back.addActionListener(this);
		
		jf.setVisible(true);
	}
	
public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String doctor_id = tfdoctor_id.getText();
			String doctor_name = tfdoctor_name.getText();
			String sex = tfsex.getText();
			String office_id = tfoffice_id.getText();
			String phone = tfphone.getText();
			connect s = new connect();
			s.getConnection();
			s.DA(doctor_id, doctor_name, sex, office_id,phone);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Doctor_Add doctor_add = new Doctor_Add();
	}

}
