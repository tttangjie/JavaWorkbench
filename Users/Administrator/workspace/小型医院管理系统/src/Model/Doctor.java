package Model;

public class Doctor {
	private int id;
	private String name;
	private String department;  //ฟฦสา
	private String sex;
	private String tel;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return this.sex;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return this.tel;
	}

	public String getDepartment() {
		return this.department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Doctor(int id,String name,String sex,String department,String tel){
		this.set(id, name,sex,department,tel);
	}
	public Doctor(Doctor doctor){
		this.set(doctor.id, doctor.name,doctor.sex,doctor.department,doctor.tel);
	}
	public void set(int id,String name,String sex,String department,String tel){
		this.name = name;
		this.id = id;
		this.sex = sex;
		this.department = department;
		this.tel = tel;
	}
}
