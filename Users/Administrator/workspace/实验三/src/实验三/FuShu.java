package 实验三;
//声明复数类
public class FuShu {
	private double real,image; //成员变量实部和虚部
	public FuShu(double real,double image) 
	{
		this.real=real;
		this.image=image;
	}
	public FuShu(String s)//字符串构造复数
	{
		int flag1=0,flag2=0,t=0,i;
		for(i=1;i<s.length();i++)
		{
			if(s.charAt(i)=='i') flag1=1;
			if(s.charAt(i)=='+'||s.charAt(i)=='-')
				{
				t=i;
			    flag2=1;
		    	}
		}
		if(flag1==0)
			{
			this.image=0;
			this.real=Double.parseDouble(s);
			}
		
		else{
			String image=s.substring(t,s.length()-1);
			this.image=Double.parseDouble(image);
		}
		if(flag2==0&&flag1!=0) this.real=0;
		else{
			String real=s.substring(0,t);
			this.real=Double.parseDouble(real);
		}
	}
	public FuShu add(FuShu f)//复数加法
	{
		FuShu result=new FuShu(this.real+f.real,this.image+f.image);
		return result;
	}
	public FuShu sub(FuShu f)//复数减法
	{
		FuShu result=new FuShu(this.real-f.real,this.image-f.image);
		return result;
	}
	public String toString()//字符串描述
	{
		if(this.real==0&&this.image==0) return "";
		if(this.real==0) return this.image+"i";
		else if(this.image==0) return this.real+"";
		else if(this.image<0) return this.real+"-"+this.image+"i";
		else return this.real+"+"+this.image+"i";
	}
	public boolean equal(FuShu b)//比较相等
	{
		return this==b||b!=null&&this.real==b.real&&this.image==b.image;
	}

	public static void main(String[] args)
	{
		FuShu a=new FuShu(1.2,5);
		FuShu b=new FuShu(0.8,2.5);
		FuShu c=new FuShu("3+2i");
		System.out.println(a+" + "+b+" = "+a.add(b).toString());
		System.out.println(a+" - "+c+" = "+a.sub(c).toString());
		System.out.println("a equals b?  "+a.equal(b));
		
	}
}
