package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ҩƷ�޸Ľ������
 */
public class Drug_Edit_result implements ActionListener {
	//�����������
			JFrame jf = new JFrame("ҩƷ�޸Ľ��");
			//���label
			Label drug_name = new Label("ҩƷ����:");
			Label drug_number = new Label("ҩƷ��������:");
			Label drug_price = new Label("ҩƷ�۸�:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			JPanel p5 = new JPanel();
			//����ı���
			TextField tfdrug_name = new TextField(15);
			TextField tfdrug_number = new TextField(15);
			TextField tfdrug_price = new TextField(15);
			String id; 
			//��Ӱ�ť
			Button finish = new Button("���");
	public Drug_Edit_result(String id) {
		this.id=id;
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
		
		//���
		p1.add(drug_name);
		p1.add(tfdrug_name);
		p2.add(drug_number); 
		p2.add(tfdrug_number);
		p3.add(drug_price);
		p3.add(tfdrug_price);
		p4.add(p1);
		p4.add(p2); 
		p4.add(p3); 
		jf.add(p4);
		p5.add(finish);
		jf.add(p5,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			String name = tfdrug_name.getText();
			String number = tfdrug_number.getText();
			String price = tfdrug_price.getText();
			connect s = new connect();
			s.getConnection();
			s.DER(id, name, number,price);
			jf.setVisible(false);
		}
		
	}
	
/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Drug_Edit_result drug_edit_result = new Drug_Edit_result();

	}
*/
}
