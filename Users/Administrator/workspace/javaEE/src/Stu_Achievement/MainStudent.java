package Stu_Achievement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class MainStudent {
	static LinkedList<Student> stulist = new LinkedList();
	static LinkedList<Course> courselist = new LinkedList();
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Course c1 = new Course("����", "c1", "��ĳĳ");
		Course c2 = new Course("Ӣ��", "c2", "��ĳĳ");
		Course c3 = new Course("���", "c3", "��ĳĳ");
		Course c4 = new Course("����", "c4", "Ԭĳĳ");
		courselist.add(c1);
		courselist.add(c2);
		courselist.add(c3);
		courselist.add(c4);
		LinkedList<Course> stucourse1 = new LinkedList();
		stucourse1.add(c1);
		stucourse1.add(c3);
		stulist.add(new Student("055", "tj", "19", "girl", stucourse1));
		LinkedList<Course> stucourse2 = new LinkedList();
		stucourse2.add(c1);
		stucourse2.add(c2);
		stulist.add(new Student("034", "lyx", "19", "girl", stucourse2));

		StudentManager stuma = new StudentManager();
		CourseMangager coursema = new CourseMangager();
		MainStudent mas = new MainStudent();
		mas.stuMenu(stuma, coursema);

	}

	public void stuMenu(StudentManager stuma, CourseMangager coursema) {
		System.out.print("\n********ѧ����Ϣ ����ϵͳ********\n"
				+ "*---------1.����ѧ��-----------*\n"
				+ "*---------2.�޸�ѧ��-----------*\n"
				+ "*---------3.ɾ��ѧ��-----------*\n"
				+ "*---------4.��ѯѧ��-----------*\n"
				+ "*---------5.��ӡѧ��-----------*\n"
				+ "*---------6.�γ̹���-----------*\n"
				+ "*---------7.ϵͳ�˳�-----------*\n" 
				+ "*����������ѡ��Ĺ��ܣ�");
		int choice = Integer.parseInt(in.nextLine());
		switch (choice) {
		case 1:
			System.out.println("*ѧ����Ϣ���");
			stuma.add(in);
			stuMenu(stuma, coursema);
			break;
		case 2:
			System.out.println("*������ѧ��ѧ���Խ����޸�");
			stuma.modify(in.nextLine(),in);
			stuMenu(stuma, coursema);
			break;
		case 3:
			System.out.println("*������ѧ��ѧ���Խ���ɾ��");
			stuma.delete(in.nextLine());
			stuMenu(stuma, coursema);
			break;
		case 4:
			System.out.println("*������ѧ��ѧ���Խ��в�ѯ");
			stuma.seek(in.nextLine());
			stuMenu(stuma, coursema);
			break;
		case 5:
			System.out.println("*����ѧ����Ϣ���£�");
			stuma.list();
			stuMenu(stuma, coursema);
			break;
		case 6:
			courseMenu(stuma,coursema);
			break;
		case 7:
			System.out.println("\n�ѳɹ��˳�ϵͳ��");
			// in.close();
			System.exit(0);
			break;
		default:
			System.out.println("��������ȷ��ţ�");
			stuMenu(stuma, coursema);
		}
	}

	public void courseMenu(StudentManager stuma,CourseMangager coursema) {
		System.out.print("\n********�γ���Ϣ ����ϵͳ********\n"
				+ "*---------1.���ӿγ�-----------*\n"
				+ "*---------2.�޸Ŀγ�-----------*\n"
				+ "*---------3.ɾ���γ�-----------*\n"
				+ "*---------4.��ӡ�γ�-----------*\n"
				+ "*-----5.��ѯѧ��ѡ�����-------*\n" 
				+ "*-----6.��ӡ�γ���ѧ����Ϣ-----*\n"
				+ "*-------7.���ѡ�ε�ѧ�� -------*\n"
				+ "*-------8.ɾ��ѡ�ε�ѧ�� -------*\n"
				+ "*-------9.�����ϼ��˵�---------*\n" 
				+ "*����������ѡ��Ĺ��ܣ�");
		int choice = Integer.parseInt(in.nextLine());
		switch (choice) {
		case 1:
			coursema.add(in);
			courseMenu(stuma,coursema);
			break;
		case 2:
			System.out.println("*��������Ҫ�޸ĵĿγ̵Ŀγ̺�");
			coursema.modify(in.nextLine(),in);
			courseMenu(stuma,coursema);
			break;
		case 3:
			System.out.println("*��������Ҫɾ���Ŀγ̵Ŀγ̺�");
			coursema.delete(in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 4:
			System.out.println("*�γ��б�����");
			coursema.list();
			courseMenu(stuma,coursema);
			break;
		case 5:
			System.out.println("*��������Ҫ��ѯ��ѧ����ѧ��");
			coursema.stuCourse(in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 6:
			System.out.println("*������γ̺�");
			coursema.listStu(in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 7:
			System.out.println("*����������γ̺ź�ѧ��ѧ��");
			coursema.courseAddStu(in.nextLine(), in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 8:
			System.out.println("*����������γ̺ź�ѧ��ѧ��");
			coursema.courseDeleteStu(in.nextLine(), in.nextLine());
			courseMenu(stuma,coursema);
			break;
		case 9:
			stuMenu(stuma, coursema);
			break;
		}
	}
}
