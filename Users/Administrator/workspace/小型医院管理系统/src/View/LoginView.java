package View;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Model.Admin;
import Dao.Dao;

public class LoginView extends JFrame{
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JButton exit;
	private JButton login;
	private MainView window;
	private static Admin user ;
	public LoginView(){
		setTitle("С��ҽԺ����ϵͳ");
		setBounds(100,100,336,206);
		//��������
		/*JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		this.setContentPane(contentPane);*/
		final JPanel panel = new JPanel();
		panel.setBounds(0,0,350,170);
		getContentPane().add(panel);
		panel.setLayout(null);
		//�û�����
		userLabel = new JLabel();
		userLabel.setText("�û�����");
		userLabel.setBounds(52, 33, 54, 15);
		panel.add(userLabel);
		final JTextField userName = new JTextField();
		userName.setBounds(116, 30, 139, 21);
		panel.add(userName);
	
		//�����
		passwordLabel = new JLabel();
		passwordLabel.setText("�� �룺");
		passwordLabel.setBounds(52, 74, 54, 15);
		panel.add(passwordLabel);
		final JPasswordField userPassword = new JPasswordField();
		userPassword.addKeyListener(new KeyAdapter(){
			public void keyPressed(final KeyEvent e){
				if(e.getKeyCode()==10)
					login.doClick();
			}
		});
		userPassword.setBounds(116,71,139,21);
		panel.add(userPassword);
		
		//��¼��ť
		login = new JButton();
		login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				    user = Dao.LoginDao(Integer.parseInt(userName.getText()),userPassword.getText());
				    if(user!=null){
				    	setVisible(false);
				    	window=new MainView();
				    	window.frame.setVisible(true);
				    	//System.out.println("id:" + user.getId() + "\tname:" + user.getName() + "password:" + user.getPassword());
				    }
				    else{
				    	
				    	System.out.println("fail");
				    }
				    	
			}
		});
		login.setText("��¼");
		login.setBounds(64,116,69,23);
		panel.add(login);
		
		//�˳���ť
		exit = new JButton();
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}	
		});
		exit.setText("�˳�");
		exit.setBounds(174,116,69,23);
		panel.add(exit);
		
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	
    public static Admin getUser(){
	     return user;
    }
    public static void setUser(Admin user){
    	LoginView.user=user;
    }
	public static void main(String args[]){
		
		LoginView loginview = new LoginView();
	}
	}
	


