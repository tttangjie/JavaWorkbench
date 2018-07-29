package demo; 
 
import java.awt.BorderLayout ; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JMenuBar; 
import javax.swing.JPanel; 
 
public class GuiDemo { 
 public static void main(String[] args) { 
 
  JFrame mainFrame = new JFrame(); 
  mainFrame.setSize(300, 300); 
  mainFrame.setVisible(true); 
  mainFrame.setDefaultCloseOperation(3); 
  //mainFrame.setLayout(new BorderLayout()); 
  JPanel topPanel = new JPanel(); 
  JPanel bottomPanel = new JPanel(); 
  topPanel.setSize(200, 280); 
  JLabel label1= new JLabel("hello"); 
  bottomPanel.setSize(200, 280); 
  topPanel.add(label1); 
  JButton btn1= new JButton(); 
  btn1.setSize(100, 40); 
  btn1.setText("°´Å¥"); 
  mainFrame.add(btn1); 
  //mainFrame.add(topPanel); 
  //mainFrame.add(bottomPanel); 
  mainFrame.add(new JMenuBar()); 
  mainFrame.add(label1); 
 } 

} 