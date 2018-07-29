package ʵ����;

public class MyDate {
	private int year,month,day;
	public MyDate(int year,int month,int day)
	{
		this.set(year,month,day);
	}
	public MyDate() //��ʼ������ֵΪ1990.1.1
	{
		this(1990,1,1);
	}
	public MyDate(MyDate d)
	{
		this.set(d);
	}
	public void set(MyDate d)
	{
		set(d.year,d.month,d.day);
	}

	public static boolean isLeapYear(int year)
	{
		return year%400==0||year%100!=0&&year%4==0;
	}

	public int daysOfMonth(int year,int month)
	{
		switch(month)
		{
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:return 31;
			case 4:case 6:case 9:case 11:return 30;
			case 2:return MyDate.isLeapYear(year)? 29: 28;
			default:return 0;
		}
	}

	public int daysOfMonth()
	{
		return daysOfMonth(this.year,this.day);
	}
	public void set(int year,int month,int day)
	{
		this.year=year;
		this.month=(month>=1&&month<=12)?month:1;
		this.day=(day>=1&&day<=daysOfMonth(year,month))?day:1;
	}

	public void tomorrow()
	{
		this.day++;
		if(this.day>this.daysOfMonth(this.year,this.month))
		{
			this.day=1;
			this.month++;
			if(this.month>12)
			{
				this.month=1;
				this.year++;
			}
		}
	}
	public MyDate yestoday()
	{
		MyDate date=new MyDate(this);
		date.day--;
		if(date.day==0)
		{
			date.month--;
			if(date.month==0)
			{
				date.month=12;
				date.year--;
			}
			date.day=daysOfMonth(date.year,date.month);
		}
		return date;
	}

	public MyDate daysAfter(int n)   //tomorrow()��yesterday()�ϲ�
	{
		MyDate date=new MyDate(this);
		if(n<0)
		{
			for(int i=0;i<-n;i++)
			{
				date=date.yestoday();
			}
		}
		else 
			for(int i=0;i<n;i++)
			{
				date.tomorrow();
			}
		return date;
	}

	public int getDistence()   //����1990.1.1������
	{
		int sum=0,n=0,m=28;
		MyDate d=new MyDate();
		for(int i=d.year;i<this.year;i++)
			if(isLeapYear(i)==true) n++;
		if (isLeapYear(this.year)==true) m=29;
		sum+=365*(this.year-d.year)+n;
		switch(this.month-1)
		{
			case 11:sum+=30;
			case 10:sum+=31;
			case 9:sum+=30;
			case 8:sum+=31;
			case 7:sum+=31;
			case 6:sum+=30;
			case 5:sum+=31;
			case 4:sum+=30;
			case 3:sum+=31;
			case 2:sum+=m;
			case 1:sum+=31;break;
		}
		return sum+this.day-1;
	}

	public int getWeek()    //���ص�ǰ��Ӧ���������ڼ�����Χ0~6
	{
		return (this.getDistence()+1)%7;
	}

	public String toWeekString()   //���ص�ǰ���������ڼ����ַ���
	{
		String week="��һ����������";
		return "����"+week.charAt(getWeek());
	}

	public boolean before(MyDate d)//�ж��Ƿ���ָ������֮ǰ
	{
		if(this.year<d.year) return true;
		else if(this.year==d.year)
		{
			if (this.month<d.month||this.month==d.month&&this.day<this.day)return true;
		}
	  return false;
}
	public int daysBetween(MyDate d)//���ص�ǰ����������d֮���������
	{
		return    (this.getDistence()-d.getDistence()>0?(this.getDistence()-d.getDistence()):(d.getDistence()-this.getDistence()));
	}

	public boolean equals(Object obj)//�Ƚ����������Ƿ����
	{
		if(obj==null)return false;
		if(obj instanceof MyDate)
		{
			return this==obj||this.year==((MyDate)obj).year&&this.month==((MyDate) obj).month&&this.day==((MyDate)obj).day;
		}
		return false;
	}

	public String toString()  //�������������ַ���
	{
		return year+"��"+month+"��"+day+"��";
	}

	public static void main(String[] args) 
	{
		MyDate d1=new MyDate(2016,4,25);
		MyDate d2=new MyDate(2016,4,20);
		System.out.println(d1.daysAfter(-60)+" "+d1.daysAfter(365));
		System.out.println(d1.toWeekString());
		System.out.println(d1.daysBetween(d2));
		System.out.println(d1.before(d2));
	}

}
