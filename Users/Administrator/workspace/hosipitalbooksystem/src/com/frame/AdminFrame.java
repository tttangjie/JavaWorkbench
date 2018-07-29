package com.frame;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AdminFrame extends JFrame implements ActionListener{
	private JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	private JMenuItem item1, item2, item3, item4, item5, item6, item7, item8, item9, item10,item11,item12;
	private JMenuBar jmb;
	private JPanelFrame jpf;
	ActionListener listener;
	public AdminFrame (){
		super("ҽԺ����ϵͳ");
		this.setSize(450,400);
		this.setLocationRelativeTo(null);
		jmb = new JMenuBar();// �����˵�����
		jm1=new JMenu(" ������Ϣ ");
		 item1=new JMenuItem("��Ӳ�����Ϣ");
		 item2=new JMenuItem("��������Ϣ");
		 jm1.add(item1).setFont(new Font("����",Font.PLAIN,12));
		 jm1.addSeparator();
		 jm1.add(item2).setFont(new Font("����",Font.PLAIN,12));
		jm2=new JMenu(" ҽ����Ϣ ");
	     item3=new JMenuItem("���ҽ����Ϣ");
		 item4=new JMenuItem("����ҽ����Ϣ");
		 jm2.add(item3).setFont(new Font("����",Font.PLAIN,12));
		 jm2.addSeparator();
		 jm2.add(item4).setFont(new Font("����",Font.PLAIN,12));
		jm3=new JMenu(" ������Ϣ ");
		 item5=new JMenuItem("��ӿ�����Ϣ");
		 item6=new JMenuItem("���������Ϣ");
		 jm3.add(item5).setFont(new Font("����",Font.PLAIN,12));
		 jm3.addSeparator();
		 jm3.add(item6).setFont(new Font("����",Font.PLAIN,12));
		jm4=new JMenu(" ҩƷ��Ϣ ");
		 item7=new JMenuItem("���ҩƷ��Ϣ");
		 item8=new JMenuItem("����ҩƷ��Ϣ");
		 jm4.add(item7).setFont(new Font("����",Font.PLAIN,12));
		 jm4.addSeparator();
		 jm4.add(item8).setFont(new Font("����",Font.PLAIN,12));
		jm5=new JMenu(" ��λ��Ϣ ");
		 item9=new JMenuItem("��Ӵ�λ��Ϣ");
		 item10=new JMenuItem("����λ��Ϣ");
		 jm5.add(item9).setFont(new Font("����",Font.PLAIN,12));
		 jm5.addSeparator();
		 jm5.add(item10).setFont(new Font("����",Font.PLAIN,12));
		jm6=new JMenu(" סԺ���� ");
		 item11=new JMenuItem("Ԥ����");
		 item12=new JMenuItem("���˵�");
		 jm6.add(item11).setFont(new Font("����",Font.PLAIN,12));
		 jm6.addSeparator();
		 jm6.add(item12).setFont(new Font("����",Font.PLAIN,12));
		 
		jmb.add(jm1).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm2).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm3).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm4).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm5).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm6).setFont(new Font("����",Font.PLAIN,14));
		this.add(jmb,"North");
		setJMenuBar(jmb);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		item8.addActionListener(this);
		item9.addActionListener(this);
		item10.addActionListener(this);
		item11.addActionListener(this);
		item12.addActionListener(this);
		
		jpf=new JPanelFrame();
		this.getContentPane().add(jpf.getJp());
		
		this.setVisible(true);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
	
	public void actionPerformed(ActionEvent ev){ 
		if(ev.getSource()==item1){
			jpf.getJp().setVisible(false);
			jpf.JPAddPatient();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item2){
			jpf.getJp().setVisible(false);
			jpf.JPManagePatient();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item3){
			jpf.getJp().setVisible(false);
			jpf.JPAddDoctor();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item4){
			jpf.getJp().setVisible(false);
			jpf.JPManageDoctor();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item5){
			jpf.getJp().setVisible(false);
			jpf.JPAddDepartment();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item6){
			jpf.getJp().setVisible(false);
			jpf.JPManageDeptartment();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item7){
			jpf.getJp().setVisible(false);
			jpf.JPAddMedicine();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item8){
			jpf.getJp().setVisible(false);
			jpf.JPManageMedicine();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item9){
			jpf.getJp().setVisible(false);
			jpf.JPAddBed();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item10){
			jpf.getJp().setVisible(false);
			jpf.JPManageBed();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item11){
			jpf.getJp().setVisible(false);
			jpf.JPPrepay();
			jpf.getJp().setVisible(true);
		}
		if(ev.getSource()==item12){
			jpf.getJp().setVisible(false);
			jpf.JPAccount();
			jpf.getJp().setVisible(true);
		}

	}
}
