import java.util.*;
public class linkedList {//创建链表单元
	int date=0;
    linkedList next ;
	linkedList()//构造方法
	{
		date=0;	
		next=null;
	}
	linkedList(int date,linkedList q)//构造方法，插指针
	{
		this.date=date;	
		next=q;
	}
	public linkedList(linkedList link)//深拷贝，新创建对象，不指向原来的对象。
	{
		link.date=this.date;
		link.next=this.next;
	}
	public static void main(String[] args)
	{  int Data=0,len=0;
	   Scanner sc=new Scanner(System.in);
	   Data=sc.nextInt();
       linkedList head = new linkedList();
       len++;
       head.date=Data;       
       linkedList q =head;
       linkedList p = null;
       Data=sc.nextInt();    
       while(Data!=-1)
       { 	
    	    p = new linkedList(Data,q);//头插法
    	    q=p;
    	    len++;//记录长度
    	    Data=sc.nextInt();    
       }
       head=p;
       for(int i=0;i<len;i++)
       {
    	   System.out.println(p.date);
    	   p=p.next;
       }
       sc.close();
       
	}
}
