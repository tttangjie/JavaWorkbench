package demo; 
 
import java.awt.*; 
public class FlowLayoutDemo{ 
  public static void main(String[] args) { 
    Frame f = new Frame("��������"); 
    Button b1 = new Button("��ť1"); 
    Button b2 = new Button("��ť2"); 
    Button b3 = new Button("��ť3"); 
     
    f.setLayout(new FlowLayout()); 
    f.add(b1); 
    f.add(b2); 
    f.add(b3); 
     
    f.setSize(200,300); 
    f.setVisible(true); 
    
  } 
} 
