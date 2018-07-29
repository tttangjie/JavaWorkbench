package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import Model.Admin;
public class MainView {
	private JMenuBar menuBar;
	protected JFrame frame;
	private Admin user  = LoginView.getUser();
	private JFrame window;
	public MainView(){
		Font font = new Font("����",Font.PLAIN,14);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);
		init();
	}
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new LoginView();
			}
		});
	}

	public void init(){
		frame = new JFrame("С��ҽԺ����ϵͳ");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100,100,600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 792, 66);
		menuBar.setBorder(new LineBorder(Color.BLACK));
		frame.setJMenuBar(menuBar);
		menuBar.add(getDoctorMenu());
		menuBar.add(getMedicineMenu());
		menuBar.add(getPatientMenu());
		menuBar.add(getMoneyMenu());
		final JPanel panel = new JPanel();
		panel.setBounds(0,0,550,370);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JButton login = new JButton();
		login.setText("���µ�¼");
		login.setBounds(100, 300, 89, 23);
		panel.add(login);
		login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
		    	window=new LoginView();
		    	window.setVisible(true);
			}	
		});
		JButton exit = new JButton();
		exit.setText("�˳�ϵͳ");
		exit.setBounds(400, 300, 89, 23);
		panel.add(exit);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}	
		});
		
		JLabel wlabel = new JLabel();
		wlabel.setText("Welcome to this system , "+user.getName()+"����Ա");
		wlabel.setBounds(130, 180, 390, 30);
		wlabel.setFont(new Font("����",1,15));
		panel.add(wlabel);
	}
	
	//��Ӳ˵�
	private void MenuManager(JMenu menu,int f){
		JMenuItem menuitem1 = null;
		if(judgeAdmin()==1){
			menuitem1 = addMenuItem(menu,"��ѯ��Ϣ");
		}
		if(judgeAdmin()==2){
			menuitem1 = addMenuItem(menu,"��ѯ��Ϣ");
			JMenuItem menuitem2 = addMenuItem(menu,"������Ϣ");
			menuitem2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						switch(f){
						case 1: window=new DoctorManageView();break;
						case 2: window=new MedicineManage();break;
						case 3: window=new PatientManage();break;
						}
						window.setVisible(true);					    	
				}
			});
		}
		menuitem1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					switch(f){
					case 1: window=new DoctorSearchView();break;
					case 2: window=new MedicineSearch();break;
					case 3: window=new PatientSearch();break;
					}
					window.setVisible(true);					    	
			}
		});
	}
	//�Ӳ˵�
	public JMenu getDoctorMenu(){
		JMenu menu = new JMenu();
		menu.setText("ҽ����Ϣ����");
		MenuManager(menu,1);
		return menu;
	}
	public JMenu getMedicineMenu(){
		JMenu menu = new JMenu();
		menu.setText("ҩƷ��Ϣ����");
		MenuManager(menu,2);
		return menu;
	}
	public JMenu getPatientMenu(){
		JMenu menu = new JMenu();
		menu.setText("������Ϣ����");
		MenuManager(menu,3);
		return menu;
	}
	public JMenu getMoneyMenu(){
		JMenu menu = new JMenu();
		menu.setText("�ɷѹ���");
		JMenuItem menuitem3 =addMenuItem(menu,"��Ժ�ɷ�");
		menuitem3.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					window=new JiaoFei();
					window.setVisible(true);					    	
			}
		});
		return menu;
	}
	/*
	//������˵���ĵ����¼������� 
    protected final class openFrameAction extends AbstractAction{

		private String frameName = null;
		private openFrameAction(){
		}
		public openFrameAction(String name){
			
			putValue(Action.NAME,name);
			putValue(Action.SHORT_DESCRIPTION,name);
			
		}
		public void actionPerformed(final ActionEvent e) {
			JInternalFrame jf = getIFrame(frameName);  //��ȡ�������
			//���ڲ�����ر�ʱ�����ڲ���������ifs����������ô���
			jf.addInternalFrameListener(new InternalFrameAdapter(){
				public void internalFrameClosed(InternalFrameEvent e){
					ifs.remove(frameName);
				}
			});
			if(jf.getDesktopPane()==null){
				desktopPane.add(jf);
				jf.setVisible(true);
			}
			try{
				jf.setSelected(true);
			}catch(PropertyVetoException e1){
				e1.printStackTrace();
			}
		}
    	
    }
    private void addFrameAction(String name,JMenu menu){
    	
    }
    
    //��ȡ���巽��
    private JInternalFrame getIFrame(String frameName){
    	JInternalFrame jf=null;
    	if(!ifs.containsKey(frameName)){
    		try{
    			jf= (JInternalFrame)Class.forName(
    					"internalFrame."+frameName).getConstructor(null).newInstance(null);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else
    		jf = ifs.get(frameName);
    	return jf;
    }*/
    private JMenuItem addMenuItem(JMenu menu,String name){
    	JMenuItem menuitem = new JMenuItem(name);
    	menu.add(menuitem);
    	return menuitem;
    }
	public int judgeAdmin(){
		return user.getLevel();
	}
    }
