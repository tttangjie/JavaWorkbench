package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ��ҩ������
 */
public class Make_Prescription implements ActionListener{
	
	//�����������
		JFrame jf = new JFrame("��ҩ��");
		//���label
				Label patient_id = new Label("���˱��:");
				Label drug_id = new Label("ҩƷ���:");
				Label number = new Label("��        ��:");
				Label doctor_id = new Label("ҽ�����:");
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();
				JPanel p4 = new JPanel();
				JPanel p5 = new JPanel();
				JPanel p6 = new JPanel();
				//����ı���
				TextField tfpatient_id = new TextField(15);
				TextField tfdrug_id = new TextField(15);
				TextField tfnumber = new TextField(15);
				TextField tfdoctor_id = new TextField(15);
				//��Ӱ�ť
				Button finish = new Button("���");
				Button back = new Button("����");
				
	public Make_Prescription() {
		
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���
		p1.add(patient_id);
		p1.add(tfpatient_id);
		p2.add(drug_id);
		p2.add(tfdrug_id);
		p3.add(number);
		p3.add(tfnumber);
		p4.add(doctor_id);
		p4.add(tfdoctor_id);
		p5.add(p1);
		p5.add(p2);
		p5.add(p3); 
		p5.add(p4);
		jf.add(p5);
		p6.add(finish);
		p6.add(back);
		jf.add(p6,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		back.addActionListener(this);
		
		jf.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==finish){
			String patient_id = tfpatient_id.getText();
			String drug_id = tfdrug_id.getText();
			String number = tfnumber.getText();
			String doctor_id = tfdoctor_id.getText();
			connect s = new connect();
			s.getConnection();
			s.MP(patient_id, drug_id, number, doctor_id);
		}else if(e.getSource()==back){
			jf.setVisible(false);
			DOCTOR_LOGIN doctor_login = new DOCTOR_LOGIN();
    		doctor_login.jf.setVisible(true);
		}
		
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Make_Prescription make_prescription = new Make_Prescription();
	}
}
