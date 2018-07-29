package Stu_Achievement;

import java.util.LinkedList;
import java.util.Scanner;

public class StudentManager {
	LinkedList<Student> stulist = MainStudent.stulist;
	LinkedList<Course> courselist = MainStudent.courselist;

	// ����ѧ����Ϣ
	public void add(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		System.out.println("����ѧ��ѧ�ţ�");
		String num = sc.nextLine();

		for (int j = 0;; j++) {
			int flag = -1;
			for (int i = 0; i < stulist.size(); i++) {
				if (stulist.get(i).getNum().equals(num)) {
					System.out.println("ѧ���ظ����������룡");
					flag = 1;
				}
			}
			if (flag < 0)
				break;
			num = sc.nextLine();
		}
		System.out.println("����ѧ��������");
		String name = sc.nextLine();
		System.out.println("����ѧ�����䣺");
		String age = sc.nextLine();
		System.out.println("����ѧ���Ա�");
		String sex = sc.nextLine();
		System.out.println("����γ̺ţ���#��������");
		String course = sc.nextLine();
		LinkedList<Course> cnolist = new LinkedList<Course>();

		while (!course.equals("#")) {
			int j = -1;
			for (int i = 0; i < courselist.size(); i++) {
				// System.out.println(courselist.get(i).getCnum());
				if (courselist.get(i).getCnum().equals(course)) {
					cnolist.add(courselist.get(i));
					j = i;
				}
			}
			if (j < 0)
				System.out.println("�޴˿γ���Ϣ��");
			course = sc.nextLine();
		}
		if (num == null) {
			System.out.println("ѧ����Ϣ���ʧ�ܣ�");
			return;
		}
		stulist.add(new Student(num, name, age, sex, cnolist));
		System.out.println("ѧ����Ϣ��ӳɹ���");
	}

	// �޸�ѧ����Ϣ
	public void modify(String num,Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				System.out.println("����ѧ��������");
				String name = sc.nextLine();
				System.out.println("����ѧ�����䣺");
				String age = sc.nextLine();
				System.out.println("����ѧ���Ա�");
				String sex = sc.nextLine();
				System.out.println("����γ̺ţ���#��������");
				String course = sc.nextLine();
				LinkedList<Course> cnolist = new LinkedList<Course>();
				while (!course.equals("#")) {
					int j = -1;
					for (int k = 0; k < courselist.size(); k++) {
						if (courselist.get(k).getCnum().equals(course)) {
							cnolist.add(courselist.get(k));
							j = k;
						}
					}
					if (j < 0)
						System.out.println("�޴˿γ���Ϣ��");
					course = sc.nextLine();
				}
				stulist.get(i).setName(name);
				stulist.get(i).setAge(age);
				stulist.get(i).setSex(sex);
				stulist.get(i).setCs(cnolist);
				System.out.println("ѧ����Ϣ�޸ĳɹ���");
				return;
			}
		}
		System.out.println("δ�ҵ���ѧ����");
	}

	// ɾ��ѧ����Ϣ
	public void delete(String num) {
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				stulist.remove(i);
				System.out.println("ѧ����Ϣɾ���ɹ���");
				return;
			}
		}
		System.out.println("δ�ҵ���ѧ����");
	}

	// ��ѯѧ����Ϣ
	public void seek(String num) {
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				System.out.println("ѧ����Ϣ�������£�");
				System.out.println(stulist.get(i).toString());
				return;
			}
		}
		System.out.println("δ�ҵ���ѧ����");
	}

	// ��ӡѧ����Ϣ
	public void list() {
		if (stulist.size() == 0) {
			System.out.println("����ѧ�����ݣ�");
			return;
		}
		for (int i = 0; i < stulist.size(); i++) {
			System.out.println(stulist.get(i).toString());
		}
	}
}
