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
		Font font = new Font("宋体",Font.PLAIN,14);
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
		frame = new JFrame("小型医院管理系统");
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
		login.setText("重新登录");
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
		exit.setText("退出系统");
		exit.setBounds(400, 300, 89, 23);
		panel.add(exit);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}	
		});
		
		JLabel wlabel = new JLabel();
		wlabel.setText("Welcome to this system , "+user.getName()+"操作员");
		wlabel.setBounds(130, 180, 390, 30);
		wlabel.setFont(new Font("黑体",1,15));
		panel.add(wlabel);
	}
	
	//添加菜单
	private void MenuManager(JMenu menu,int f){
		JMenuItem menuitem1 = null;
		if(judgeAdmin()==1){
			menuitem1 = addMenuItem(menu,"查询信息");
		}
		if(judgeAdmin()==2){
			menuitem1 = addMenuItem(menu,"查询信息");
			JMenuItem menuitem2 = addMenuItem(menu,"管理信息");
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
	//子菜单
	public JMenu getDoctorMenu(){
		JMenu menu = new JMenu();
		menu.setText("医生信息管理");
		MenuManager(menu,1);
		return menu;
	}
	public JMenu getMedicineMenu(){
		JMenu menu = new JMenu();
		menu.setText("药品信息管理");
		MenuManager(menu,2);
		return menu;
	}
	public JMenu getPatientMenu(){
		JMenu menu = new JMenu();
		menu.setText("病人信息管理");
		MenuManager(menu,3);
		return menu;
	}
	public JMenu getMoneyMenu(){
		JMenu menu = new JMenu();
		menu.setText("缴费管理");
		JMenuItem menuitem3 =addMenuItem(menu,"出院缴费");
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
	//主窗体菜单项的单击事件监听器 
    protected final class openFrameAction extends AbstractAction{

		private String frameName = null;
		private openFrameAction(){
		}
		public openFrameAction(String name){
			
			putValue(Action.NAME,name);
			putValue(Action.SHORT_DESCRIPTION,name);
			
		}
		public void actionPerformed(final ActionEvent e) {
			JInternalFrame jf = getIFrame(frameName);  //获取窗体对象
			//在内部窗体关闭时，从内部窗体容器ifs对象中清除该窗体
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
    
    //获取窗体方法
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
