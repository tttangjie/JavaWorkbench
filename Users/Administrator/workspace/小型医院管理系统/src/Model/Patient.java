package Model;

public class Patient {
	private String room;
	private int id; 
    private String name;
    private String sex;
    private int money;
    private int age;
    private String jiaofei;
    
    public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getRoom() {
		return this.room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	public int getMoney() {
		return this.money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getJiao(){
		return this.jiaofei;
	}
	public void setJiao(String b){
		this.jiaofei = b;
	}
	public Patient(String room,String name,String sex,int id,int money,int age,String b){
		this.set(room, name, sex, id, money,age,b);
	}
	public void set(String room,String name,String sex,int id,int money,int age,String b){
		this.id=id;
		this.money=money;
		this.name=name;
		this.room=room;
		this.sex=sex;
		this.age=age;
		this.jiaofei=b;
	}
}
