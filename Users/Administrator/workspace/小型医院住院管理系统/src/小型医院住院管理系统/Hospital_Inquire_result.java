package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * סԺ��ѯ�������
 */
public class Hospital_Inquire_result {
	public Hospital_Inquire_result(String a,String b,String c,String d,String e,String f,String g,String h) {
		//�����������
		JFrame jf = new JFrame("סԺ��ѯ���");
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
		Label patient_id = new Label("���˱��:");
		Label patient_name = new Label("��������:");
		Label sex = new Label("�Ա�:");
		Label age = new Label("����:");
		Label patient_phone = new Label("��ϵ��ʽ:");
		Label premoney = new Label("Ԥ����:");
		Label room_id = new Label("������:");
		Label bed_number = new Label("��λ��:");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		//�����Ϣ
		Label tfpatient_id = new Label(a);
		Label tfpatient_name = new Label(b);
		Label tfsex = new Label(c);
		Label tfage = new Label(d);
		Label tfpatient_phone = new Label(f);
		Label tfpremoney = new Label(e);
		Label tfroom_id = new Label(g);
		Label tfbed_number = new Label(h);
		//���
		p1.add(patient_id);
		p1.add(tfpatient_id);
		p2.add(patient_name);
		p2.add(tfpatient_name);
		p3.add(sex);
		p3.add(tfsex);
		p4.add(age);
		p4.add(tfage);
		p5.add(patient_phone);
		p5.add(tfpatient_phone);
		p6.add(premoney);
		p6.add(tfpremoney);
		p7.add(room_id);
		p7.add(tfroom_id);
		p8.add(bed_number);
		p8.add(tfbed_number);
		p9.add(p1); 
		p9.add(p2); 
		p9.add(p3); 
		p9.add(p4);
		p9.add(p5);
		p9.add(p6);
		p9.add(p7);
		p9.add(p8);
		jf.add(p9);

		jf.setVisible(true);
	}
/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Hospital_Inquire_result hospital_inquire_result = new Hospital_Inquire_result();
	}
*/
}
