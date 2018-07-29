package demo; 
 
import java.awt.*; 
import java.awt.event.*; 
 
class ButtonListener implements ActionListener { 
 public void actionPerformed(ActionEvent e) { 
  System.out.println("hello"); 
 } 
} 
 
class myButtonFrame extends Frame { 
 Button btn; 
 
 myButtonFrame(String s) { // 构造函数 
  super(s); 
  this.setSize(200, 120); 
  /* 创建按钮 */ 
  btn = new Button("点击"); 
  this.add(btn); 
  // 事件监听器创建和注册 
  ButtonListener bl = new ButtonListener(); 
  btn.addActionListener(bl); 
 } 
} 
 
