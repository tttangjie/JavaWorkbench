package ����;

public class Student {
    private String name;
    private int age;
    private boolean sex;
    private int score;
 
public  Student (String name,int age,boolean sex,int score){
    this.name= name;
    this.age= age;
    this.sex= sex;
    this.score= score;
}
    public Student() {
	// TODO Auto-generated constructor stub
}
	public static void main(String[] args) {
        // TODO Auto-generated method stub
Student stu01=new Student("�����",46,true,120);
Student stu02= stu01;
Student stu03=new Student("�����",46,true,120);
System.out.println("ͨ������ֵ�ı�����ԭ�������Ƿ����:"+stu01.equals(stu02));
System.out.println("������ȫ��ͬ�����ֱ�ʵ�����������������Ƿ����:"+stu01.equals(stu03));
System.out.println(stu01==stu02);
System.out.println(stu01==stu03);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age= age;
    }
    public String getSex(){
        if(sex)
            return"��";
        return"Ů";
    }
    public void setSex(boolean sex){
        this.sex= sex;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score= score;
 
    }
}
