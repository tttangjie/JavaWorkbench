package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ҩƷ��ѯ����
 */
public class Drug_Inquire implements ActionListener{
	
	//�����������
			JFrame jf = new JFrame("ҩƷ��ѯ");
			//���label
			Label drug_id = new Label("ҩƷ���:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			//����ı���
			TextField tfdrug_id = new TextField(15);
			//��Ӱ�ť
			Button finish = new Button("��ѯ");
			Button back = new Button("����");
			
	public Drug_Inquire() {
		
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ò���
		jf.setLayout(new FlowLayout());
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���
		p1.add(drug_id);
		p1.add(tfdrug_id);
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
			String drug_id = tfdrug_id.getText();
			connect s = new connect();
			s.getConnection();
			s.DRUGI(drug_id);
		}
		else if(e.getSource()==back){
			jf.setVisible(false);
			DOCTOR_LOGIN doctor_login = new DOCTOR_LOGIN();
    		doctor_login.jf.setVisible(true);
		}
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Drug_Inquire drug_inquire = new Drug_Inquire();
	}
}
