package Stu_Achievement;

import java.util.LinkedList;
import java.util.Scanner;

public class CourseMangager {
	LinkedList<Course> courselist = MainStudent.courselist;
	LinkedList<Student> stulist = MainStudent.stulist;

	// ���ӿγ�
	public void add(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		System.out.println("����γ̺ţ�");
		String cnum = sc.nextLine();
		System.out.println("����γ�����");
		String cname = sc.nextLine();
		System.out.println("�����ʦ����");
		String teacher = sc.nextLine();
		if (cnum == null) {
			System.out.println("�γ���Ϣ���ʧ�ܣ�");
			return;
		}
		courselist.add(new Course(cnum, cname, teacher));
		System.out.println("�γ���Ϣ��ӳɹ���");
	}

	// �޸Ŀγ�
	public void modify(String cnum,Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		for (int i = 0; i < courselist.size(); i++) {
			if (courselist.get(i).getCnum().equals(cnum)) {
				System.out.println("����γ�����");
				courselist.get(i).setCname(sc.nextLine());
				System.out.println("�����ʦ����");
				courselist.get(i).setTeacher(sc.nextLine());
				System.out.println("�γ���Ϣ�޸ĳɹ�");
				return;
			}
		}
		System.out.println("δ�ҵ��˿γ̣�");
	}

	// ɾ���γ���Ϣ
	public void delete(String cnum) {
		for (int i = 0; i < courselist.size(); i++) {
			if (courselist.get(i).getCnum().equals(cnum)) {
				courselist.remove(i);
				System.out.println("�γ���Ϣɾ���ɹ���");
				return;
			}
		}
		System.out.println("δ�ҵ��˿γ̣�");
	}

	// ��ӡ�γ���Ϣ
	public void list() {
		if (courselist.size() == 0) {
			System.out.println("���޿γ����ݣ�");
			return;
		}
		for (int i = 0; i < courselist.size(); i++) {
			System.out.println(courselist.get(i).toString());
		}
	}

	// ͨ��ѧ��ѧ�ţ���ѯ��ѧ��ѡ�����
	public void stuCourse(String num) {
		for (int i = 0; i < stulist.size(); i++) {
			if (stulist.get(i).getNum().equals(num)) {
				for (int j = 0; j < stulist.get(i).getCs().size(); j++)
					System.out.println(stulist.get(i).getCs().get(j));
				return;
			}
		}
		System.out.println("δ��ѯ����ѧ��ѡ����Ϣ��");
	}

	// ͨ���γ̺ţ���ӡ��ǰ�γ�����ѧ����Ϣ
	public void listStu(String cnum) {
		for (int i = 0; i < stulist.size(); i++) {
			for (int j = 0; j < stulist.get(i).getCs().size(); j++) {
				if (stulist.get(i).getCs().get(j).getCnum().equals(cnum)) {
					System.out.println(stulist.get(i).toString());
					break;
				}
			}
		}
	}

	// ���ѡ���ſγ̵�ѧ��
	public void courseAddStu(String cnum, String num) {
		int flag=-1;
		for (int j = 0; j < stulist.size(); j++) {
			if (stulist.get(j).getNum().equals(num)) {
				for (int i = 0; i < courselist.size(); i++) {
					if (courselist.get(i).getCnum().equals(cnum)) {
						stulist.get(j).getCs().add(courselist.get(i));
						System.out.println("�ѳɹ����ѡ���ſγ̵�ѧ����");
						flag=1;
					}
				}
			}
		}
		if(flag<0)
			System.out.println("δ�ɹ���ӣ�");
	}
	
	//ɾ��ѡ���ſγ̵�ѧ��
	public void courseDeleteStu(String cnum,String num){
		int flag=-1;
		for (int j = 0; j < stulist.size(); j++) {
			if (stulist.get(j).getNum().equals(num)) {
				for (int i = 0; i < stulist.get(j).getCs().size(); i++) {
					if (stulist.get(j).getCs().get(i).getCnum().equals(cnum)) {
						stulist.get(j).getCs().remove(i);
						flag=1;
					}
				}
			}
		}
		if(flag<0)
			System.out.println("δ�ɹ�ɾ����");
	}
}
