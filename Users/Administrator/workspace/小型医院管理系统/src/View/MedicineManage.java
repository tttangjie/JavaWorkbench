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

public class MedicineManage extends JFrame{
	private MainView window;
	MedicineTianjia panel1;
	MedicineXiugai panel2;
	public MedicineManage(){
		
		setTitle("药品管理界面");
		setBounds(100,100,400,300);
		JTabbedPane tabPane = new JTabbedPane();
	    panel1 = new MedicineTianjia();	    
	    panel2 = new MedicineXiugai();
	    menuReturn();
		tabPane.addTab("信息添加", null, panel1, "添加");
		tabPane.addTab("信息修改与删除", null, panel2, "修改与删除");
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
