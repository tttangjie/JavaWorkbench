package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Model.*;
import Dao.Dao;
public class DoctorXiuGaiPanel extends JPanel {
	private JTextField name;
	private JTextField tel;
	private JTextField sex;
	private JTextField department;
	private  JComboBox choose;
	private JButton button1;
	private JButton button2;
	private Doctor doctor_new;
	public DoctorXiuGaiPanel(){
		setBounds(0,0,350,300);
		setLayout(new GridBagLayout());
		setupComponent(new JLabel("医生姓名："),0,4,1,1,false);
		name= new JTextField();
		name.setEditable(false);
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
		
		setupComponent(new JLabel("选择医生："),0,20,1,1,false);
		choose = new JComboBox<String>();
		setupComponent(choose,1,20,3,10,true);
		choose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				doctor_new = doSelectNameAction();
			}	
		});
		
		button1 = new JButton();
		button1.setText("修改");
		setupComponent(button1,2,22,1,1,false);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String department_new = department.getText();
				String sex_new = sex.getText();
				String tel_new = tel.getText();
				int r=Dao.updateDoctor(doctor_new,sex_new,department_new,tel_new);
				if(r==0)
					JOptionPane.showMessageDialog(null, "修改失败");
				else
					JOptionPane.showMessageDialog(null, "修改成功");
			}	
		});
		button2 = new JButton();
		button2.setText("删除");
		setupComponent(button2,3,22,1,1,false);
		button2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int r=Dao.deleteDoctor(doctor_new);
				if(r==0)
					JOptionPane.showMessageDialog(null, "删除失败");
				else
					JOptionPane.showMessageDialog(null, "删除成功");
			}	
		});
		
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
		
		//处理下拉框选择事件，实时更新
		private  Doctor doSelectNameAction(){
			Item selectedItem;
			if(!(choose.getSelectedItem()instanceof Item)){
				return null;
			}
			selectedItem = (Item)choose.getSelectedItem();
			Doctor doctor = Dao.getDoctor(selectedItem.getName());
			if(doctor!=null){
				name.setText(doctor.getName());
				sex.setText(doctor.getSex());
				tel.setText(doctor.getTel());
				department.setText(doctor.getDepartment());
			}
			return doctor;
		}
		//初始化医生姓名下拉框
		public void initComboBox(){
			List namelist = Dao.doctorList();
			List<Item> items = new ArrayList<Item>();
			choose.removeAllItems();
			for (Iterator iter = namelist.iterator(); iter.hasNext();) {
				List element = (List) iter.next();
				Item item = new Item();
				item.setId(element.get(0).toString().trim());
				item.setName(element.get(1).toString().trim());
				if (items.contains(item))
					continue;
				items.add(item);
				choose.addItem(item);
			}
			doSelectNameAction();

}
}
