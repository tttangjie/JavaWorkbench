package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ��Ժ������1-��Ǯ����
 */
public class Do_Recover_result1 implements ActionListener{
	//�����������
			JFrame jf = new JFrame("��Ǯ");
			//��Ӱ�ť
			Button finish = new Button("ȷ��");
	public Do_Recover_result1(float a) {
		
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���label
		Label out_money = new Label("��Ǯ:");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		//����ı���
		String m=a+"";
		Label tfout_money = new Label(m);
		
		//���
		p1.add(out_money);
		p1.add(tfout_money);
		jf.add(p1);
		p2.add(finish);
		jf.add(p2,BorderLayout.SOUTH);
		
		finish.addActionListener(this);
		
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==finish){
			jf.setVisible(false);
			ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
    		administrator_login.jf.setVisible(true);
		}
	}
	
	/*
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Do_Recover_result1 do_recover_result1 = new Do_Recover_result1();
	}
*/
}
