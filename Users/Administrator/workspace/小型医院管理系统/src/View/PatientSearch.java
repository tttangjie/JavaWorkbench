package View;

import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Dao.Dao;
import Model.*;

public class PatientSearch extends JFrame {
	private JTextField id ;
	private JTextField name;
	private JTextField room;
	private JTextField sex;
	private JTextField age;
	private JTextField money;
	private JTextField jiaofei;
	private JButton button1;
	public JButton menu_button;
	protected Patient p;
	private MainView window;
	public PatientSearch(){
		setTitle("病人信息查询");
		setBounds(100,100,400,300);
		JPanel panel = new JPanel();
		panel.setBounds(0,0,350,300);
		panel.setLayout(new GridBagLayout());
		getContentPane().add(panel);
		
		setupComponent(panel,new JLabel("病人编号："),0,3,1,1,false);
		id = new JTextField();
		setupComponent(panel,id,1,3,3,1,true);
		id.setEditable(false);
		
		setupComponent(panel,new JLabel("病人姓名："),0,0,1,1,false);
		name= new JTextField();
		setupComponent(panel,name,1,0,3,10,true);
		
		setupComponent(panel,new JLabel("病人性别："),0,6,1,1,false);
		sex = new JTextField();
		setupComponent(panel,sex,1,6,3,1,true);
		sex.setEditable(false);
		
		setupComponent(panel,new JLabel("病人年龄："),0,9,1,1,false);
		age= new JTextField();
		setupComponent(panel,age,1,9,3,10,true);
		age.setEditable(false);
		
		setupComponent(panel,new JLabel("病房位置："),0,12,1,1,false);
		room= new JTextField();
		setupComponent(panel,room,1,12,3,10,true);
		room.setEditable(false);
		
		setupComponent(panel,new JLabel("病人缴费："),0,15,1,1,false);
		money= new JTextField();
		setupComponent(panel,money,1,15,3,10,true);
		money.setEditable(false);
		
		setupComponent(panel,new JLabel("是否缴费："),0,18,1,1,false);
		jiaofei= new JTextField();
		setupComponent(panel,jiaofei,1,18,3,10,true);
		jiaofei.setEditable(false);
		
		//返回主界面
		menu_button = new JButton();
		menu_button.setText("返回");
		setupComponent(panel,menu_button,0,21,1,1,false);
		menu_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				window=new MainView();
				window.frame.setVisible(true);
			}	
		});
		
		button1 = new JButton();
		button1.setText("查询");
		setupComponent(panel,button1,1,21,1,1,false);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String n = name.getText();
				boolean r=serachByName(n);
				if(!r)
					JOptionPane.showMessageDialog(null, "查询失败");
			}	
		});
		
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	private  boolean serachByName(String n){
		p = Dao.getPatient(n);
		if(p!=null){
			id.setText(""+p.getId());;
			name.setText(p.getName());;
			room.setText(p.getRoom());;
			sex.setText(p.getSex());;
			age.setText(""+p.getAge());;
			money.setText(""+p.getMoney());;
			jiaofei.setText(p.getJiao());
			return true;
		}
		return false;
	}
	private void setupComponent(JPanel panel,JComponent component, int i, int j, int k, int l, boolean b) {
		GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx=i;
		gridBagConstrains.gridy=j;
		gridBagConstrains.insets = new Insets(5,1,3,1);
		if(k>1)
			gridBagConstrains.gridwidth=k;
		if(l>0)
			gridBagConstrains.weightx=l;
		if(b)
			gridBagConstrains.fill=GridBagConstraints.BOTH;
		panel.add(component,gridBagConstrains);
	}

}
