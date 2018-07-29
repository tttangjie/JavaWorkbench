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
import Model.Doctor;
public class DoctorTianJiaPanel extends JPanel {
	/**
	 * time：2017/5/29
	 * author:Daniel Wu
	 */
	private JTextField id ;
	private JTextField name;
	private JTextField tel;
	private JTextField sex;
	private JTextField department;
	private JButton button1;
	public JButton menu_button;
	protected Doctor doctor_new;
	public DoctorTianJiaPanel(){
		setBounds(0,0,350,300);
		setLayout(new GridBagLayout());
		
		setupComponent(new JLabel("    医生id："),0,0,1,1,false);
		id = new JTextField();
		setupComponent(id,1,0,3,1,true);
		
		setupComponent(new JLabel("医生姓名："),0,4,1,1,false);
		name= new JTextField();
		setupComponent(name,1,4,3,10,true);
		
		setupComponent(new JLabel("医生性别："),0,8,1,1,false);
		sex = new JTextField();
		setupComponent(sex,1,8,3,1,true);
		
		setupComponent(new JLabel("所属科室："),0,12,1,1,false);
		department= new JTextField();
		setupComponent(department,1,12,3,10,true);
		
		setupComponent(new JLabel("联系方式："),0,16,1,1,false);
		tel= new JTextField();
		setupComponent(tel,1,16,3,10,true);
		//考虑添加科室下拉选框
		button1 = new JButton();
		button1.setText("添加");
		setupComponent(button1,1,18,1,1,false);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int id_new = Integer.parseInt(id.getText());
				String name_new = name.getText();
				String department_new = department.getText();
				String sex_new = sex.getText();
				String tel_new = tel.getText();
				doctor_new = new Doctor(id_new, name_new,sex_new,department_new,tel_new);
				System.out.println(id_new+" "+name_new+" "+department_new+" "+sex_new+" "+tel_new);
				int r = Dao.addDoctor(doctor_new);
				if(r==0)
					JOptionPane.showMessageDialog(null, "添加失败");
				else
					JOptionPane.showMessageDialog(null, "添加成功");
			}	
		});
		//返回主界面
		menu_button = new JButton();
		menu_button.setText("返回");
		setupComponent(menu_button,0,18,1,1,false);
		
	}

	private void setupComponent(JComponent component, int i, int j, int k, int l, boolean b) {
		GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx=i;
		gridBagConstrains.gridy=j;
		gridBagConstrains.insets = new Insets(5,1,3,1);
		if(k>1)
			gridBagConstrains.gridwidth=k;
		if(l>0)
			gridBagConstrains.ipadx=l;
		if(b)
			gridBagConstrains.fill=GridBagConstraints.HORIZONTAL;
		add(component,gridBagConstrains);
	}

}
