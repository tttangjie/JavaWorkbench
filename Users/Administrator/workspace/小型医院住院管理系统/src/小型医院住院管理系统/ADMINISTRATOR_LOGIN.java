package С��ҽԺסԺ����ϵͳ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
@SuppressWarnings("serial")

public class ADMINISTRATOR_LOGIN implements ActionListener{
	JFrame jf = new JFrame();
	JMenuBar administrator_menuBar = new JMenuBar();
	//�˵�
			JMenu hospital_manage = new JMenu("סԺ����");
			JMenu office_manage = new JMenu("���ҹ���");
			JMenu doctor_manage = new JMenu("ҽ������");
			JMenu recover  = new JMenu("��Ժ����");
			JMenu other = new JMenu("����...");
			//�˵���
			JMenuItem hospital_in = new JMenuItem("סԺ����");
			JMenuItem hospital_inquire = new JMenuItem("סԺ��ѯ");
			JMenuItem office_add = new JMenuItem("�������");
			JMenuItem office_inquire = new JMenuItem("���Ҳ�ѯ");
			JMenuItem doctor_add = new JMenuItem("ҽ�����");
			JMenuItem doctor_delete = new JMenuItem("ҽ��ɾ��");
			JMenuItem doctor_inquire = new JMenuItem("ҽ����ѯ");
			JMenuItem do_rceover = new JMenuItem("��Ժ����");
			JMenuItem exit = new JMenuItem("�˳���½");
	public ADMINISTRATOR_LOGIN(){
		super();
		jf.setTitle("����Ա��½����");
		jf.setBounds(200,200,480,320);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���˵�����ӵ��˵�
		hospital_manage.add(hospital_in);
		hospital_manage.add(hospital_inquire);
		office_manage.add(office_add);
		office_manage.add(office_inquire);
		doctor_manage.add(doctor_add);
		doctor_manage.add(doctor_delete);
		doctor_manage.add(doctor_inquire);
		recover.add(do_rceover);
		other.add(exit);
		//���˵���ӵ��˵���
		administrator_menuBar.add(hospital_manage);
		administrator_menuBar.add(office_manage);
		administrator_menuBar.add(doctor_manage);
		administrator_menuBar.add(recover);
		administrator_menuBar.add(other);
		//���˵�����ӵ�����
		jf.setJMenuBar(administrator_menuBar);
		hospital_in.addActionListener(this);
		hospital_inquire.addActionListener(this);
		office_add.addActionListener(this);
		office_inquire.addActionListener(this);
		doctor_add.addActionListener(this);
		doctor_delete.addActionListener(this);
		doctor_inquire.addActionListener(this);
		do_rceover.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==hospital_in){
			new Hospital_In();
			jf.setVisible(false);
		}
		
		if(e.getSource()==hospital_inquire){
			new Hospital_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==office_add){
			new Office_Add();
			jf.setVisible(false);
		}
		
		if(e.getSource()==office_inquire){
			new Office_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==doctor_add){
			new Doctor_Add();
			jf.setVisible(false);
		}
		
		if(e.getSource()==doctor_delete){
			new Doctor_Delete();
			jf.setVisible(false);
		}
		
		if(e.getSource()==doctor_inquire){
			new Doctor_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==do_rceover){
			new Do_Recover();
			jf.setVisible(false);
		}

		if(e.getSource()==exit){
			new LOGIN();
			jf.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
		administrator_login.jf.setVisible(true);
	}

}
