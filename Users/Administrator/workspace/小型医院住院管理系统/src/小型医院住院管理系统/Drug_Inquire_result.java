package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ҩƷ��ѯ�������
 */
public class Drug_Inquire_result {
	public Drug_Inquire_result(String a,String b,String c,String d) {
		//�����������
		JFrame jf = new JFrame("ҩƷ��ѯ���"); 
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
		Label drug_id = new Label("ҩƷ���:");
		Label name = new Label("ҩƷ����:");
		Label number = new Label("ҩƷ����:");
		Label price = new Label("ҩƷ�۸�:");
		//�����Ϣ
		Label tfdrug_id = new Label(a);
		Label tfname = new Label(b);
		Label tfnumber = new Label(c);
		Label tfprice = new Label(d);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		//���
		p1.add(drug_id);
		p1.add(tfdrug_id);
		p2.add(name);
		p2.add(tfname);
		p3.add(number);
		p3.add(tfnumber);
		p4.add(price);
		p4.add(tfprice);
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		jf.add(p5);
		
		jf.setVisible(true);
	}
/*
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Drug_Inquire_result drug_inquire_result = new Drug_Inquire_result();
	}
*/
}
