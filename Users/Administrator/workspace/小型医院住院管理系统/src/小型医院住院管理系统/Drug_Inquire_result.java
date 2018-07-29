package 小型医院住院管理系统;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 药品查询结果界面
 */
public class Drug_Inquire_result {
	public Drug_Inquire_result(String a,String b,String c,String d) {
		//创建窗体对象
		JFrame jf = new JFrame("药品查询结果"); 
		//设置大小
		jf.setSize(300, 300);
		//设置居中
		jf.setLocationRelativeTo(null);
		//设置关闭事件
		jf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ee){
				jf.setVisible(false);
			}
		});
		//添加label
		Label drug_id = new Label("药品编号:");
		Label name = new Label("药品名称:");
		Label number = new Label("药品余量:");
		Label price = new Label("药品价格:");
		//添加信息
		Label tfdrug_id = new Label(a);
		Label tfname = new Label(b);
		Label tfnumber = new Label(c);
		Label tfprice = new Label(d);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		//添加
		p1.add(drug_id);
		p1.add(tfdrug_id);
		p2.add(name);
		p2.add(tfname);
		p3.add(number);
		p3.add(tfnumber);
		p4.add(price);
		p4.add(tfprice);
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		jf.add(p5);
		
		jf.setVisible(true);
	}
/*
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Drug_Inquire_result drug_inquire_result = new Drug_Inquire_result();
	}
*/
}
