package View;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class PatientManage extends JFrame{
	private MainView window;
	PatientTianjia panel1;
	PatientXiuGai panel2;
	public PatientManage(){
		
		setTitle("ҽ���������");
		setBounds(100,100,500,400);
		JTabbedPane tabPane = new JTabbedPane();
	    panel1 = new PatientTianjia();	    
	    panel2 = new PatientXiuGai();
	    menuReturn();
		tabPane.addTab("��Ϣ���", null, panel1, "���");
		tabPane.addTab("��Ϣ�޸���ɾ��", null, panel2, "�޸���ɾ��");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e){
				panel2.initComboBox();
			}
		});
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	public void menuReturn(){
		panel1.menu_button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				setVisible(false);
		    	window=new MainView();
		    	window.frame.setVisible(true);
			}	
		});
		
	}

}
