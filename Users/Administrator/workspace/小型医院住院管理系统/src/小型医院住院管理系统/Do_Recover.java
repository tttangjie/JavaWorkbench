package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ��Ժ�������
 */
public class Do_Recover implements ActionListener{
	//�����������
			JFrame jf = new JFrame("��Ժ����");
			//���label
			Label patient_id = new Label("���˱��:");
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			//����ı���
			final TextField tfpatient_id = new TextField(15);
			//��Ӱ�ť
			Button finish = new Button("ȷ��");		
			
	
	public Do_Recover() {
		
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
		jf.add(p2);	
		jf.add(p2,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		
		jf.setVisible(true);	
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			jf.setVisible(false);
			String patient_id = tfpatient_id.getText();
			connect s = new connect();
			s.getConnection();
			s.DR(patient_id);
			connect q = new connect();
			q.getConnection();
			q.DP(patient_id);
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Do_Recover do_recover = new Do_Recover();
	}
}
