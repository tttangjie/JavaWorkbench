package test;  
import java.awt.*;  
  
import javax.swing.*;  
  
import java.awt.event.*;  
  
//Java事件处理  
public class EventDemo extends JFrame implements ActionListener {  
  
    // 定义一个panel  
    Panel mp = null;  
    JButton jb1 = null;  
    JButton jb2 = null;  
  
    public static void main(String[] args) {  
        EventDemo ed = new EventDemo();  
  
    }  
  
    public EventDemo() {  
        mp = new Panel();  
        jb1 = new JButton("黑色");  
        jb2 = new JButton("红色");  
  
        this.add(jb1, BorderLayout.NORTH);  
        mp.setBackground(Color.black);  
        this.add(mp);  
        this.add(jb2, BorderLayout.SOUTH);  
  
        Cat myCat=new Cat();  
          
        jb1.addActionListener(myCat);  
        jb2.addActionListener(myCat);  
          
        // 注册监听  
        jb1.addActionListener(this);  
        //指定action命令  
        jb1.setActionCommand("aa");  
        jb2.addActionListener(this);  
        jb2.setActionCommand("bb");  
          
        this.setSize(200, 150);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
    }  
  
    // 对事件处理的方法  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        //判断是哪个按钮被点击  
        if(e.getActionCommand().equals("aa")){  
            //System.out.println("黑色");   
            mp.setBackground(Color.BLACK);  
        }else if(e.getActionCommand().equals("bb")){  
            //System.out.println("红色");  
            mp.setBackground(Color.RED);  
        }  
    }  
  
}  
  
//一个普通的类也可以监听  
class Cat implements ActionListener{  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("aa")){  
            System.out.println("猫也知道你按下了黑色按钮");  
        }else if(e.getActionCommand().equals("bb")){  
            System.out.println("猫也知道你按下了红色按钮");  
        }  
    }  
      
}  