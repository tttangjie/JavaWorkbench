package LinkedList;
import java.util.Scanner;

public class Node {
	private Object data;
	private Node next;
	public Node()
	{

	}
	public Node(Object m)
	{
		this.data=m;
		this.next=null;
	}
	public Object getData()
	{
		return this.data;
	}
	
	public void creatListHead()//头插法 建立带头节点的链表
	{
		Node head=null;
		Scanner input=new Scanner(System.in);
		int m=input.nextInt();
		while(m>0)
		{
			Node p=new Node(m);
			p.next=head;
			head=p;
			m=input.nextInt();
		}
		//input.close();
		this.next=head;
	}
	
	public void creatListTail()//尾插法 建立带头节点的链表
	{
		Node tail=null,head=null;
		Scanner input=new Scanner(System.in);
		int m=input.nextInt();
		while(m>0)
		{
			if(head==null)
				{
				tail=head=new Node(m);
				this.next=head;
				}
			else
			{
				Node p=new Node(m);
				tail.next=p;
				tail=p;
			}
			m=input.nextInt();
		}
		//input.close();
	}
	
	public void print()//链表输出
	{
		Node p=this.next;
		while(p!=null)
		{
			System.out.print(p.data+" ");
			p=p.next;
		}
		System.out.println();
	}
	
	public Node reverse()//链表倒置
	{
		Node q=this.next;
		Node head=null;
		while(q!=null)
		{
			Node p=new Node(q.data);
			p.next=head;
			head=p;
			q=q.next;
		}
		Node h=new Node();
		h.next=head;
		return h;
	}
	
	public void insert(int m)//有序链表的插入
	{
		Node node=new Node(m);
		Node p=this,q=this.next;
		while(q!=null&&(int)q.data<=m)
		{
			p=q;
			q=q.next;
		}
		p.next=node;
		node.next=q;
	}
	
	public void delete(int m)//有序链表的删除
	{
		Node p=this,q=this.next;
		while(q!=null&&(int)q.data!=m)
		{
			p=q;
			q=q.next;
		}
		if(q==null);
		else if(q.next==null)
			p.next=null;
		else
			p.next=q.next;
	}
	
	public boolean combine(Node list)//有序链表的合并
	{
		Node h=new Node(),h1=this.next,h2=list.next,head=new Node();
		if(h1==null) 
			{
			this.next=h2;
			return true;
			}
		else if(h2==null)
			return true;
		else if((int)h1.data<=(int)h2.data)
		{
			head.next=h1;
			h1=h1.next;
		}
		else
			{
			head.next=h2;
			h2=h2.next;
			}
		h=head.next;
		while(h1!=null&&h2!=null)
		{
			if((int)h1.data<=(int)h2.data)
				{
				h.next=h1;
				h=h1;
				h1=h1.next;
				}
			else
				{
				h.next=h2;
				h=h2;
				h2=h2.next;
				}
			if(h2==null)
				h.next=h1;
			else
				h.next=h2;
		}
		this.next=head.next;
		return true;
	}
}
