package С��ҽԺסԺ����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import java.sql.*;
/*
 * ��½����
 */
public class LOGIN extends JFrame implements ActionListener{
	//���JLabel
	JLabel login_id = new JLabel("��    ��:");
	JLabel login_password = new JLabel("��    ��:");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	//����ı���
	JTextField tflogin_id = new JTextField(15);
	JPasswordField tflogin_password = new JPasswordField(15);

	//�����������
	JFrame jf = new JFrame("��½");
	Connection con;
	
	public LOGIN() {
		//���ô�С
		jf.setSize(300, 300);
		//���þ���
		jf.setLocationRelativeTo(null);
		//���ùر��¼�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//��Ӱ�ť
		JButton finish = new JButton("��½");
		finish.addActionListener(this);
		//���
		p1.add(login_id);
		p1.add(tflogin_id);
		p2.add(login_password);
		p2.add(tflogin_password);
		p3.add(p1);
		p3.add(p2);
		jf.add(p3);
		p4.add(finish);	
		jf.add(p4,BorderLayout.SOUTH);
		
		jf.setVisible(true);	
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getActionCommand()=="��½")
		{
			//�����жϣ�Ϊ���򲻽��е�¼������
			if(tflogin_id.getText().isEmpty()||tflogin_password.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "�������û���������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				
			}
			else
			//���õ�¼����
			{
				this.login();
				jf.setVisible(false);
			}
		}
	}		
	
	public void login() {
		connect s=new connect();
		con=s.getConnection();
		s.SQLverify(tflogin_id.getText(), tflogin_password.getText());
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		LOGIN login = new LOGIN();
	}

}
