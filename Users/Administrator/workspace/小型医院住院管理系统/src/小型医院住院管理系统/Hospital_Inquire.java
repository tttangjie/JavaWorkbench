package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * סԺ��ѯ����
 */
public class Hospital_Inquire implements ActionListener{
	//�����������
			JFrame jf = new JFrame("סԺ��ѯ");
			//���label
			Label patient_id = new Label("���˱��:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			//����ı���
			final TextField tfpatient_id = new TextField(15);
			//��Ӱ�ť
			Button finish = new Button("��ѯ");
			Button back = new Button("����");
			
	public Hospital_Inquire() {
		
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ò���
		jf.setLayout(new FlowLayout());
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���
		p1.add(patient_id);
		p1.add(tfpatient_id);
		jf.add(p1);
		p2.add(finish);
		p2.add(back);
		jf.add(p2);	
		jf.add(p2,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		back.addActionListener(this);
		
		jf.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String patient_id = tfpatient_id.getText();
			connect s = new connect();
			s.getConnection();
			s.HOSPITALI(patient_id);
		}
		else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
	}
	

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Hospital_Inquire hospital_inquire = new Hospital_Inquire();
	}

}
