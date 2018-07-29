package Student_Achievement;

import java.io.IOException;
import java.util.Scanner;

public class MainStu {
	Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		Manage manage=new Manage("Student_Achievement.txt");
		MainStu mas=new MainStu();
		mas.menuStu(manage);
		}
	public void menuStu(Manage manage)
	{
		System.out.print("\n**********ѧ���ɼ� ��ѯϵͳ**********\n"+
	                       "*---------1.ѧ����Ϣ��ѯ-----------*\n"+
	                       "*---------2.��ʦ�˺ŵ�½-----------*\n"+
				           "*---------3.�˳���ѯϵͳ-----------*\n"+
				           "*����������ѡ��Ĺ��ܣ�");
		int choice=Integer.parseInt(in.nextLine());
		switch(choice){
		case 1:
			System.out.print("\n����ѧ��ѧ�Ż������Բ�ѯ�ɼ���\n"
					+"ѧ��/������");
			//in.nextLine();
			String info=in.nextLine();
			if(manage.search(manage.file,info)==0)
				System.out.println("��Ϣ��ѯʧ�ܣ�");
			menuStu(manage);
			break;
		case 2: 
			System.out.println("��ʦ�˺ŵ�½��");
			try {
				boolean flag=manage.login();
				if(flag==false)
				{
					System.out.println("��½ʧ�ܣ������µ�½��");
					flag=manage.login();
				}
				System.out.println("����Ա�ѳɹ���½��");
				menuAdmin(manage);
			} catch (IOException e) {
				 e.printStackTrace();
			}
			break;
		case 3:{
			System.out.println("\n�ѳɹ��˳�ϵͳ��");
			in.close();
			System.exit(0);
		}
		default:
			System.out.println("��������ȷ��ţ�");
		}
		//in.close();
	}
	public void menuAdmin(Manage manage)
	{
		System.out.print("\n**********ѧ���ɼ� ����ϵͳ*********\n"+
	                       "*---------1.ѧ����Ϣ�б�-----------*\n"+
	                       "*---------2.ѧ����Ϣ���-----------*\n"+
	                       "*---------3.ѧ����Ϣɾ��-----------*\n"+
	                       "*---------4.ѧ����Ϣ�޸�-----------*\n"+
	                       "*---------5.��ѧ��������-----------*\n"+
	                       "*---------6.�˳���ѯϵͳ-----------*\n"+
				           "*����������ѡ��Ĺ��ܣ�");
		int choice=Integer.parseInt(in.nextLine());
		switch(choice)
		{
		case 1:
			System.out.println("\n����\tѧ��\tԺϵ\tרҵ\t����\tӢ��\t����\tרҵ1\tרҵ2\t�ܷ�\tƽ����\n");
			manage.list(manage.file);
			menuAdmin(manage);
			break;
		case 2:
			manage.input(manage.file, manage.stu);
			menuAdmin(manage);
			break;
		case 3:
			System.out.println("\n����ѧ��������ѧ���Խ���ɾ����");
			System.out.print("����/ѧ��:");
			//in.nextLine();
			String info=in.nextLine();
			try {
				manage.delete(manage.file, info, manage.stu);
			} catch (Exception e) {
				e.printStackTrace();
			}

			menuAdmin(manage);
			break;
		case 4:
			System.out.println("\n����ѧ��������ѧ���Խ����޸ģ�");
			System.out.print("����/ѧ��:");
			//in.nextLine();
			String information=in.nextLine();
			try {
				int flag=manage.revise(manage.file, manage.stu, information);
				if(flag==1)
					System.out.println("�޸ĳɹ���");
				else
					System.out.println("���޴��ˣ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
			menuAdmin(manage);
			break;
		case 5:
			System.out.println("\n*---��ѧ���ʸ��---*\n"
					+"ѧԺ\t����\tѧ��");
			manage.scholarship(manage.file, manage.stu, 3);
			menuAdmin(manage);
			break;
		case 6:
			System.out.println("�ѳɹ��˳�ϵͳ��");
			in.close();
			System.exit(0);
			break;
		default:
			System.out.println("��������ȷ��ţ�");
			menuAdmin(manage);
		}
	}
}