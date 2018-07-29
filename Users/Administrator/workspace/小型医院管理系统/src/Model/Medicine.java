package Model;

public class Medicine {
	private int number;
	private String name;
	private int money;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getMoney() {
		return this.money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Medicine(int number,String name,int money){
		this.set(number, name,money);
	}
	public Medicine(Medicine medicine){
		this.set(medicine.number, medicine.name,medicine.money);
	}
	public void set(int number,String name,int money){
		this.name = name;
		this.number = number;
		this.money = money;
	}
}
