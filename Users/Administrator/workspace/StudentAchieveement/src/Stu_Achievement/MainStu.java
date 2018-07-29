package Stu_Achievement;

import java.io.File;

public class MainStu {
	public static int count=0;
	static Student stu[]=new Student[100];
	public static void main(String[] args) throws Exception {
		File file=new File("Student_Achievement.txt");
		if(!file.exists())
			file.createNewFile();	
		new ArrayStu(file,stu);
		
		/*while(count==0)
		{
			
		}*/
		
		//InputStu ins=new InputStu(count,file,stu);
		//System.out.println(count);
		//SearchStu ses=new SearchStu(file,"tj");
		//DeleteStu des=new DeleteStu(file,"053",stu);
		//ReviseStu res=new ReviseStu(file,stu,"056");
		//System.out.println(stu[2].getSum());
		new SortStu(file,stu);
	}
	/*public static int choose(){
		System.out.println("****学生成绩管理系统****\n******1.成绩查询******\n******2.成绩添加******\n******3.成绩删除******\n******4.成绩修改******");
		
		return 1;
	}*/

}
