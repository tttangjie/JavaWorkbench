package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ���Ҳ�ѯ�������
 */
public class Office_Inquire_result {
	public Office_Inquire_result(String a,String b,String c) {
		//�����������
		JFrame jf = new JFrame("���Ҳ�ѯ���");
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ùر��¼�
		jf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ee){
				jf.setVisible(false);
			}
		});
		//���label
		Label office_id = new Label("���ұ��:");
		Label office_name = new Label("������:");
		Label doctor_number = new Label("ҽ������:");
		//�����Ϣ
		Label tfoffice_id = new Label(a);
		Label tfoffice_name = new Label(b);
		Label tfdoctor_number = new Label(c);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		//���
		p1.add(office_id);
		p1.add(tfoffice_id);
		p2.add(office_name);
		p2.add(tfoffice_name);
		p3.add(doctor_number);
		p3.add(tfdoctor_number);
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		jf.add(p4);
		
		jf.setVisible(true);
	}

/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Office_Inquire_result office_inquire_result = new Office_Inquire_result();
	}
*/
}
