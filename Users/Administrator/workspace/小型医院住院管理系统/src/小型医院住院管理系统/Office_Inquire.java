package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ���Ҳ�ѯ����
 */
public class Office_Inquire implements ActionListener{
	//�����������
			JFrame jf = new JFrame("���Ҳ�ѯ");
			//���label
			Label office_id = new Label("���ұ��:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			//����ı���
			TextField tfoffice_id = new TextField(15);
			//��Ӱ�ť
			Button finish = new Button("��ѯ");
			Button back = new Button("����"); 
	
	public Office_Inquire() {

		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ò���
		jf.setLayout(new FlowLayout());
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���
		p1.add(office_id);
		p1.add(tfoffice_id);
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
			String office_id = tfoffice_id.getText();
			connect s = new connect();
			s.getConnection();
			s.OI(office_id);
		}
		else if(e.getSource()==back){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Office_Inquire office_inquire = new Office_Inquire();
	}

}
