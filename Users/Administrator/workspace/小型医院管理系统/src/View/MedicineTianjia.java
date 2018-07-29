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
	 * time��2017/5/31
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
		
		setupComponent(new JLabel("    ҩƷid��"),0,0,1,1,false);
		id = new JTextField();
		setupComponent(id,1,0,3,1,true);
		
		setupComponent(new JLabel("ҩƷ���ƣ�"),0,6,1,1,false);
		name= new JTextField();
		setupComponent(name,1,6,3,10,true);
	
		setupComponent(new JLabel("ҩƷ�۸�"),0,12,1,1,false);
		money= new JTextField();
		setupComponent(money,1,12,3,10,true);
	
		button1 = new JButton();
		button1.setText("���");
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
					JOptionPane.showMessageDialog(null, "���ʧ��");
				else
					JOptionPane.showMessageDialog(null, "��ӳɹ�");
			}	
		});
		//����������
		menu_button = new JButton();
		menu_button.setText("����");
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

