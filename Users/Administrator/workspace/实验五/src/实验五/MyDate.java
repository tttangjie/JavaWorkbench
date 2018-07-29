package ʵ����;
//��MyDate������һ�����췽����һ����̬����
	public class MyDate {
		private static int thisYear=2016;
		int year,month,day;
	    
	    public MyDate(String s,String format) throws DateFormatException //faomatָ�����ڸ�ʽ
	    {
	    	int numY=0,numM=0,numD=0;
	    	for(int i=0;i<format.length();i++)
	    	{   
	    		if(format.charAt(i)=='y') numY++;
	    		if(format.charAt(i)=='M') numM++;
	    		if(format.charAt(i)=='d') numD++;
	    	}
	    	if(numY==0)this.set(thisYear,Integer.parseInt(s.substring(0,2)),Integer.parseInt(s.substring(3,5)));
	    	else if(numY==2)
	    	{
	    		if(Integer.parseInt(s.substring(0,2))>=50)
	    			this.set(Integer.parseInt("19"+s.substring(0,2)),Integer.parseInt(s.substring(3,5)),Integer.parseInt(s.substring(6,8)));
	    		else
	    			this.set(Integer.parseInt("20"+s.substring(0,2)),Integer.parseInt(s.substring(3,5)),Integer.parseInt(s.substring(6,8)));
	    	}
	    	else if(numY==4&&numM==2&&numD==2)
	    		this.set(Integer.parseInt(s.substring(0,4)),Integer.parseInt(s.substring(5,7)),Integer.parseInt(s.substring(8,10)));
	    	else
	    		throw new DateFormatException("���ڸ�ʽ�������");
	    }
	    //��̬�����д���ʵ��
	    public static MyDate parseDate(String s,String format)throws DateFormatException
	    {
	    	return new MyDate(s,format);
	    }
	    
	    
		public void set(int year,int month,int day)
		{
			if(year<=-2000||year>2500)
			{
				throw new DateFormatException(year+",��ݲ����ʣ���Ч���Ϊ-2000~2500��");
			}
			if(month<1||month>12)
			{
				throw new DateFormatException(month+"�£��·ݴ���");
			}
			if(day<1||day>MyDate.daysOfMonth(year,month))
			{
				throw new DateFormatException(year+"��"+month+"��"+day+"�գ����ڴ���");
			}
			this.year=year;
			this.month=month;
			this.day=day;
		}
		public MyDate(int year,int month,int day)throws DateFormatException
		{
			this.set(year,month,day);
		}
		public MyDate(MyDate d)throws DateFormatException
		{
			this.set(d.year,d.month,d.day);
		}
		public MyDate(String s)throws NumberFormatException,DateFormatException
		{
			this.set(Integer.parseInt(s.substring(0,4)),Integer.parseInt(s.substring(5,7)),Integer.parseInt(s.substring(8,10)));
		}
		public static MyDate parseDate(String s)throws NumberFormatException,DateFormatException
		{
			return new MyDate(s);
		}
		public static boolean isLeapYear(int year)
		{
			return year%400==0||year%100!=0&&year%4==0;
		}
		    public static int daysOfMonth(int year,int month)
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

	}
