package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ������ӽ���
 */
public class Office_Add implements ActionListener{
	//�����������
			JFrame jf = new JFrame("�������");
			//���label
			Label office_id = new Label("���Һ�:");
			Label office_name = new Label("������:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			//����ı���
			TextField tfoffice_id = new TextField(15);
			TextField tfoffice_name = new TextField(15);
			//��Ӱ�ť
			Button finish = new Button("���");
			Button back = new Button("����");
	
	public Office_Add() {
		
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���
		p1.add(office_id);
		p1.add(tfoffice_id);
		p2.add(office_name);
		p2.add(tfoffice_name);
		p3.add(p1);
		p3.add(p2);
		jf.add(p3);
		p4.add(finish);
		p4.add(back);
		jf.add(p4,BorderLayout.SOUTH);
		finish.addActionListener(this);
		back.addActionListener(this);
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String office_id = tfoffice_id.getText();
			String office_name = tfoffice_name.getText();
			connect s = new connect();
			s.getConnection();
			s.OA(office_id, office_name);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Office_Add office_add = new Office_Add();
	}

}
