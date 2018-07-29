package com.frame;

import java.awt.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mybaties.util.BedOperation;
import com.mybaties.util.CaseOperate;
import com.mybaties.util.DepartmentOperate;
import com.mybaties.util.DoctorOperate;
import com.mybaties.util.MedicineOperate;
import com.mybaties.util.PatientOperate;
import com.mybaties.util.PrepayOperate;
import com.po.Bed;
import com.po.MedicalCase;
import com.po.Department;
import com.po.Doctor;
import com.po.Medicine;
import com.po.Patient;
import com.po.Prepay;

public class JPanelFrame extends JFrame implements ActionListener{
	private JPanel jp;
	private Button back,pok,dok,depok,mok,bok,preok;
	private Button pseek,dseek,depseek,mseek,bseek,aseek;
	private Button pdelete,ddelete,depdelete,mdelete,bdelete;
	private Button pmodify,dmodify,depmodify,mmodify,bmodify;
	private TextField tfpno,tfpname,tfpsex,tfpage,tfpid,tfptel;
    private	TextField tfdno,tfdname,tfdsex,tfdage,tfdid,tfdtel;
	private TextField tfdepno,tfdepname;
	private TextField tfmno,tfmname,tfmprice;
	private TextField tfbno,tfcondition,tfbprice;
	private TextField tfprepay,tfday,tftotal,tfpay;
	public JPanelFrame(){
		jp=new JPanel(); 
		jp.removeAll();
		jp.setSize(450,400); 
		ImageIcon icon=new ImageIcon("src/com/frame/init.jpg");
		JLabel Imagelabel=new JLabel(icon);
		jp.add(Imagelabel);
		jp.setVisible(true);
		
	}
	
	
	public void JPAddPatient(){


		Label lpno = new Label("病人编号:");
		Label lpname = new Label("病人姓名:");
		Label lpsex = new Label("病人性别:");
		Label lpage= new Label("病人年龄:");
		Label lpid = new Label("身份证号:");
		Label lptel = new Label("联系方式:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		//添加文本框
		tfpno = new TextField(15);
		tfpname = new TextField(15);
		tfpsex = new TextField(15);
		tfpage= new TextField(15);
		tfpid = new TextField(15);
		tfptel = new TextField(15);
		//添加按钮
		pok = new Button("添加");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lpno);
		jp1.add(tfpno);
		jp2.add(lpname);
		jp2.add(tfpname);
		jp3.add(lpsex);
		jp3.add(tfpsex);
		jp4.add(lpage);
		jp4.add(tfpage);
		jp5.add(lpid);
		jp5.add(tfpid);
		jp6.add(lptel);
		jp6.add(tfptel);
		jp7.add(pok).setFont(new Font("宋体",1,15));
		jp7.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		
		jp.add(jp3);
		jp4.setBounds(0,130,300,40);
		jp.add(jp4);
		jp5.setBounds(0,170,300,40);
		jp.add(jp5);
		jp6.setBounds(0,210,300,40);
		jp.add(jp6);
		jp7.setBounds(0, 260, 300, 40);
		jp.add(jp7);
		
		pok.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
		
	}
	
	public void JPManagePatient(){

		Label lpno = new Label("病人编号:");
		Label lpname = new Label("病人姓名:");
		Label lpsex = new Label("病人性别:");
		Label lpage= new Label("病人年龄:");
		Label lpid = new Label("身份证号:");
		Label lptel = new Label("联系方式:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		//添加文本框
		tfpno = new TextField(15);
		tfpname = new TextField(15);
		tfpsex = new TextField(15);
		tfpage= new TextField(15);
		tfpid = new TextField(15);
		tfptel = new TextField(15);
		//添加按钮
		pseek = new Button("查找");
		pdelete = new Button("删除");
		pmodify = new Button("修改");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lpno);
		jp1.add(tfpno);
		jp1.add(pseek);
		jp2.add(lpname);
		jp2.add(tfpname);
		jp3.add(lpsex);
		jp3.add(tfpsex);
		jp4.add(lpage);
		jp4.add(tfpage);
		jp5.add(lpid);
		jp5.add(tfpid);
		jp6.add(lptel);
		jp6.add(tfptel);
		jp7.add(pdelete).setFont(new Font("宋体",1,15));
		jp7.add(pmodify).setFont(new Font("宋体",1,15));
		jp7.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(22,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,130,300,40);
		jp.add(jp4);
		jp5.setBounds(0,170,300,40);
		jp.add(jp5);
		jp6.setBounds(0,210,300,40);
		jp.add(jp6);
		jp7.setBounds(0, 260, 300, 40);
		jp.add(jp7);
		
		pseek.addActionListener(this);
		pdelete.addActionListener(this);
		pmodify.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}
	
	public void JPAddDoctor(){
		Label ldno = new Label("医生编号:");
		Label ldname = new Label("医生姓名:");
		Label ldsex = new Label("医生性别:");
		Label ldage= new Label("医生年龄:");
		Label ldid = new Label("身份证号:");
		Label ldtel = new Label("联系方式:");
		Label ldepno = new Label("科室编号:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		JPanel jp8 = new JPanel();
		//添加文本框
		tfdno = new TextField(15);
		tfdname = new TextField(15);
		tfdsex = new TextField(15);
		tfdage= new TextField(15);
		tfdid = new TextField(15);
		tfdtel = new TextField(15);
		tfdepno = new TextField(15);
		//添加按钮
		dok = new Button("添加");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(ldno);
		jp1.add(tfdno);
		jp2.add(ldname);
		jp2.add(tfdname);
		jp3.add(ldsex);
		jp3.add(tfdsex);
		jp4.add(ldage);
		jp4.add(tfdage);
		jp5.add(ldid);
		jp5.add(tfdid);
		jp6.add(ldtel);
		jp6.add(tfdtel);
		jp7.add(ldepno);
		jp7.add(tfdepno);
		jp8.add(dok).setFont(new Font("宋体",1,15));
		jp8.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,130,300,40);
		jp.add(jp4);
		jp5.setBounds(0,170,300,40);
		jp.add(jp5);
		jp6.setBounds(0,210,300,40);
		jp.add(jp6);
		jp7.setBounds(0, 250, 300, 40);
		jp.add(jp7);
		jp8.setBounds(0, 300, 300, 40);
		jp.add(jp8);
		
		dok.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
		
	}
	
	public void JPManageDoctor(){
		Label ldno = new Label("医生编号:");
		Label ldname = new Label("医生姓名:");
		Label ldsex = new Label("医生性别:");
		Label ldage= new Label("医生年龄:");
		Label ldid = new Label("身份证号:");
		Label ldtel = new Label("联系方式:");
		Label ldepno = new Label("科室编号:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		JPanel jp8 = new JPanel();
		//添加文本框
		tfdno = new TextField(15);
		tfdname = new TextField(15);
		tfdsex = new TextField(15);
		tfdage= new TextField(15);
		tfdid = new TextField(15);
		tfdtel = new TextField(15);
		tfdepno = new TextField(15);
		//添加按钮
		dseek = new Button("查找");
		ddelete = new Button("删除");
		dmodify = new Button("修改");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(ldno);
		jp1.add(tfdno);
		jp1.add(dseek);
		jp2.add(ldname);
		jp2.add(tfdname);
		jp3.add(ldsex);
		jp3.add(tfdsex);
		jp4.add(ldage);
		jp4.add(tfdage);
		jp5.add(ldid);
		jp5.add(tfdid);
		jp6.add(ldtel);
		jp6.add(tfdtel);
		jp7.add(ldepno);
		jp7.add(tfdepno);
		jp8.add(ddelete).setFont(new Font("宋体",1,15));
		jp8.add(dmodify).setFont(new Font("宋体",1,15));
		jp8.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(22,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,130,300,40);
		jp.add(jp4);
		jp5.setBounds(0,170,300,40);
		jp.add(jp5);
		jp6.setBounds(0,210,300,40);
		jp.add(jp6);
		jp7.setBounds(0, 250, 300, 40);
		jp.add(jp7);
		jp8.setBounds(0, 300, 300, 40);
		jp.add(jp8);
		
		dseek.addActionListener(this);
		ddelete.addActionListener(this);
		dmodify.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}	
	
	public void JPAddDepartment(){

		Label ldepno = new Label("部门编号:");
		Label ldepname = new Label("部门名称:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		//添加文本框
		tfdepno = new TextField(15);
		tfdepname = new TextField(15);
		//添加按钮
		depok = new Button("添加");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(ldepno);
		jp1.add(tfdepno);
		jp2.add(ldepname);
		jp2.add(tfdepname);
		jp3.add(depok).setFont(new Font("宋体",1,15));
		jp3.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,100,300,40);
		jp.add(jp3);
		
		depok.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}
	
	public void JPManageDeptartment(){
		Label ldepno = new Label("部门编号:");
		Label ldepname = new Label("部门名称:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		//添加文本框
		tfdepno = new TextField(15);
		tfdepname = new TextField(15);
		//添加按钮
		depseek = new Button("查找");
		depdelete = new Button("删除");
		depmodify = new Button("修改");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(ldepno);
		jp1.add(tfdepno);
		jp1.add(depseek);
		jp2.add(ldepname);
		jp2.add(tfdepname);
		jp3.add(depdelete).setFont(new Font("宋体",1,15));
		jp3.add(depmodify).setFont(new Font("宋体",1,15));
		jp3.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(22,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,100,300,40);
		jp.add(jp3);
		
		depseek.addActionListener(this);
		depdelete.addActionListener(this);
		depmodify.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}
	
	public void JPAddMedicine(){
		Label lmno = new Label("药品编号:");
		Label lmname = new Label("药品名称:");
		Label lmprice = new Label("药瓶价格:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		//添加文本框
		tfmno = new TextField(15);
		tfmname = new TextField(15);
		tfmprice = new TextField(15);
		//添加按钮
		mok = new Button("添加");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lmno);
		jp1.add(tfmno);
		jp2.add(lmname);
		jp2.add(tfmname);
		jp3.add(lmprice);
		jp3.add(tfmprice);
		jp4.add(mok).setFont(new Font("宋体",1,15));
		jp4.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,140,300,40);
		jp.add(jp4);
		
		mok.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}
	
	public void JPManageMedicine(){
		Label lmno = new Label("药品编号:");
		Label lmname = new Label("药品名称:");
		Label lmprice = new Label("药瓶价格:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		//添加文本框
		tfmno = new TextField(15);
		tfmname = new TextField(15);
		tfmprice = new TextField(15);
		//添加按钮
		mseek = new Button("查找");
		mdelete = new Button("删除");
		mmodify = new Button("修改");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lmno);
		jp1.add(tfmno);
		jp1.add(mseek);
		jp2.add(lmname);
		jp2.add(tfmname);
		jp3.add(lmprice);
		jp3.add(tfmprice);
		jp4.add(mdelete).setFont(new Font("宋体",1,15));
		jp4.add(mmodify).setFont(new Font("宋体",1,15));
		jp4.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(22,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,140,300,40);
		jp.add(jp4);
		
		mseek.addActionListener(this);
		mdelete.addActionListener(this);
		mmodify.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}

	public void JPAddBed(){

		Label lbno = new Label("床位编号:");
		Label lcondition = new Label("床位状态:");
		Label lbprice = new Label("床位价格:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		//添加文本框
		tfbno = new TextField(15);
		tfcondition = new TextField(15);
		tfbprice = new TextField(15);
		//添加按钮
		bok = new Button("添加");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lbno);
		jp1.add(tfbno);
		jp2.add(lcondition);
		jp2.add(tfcondition);
		jp3.add(lbprice);
		jp3.add(tfbprice);
		jp4.add(bok).setFont(new Font("宋体",1,15));
		jp4.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,140,300,40);
		jp.add(jp4);
		
		bok.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}
	
	public void JPManageBed(){
		Label lbno = new Label("床位编号:");
		Label lcondition = new Label("床位状态:");
		Label lbprice = new Label("床位价格:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		//添加文本框
		tfbno = new TextField(15);
		tfcondition = new TextField(15);
		tfbprice = new TextField(15);
		//添加按钮
		bseek = new Button("查找");
		bdelete = new Button("删除");
		bmodify = new Button("修改");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lbno);
		jp1.add(tfbno);
		jp1.add(bseek);
		jp2.add(lcondition);
		jp2.add(tfcondition);
		jp3.add(lbprice);
		jp3.add(tfbprice);
		jp4.add(bdelete).setFont(new Font("宋体",1,15));
		jp4.add(bmodify).setFont(new Font("宋体",1,15));
		jp4.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(22,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,140,300,40);
		jp.add(jp4);
		
		bseek.addActionListener(this);
		bdelete.addActionListener(this);
		bmodify.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}
	
	public void JPPrepay(){
		Label lpno = new Label("病人编号:");
		Label lprepay = new Label("预交费用:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		//添加文本框
		tfpno = new TextField(15);
		tfprepay = new TextField(15);
		//添加按钮
		preok = new Button("添加");
		back = new Button("返回");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lpno);
		jp1.add(tfpno);
		jp2.add(lprepay);
		jp2.add(tfprepay);
		jp3.add(preok).setFont(new Font("宋体",1,15));
		jp3.add(back).setFont(new Font("宋体",1,15));
		
		
		jp1.setBounds(0,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,100,300,40);
		jp.add(jp3);
		
		preok.addActionListener(this);
		back.addActionListener(this);
		jp.setVisible(true);
	}
	
	public void JPAccount(){
		Label lpno = new Label("病人编号:");
		Label ldno = new Label("主治医师:");
		Label lmno = new Label("药品名称:");
		Label lbno = new Label("床位编号:");
		Label lday = new Label("住院天数:");
		Label lprepay = new Label("预交费用:");
		Label ltotal = new Label("费用总计:");
		Label lpay = new Label("应收费用:");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		JPanel jp8 = new JPanel();
		//添加文本框
		tfpno = new TextField(15);
		tfdno = new TextField(15);
		tfdno.setEditable(false);
		tfmno = new TextField(15);
		tfmno.setEditable(false);
		tfbno= new TextField(15);
		tfbno.setEditable(false);
		tfday = new TextField(15);
		tfday.setEditable(false);
		tfprepay = new TextField(15);
		tfprepay.setEditable(false);
		tftotal = new TextField(15);
		tftotal.setEditable(false);
		tfpay = new TextField(15);
		tfpay.setEditable(false);
		//添加按钮
		aseek = new Button("添加");
		jp.removeAll();
		jp.setLayout(null);
		
		jp1.add(lpno);
		jp1.add(tfpno);
		jp1.add(aseek);
		jp2.add(ldno);
		jp2.add(tfdno);
		jp3.add(lmno);
		jp3.add(tfmno);
		jp4.add(lbno);
		jp4.add(tfbno);
		jp5.add(lday);
		jp5.add(tfday);
		jp6.add(lprepay);
		jp6.add(tfprepay);
		jp7.add(ltotal);
		jp7.add(tftotal);
		jp7.add(ltotal);
		jp7.add(tftotal);
		jp8.add(lpay);
		jp8.add(tfpay);
		
		
		jp1.setBounds(22,10, 300, 40);
		jp.add(jp1);
		jp2.setBounds(0,50, 300,40);
		jp.add(jp2);
		jp3.setBounds(0,90,300,40);
		jp.add(jp3);
		jp4.setBounds(0,130,300,40);
		jp.add(jp4);
		jp5.setBounds(0,170,300,40);
		jp.add(jp5);
		jp6.setBounds(0,210,300,40);
		jp.add(jp6);
		jp7.setBounds(0, 250, 300, 40);
		jp.add(jp7);
		jp8.setBounds(0, 300, 300, 40);
		jp.add(jp8);
		
		aseek.addActionListener(this);
		jp.setVisible(true);
	}
	
	public JPanel getJp() {
		return jp;
	}
	public void setJp(JPanel jp) {
		this.jp = jp;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		if(ev.getSource()==back){
			jp.removeAll();
			jp.setVisible(false);
		}
		
		//病人信息管理
		if(ev.getSource()==pok){
			Patient pa=new Patient();
			pa.setPno(tfpno.getText());
			pa.setPname(tfpname.getText());
			pa.setPsex(tfpsex.getText());
			pa.setPage(tfpage.getText());
			pa.setPid(tfpid.getText());
			pa.setPtel(tfptel.getText());
			PatientOperate.insertPatient(pa);
		}
		
		if(ev.getSource()==pdelete){
			PatientOperate.deletePatientByPno(tfpno.getText());
		}
		
		if(ev.getSource()==pmodify){
			
			Patient pa=new Patient();
			pa=PatientOperate.findPatientByPno(tfpno.getText());
		//	pa.setPno(tfpno.getText());
			pa.setPname(tfpname.getText());
			pa.setPsex(tfpsex.getText());
			pa.setPage(tfpage.getText());
			pa.setPid(tfpid.getText());
			pa.setPtel(tfptel.getText());
			PatientOperate.updatePatientByPno(pa);
		}
		if(ev.getSource()==pseek){
			Patient pa=new Patient();
			pa=PatientOperate.findPatientByPno(tfpno.getText());
			tfpname.setText(pa.getPname());
			tfpsex.setText(pa.getPsex());
			tfpage.setText(pa.getPage());
			tfpid.setText(pa.getPid());
			tfptel.setText(pa.getPtel());
		}
		
		//医生信息管理
		if(ev.getSource()==dok){
			Doctor doc=new Doctor();
			doc.setDno(tfdno.getText());
			doc.setDname(tfdname.getText());
			doc.setDsex(tfdsex.getText());
			doc.setDage(tfdage.getText());
			doc.setDid(tfdid.getText());
			doc.setDtel(tfdtel.getText());
			doc.setDepno(tfdepno.getText());
			DoctorOperate.insertDoctor(doc);
		}
		

		if(ev.getSource()==ddelete){
			DoctorOperate.deleteDoctorByDno(tfdno.getText());
		}
		if(ev.getSource()==dmodify){
			Doctor doc=new Doctor();
			doc=DoctorOperate.findDoctorByDno(tfdno.getText());
		//	doc.setDno(tfdno.getText());
			doc.setDname(tfdname.getText());
			doc.setDsex(tfdsex.getText());
			doc.setDage(tfdage.getText());
			doc.setDid(tfdid.getText());
			doc.setDtel(tfdtel.getText());
			doc.setDepno(tfdepno.getText());
			DoctorOperate.updateDoctorByDno(doc);
		}

		if(ev.getSource()==dseek){
			Doctor doc=new Doctor();
			doc=DoctorOperate.findDoctorByDno(tfdno.getText());
			tfdname.setText(doc.getDname());
			tfdsex.setText(doc.getDsex());
			tfdage.setText(doc.getDage());
			tfdid.setText(doc.getDid());
			tfdtel.setText(doc.getDtel());
			tfdepno.setText(doc.getDepno());
		}
		
		//科室信息管理
		if(ev.getSource()==depok){
			Department dep=new Department();
			dep.setDepno(tfdepno.getText());
			dep.setDepname(tfdepname.getText());
			DepartmentOperate.insertDepartment(dep);
		}

		if(ev.getSource()==depdelete){
			DepartmentOperate.deleteDepartmentByDepno(tfdepno.getText());
		}
		if(ev.getSource()==depmodify){
			Department dep=new Department();
			dep=DepartmentOperate.findDepartmentByDepno(tfdepno.getText());
			dep.setDepname(tfdepname.getText());
			DepartmentOperate.updateDepartmentByDepno(dep);
		}

		if(ev.getSource()==depseek){
			Department dep=new Department();
			dep=DepartmentOperate.findDepartmentByDepno(tfdepno.getText());
			tfdepname.setText(dep.getDepname());
		}
		
		//药品信息管理
		if(ev.getSource()==mok){
			Medicine med=new Medicine();
			med.setMno(tfmno.getText());
			med.setMname(tfmname.getText());
			med.setMprice(Integer.parseInt(tfmprice.getText()));
			MedicineOperate.insertMedicine(med);
		}
		if(ev.getSource()==mdelete){
			MedicineOperate.deleteMedicineByMno(tfmno.getText());
		}
		if(ev.getSource()==mmodify){
			Medicine med=new Medicine();
			med=MedicineOperate.findMedicineByMno(tfmno.getText());
			med.setMname(tfmname.getText());
			med.setMprice(Integer.parseInt(tfmprice.getText()));
			MedicineOperate.updateMedicineByMno(med);
		}
		if(ev.getSource()==mseek){
			Medicine med=new Medicine();
			med=MedicineOperate.findMedicineByMno(tfmno.getText());
			tfmname.setText(med.getMname());
			tfmprice.setText(Integer.toString(med.getMprice()));
		}
		
		//床位信息管理
		if(ev.getSource()==bok){
			Bed bed=new Bed();
			bed.setBno(tfbno.getText());
			bed.setCondition(tfcondition.getText());
			bed.setBprice(Integer.parseInt(tfbprice.getText()));
			BedOperation.insertBed(bed);
		}	
		if(ev.getSource()==bdelete){
			BedOperation.deleteBedByBno(tfbno.getText());
		}
		if(ev.getSource()==bmodify){
			Bed bed=new Bed();
			bed=BedOperation.findBedByBno(tfbno.getText());
			bed.setCondition(tfcondition.getText());
			bed.setBprice(Integer.parseInt(tfbprice.getText()));
			BedOperation.updateBedByBno(bed);
		}
		if(ev.getSource()==bseek){
			Bed bed=new Bed();
			bed=BedOperation.findBedByBno(tfbno.getText());
			tfcondition.setText(bed.getCondition());
			tfbprice.setText(Integer.toString(bed.getBprice()));
		}
		
		if(ev.getSource()==preok){
			Prepay pre=new Prepay();
			pre.setPno(tfpno.getText());
			pre.setPremoney(tfprepay.getText());
			PrepayOperate.insertPrepay(pre);
		}
		
		if(ev.getSource()==aseek){
			MedicalCase ca=new MedicalCase();
			Prepay pre=new Prepay();
			Medicine med=new Medicine();
			Bed bed=new Bed();
			ca=CaseOperate.findcaseByPno(tfpno.getText());
			pre=PrepayOperate.findPrepayByPno(tfpno.getText());
			tfdno.setText(ca.getDno());
			tfmno.setText(ca.getMno());
			tfbno.setText(ca.getBno());
			med=MedicineOperate.findMedicineByMno(tfmno.getText());
			bed=BedOperation.findBedByBno(tfbno.getText());
			tfday.setText(Integer.toString(ca.getDay()));
			if(pre.getPremoney()==null){
				tfprepay.setText("0");
			}
			else tfprepay.setText(pre.getPremoney());
			
			tftotal.setText(Integer.toString(bed.getBprice()+med.getMprice()));
			tfpay.setText(Integer.toString(-Integer.parseInt(pre.getPremoney())+Integer.parseInt(tftotal.getText())));
			
		}
	}
}
