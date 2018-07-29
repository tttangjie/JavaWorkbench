package View;

import javax.swing.JPanel;
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
public class PatientXiuGai extends JPanel {
	private JTextField id ;
	private JTextField name;
	private JTextField room;
	private JTextField sex;
	private JTextField age;
	private JTextField money;
	private JButton button1;
	private JButton button2;
	public JButton menu_button;
	protected Patient patient_new;
	private  JComboBox choose;
	public PatientXiuGai(){
		setBounds(0,0,450,400);
		setLayout(new GridBagLayout());
		setupComponent(new JLabel("病人编号："),0,3,1,1,false);
		id = new JTextField();
		setupComponent(id,1,3,3,1,true);
		id.setEditable(false);
		
		setupComponent(new JLabel("病人姓名："),0,0,1,1,false);
		name= new JTextField();
		setupComponent(name,1,0,3,10,true);
		name.setEditable(false);
		
		setupComponent(new JLabel("病人性别："),0,6,1,1,false);
		sex = new JTextField();
		setupComponent(sex,1,6,3,1,true);
		
		setupComponent(new JLabel("病人年龄："),0,9,1,1,false);
		age= new JTextField();
		setupComponent(age,1,9,3,10,true);
		
		
		setupComponent(new JLabel("病房位置："),0,12,1,1,false);
		room= new JTextField();
		setupComponent(room,1,12,3,10,true);
		
		setupComponent(new JLabel("病人缴费："),0,15,1,1,false);
		money= new JTextField();
		setupComponent(money,1,15,3,10,true);
		
		setupComponent(new JLabel("选择病人："),0,18,1,1,false);
		choose = new JComboBox<String>();
		setupComponent(choose,1,18,3,10,true);
		choose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				patient_new = doSelectNameAction();
			}	
		});
		
		button1 = new JButton();
		button1.setText("修改");
		setupComponent(button1,2,22,1,1,false);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String room_new = room.getText();
				String sex_new = sex.getText();
				int money_new = Integer.parseInt(money.getText());
				int age_new = Integer.parseInt(age.getText());
				int r=Dao.updatePatient(patient_new, room_new,sex_new,money_new,age_new);
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
				int r=Dao.deletePatient(patient_new);
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
		private  Patient doSelectNameAction(){
			Item selectedItem;
			if(!(choose.getSelectedItem()instanceof Item)){
				return null;
			}
			selectedItem = (Item)choose.getSelectedItem();
			Patient p = Dao.getPatient(selectedItem.getName());
			if(p!=null){
				name.setText(p.getName());
				sex.setText(p.getSex());
				id.setText(""+p.getId());
				room.setText(p.getRoom());
				money.setText(""+p.getMoney());
				age.setText(""+p.getAge());
			}
			return p;
		}
		//初始化医生姓名下拉框
		public void initComboBox(){
			List namelist = Dao.patientList();
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
