
import java.util.Scanner;

public class Nodeone {
	private int data;
	private Nodeone next;
	public Nodeone(int m)//构造函数
	{
		this.data=m;
		this.next=null;
	}

	public  Nodeone creatByHead(Scanner reader)//创建链表
	{
		Nodeone head = null,rear;
		int m=reader.nextInt();
		//System.out.println(m+"*****");//输出m
		head=new Nodeone(m);
		m=reader.nextInt();
		
		while(m>0)
		{
			if(head==null) 
				rear=head;
			else
			{
				//System.out.println(m);//输出m
				rear=new Nodeone(m);
				rear.next=head;
				head=rear;
				m=reader.nextInt();				
			}

		}
		
		return head;
	}
	public void print(Nodeone head)
	{
		while(head!=null)
		{
			System.out.println(head.data);
			head=head.next;
		}
	}
	  public static void main(String args[])
	   {
		   Scanner reader=new Scanner(System.in);
		   Nodeone h=new Nodeone(1),head; 
		   head=h.creatByHead(reader);
		   h.print(head);
		   reader.close();
		   
	   }
}
