package 实验三;
//声明一个Friends类继承Person类
public class Friends extends Person 
{
	private Friends friends[];//好友数组，元素引用本类实例
	public Friends(String name,MyDate birthday,String sex,String province,String city,Friends friends[])
	{
		super(name,birthday,sex,province,city);
		set(friends);
	}
	public Friends(String name,MyDate birthday,Friends friends[])
	{
		this(name,birthday,"","","",friends);
	}
	public Friends()
	{
		this("",null,null);
	}
	public Friends(Friends f)
	{
		this(f.name,f.birthday,f.sex,f.province,f.city,f.friends);
	}
	public void set(Friends friends[])
	{
		this.friends=friends;
	}
	public void addFriend(Friends f)//添加好友，互为好友，插入不重复元素
	{
		boolean flag=true;
		for(int i=0;i<friends.length;i++)
			if(friends[i].equals(f))
				{flag=false;}
			if(flag==true)
	     	 {
	     		friends[friends.length]=f;
	     		f.friends[f.friends.length]=this;
	     	}
	}
	public String toString()
	{
		String s=super.toString()+"\nFriends:";
		for(int i=0;i<friends.length;i++)
		{
			s=s+"\n"+friends[i].name;
		}
		return s;
	}
}
