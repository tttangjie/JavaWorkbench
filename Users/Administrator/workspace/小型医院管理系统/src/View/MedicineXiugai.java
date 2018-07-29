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
public class MedicineXiugai extends JPanel{
	private JTextField name;
	private JTextField number;
	private JTextField money;
	private  JComboBox choose;
	private JButton button1;
	private JButton button2;
	private Medicine medicine_new;
	public MedicineXiugai(){
		setBounds(0,0,350,300);
		setLayout(new GridBagLayout());
		setupComponent(new JLabel("药品名称："),0,4,1,1,false);
		name= new JTextField();
		name.setEditable(false);
		setupComponent(name,1,4,3,10,true);
		
		setupComponent(new JLabel("  药品id："),0,8,1,1,false);
		number = new JTextField();
		setupComponent(number,1,8,3,1,true);
		
		setupComponent(new JLabel("药品价格："),0,12,1,1,false);
		money= new JTextField();
		setupComponent(money,1,12,3,10,true);
		
		setupComponent(new JLabel("选择药品："),0,20,1,1,false);
		choose = new JComboBox<String>();
		setupComponent(choose,1,20,3,10,true);
		choose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				medicine_new = doSelectNameAction();
			}	
		});
		
		button1 = new JButton();
		button1.setText("修改");
		setupComponent(button1,2,22,1,1,false);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int number_new = Integer.parseInt(number.getText());
				int money_new = Integer.parseInt(money.getText());
				int r=Dao.updateMedicine(medicine_new,number_new,money_new);
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
				int r=Dao.deleteMedicine(medicine_new);
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
		private  Medicine doSelectNameAction(){
			Item selectedItem;
			if(!(choose.getSelectedItem()instanceof Item)){
				return null;
			}
			selectedItem = (Item)choose.getSelectedItem();
			Medicine m = Dao.getMedicine(selectedItem.getName());
			if(m!=null){
				name.setText(m.getName());
				number.setText(""+m.getNumber());
				money.setText(""+m.getMoney());
			}
			return m;
		}
		//初始化医生姓名下拉框
		public void initComboBox(){
			List namelist = Dao.medicineList();
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
