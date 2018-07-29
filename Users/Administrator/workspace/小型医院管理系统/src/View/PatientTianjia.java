package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.Dao;
import Model.Patient;

public class PatientTianjia extends JPanel{
	/**
	 * time：2017/5/31
	 * author:Daniel Wu
	 */
	private JTextField id ;
	private JTextField name;
	private JTextField room;
	private JTextField sex;
	private JTextField age;
	private JTextField money;
	private JButton button1;
	public JButton menu_button;
	protected Patient patient_new;
	public PatientTianjia(){
		setBounds(0,0,450,400);
		setLayout(new GridBagLayout());
		
		setupComponent(new JLabel("病人编号："),0,0,1,1,false);
		id = new JTextField();
		setupComponent(id,1,0,3,1,true);
		
		setupComponent(new JLabel("病人姓名："),0,4,1,1,false);
		name= new JTextField();
		setupComponent(name,1,4,3,10,true);
		
		setupComponent(new JLabel("病人性别："),0,8,1,1,false);
		sex = new JTextField();
		setupComponent(sex,1,8,3,1,true);
		
		setupComponent(new JLabel("病人年龄："),0,12,1,1,false);
		age= new JTextField();
		setupComponent(age,1,12,3,10,true);
		
		
		setupComponent(new JLabel("病房位置："),0,16,1,1,false);
		room= new JTextField();
		setupComponent(room,1,16,3,10,true);
		
		setupComponent(new JLabel("病人缴费："),0,20,1,1,false);
		money= new JTextField();
		setupComponent(money,1,20,3,10,true);
		
		button1 = new JButton();
		button1.setText("添加");
		setupComponent(button1,1,22,1,1,false);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int id_new = Integer.parseInt(id.getText());
				String name_new = name.getText();
				String room_new = room.getText();
				String sex_new = sex.getText();
				int money_new = Integer.parseInt(money.getText());
				int age_new = Integer.parseInt(age.getText());
				patient_new = new Patient(room_new,name_new,sex_new,id_new,money_new,age_new,"否");
				int r = Dao.addPatient(patient_new);
				if(r==0)
					JOptionPane.showMessageDialog(null, "添加失败");
				else
					JOptionPane.showMessageDialog(null, "添加成功");
			}	
		});
		//返回主界面
		menu_button = new JButton();
		menu_button.setText("返回");
		setupComponent(menu_button,1,24,1,1,false);
		
	}

	private void setupComponent(JComponent component, int i, int j, int k, int l, boolean b) {
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
		add(component,gridBagConstrains);
	}


}
