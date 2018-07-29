package StuAchievement;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;;
public class MenuFrame extends JFrame {
	private JMenu jm1,jm2,jm3,jm4;
	private JMenuBar jmb;
	private DefaultTableModel tablemodel;
	public MenuFrame (){
		super("医院管理系统");
		this.setSize(900,500);
		this.setLocationRelativeTo(null);
		
		jmb = new JMenuBar();// 创建菜单容器
		jm1=new JMenu(" 增添 ");
		jm2=new JMenu(" 修改 ");
		jm3=new JMenu(" 删除 ");
		jm4=new JMenu(" 奖学金 ");
		jmb.add(jm1).setFont(new Font("宋体",Font.PLAIN,14));
		jmb.add(jm2).setFont(new Font("宋体",Font.PLAIN,14));
		jmb.add(jm3).setFont(new Font("宋体",Font.PLAIN,14));
		jmb.add(jm4).setFont(new Font("宋体",Font.PLAIN,14));
		this.add(jmb,"North");
		
		this.setVisible(true);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String titles[]={"姓名","学号","院系","班级","高数","英语","体育","专业1","专业2","总分","平均分"};
		this.tablemodel=new DefaultTableModel(titles,0);//默认表格模型，titles指定标题，0行
		JTable jtable=new JTable(this.tablemodel);//创建表格，指定表格模型
		this.getContentPane().add(new JScrollPane(jtable));//添加滚动窗格（包含表格）
	}

}
