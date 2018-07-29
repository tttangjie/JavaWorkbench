package zuoye;

import java.util.Scanner;

public class money {

		public static String change(double n)throws NumberFormatException
		{
			if((n*1000)%10!=0)throw new NumberFormatException("Input wrong number");
			String b[]={"Áã","Ò¼","·¡","Èþ","ËÁ","Îé","Â½","Æâ","°Æ","¾Á"};
			String c[]={"","Ê°","°Û","Ç§","Íò","Ê°Íò","°ÛÍò","Ç§Íò","ÒÚ"};
			String d[]={"½Ç","·Ö"};
			String s="";
			int m=(int)n,f1=((int)(n*10))%10,f2=((int)(n*100))%10,i=0,t=m,j,x=0;
			int[] k=new int[10];
			if(t==0);
			else
			{while(t!=0)
			{
				k[i++]=t%10;
				t=t/10;
			}
			while(k[x]==0) x++;
			if((j=i-1)==1||(j=i-1)==5&&k[j]==1)
				s+=c[j];
			else s=s+b[k[j]]+c[j];
			for(j--;j>=x;j--)
			{
			    if(k[j]==0&&k[j-1]==0) continue;
				else if(k[j]==0) s+="Áã";
				else 
					s=s+b[k[j]]+c[j];
			}
			s+="Ôª";
			}
			if(f1==0&&f2==0)s+="Õû";
			if(f1!=0) s+=b[f1]+d[0];
			if(f2!=0) s+=b[f2]+d[1];	
			return s;
		}

		public static void main(String[] args) {
			Scanner input=new Scanner(System.in);
			System.out.print("Please input an number:");
			double n=input.nextDouble();
			String s;
			s=change(n);
			System.out.println(s);		
			input.close();
		}
	}
