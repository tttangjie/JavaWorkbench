import java.util.*;
public class linkedList {//��������Ԫ
	int date=0;
    linkedList next ;
	linkedList()//���췽��
	{
		date=0;	
		next=null;
	}
	linkedList(int date,linkedList q)//���췽������ָ��
	{
		this.date=date;	
		next=q;
	}
	public linkedList(linkedList link)//������´������󣬲�ָ��ԭ���Ķ���
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
    	    p = new linkedList(Data,q);//ͷ�巨
    	    q=p;
    	    len++;//��¼����
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
