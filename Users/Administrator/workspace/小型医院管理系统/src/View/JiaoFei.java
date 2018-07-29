package View;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Dao.Dao;
import Model.Patient;

public class JiaoFei extends JFrame {
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel jiaofeiLabel;
	private JLabel moneyLabel;
	private JTextField id ;
	private JTextField name;
	private JTextField jiaofei;
	private JTextField money;
	private JButton button1;
	private JButton button2;
	protected Patient p;
	public JiaoFei(){
		setTitle("��Ժ�ɷѹ���");
		setBounds(100,100,400,300);
		JPanel panel = new JPanel();
		panel.setBounds(0,0,350,220);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		idLabel = new JLabel();
		idLabel.setText("���˱�ţ�");
		idLabel.setBounds(52, 33, 70, 15);
		panel.add(idLabel);
		id = new JTextField();
		id.setBounds(116, 30, 139, 21);
		panel.add(id);
		
		nameLabel = new JLabel();
		nameLabel.setText("����������");
		nameLabel.setBounds(52, 74, 70, 15);
		panel.add(nameLabel);
		name = new JTextField();
		name.setBounds(116,71,139,21);
		panel.add(name);
		
		
		moneyLabel = new JLabel();
		moneyLabel.setText("��Ҫ�ɷѣ�");
		moneyLabel.setBounds(52, 105,70, 15);
		panel.add(moneyLabel);
		money = new JTextField();
		money.setBounds(116,102,139,21);
		panel.add(money);
		
		jiaofeiLabel = new JLabel();
		jiaofeiLabel.setText("�Ƿ�ɷѣ�");
		jiaofeiLabel.setBounds(52, 146, 70, 15);
		panel.add(jiaofeiLabel);
		jiaofei = new JTextField();
		jiaofei.setBounds(116,146,139,21);
		panel.add(jiaofei);
		
		button1 = new JButton();
		button1.setText("��ѯ");
		button1.setBounds(64,180,69,23);
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String n = name.getText();
				int i = Integer.parseInt(id.getText());
				boolean r=serachByName(n,i);
				if(!r)
					JOptionPane.showMessageDialog(null, "��ѯʧ��");
			}	
		});
		panel.add(button1);
		
		button2 = new JButton();
		button2.setText("�ѽ�");
		button2.setBounds(160,180,69,23);
		button2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(p.getJiao().equals("��"))
				{
					int r=Dao.updateJiaoFei(p);
					if(r==1)
					    JOptionPane.showMessageDialog(null, "�ɷѳɹ�");
					else
						JOptionPane.showMessageDialog(null, "�ɷ�ʧ��");
				}
				if(p.getJiao().equals("��"))
					JOptionPane.showMessageDialog(null, "�Ѿ���ɽɷѣ������ظ�����");
				
			}	
		});
		panel.add(button2);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	private  boolean serachByName(String n,int i){
		p = Dao.getPatient(n);
		if(p!=null&&i==p.getId()){
			id.setText(""+p.getId());
			name.setText(p.getName());
			money.setText(p.getMoney()+"");
			jiaofei.setText(p.getJiao());
			return true;
		}
		return false;
	}

}
