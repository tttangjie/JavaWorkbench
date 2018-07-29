package С��ҽԺסԺ����ϵͳ;
import java.awt.event.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class DOCTOR_LOGIN  implements ActionListener{
	JFrame jf = new JFrame();
	JMenuBar doctor_menuBar = new JMenuBar();
	//�˵�
	JMenu prescription = new JMenu("ҩ��");
	JMenu drug_manage = new JMenu("ҩƷ");
	JMenu other = new JMenu("����...");
	
	//�˵���
	JMenuItem make_prescription = new JMenuItem("��ҩ��");
	JMenuItem drug_inquire = new JMenuItem("ҩƷ��ѯ");
	JMenuItem drug_edit = new JMenuItem("ҩƷ�޸�");
	JMenuItem exit = new JMenuItem("�˳���½");
	
	
	public DOCTOR_LOGIN(){
		super();
		jf.setTitle("ҽ����½����");
		jf.setBounds(200,200,480,320);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���˵�����ӵ��˵�
		prescription.add(make_prescription);
		drug_manage.add(drug_inquire);
		drug_manage.add(drug_edit);
		other.add(exit);
		//���˵���ӵ��˵���
		doctor_menuBar.add(prescription);
		doctor_menuBar.add(drug_manage);
		doctor_menuBar.add(other);
		//���˵�����ӵ�����
		jf.setJMenuBar(doctor_menuBar);
		make_prescription.addActionListener(this);
		drug_inquire.addActionListener(this);
		drug_edit.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==make_prescription){
			new Make_Prescription();
			jf.setVisible(false);
		}
		
		if(e.getSource()==drug_inquire){
			new Drug_Inquire();
			jf.setVisible(false);
		}
		
		if(e.getSource()==drug_edit){
			new Drug_Edit();
			jf.setVisible(false);
		}
		
		if(e.getSource()==exit){
			new LOGIN();
			jf.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		DOCTOR_LOGIN doctor_login = new DOCTOR_LOGIN();
		doctor_login.jf.setVisible(true);
	}

}
