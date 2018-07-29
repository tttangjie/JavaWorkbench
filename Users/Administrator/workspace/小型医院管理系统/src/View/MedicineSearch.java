package View;

import javax.swing.JFrame;
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
import javax.swing.WindowConstants;

import Dao.Dao;
import Model.Doctor;
import Model.Medicine;
public class MedicineSearch extends JFrame{
	private MainView window;
	private JTextField id ;
	private JTextField name;
	private JTextField money;
	private JButton menu_button;
	private JButton button1;
	protected Medicine m;
	public MedicineSearch(){
		setTitle("药品信息查询");
		setBounds(100,100,300,250);
		JPanel panel = new JPanel();
		panel.setBounds(0,0,350,300);
		panel.setLayout(new GridBagLayout());
		getContentPane().add(panel);
		
		setupComponent(panel,new JLabel("    药品id："),0,4,1,1,false);
		id = new JTextField();
		setupComponent(panel,id,1,4,3,1,true);
		id.setEditable(false);
		
		setupComponent(panel,new JLabel("药品名称："),0,0,1,1,false);
		name= new JTextField();
		setupComponent(panel,name,1,0,3,10,true);
		
		setupComponent(panel,new JLabel("药品价格："),0,8,1,1,false);
		money = new JTextField();
		setupComponent(panel,money,1,8,3,1,true);
		money.setEditable(false);
		
		//返回主界面
		menu_button = new JButton();
		menu_button.setText("返回");
		setupComponent(panel,menu_button,0,12,1,1,false);
		menu_button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				window=new MainView();
				window.frame.setVisible(true);
			}	
		});
		
		button1 = new JButton();
		button1.setText("查询");
		setupComponent(panel,button1,1,12,1,1,false);
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
		m = Dao.getMedicine(n);
		if(m!=null){
			id.setText(""+m.getNumber());
			money.setText(""+m.getMoney());
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
