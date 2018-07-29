package test;  
import java.awt.*;  
  
import javax.swing.*;  
  
import java.awt.event.*;  
  
//Java�¼�����  
public class EventDemo extends JFrame implements ActionListener {  
  
    // ����һ��panel  
    Panel mp = null;  
    JButton jb1 = null;  
    JButton jb2 = null;  
  
    public static void main(String[] args) {  
        EventDemo ed = new EventDemo();  
  
    }  
  
    public EventDemo() {  
        mp = new Panel();  
        jb1 = new JButton("��ɫ");  
        jb2 = new JButton("��ɫ");  
  
        this.add(jb1, BorderLayout.NORTH);  
        mp.setBackground(Color.black);  
        this.add(mp);  
        this.add(jb2, BorderLayout.SOUTH);  
  
        Cat myCat=new Cat();  
          
        jb1.addActionListener(myCat);  
        jb2.addActionListener(myCat);  
          
        // ע�����  
        jb1.addActionListener(this);  
        //ָ��action����  
        jb1.setActionCommand("aa");  
        jb2.addActionListener(this);  
        jb2.setActionCommand("bb");  
          
        this.setSize(200, 150);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
    }  
  
    // ���¼�����ķ���  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        //�ж����ĸ���ť�����  
        if(e.getActionCommand().equals("aa")){  
            //System.out.println("��ɫ");   
            mp.setBackground(Color.BLACK);  
        }else if(e.getActionCommand().equals("bb")){  
            //System.out.println("��ɫ");  
            mp.setBackground(Color.RED);  
        }  
    }  
  
}  
  
//һ����ͨ����Ҳ���Լ���  
class Cat implements ActionListener{  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("aa")){  
            System.out.println("èҲ֪���㰴���˺�ɫ��ť");  
        }else if(e.getActionCommand().equals("bb")){  
            System.out.println("èҲ֪���㰴���˺�ɫ��ť");  
        }  
    }  
      
}  