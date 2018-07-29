package 实验五;

public class Complex {
	double real,image;
	public Complex(double real,double image) 
	{
		this.real=real;
		this.image=image;
	}
	public Complex(Complex d)
	{
		this.real=d.real;
		this.image=d.image;
	}
	public Complex(String s)/*throws NumberFormatException*/
	{
		int flag1=0,flag2=0,t1=0,t2=-1,i;
		for(i=1;i<s.length();i++)
		{
			if(s.charAt(i)=='i') {t1=i;flag1=1;}
			if(s.charAt(i)=='+'||s.charAt(i)=='-')
				{t2=i;flag2=1;}
		}
		if(t1>t2)
		{
			if(flag1==0&&flag2==0)
			{
				this.image=0;
		    	if(s.charAt(0)=='i')
		    	{ this.image=1; this.real=0; }
	    	 	else{
	     			try{
				    	 this.real=Double.parseDouble(s);}
		     		catch(NumberFormatException ex){
				    	System.out.println("实数部分不能转化为字符串");}
		    	}
			}
			
			else if(flag2==0&&flag1==1){
				this.real=0;
		    	if(s.length()-1==0||s.length()-1==1)
		    	{
		    		if(s.charAt(0)=='-') this.image=-1;
			    	else if(s.charAt(0)=='i') this.image=1;
			    	else throw new NumberFormatException("纯虚数格式错误");
				}
		    	else
		    	{
		    		try{
		    			this.image=Double.parseDouble(s.substring(0,s.length()-1));}
		    		catch(NumberFormatException ex){
		    			System.out.println("虚数部分不能转化为字符串");}
			    }
	     	}	
			
			else if(flag1==1&&flag2==1){
				try{
					this.real=Double.parseDouble(s.substring(0,t2));}
				catch(NumberFormatException ex){
					System.out.println("实数部分不能转化为字符串");}
			if(t2==s.length()-2)
			this.image=1;
			else{
				try{
					this.image=Double.parseDouble(s.substring(t2,s.length()-1));}
				catch(NumberFormatException ex){
					System.out.println("虚数部分不能转化为字符串");}
			}
     		}
			else
				throw new NumberFormatException("输入格式错误");
     	}
		
		else throw new NumberFormatException("输入格式应为 a+bi");
	}
	public static Complex parseComplex(String s)throws NumberFormatException
	{
		return new Complex(s);
	}
}
