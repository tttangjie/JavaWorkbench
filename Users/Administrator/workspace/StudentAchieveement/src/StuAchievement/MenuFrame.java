package StuAchievement;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;;
public class MenuFrame extends JFrame {
	private JMenu jm1,jm2,jm3,jm4;
	private JMenuBar jmb;
	private DefaultTableModel tablemodel;
	public MenuFrame (){
		super("ҽԺ����ϵͳ");
		this.setSize(900,500);
		this.setLocationRelativeTo(null);
		
		jmb = new JMenuBar();// �����˵�����
		jm1=new JMenu(" ���� ");
		jm2=new JMenu(" �޸� ");
		jm3=new JMenu(" ɾ�� ");
		jm4=new JMenu(" ��ѧ�� ");
		jmb.add(jm1).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm2).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm3).setFont(new Font("����",Font.PLAIN,14));
		jmb.add(jm4).setFont(new Font("����",Font.PLAIN,14));
		this.add(jmb,"North");
		
		this.setVisible(true);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String titles[]={"����","ѧ��","Ժϵ","�༶","����","Ӣ��","����","רҵ1","רҵ2","�ܷ�","ƽ����"};
		this.tablemodel=new DefaultTableModel(titles,0);//Ĭ�ϱ��ģ�ͣ�titlesָ�����⣬0��
		JTable jtable=new JTable(this.tablemodel);//�������ָ�����ģ��
		this.getContentPane().add(new JScrollPane(jtable));//��ӹ������񣨰������
	}

}
