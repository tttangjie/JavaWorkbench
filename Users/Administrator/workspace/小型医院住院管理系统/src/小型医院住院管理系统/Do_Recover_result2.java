package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ��Ժ������2-��������
 */
public class Do_Recover_result2 implements ActionListener{
	//�����������
			JFrame jf = new JFrame("����");
			//��Ӱ�ť
			Button finish = new Button("ȷ��");		
	public Do_Recover_result2(float a) {
		
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���label
		Label in_money = new Label("����:");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		//����ı���
		String m=a+"";
		Label tfin_money = new Label(m);
		
		//���
		p1.add(in_money);
		p1.add(tfin_money);
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
		Do_Recover_result2 do_recover_result2 = new Do_Recover_result2();
	}
*/
}
