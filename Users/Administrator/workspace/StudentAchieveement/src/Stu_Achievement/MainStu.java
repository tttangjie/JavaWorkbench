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
		System.out.println("****ѧ���ɼ�����ϵͳ****\n******1.�ɼ���ѯ******\n******2.�ɼ����******\n******3.�ɼ�ɾ��******\n******4.�ɼ��޸�******");
		
		return 1;
	}*/

}
