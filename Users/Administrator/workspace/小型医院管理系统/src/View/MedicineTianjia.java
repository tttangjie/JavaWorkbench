package View;

import javax.swing.JPanel;
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
import Model.Medicine;;
public class MedicineTianjia extends JPanel {
	/**
	 * time：2017/5/31
	 * author:Daniel Wu
	 */
	private JTextField id ;
	private JTextField name;
	private JTextField money;
	private JButton button1;
	public JButton menu_button;
	protected Medicine medicine_new;
	public MedicineTianjia(){
		setBounds(0,0,350,300);
		setLayout(new GridBagLayout());
		
		setupComponent(new JLabel("    药品id："),0,0,1,1,false);
		id = new JTextField();
		setupComponent(id,1,0,3,1,true);
		
		setupComponent(new JLabel("药品名称："),0,6,1,1,false);
		name= new JTextField();
		setupComponent(name,1,6,3,10,true);
	
		setupComponent(new JLabel("药品价格："),0,12,1,1,false);
		money= new JTextField();
		setupComponent(money,1,12,3,10,true);
	
		button1 = new JButton();
		button1.setText("添加");
		setupComponent(button1,1,15,1,1,false);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int id_new = Integer.parseInt(id.getText());
				String name_new = name.getText();
				int money_new = Integer.parseInt(money.getText());
				medicine_new = new Medicine(id_new,name_new,money_new);
				int r = Dao.addMedicine(medicine_new);
				if(r==0)
					JOptionPane.showMessageDialog(null, "添加失败");
				else
					JOptionPane.showMessageDialog(null, "添加成功");
			}	
		});
		//返回主界面
		menu_button = new JButton();
		menu_button.setText("返回");
		setupComponent(menu_button,0,15,1,1,false);
		
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

