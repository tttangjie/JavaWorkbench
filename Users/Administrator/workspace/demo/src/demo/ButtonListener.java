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
 
 myButtonFrame(String s) { // ���캯�� 
  super(s); 
  this.setSize(200, 120); 
  /* ������ť */ 
  btn = new Button("���"); 
  this.add(btn); 
  // �¼�������������ע�� 
  ButtonListener bl = new ButtonListener(); 
  btn.addActionListener(bl); 
 } 
} 
 
